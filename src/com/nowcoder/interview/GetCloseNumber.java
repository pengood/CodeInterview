package com.nowcoder.interview;

import java.util.Arrays;

/*
 * 有一个正整数，请找出其二进制表示中1的个数相同、且大小最接近的那两个数。(一个略大，一个略小)
	给定正整数int x，请返回一个vector，代表所求的两个数（小的在前）。保证答案存在。
	测试样例：
	2
	返回：[1,4]
 */
public class GetCloseNumber {
	//error
	 public int[] getCloseNumber(int x) {
		 int[] ret=new int[2];
		 int first1=0;
		 for(int i=0;i<32;i++){
			 if((x&(1<<i))>0){
				 first1=i;
				 break;
			 }
		 }
		 ret[0]=x&(Integer.MAX_VALUE^(1<<first1))|(1<<(first1-1));
		 int j=first1;
		 for(;j<32;j++){
			 if((x&(1<<j))==0){
				 break;
			 }
		 }
		 ret[1]=(x|(1<<j))&(Integer.MAX_VALUE^(1<<(j-1)));
		return ret;
	    }
	 public int[] getCloseNumber1(int x){
		 int count=getonecount(x);
		 int[] ret=new int[2];
		 for(int i=x-1;i>0;i--){
			 if(getonecount(i)==count){
				 ret[0]=i;
				 break;
			 }
		 }
		 for(int i=x+1;i<Integer.MAX_VALUE;i++){
			 if(getonecount(i)==count){
				 ret[1]=i;
				 break;
			 }
		 }
		 return ret;
	 }
	 private int getonecount(int x){
		 int count=0;
		 for(int i=0;i<32;i++){
			 if((x&(1<<i))>0)
				 count++;
		 }
		 return count;
	 }
	 public static void main(String[] args) {
		GetCloseNumber number=new GetCloseNumber();
		System.out.println(Arrays.toString(number.getCloseNumber1(76351)));
	}
}
