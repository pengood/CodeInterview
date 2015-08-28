package com.leetcode.test;

/*
 * Given a string, determine if it is a palindrome, considering only 
 * alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good 
 question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if(s==null)
			throw new IllegalArgumentException();
		if(s.length()==0)
			return true;
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(c>='0'&&c<='9'||c>='a'&&c<='z')
				builder.append(c);
			if (c>='A'&&c<='Z') {
				builder.append((char)(c-('A'-'a')));
			}
			
		}
		char[] chars=builder.toString().toCharArray();
		int begin=0;
		int end=chars.length-1;
		boolean ret=true;
		while(begin<end){
			if(chars[begin]!=chars[end]){
				ret=false;
				break;
			}
			begin++;
			end--;
		}
		return ret;
	}
	public static void main(String[] args) {
		String string="1a2";
		ValidPalindrome palindrome=new ValidPalindrome();
		System.out.println(palindrome.isPalindrome(string));
		
	}
}
