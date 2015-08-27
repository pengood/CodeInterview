package com.nowcoder.offer;

import java.util.Arrays;

/*
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符的位置。若为空串，返回-1
 */
public class FirstNotRepeatingCharTest {
	public int FirstNotRepeatingChar(String str) {
		if(str==null||str.length()==0)
			return -1;
		int[] nums=new int[256];
		Arrays.fill(nums, 0);
		for(int i=0;i<str.length();i++){
			nums[str.charAt(i)]++;
		}
		int j=0;
		for(;j<str.length();j++){
			if(nums[str.charAt(j)]==1)
				break;
		}
		if(j==str.length())
			return -1;
		return j;
    }
	public static void main(String[] args) {
		FirstNotRepeatingCharTest test=new FirstNotRepeatingCharTest();
		String str="gjgj";
		System.out.println(test.FirstNotRepeatingChar(str));
	}
}
