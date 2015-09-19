package com.nowcoder.interview;

import java.util.HashMap;

/*
 * 请设计一个高效的方法，找出任意指定单词在一篇文章中的出现频数。
	给定一个string数组article和数组大小n及一个待统计单词word，
	请返回该单词在文章中的出现频数。保证文章的词数小于等于1000。	
 */
public class WordFrequency {
	 public int getFrequency(String[] article, int n, String word) {
		 if(article==null||article.length==0||word==null)
			 return -1;
		 HashMap<String, Integer> map=new HashMap<>();
		 for(int i=0;i<article.length;i++){
			 if(map.get(article[i])==null)
				 map.put(article[i], 1);
			 else {
				map.put(article[i], map.get(article[i])+1);
			}
		 }
		 if(map.get(word)==null)
			 return 0;
		 return map.get(word);
	    }
	 public static void main(String[] args) {
		WordFrequency frequency=new WordFrequency();
		String[] aStrings={"abcd"};
		System.out.println(frequency.getFrequency(aStrings, 1, "ccds"));
	}
}
