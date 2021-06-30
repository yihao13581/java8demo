package com.haotian.service;

import com.alibaba.fastjson.JSON;
import com.haotian.pojo.Content;
import com.haotian.util.HtmlParseUtil;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class ContentService {

	@Autowired
	private RestHighLevelClient restHighLevelClient;

	//1、解析数据放入es索引中
	public Boolean parseContent(String keywords) throws IOException {
		List<Content> contents = new HtmlParseUtil().parseJD(keywords);
		//将查询到的数据放入es中
		System.out.println(contents.size());
		BulkRequest bulkRequest = new BulkRequest();
		bulkRequest.timeout("2m");
		for (int i = 0; i < contents.size(); i++) {
			bulkRequest.add(
					new IndexRequest("jd_goods").source(JSON.toJSONString(contents.get(i)), XContentType.JSON)
			);
		}
		BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
		return !bulkResponse.hasFailures();
	}

	//2获取这些数据实现搜索功能
	public List<Map<String, Object>> searchPage(String keyword, int pageNo, int pageSize) throws IOException {
		if (pageNo <= 1) {
			pageNo = 1;
		}
		//条件搜索
		SearchRequest searchRequest = new SearchRequest("jd_goods");
		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

		//分页
		sourceBuilder.from(pageNo);
		sourceBuilder.size(pageSize);

		//精准匹配
		TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", keyword);
		sourceBuilder.query(termQueryBuilder);
		sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

		//高亮
		HighlightBuilder highlightBuilder = new HighlightBuilder();
		highlightBuilder.field("title");
		highlightBuilder.requireFieldMatch(false);//多个高亮显示
		highlightBuilder.preTags("<span style='color:red'");//前置头
		highlightBuilder.postTags("</span>");
		sourceBuilder.highlighter(highlightBuilder);


		//执行搜索
		searchRequest.source(sourceBuilder);
		SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
		//解析结果
		ArrayList<Map<String, Object>> list = new ArrayList<>();
		for (SearchHit hit : searchResponse.getHits().getHits()) {
			Map<String, HighlightField> highlightFields = hit.getHighlightFields();
			HighlightField title = highlightFields.get("title");
			Map<String, Object> sourceMap = hit.getSourceAsMap();//原来的结果！
			//解析高亮的字段,将原来高亮的字段替换成我们高亮的字段即可！
			if (title != null) {
				Text[] fragments = title.fragments();
				String n_title = "";
				for (Text text : fragments) {
					n_title += text;
				}
				sourceMap.put("title", n_title);//高亮指端你替换原来的内容即可！
			}
			list.add(sourceMap);
		}
		return list;
	}

}
