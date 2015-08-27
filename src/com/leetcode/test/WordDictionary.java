package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class WordDictionary {
	List<String> list=new ArrayList<String>();
	 public void addWord(String word) {
	        list.add(word);
	    }
	  public boolean search(String word) {
	        if(list.contains(word))
	        	return true;
	        for(int i=0;i<list.size();i++){
	        	if(word.length()!=list.get(i).length())
	        		continue;
	        	int j=0;
	        	for(;j<word.length();j++){
	        		if(word.charAt(j)!='.'&&word.charAt(j)!=list.get(i).charAt(j))
	        			break;
	        	}
	        	if(j==word.length())
	        		return true;
	        }
	        return false;
	    }
	  public static void main(String[] args) {
		WordDictionary dictionary=new WordDictionary();
		dictionary.addWord("word");
		System.out.println(dictionary.search("word"));
		System.out.println(dictionary.search(".ood"));
	}
}
