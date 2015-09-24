package com.leetcode.test;

import java.util.Arrays;

/*
 * Given an array nums, write a function to move all 0's to the end of it 
 * while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, 
nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class MoveZeroes {
	//参考插入排序
	 public void moveZeroes(int[] nums) {
	        if(nums==null||nums.length==0)
	        	throw new IllegalArgumentException();
	        for(int i=0;i<nums.length;i++){
	        	if(nums[i]==0)
	        		continue;
	        	int j;
	        	int tmp=nums[i];
	        	for(j=i;j>0&&nums[j-1]==0;j--){
	        		nums[j]=nums[j-1];
	        	}
	        	nums[j]=tmp;
	        }
	    }
	 public static void main(String[] args) {
		int[] a={0,1,0,3,12};
		MoveZeroes zeroes=new MoveZeroes();
		zeroes.moveZeroes(a);
		System.out.println(Arrays.toString(a));
	 }
}
