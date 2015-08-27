package com.leetcode.test;

import java.util.Arrays;

public class ValidAnagram {
	 public static boolean isAnagram(String s, String t) {
	        if(s==null||t==null||s.length()!=t.length())
	        	return false;
	        int[] chs=new int[256];
	        Arrays.fill(chs, 0);
	        for(int i=0;i<s.length();i++)
	        	chs[s.charAt(i)]++;
	        for(int i=0;i<t.length();i++){
	        	chs[t.charAt(i)]--;
	        }
	        for(int i=0;i<256;i++)
	        	if(chs[i]!=0)
	        		return false;
	        return true;
	        	
	    }
	 public static void main(String[] args) {
		String string="anagram";
		String tString="anagramq";
		System.out.println(isAnagram(string, tString));
	}
}
