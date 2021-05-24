package com.it.java8demo.stream;

import lombok.Data;

/**
 * @CLassName Dish
 * @Description: TODO
 * @date: 2020/10/29 17:20
 * @Version 1.0
 */
@Data
public class Dish  {
	private String name;
	private Integer calories;

	public Dish(){
	}
	public Dish(String name,Integer calories){
		this.name=name;
		this.calories=calories;
	}
}
