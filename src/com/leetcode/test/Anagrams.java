package com.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Anagrams {
	 public  List<String> anagrams(String[] strs) {
	        List<String> list=new ArrayList<>();
	        if(strs==null||strs.length<2)
	        	return list;
	        HashMap<String, List<String>> map=new HashMap<>();
	        for(int i=0;i<strs.length;i++){
	        	String sorted=sort(strs[i]);
	        	List<String> list2=map.get(sorted);
	        	if(list2!=null){
	        		list2.add(strs[i]);
	        	}else {
					List<String> list3=new ArrayList<>();
					list3.add(strs[i]);
					map.put(sorted, list3);
				}
	        }
	        Iterator<Map.Entry<String, List<String>>> iterator=map.entrySet().iterator();
	        while(iterator.hasNext()){
	        	Map.Entry<String, List<String>> entry=iterator.next();
	        	if(entry.getValue().size()>1){
	        		list.addAll(entry.getValue());
	        	}
	        }
	        return list;
	    }
	 
	 private String sort(String s){
		 char[] a=s.toCharArray();
		 Arrays.sort(a);
		 return new String(a);
	 } 
	 
	public static void main(String[] args) {
		Anagrams anagrams=new Anagrams();
		String[] strings={"tea","and","ate","eat","den"};
		System.out.println(anagrams.anagrams(strings));
	}
}
