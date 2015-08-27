package com.nowcoder.offer;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 
 * 输入描述:输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class PermutationTest {
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> list = new ArrayList<>();
		if (str == null || str.length() == 0)
			return list;
		char[] a=str.toCharArray();
		Arrays.sort(a);
		StringBuilder builder=new StringBuilder();
		builder.append(a);
		permutation(builder, list, 0, builder.length());
		return list;
	}
	private void permutation(StringBuilder stringBuilder,ArrayList<String> list,int start,int end){
		if(start==end-1){
			String string=new String(stringBuilder);
			list.add(string);
			return;
		}
		for(int i=start;i<end;i++){
			if(isSwap(stringBuilder, start, i)){
				swap(stringBuilder, start, i);
				permutation(stringBuilder, list, start+1, end);
				swap(stringBuilder, i, start);
			}
		}
		
			
	}
	private  void swap(StringBuilder s,int p,int q){
		char tmp=s.charAt(p);
		s.setCharAt(p, s.charAt(q));
		s.setCharAt(q, tmp);
	}
	private boolean isSwap(StringBuilder s,int start,int i){
		for(;start<i;start++){
			if(s.charAt(start)==s.charAt(i))
				return false;
		}
		return true;
	}
	public ArrayList<String> Permutation1(String str) {
		ArrayList<String> list = new ArrayList<>();
		if (str == null || str.length() == 0)
			return list;
		char[] a=str.toCharArray();
		Arrays.sort(a);
		StringBuilder builder=new StringBuilder();
		builder.append(a);
		permutation1(builder, list, 0, builder.length());
		return list;
	}
	private void permutation1(StringBuilder stringBuilder,ArrayList<String> list,int start,int end){
		if(start==end-1){
			String string=new String(stringBuilder);
			list.add(string);
			return;
		}
		permutation1(stringBuilder, list, start+1, end);
		for(int i=start+1;i<end;i++){
			if(stringBuilder.charAt(i)!=stringBuilder.charAt(start)){
				swap(stringBuilder, start, i);
				permutation1(stringBuilder, list, start+1, end);
				swap(stringBuilder, i, start);
			}
		}
	}
	
	//dfs permutation
	boolean[] visited;
	int[] data;
	public ArrayList<String> Permutation2(String str) {
		ArrayList<String> list = new ArrayList<>();
		if (str == null || str.length() == 0)
			return list;
		char[] a=str.toCharArray();
		Arrays.sort(a);
		StringBuilder builder=new StringBuilder();
		builder.append(a);
		visited=new boolean[builder.length()];
		Arrays.fill(visited, false);
		data=new int[builder.length()];
		Arrays.fill(data, -1);
		dfs(builder, list, 0, builder.length());
		return list;
	}
	private void dfs(StringBuilder builder,ArrayList<String> list,int d,int end){
		if(d==end){
			StringBuilder builder2=new StringBuilder();
			for(int i=0;i<end;i++){
				builder2.append(builder.charAt(data[i]));
			}
			if(list.contains(builder2.toString()))
				return;
			list.add(builder2.toString());
			return;
		}
		for(int i=0;i<end;i++){
			if(!visited[i]){
				visited[i]=true;
				data[d]=i;
				dfs(builder, list, d+1, end);
				visited[i]=false;
			}
		}
	}
	public static void main(String[] args) {
		String aString="abcd";
		PermutationTest test=new PermutationTest();
		System.out.println(test.Permutation2(aString).size());
		System.out.println();
	}
}
