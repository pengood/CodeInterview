package com.nowcoder.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/*
 * 有一组单词，请编写一个程序，在数组中找出由数组中字符串组成的最长的串A，即A是由其它单词组成的(可重复)最长的单词。
	给定一个string数组str，同时给定数组的大小n。请返回最长单词的长度，保证题意所述的最长单词存在。
	测试样例：
	["a","b","c","ab","bc","abc"],6
	 返回：3
 */
public class LongestString {
	class LengthCompartor implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return o1.length()-o2.length();
		}
		
	}
	  public int getLongest(String[] str, int n) {
		  Arrays.sort(str, new LengthCompartor());
		  HashMap<String, Boolean> map=new HashMap<>();
		  for(String s:str){
			  map.put(s, true);
		  }
		  for(int i=str.length-1;i>=0;i--){
			  for(int j=1;j<str[i].length();j++){
				  String sub1=str[i].substring(0, j);
				  String sub2=str[i].substring(j, str[i].length());
				  if(map.containsKey(sub1)&&canBuild(map, sub2))
					  return str[i].length();
			  }
		  }
		return -1;
	    }
	  private boolean canBuild(HashMap<String, Boolean> map,String str){
		  if(map.containsKey(str))
			  return true;
		  for(int i=1;i<str.length();i++){
			  String sub1=str.substring(0, i);
			  String sub2=str.substring(i, str.length());
			  if(map.containsKey(sub1)&&canBuild(map, sub2))
				  return true;
		  }
		  return false;
	  }
	  public static void main(String[] args) {
		LongestString string=new LongestString();
		String[] aStrings={"a","b","cds","abs","bc","abdc","aaaaaa"};
		int i=string.getLongest(aStrings, aStrings.length);
		System.out.println(i);
	}
}
