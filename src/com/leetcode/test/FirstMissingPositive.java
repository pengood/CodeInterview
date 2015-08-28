package com.leetcode.test;

import java.util.HashMap;

/*
 * Given an unsorted integer array, find the first missing positive integer.

	For example,
	Given [1,2,0] return 3,
	and [3,4,-1,1] return 2.

	Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		HashMap<Integer, Boolean> map=new HashMap<>();
		int first=1;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==first){
				first++;
				while(map.get(first)!=null){
					first++;
				}
			}else {
				map.put(nums[i], true);
			}
		}
		return first;
	}
	public static void main(String[] args) {
		int[] a={1,2,0};
		int[] b={3,4,-1,1};
		FirstMissingPositive positive=new FirstMissingPositive();
		System.out.println(positive.firstMissingPositive(b));
	}
}
