package com.it.java8demo.testObject;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @CLassName ConvertObject
 * @Description: TODO
 * @date: 2020/12/1 17:34
 * @Version 1.0
 */
public class ConvertObject {
	public static void main(String[] args) {
//		List<Map<String,String>> workTimeIteams=new ArrayList<>();
//		Map<String,String> iteam=new HashMap<>();
		//"vccId":"121212",
		//"itemKey": "0000251212121000",
		//"scheduleKey": "0000241212123333",
		//"monday": "1",
		//"tuesday": "1",
		//"wednesday": "1",
		//"thursday": "1",
		//"friday": "1",
		//"saturday": "1",
		//"sunday": "1",
		//"dateStart": "20180712",
		//"dateEnd": "20200712",
		//"hourStart": "0",
		//"hourEnd": "23",
		//"minuteStart": "0",
		//"minuteEnd": "59"
//		String times="00:05";
//		String hourStart=times.substring(0,2);
//		int s=Integer.valueOf(hourStart);
//		String hourEnd=times.substring(3,5);
//		int y=Integer.valueOf(hourEnd);
//		System.out.println(s);
//		System.out.println(y);
//		Map<String,List<Map<String,Object>>> list=new HashMap<>();
//		List<Map<String,Object>> list1=new ArrayList<>();
//		Map<String,Object> map=new HashMap<>();
//		map.put("serviceType","3");
//		map.put("startTime","12:30");
//		Map<String,Object> map2=new HashMap<>();
//		map2.put("serviceType","2");
//		map2.put("startTime","12:30");
//		list1.add(map);
//		list1.add(map2);
//
////		list.put("workingTimeList",list1);
////		String json= JSON.toJSONString(list);
////		System.out.println(json);
//		System.out.println(list1);
//		Collections.reverse(list1);
//		System.out.println(list1);
		String url="http://192.168.28.125:8068/cincc-serv";
		String finalUrl=url.substring(0,url.lastIndexOf("/"));
		System.out.println(finalUrl);







	}
}
