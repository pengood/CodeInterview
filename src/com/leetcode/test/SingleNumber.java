package com.leetcode.test;
/*
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class SingleNumber {
	 public int singleNumber(int[] nums) {
	        if(nums==null||nums.length==0)
	        	throw new IllegalArgumentException();
	        int n=0;
	        for(int i=0;i<nums.length;i++){
	        	n^=nums[i];
	        }
	        return n;
	    }
	 public static void main(String[] args) {
		SingleNumber number=new SingleNumber();
		int[] a={1,2,3,4,4,3,2,5,5};
		System.out.println(number.singleNumber(a));
	}

}
