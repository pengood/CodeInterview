package com.nowcoder.offer;
/*
 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。
 * 若压缩后的字符串没有变短，则返回原先的字符串。给定一个string iniString为待压缩的串(长度小于等于3000)，
 * 保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变化的串。测试样例"aabcccccaaa"返回："a2b1c5a3"
 * "welcometonowcoderrrrr"返回："welcometonowcoderrrrr"
 */
public class ZipStringTest {
	public String zipString(String iniString) {
		StringBuilder builder=new StringBuilder();
		if(iniString==null||iniString.length()==0)
			return builder.toString();
		for(int i=0;i<iniString.length();i++){
			char c=iniString.charAt(i);
			int num=1;
			while(++i<iniString.length()&&iniString.charAt(i)==c){
				num++;
			}
			builder.append(c).append(num);
			i--;
		}
		if(builder.length()<iniString.length())
			return builder.toString();
		return iniString;
	}
	public static void main(String[] args) {
		ZipStringTest test=new ZipStringTest();
		String a="aabcccccaaa";
		String bString="welcometonowcoderrrrr";
		System.out.println(test.zipString(a));
		System.out.println(test.zipString(bString));
	}
}
