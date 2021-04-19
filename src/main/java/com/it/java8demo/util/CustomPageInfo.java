package com.it.java8demo.util;

import com.github.pagehelper.PageInfo;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @CLassName PageInfo
 * @Description: 分页util,不经过mybatis
 * @date: 2021/1/6 19:53
 * @Version 1.0
 */
public class CustomPageInfo {
	public <T> PageInfo<T> defPageHelper(List<T> dateList, int pageNum, int pageSize){
		if(pageNum !=1 && !CollectionUtils.isEmpty(dateList) && dateList.size() <=pageSize) {
			pageNum = 1;//不足一页则返回一页
		}
		ArrayList<T> arrayList = new ArrayList<>();
		int startIndex = (pageNum - 1) *pageSize; //分页开始节点
		int endIndex = pageNum * pageSize - 1; //分页结束节点
		if (endIndex >= dateList.size()) {
			endIndex = dateList.size();
		}
		int i = 0;
		for (T t : dateList) {
			if (i >= startIndex && i <= endIndex){
				arrayList.add(t);
			}
			i ++;
		}

		PageInfo<T> dateInfo = new PageInfo<>(arrayList);

		if (dateList.size() % pageSize != 0){
			dateInfo.setPages((dateList.size() / pageSize) +1);
		} else {
			dateInfo.setPages(dateList.size() / pageSize);
		}

		dateInfo.setPageNum(pageNum);
		dateInfo.setPageSize(pageSize);
		dateInfo.setTotal(dateList.size());
		return dateInfo;
	}
}
