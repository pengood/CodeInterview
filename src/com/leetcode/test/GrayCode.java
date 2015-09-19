package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/*
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 00 - 0
 01 - 1
 11 - 3
 10 - 2
 */
public class GrayCode {
	public List<Integer> grayCode(int n) {
		if(n<0)
			throw new IllegalArgumentException();
		List<Integer> list=new ArrayList<Integer>();
		if(n==0)
			return list;
		int[][] result=helpGrayCode(n);
		for(int i=0;i<result.length;i++){
			int num=0;
			for(int j=n-1;j>=0;j--){
				if((result[i][n-j-1]&1)>0)
					num+=(1<<j);
			}
			list.add(num);
		}
		return list;
	}
	
	private int[][] helpGrayCode(int n){
		int N=(int)Math.pow(2, n);
		int[][] code=new int[N][n];
		if(n==1){
			code[0][0]=0;
			code[1][0]=1;
			return code;
		}
		int[][] last=helpGrayCode(n-1);
		for(int i=0;i<last.length;i++){
			code[i][0]=0;
			for(int j=0;j<last[i].length;j++){
				code[i][j+1]=last[i][j];
			}
			code[N-i-1][0]=1;
			for(int j=0;j<last[last.length-i-1].length;j++){
				code[N-i-1][j+1]=last[i][j];
			}
		}
		return code;
	}
	public static void main(String[] args) {
		GrayCode code=new GrayCode();
		System.out.println(code.grayCode(3));
	}
}
