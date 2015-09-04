package com.nowcoder.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/*
 * 	请编写一个方法，对一个字符串数组进行排序，将所有变位词合并，保留其字典序最小的一个串。
 * 这里的变位词指变换其字母顺序所构成的新的词或短语。例如"triangle"和"integral"就是变位词。
	给定一个string的数组str和数组大小int n，请返回排序合并后的数组。保证字符串串长小于等于20，数组大小小于等于300。
	测试样例：
	["ab","ba","abc","cba"]
	返回：["ab","abc"]
 */
public class SortString {
	 public ArrayList<String> sortStrings(String[] str, int n) {
		 ArrayList<String> list=new ArrayList<>();
		 if(str==null||str.length==0)
			 return list;
		 HashMap<String, String>map=new HashMap<>();
		 for(int i=0;i<str.length;i++){
			 char[] ch=str[i].toCharArray();
			 Arrays.sort(ch);
			 String string=new String(ch);
			 if(map.get(string)==null){
				 map.put(string, str[i]);
			 }else {
				String string2=map.get(string);
				if(compare(string, string2, str[i])==-1)
					map.put(string, str[i]);
			}
		 }
		 for(String string:map.values()){
			 list.add(string);
		 }
		 Collections.sort(list);
		 return list;
	    }
	 private int compare(String dirc,String str1,String str2){
		 if(str1.equals(str2))
			 return 0;
		 for(int i=0;i<dirc.length();i++){
			 if(str1.charAt(i)!=dirc.charAt(i))
				 return -1;
			 if(str2.charAt(i)!=dirc.charAt(i))
				 return 1;
		 }
		 return 0;
	 }
	 public static void main(String[] args) {
		String[] strings={"emmaldzsvjggzfoda","a","skmjhsm","zjwmkgufsvwrwyvrhk","vyksgrwwjmwrhzfvuk","wfszrykvjrmuwhkvgw","kwrwuwjvksyvhmrzfg","kom","mko","mko","nezrxmdjgjqexmqz","gjmqdrzqzjeemxxn","qqxedgjjmrznmxez","xxgmjezerjnqmzdq","vwcmmngdsvzx","xvmdvwscgnmz","msnvvczxdgwm","izmvzrhltsiubcukc","cslnzuenr","rznulsenc","lnsnucrez","gkyfvvni","gikvvynf","ivkfyvng","vygfvikn","nwxkeyhnvniquhpapw","wnhyknvanhepwquxip","rrpujexoukmmrnmpdzcf","ksirghrnjx","ixrhgkrnjs","kup","kpu","kpu","emnetqjwnfwi","qpozvklf","qpvkolfz","flpkvoqz","zlkpvfoq","zldjqciktnevrkb","vklqjdrktcebizn","ntrqkvebiljczkd","nkktcebjirqvldz","mytegbucud","gbtcyuemud","gctmuedybu","ahgeomesgcehvk","oamshhecevggek","gmcekevoehsahg","gvgeacmheeoksh","ma","am","am","wxdyddyrenzsylfwx","syedwdylxrwfyxzdn","dwsddyelxywrxyfnz","rdrrfuowxukryfmli","qdjzmdobajs","ymysuotfxpboc","awzccscrkozbhygrkvv","ovrgybhswrczzkcacvk","zcrwkyhrzkgacvsocbv","vzwgzosrkvkcrcybahc","ftytv","ttvyf","tfyvt","vtytf","pggunxuyduy","qijygauutkt","aytqutkugji","itjutqugaky","nfoenumvnmannkkhmueo"};
		SortString sortString=new SortString();
		System.out.println(sortString.sortStrings(strings, strings.length));
	}
}
