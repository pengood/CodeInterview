package com.leetcode.test;

import java.util.Arrays;

/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity. Could you implement 
 it using only constant extra space complexity?
 */
public class MissingNumber {
	public int missingNumber(int[] nums) {
		if(nums==null||nums.length==0)
			return 0;
		Arrays.sort(nums);
		if(nums[0]!=0)
			return 0;
		if(nums[nums.length-1]==nums.length-1)
			return nums.length;
		int len=nums.length;
		int begin=0;
		int end=len-1;
		while(begin<end){
			int mid=begin+(end-begin)/2;
			if(mid<nums[mid]){
				end=mid;
			}else {
				begin=mid;
			}
			if(begin+1==end)
				break;
		}
		return end;
	}
	public int missingNumber1(int[] nums){
		if(nums==null||nums.length==0)
			return 0;
		int len=nums.length;
		int total=(len+1)*(len)/2;
		for(int i=0;i<len;i++){
			total-=nums[i];
		}
		return total;
	}
	public static void main(String[] args) {
		int[] a={ 1, 2,3,4,5,6};
		MissingNumber number=new MissingNumber();
		System.out.println(number.missingNumber1(a));
	}
}
