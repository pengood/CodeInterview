package com.leetcode.test;

import java.util.Arrays;

/*
 * Given a sorted array, remove the duplicates in place such that each element 
 * appear only once and return the new length.
 Do not allocate extra space for another array, you must do this in place with constant memory.
 For example,
 Given input array nums = [1,1,2],
 Your function should return length = 2, with the first two elements of nums being 1 and 2 
 respectively. It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums == null)
			throw new IllegalArgumentException();
		if (nums.length <= 1)
			return nums.length;
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1])
				count++;
		}
		for(int i=1,j=1;i<nums.length-count;i++,j++){
			while(nums[j]==nums[j-1]){
				j++;
			}
			nums[i]=nums[j];
		}
		return nums.length-count;
	}
	public static void main(String[] args) {
		int[] array={1,1,1,2,3,3};
		RemoveDuplicatesfromSortedArray array2=new RemoveDuplicatesfromSortedArray();
		int len=array2.removeDuplicates(array);
		System.out.println(len);
		System.out.println(Arrays.toString(array));
	}
}
