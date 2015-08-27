package com.offer;

import java.util.Arrays;

public class FirstNotRepeatChar {
	public static void firstOneChar(char[] chars){
		if(chars==null||chars.length==0)
			throw new IllegalArgumentException();
		int len=chars.length;
		int[] times=new int[256];
		Arrays.fill(times, 0);
		for(int i=0;i<len;i++){
			times[chars[i]]++;
		}
		for(int i=0;i<len;i++){
			if(times[chars[i]]==1){
				System.out.print(chars[i]);
				break;
			}
		}
	}
	public static void main(String[] args){
		char[] ch={'a','b','a','c','c','d','e','f','f'};
		firstOneChar(ch);
		StringBuilder stringBuilder;
		
	}
}
