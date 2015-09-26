package com.leetcode.test;

import java.util.HashMap;

/*
 * Given an array of integers and an integer k, find out whether 
 * there are two distinct indices i and j in the array such that 
 * nums[i] = nums[j] and the difference between i and j is at most k.
 */
public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || nums.length <= 1)
			return false;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int n = nums[i];
			if (map.get(n) == null) {
				map.put(n, i);
			} else {
				if (i - map.get(n) > k)
					map.put(n, i);
				else {
					return true;
				}
				
			}
		}
		return false;
	}
}
