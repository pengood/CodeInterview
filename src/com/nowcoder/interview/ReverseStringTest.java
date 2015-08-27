package com.nowcoder.interview;

/*
 * 请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
 给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。
 测试样例：
 "This is nowcoder"
 返回："redocwon si sihT"
 */
public class ReverseStringTest {
	public String reverseString(String iniString) {
		// write code here
		if(iniString==null||iniString.length()<=1)
			return iniString;
		char[] ch=iniString.toCharArray();
		reverse(ch, 0, ch.length-1);
		return new String(ch);
	}
	
	private void reverse(char[] ch, int begin,int end){
		while(begin<end){
			char tmp=ch[begin];
			ch[begin]=ch[end];
			ch[end]=tmp;
			begin++;
			end--;
		}
	}
	public static void main(String[] args) {
		String s="This is nowcoder";
		ReverseStringTest test=new ReverseStringTest();
		System.out.println(test.reverseString(s));
		StringBuilder builder=new StringBuilder();
		builder.append(2);
	}
}
