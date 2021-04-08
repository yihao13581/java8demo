package com.it.java8demo.stream;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * @CLassName StreamDemo
 * @Description: TODO
 * @date: 2020/10/29 17:20
 * @Version 1.0
 */
public class StreamDemo {
	public static void main(String[] args) {
//		List<String> list=java8before();
//		List<String> list2=java8();
//		System.out.println(list);
//		System.out.println(list2);
//		test01();
		Map<String,Object> map=new HashMap<>();
		System.out.println(map.get("we"));


	}

	private static void test01() {
		List<Dish> list=new ArrayList<>();
		Dish dish=new Dish("红烧鱼",29);
		Dish dish2=new Dish("武昌鱼最好了",59);
		Dish dish3=new Dish("秋刀鱼有点难吃了，亲",29);
		list.add(dish);
		list.add(dish2);
		list.add(dish3);

		List<Integer> dishNameLengths=list.stream()
				.map(Dish::getName)
				.map(String::length)
				.collect(toList());
		System.out.println(dishNameLengths);
	}

	private static List<String> java8before() {
		List<Dish> menu = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Dish dish = new Dish();
			dish.setCalories(500 - i * 20);
			dish.setName("红烧鱼" + i);
			menu.add(dish);
		}
		List<Dish> lowCaloricDishes = new ArrayList<>();
		for(Dish d: menu){
			if(d.getCalories() < 400){
				lowCaloricDishes.add(d);
			}
		}
		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
			@Override
			public int compare(Dish d1, Dish d2) {
				return Integer.compare(d1.getCalories(),d2.getCalories());
			}
		});
		List<String> lowCaloricDishesName = new ArrayList<>();
		for(Dish d: lowCaloricDishes){
			lowCaloricDishesName.add(d.getName());
		}
		return lowCaloricDishesName;
	}



	private static List<String> java8() {
		List<Dish> menu = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Dish dish = new Dish();
			dish.setCalories(500 - i * 20);
			dish.setName("红烧鱼" + i);
			menu.add(dish);
		}
		//parallelStream多核架构并行执行这段代码
		List<String> lowCaloricDishesName=menu.parallelStream().filter(d->d.getCalories()<400)
				.sorted(comparing(Dish::getCalories))
				.map(Dish::getName)
				.collect(toList());
		return lowCaloricDishesName;
	}


}
