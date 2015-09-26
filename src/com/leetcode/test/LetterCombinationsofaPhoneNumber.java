package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.
	A mapping of digit to letters (just like on the telephone buttons) is given below.
	Input:Digit string "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsofaPhoneNumber {
	String[] strings={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public List<String> letterCombinations(String digits) {
		List<String> list=new ArrayList<String>();
		if(digits==null||digits.length()==0)
			return list;
		StringBuilder builder=new StringBuilder();
		helpTrival(digits, 0, list, builder);
        return list;
    }
	
	private void helpTrival(String digits,int d,List<String> list,StringBuilder builder){
		if(d==digits.length()){
			list.add(builder.toString());
			return;
		}
		int i=Integer.valueOf(digits.charAt(d)-'0');
		String string=strings[i];
		for(int j=0;j<string.length();j++){
			builder.append(string.charAt(j));
			helpTrival(digits, d+1, list, builder);
			builder.deleteCharAt(builder.length()-1);
		}
	}
	public static void main(String[] args) {
		String string="233";
		LetterCombinationsofaPhoneNumber number=new LetterCombinationsofaPhoneNumber();
		System.out.println(number.letterCombinations(string));
	}
}
