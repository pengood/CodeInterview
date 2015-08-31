package com.nowcoder.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * 编写一个方法，确定某字符串的所有排列组合。
	给定一个string A和一个int n,代表字符串和其长度，请返回所有该字符串字符的排列，
	保证字符串长度小于等于11且字符串中字符均为大写英文字符，排列中的字符串按字典序从大到小排序。(不合并重复字符串)
	测试样例：
	"ABC"
	返回：["CBA","CAB","BCA","BAC","ACB","ABC"]
 */
public class Permutation {
	boolean[] visited;
	int[] data;
	 public ArrayList<String> getPermutation(String A) {
		 ArrayList<String> list=new ArrayList<>();
		 if(A==null||A.length()==0)
			 return list;
		 char[] ch=A.toCharArray();
		 Arrays.sort(ch);
		 reserve(ch, 0, ch.length-1);
		 visited=new boolean[ch.length];
		 data=new int[ch.length];
		 dfs(ch, list, 0, ch.length);
		 Collections.sort(list,Collections.reverseOrder());
		 return list;
	    }
	 private void dfs(char[] ch,ArrayList<String> list,int d,int end){
		 if(d==end){
			 StringBuilder builder=new StringBuilder();
			 for(int i=0;i<end;i++){
				 builder.append(ch[data[i]]);
			 }
//			 if(list.contains(builder.toString()))
//				 return;
			 list.add(builder.toString());
			 return;
		 }
		 for(int i=0;i<end;i++){
			 if(!visited[i]){
				 data[d]=i;
				 visited[i]=true;
				 dfs(ch, list, d+1, end);
				 visited[i]=false;
			 }
		 }
	 }
	 private void reserve(char[] array,int begin,int end){
			while(begin<end){
				char tmp=array[begin];
				array[begin]=array[end];
				array[end]=tmp;
				begin++;
				end--;
			}
		}
public static void main(String[] args) {
	String s="NXX";
	Permutation permutation=new Permutation();
	System.out.println(permutation.getPermutation(s));
}
}
