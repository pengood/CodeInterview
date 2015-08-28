package com.leetcode.test;

/*
 * Write a program to find the n-th ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

 Note that 1 is typically treated as an ugly number.
 */
public class UglyNumber {
	public int nthUglyNumber(int n) {
		if(n<=0)
			throw new IllegalArgumentException();
		int[] nums=new int[n];
		nums[0]=1;
		int m2=0;
		int m3=0;
		int m5=0;
		int index=0;
		while(index<n-1){
			nums[++index]=min(nums[m2]*2, nums[m3]*3, nums[m5]*5);
			while(nums[m2]*2<=nums[index])
				m2++;
			while(nums[m3]*3<=nums[index])
				m3++;
			while(nums[m5]*5<=nums[index])
				m5++;
		}
		return nums[index];
	}
	private int min(int a,int b,int c){
		if(a>b)
			a=b;
		return a<c?a:c;
	}
	public static void main(String[] args) {
		UglyNumber number=new UglyNumber();
		System.out.println(number.nthUglyNumber(10));
	}
}
