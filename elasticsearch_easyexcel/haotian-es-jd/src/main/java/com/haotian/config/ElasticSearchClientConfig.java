package com.haotian.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @CLassName ElasticSearchConfig
 * @Description: TODO
 * @date: 2021/1/14 11:20
 * @Version 1.0
 */
@Configuration//xml-bean
public class ElasticSearchClientConfig {
	@Bean
	public RestHighLevelClient restHighLevelClient() {
		RestHighLevelClient client = new RestHighLevelClient(
				RestClient.builder(
						new HttpHost("localhost", 9200, "http"),
						new HttpHost("localhost", 9201, "http")));
		return client;
	}
}
