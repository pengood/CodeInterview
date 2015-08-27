package com.offer;

import java.util.Arrays;


public class Print1Tomax {
	public static void print(int n){
		char[] chs=new char[n];
		Arrays.fill(chs, '0');
		int n1=0;
		while(!increase(chs))
			{
			n1++;
			MyArrays.print(chs);
			System.out.print(",");
			if(n1%10==0)
				System.out.println();
			}
	}
	private static boolean increase(char[] chars){ 
		int len=chars.length;
		boolean isIsOverflow=false;
		int nTackOver=0;
		int sum=0;
		for(int i=len-1;i>=0;i--){
			sum=chars[i]-'0'+nTackOver;
			if(i==len-1)
				sum++;
			if(sum>=10){
				if(i==0)
					isIsOverflow=true;
				else {
					sum-=10;
					nTackOver=1;
					chars[i]=(char) (sum+'0');
				}
			}else {
				chars[i]=(char) (sum+'0');
				break;
			}
		}
		return isIsOverflow;
	}
	public static void print2(int n){
		char[] chars=new char[n];
		Arrays.fill(chars, '0');
		for(int i=0;i<10;i++){
			chars[0]=(char)(i+'0');
			printRecursively(chars, n, 0);
		}
			
	}
	public static void printRecursively(char[] chars,int length,int index){
		if(index==length-1){
			MyArrays.print(chars);
			System.out.print(",");
			return;
		}
		for(int i=0;i<10;i++){
			chars[index+1]=(char)(i+'0');
			printRecursively(chars, length, index+1);
			System.out.println();
		}
	}
	public static void main(String[] args){
		print2(3);
	}
}
