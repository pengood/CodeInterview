package com.leetcode.test;
/*
 * Find the contiguous subarray within an array (containing at least one number) 
 * which has the largest sum.

	For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
	the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
	 public int maxSubArray(int[] nums) {
	        if(nums==null||nums.length==0)
	        	throw new IllegalArgumentException();
	        int maxsum=Integer.MIN_VALUE;
	        int currentsum=0;
	        for(int i=0;i<nums.length;i++){
	        	if(currentsum<0){
	        		currentsum=nums[i];
	        	}else {
					currentsum+=nums[i];
				}
	        	if(currentsum>maxsum)
	        		maxsum=currentsum;
	        }
	        return maxsum;
	    }
	 public static void main(String[] args) {
		int[] nums={-2,1,-3,4,-1,2,1,-5,4};
		MaximumSubarray subarray=new MaximumSubarray();
		System.out.println(subarray.maxSubArray(nums));
	}
	 
}
