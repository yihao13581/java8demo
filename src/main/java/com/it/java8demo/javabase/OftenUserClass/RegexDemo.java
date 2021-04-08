package com.it.java8demo.javabase.OftenUserClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @CLassName RegexDemo
 * @Description: TODO
 * @date: 2020/12/14 14:01
 * @Version 1.0
 */
public class RegexDemo {
	/**
	 * 正则表达式是一个强大的字符串处理工具，可以对字符串进行查找、提取、分割、替换等操作。
	 * String类里也提供了如下几个特殊的方法：
	 * 		boolean matches(String regex):判断该字符串是否匹配指定的正则表达式
	 * 		String  replaceAll(String regex,String replacement):将该字符串中所有匹配的regex的子串替换成replacement
	 * 		String replaceFirst(String regex,String replacement):将该字符串中第一个匹配的regex的子串替换成replacement
	 * 		String[] split(String regex):以regex为分隔符，把该字符串分割成多个字串。
	 *
	 *常见规则：
	 *
	 * A:字符
	 * x 字符 x。举例：'a'表示字符a
	 * \ 反斜线字符。
	 * \n 新行（换行）符 ('\u000A')
	 * \r 回车符 ('\u000D')
	 *
	 * B:字符类
	 * [abc] a、b 或 c（简单类）
	 * [^abc] 任何字符，除了 a、b 或 c（否定）
	 * [a-zA-Z] a到 z 或 A到 Z，两头的字母包括在内（范围）
	 * [0-9] 0到9的字符都包括
	 *
	 * C:预定义字符类
	 * . 任何字符。我的就是.字符本身，怎么表示呢? .
	 * \d 数字：[0-9]
	 * \w 单词字符：[a-zA-Z_0-9]在正则表达式里面组成单词的东西必须有这些东西组成
	 * D:边界匹配器
	 * ^ 行的开头
	 * $ 行的结尾
	 * \b 单词边界。就是不是单词字符的地方。举例：hello world?haha;xixi
	 *
	 * E:Greedy 数量词
	 * X? X，一次或一次也没有
	 * X* X，零次或多次
	 * X+ X，一次或多次
	 * X{n} X，恰好 n 次
	 * X{n,} X，至少 n 次
	 * X{n,m} X，至少 n 次，但是不超过 m 次
	 */


	/**
	 * 使用正则表达式：使用Pattern和Matcher来使用正则表达式。
	 * 		Pattern对象是正则表达式编译后在内存中的表示形式，因此，正则表达式字符必须先被编译为Patter
	 * 	对象，然后再利用该Pattern对象创建对应的Matcher对象，执行匹配所涉及的状态保留在Matcher对象中，多个
	 * 	Matcher对象可共享同一个Patter对象
	 * 		Pattern是不可变类，可供多个并发线程安全使用
	 * 		Matcher类提供了如下几个常用的方法：
	 * 			find():返回目标字符串中是否包含与Patter匹配的子串。
	 * 		 	group()：返回上一次与Pattern匹配的字串
	 * 		    start():返回上一次与Pattern匹配的子串在目标字符串中的开始位置。
	 * 		    end():返回上一次与Pattern匹配的子串在目标字符串中的结束位置加1。
	 * 		    lookingAt():返回目标字符串前面部分与Pattern是否匹配。
	 * 		    matches()；返回整个目标字符串与Pattern是否匹配
	 * 		    reset():将现有的Matcher对象应用于一个新的字符序列
	 */
	public static void main(String[] args) {
//		firstDemo();

		useGerexDemo();

	}

	private static void useGerexDemo() {
		//使用字符串模拟从网络上得到的网页源码
		String str="我想求购一本《疯狂JAVA讲义》，尽快联系我13500006666"+"交朋友，电话号码是13611125565"
				+"出售二手电脑，联系方式15899903312";
		Matcher m=Pattern.compile("(13\\d)|(15\\d)\\d{8}")
				.matcher(str);
		//将所有符合正则表达式的子串（电话号码）全部输出
		while(m.find())
		{
			System.out.println(m.group());
		}
	}

	private static void firstDemo() {
		//将一个字符串编译成patter对象
		Pattern p= Pattern.compile("a*b");
		//使用Pattern对象创建Matcher对象
		Matcher m=p.matcher("aaaaab");
		boolean b=m.matches();
		//返回true
		System.out.println(b);
	}
}
