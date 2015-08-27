package com.leetcode.test;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		int[] rst = new int[2];
        int len = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i< len; i++) {
            Integer j = hm.get(target-nums[i]);
            if ((j = hm.get(target-nums[i])) != null) {
                rst[0] = j+1;
                rst[1] = i+1;
                return rst;
            }
            hm.put(nums[i], i);
        }
        return rst;
	}
	
	public static void main(String[] args){
		int[] numbers={2, 7, 11, 15};
		int target=9;
		System.out.print(Arrays.toString(twoSum(numbers, target)));
	}
}
