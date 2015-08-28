package com.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
 * Given two words (start and end), and a dictionary, find all shortest 
 * transformation sequence(s) from start to end, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,

 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 Return
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 Note:
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 */
public class WordLadderII {
	List<List<String>> list = new ArrayList<>();
	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		if(start==null||end==null||start.length()!=end.length())
			return list;
		HashMap<String, ArrayList<String>> map = new HashMap<>(dict.size() + 2);
		HashMap<String, Boolean> visited = new HashMap<>(dict.size() + 2);
		ArrayList<String> list1 = new ArrayList<>();
		map.put(start, list1);
		ArrayList<String> list2 = new ArrayList<>();
		map.put(end, list2);
		for (String string : dict) {
			ArrayList<String> list = new ArrayList<>();
			map.put(string, list);
			if (isNeighbor(start, string)) {
				list.add(start);
				map.get(start).add(string);
			}
			if (isNeighbor(end, string)) {
				list.add(end);
				map.get(end).add(string);
			}
			for (String string2 : dict) {
				if (isNeighbor(string, string2))
					list.add(string2);
			}
		}
	
		for (String string : map.get(start)) {
			List<String> list3 = new ArrayList<>();
			list3.add(start);
			visited.put(start, true);
			dfs(string, end, map, visited, list3);
			
		}
		if(list.size()==0)
			return list;
		int minsize=list.get(0).size();
		for(List<String> list5:list){
			if(list5.size()<minsize)
				minsize=list5.size();
		}
		Iterator<List<String>> iterator=list.iterator();
		while(iterator.hasNext()){
			List<String> list5=iterator.next();
			if(list5.size()>minsize)
				iterator.remove();
		}
		return list;

	}

	private void dfs(String word, String end,
			HashMap<String, ArrayList<String>> map,
			HashMap<String, Boolean> visited, List<String> path) {
		if (word.equals(end)){
			path.add(word);
			list.add(new ArrayList<>(path));
			return;
		}
		visited.put(word, true);
		path.add(word);
		for (String string : map.get(word)) {
			if (visited.get(string) == null || !visited.get(string)) {
				dfs(string, end, map, visited, path);
				path.remove(string);
				visited.put(string, false);
			}
		}
		visited.put(word, false);
	}

	private boolean isNeighbor(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				count++;
		}
		return count == 1;
	}
	public static void main(String[] args) {
		String start="hit";
		String end="cog";
		String[] strings={"hot","dot","dog","lot","log"};
		Set<String> dic=new HashSet<>();
		dic.addAll(Arrays.asList(strings));
		WordLadderII wordLadderII=new WordLadderII();
		System.out.println(wordLadderII.findLadders(start, end, dic));
	}
}
