package com.leetcode.test;

import java.util.Arrays;

/*
 * Given an array of n integers where n > 1, nums, return an array output such that 
 * output[i] is equal to the product of all the elements of nums except nums[i].

 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].
 */
public class ProductofArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		if(nums==null||nums.length<=1)
			throw new IllegalArgumentException();
		int[] pre=new int[nums.length-1];
		int[] post=new int[nums.length-1];
		pre[0]=nums[0];
		post[0]=nums[nums.length-1];
		for(int i=1;i<nums.length-1;i++){
			pre[i]=pre[i-1]*nums[i];
			post[i]=post[i-1]*nums[nums.length-i-1];
		}
		int[] ret=new int[nums.length];
		ret[0]=post[nums.length-2];
		ret[nums.length-1]=pre[nums.length-2];
		for(int i=1;i<nums.length-1;i++){
			ret[i]=pre[i-1]*post[nums.length-i-2];
		}
		return ret;
	}
	public static void main(String[] args) {
		ProductofArrayExceptSelf self=new ProductofArrayExceptSelf();
		int[] a={1,2,3};
		int[] b=self.productExceptSelf(a);
		System.out.println(Arrays.toString(b));
	}
}
