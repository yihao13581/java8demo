package com.haotian.util;

import com.haotian.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @CLassName HtmlParseUtil
 * @Description: TODO
 * @date: 2021/1/14 16:45
 * @Version 1.0
 */
@Component
public class HtmlParseUtil {
	public static void main(String[] args) throws IOException {
		new HtmlParseUtil().parseJD("java").forEach(System.out::println);
	}

	public List<Content> parseJD(String keywords) throws IOException {
		String url="http://search.jd.com/Search?keyword="+keywords;
		//解析网页(Jsoup返回Document就是浏览器Document对象)
		Document document = Jsoup.parse(new URL(url), 30000);
		//所有你在js中可以使用的方法，这里都能用！
		Element element=document.getElementById("J_goodsList");
//		System.out.println(element.html());
		//获取所有的li的元素
		Elements elements = element.getElementsByTag("li");

		ArrayList<Content> goodsList=new ArrayList<>();
		//获取元素中的内容，这里el就是每一个li标签了！
		for (Element el : elements) {
			//关于图片特别多的网站，所有的图片都是延迟加载的
			//所以不是src的属性，而是data-lazy-img
			String img=el.getElementsByTag("img").eq(0).attr("data-lazy-img");
			String price=el.getElementsByClass("p-price").eq(0).text();
			String title=el.getElementsByClass("p-name").eq(0).text();
			Content content = new Content();
			content.setImg(img);
			content.setPrice(price);
			content.setTitle(title);
			goodsList.add(content);
		}
		return goodsList;
	}
//	private static void test() throws IOException {
//		//获取请求 http://search.jd.com/Search?keyword=java
//		//前提，需要联网！
//		String url="http://search.jd.com/Search?keyword=java";
//		//解析网页(Jsoup返回Document就是浏览器Document对象)
//		Document document = Jsoup.parse(new URL(url), 30000);
//		//所有你在js中可以使用的方法，这里都能用！
//		Element element=document.getElementById("J_goodsList");
//		System.out.println(element.html());
//		//获取所有的li的元素
//		Elements elements = element.getElementsByTag("li");
//
//		//获取元素中的内容，这里el就是每一个li标签了！
//		for (Element el : elements) {
//			//关于图片特别多的网站，所有的图片都是延迟加载的
//			//所以不是src的属性，而是data-lazy-img
//			String img=el.getElementsByTag("img").eq(0).attr("data-lazy-img");
//			String price=el.getElementsByClass("p-price").eq(0).text();
//			String title=el.getElementsByClass("p-name").eq(0).text();
//			System.out.println("================");
//			System.out.println(img);
//			System.out.println(price);
//			System.out.println(title);
//
//		}
//	}

}
