package com.nowcoder.interview;

import java.util.Arrays;

/*
 * 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串重点空格。
 给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
 测试样例：
 "This is nowcoder","is This nowcoder"
 返回：true
 "Here you are","Are you here"
 返回：false
 */
public class CheckSamTest {
	public boolean checkSam(String stringA, String stringB) {
		if(stringA==null&&stringB==null||stringA.length()==0&&stringB.length()==0)
			return true;
		if(stringA==null||stringB==null||stringA.length()!=stringB.length())
			return false;
		int[] charTimes=new int[256];
		//Arrays.fill(charTimes, 0);
		for(int i=0;i<stringA.length();i++)
			charTimes[stringA.charAt(i)]++;
		for(int i=0;i<stringB.length();i++)
			charTimes[stringB.charAt(i)]--;
		for(int i=0;i<256;i++){
			if(charTimes[i]!=0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		String string="This is nowcoder";
		String string2="is This nowcofer";
		CheckSamTest test=new CheckSamTest();
		System.out.println(test.checkSam(string, string2));
	}
}
