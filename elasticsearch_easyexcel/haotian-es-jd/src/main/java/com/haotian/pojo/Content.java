package com.haotian.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @CLassName Content
 * @Description: TODO
 * @date: 2021/1/14 17:24
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Content {
	private String title;
	private String img;
	private String price;
	//可以自己添加属性
}
