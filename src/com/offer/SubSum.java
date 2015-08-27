package com.offer;

public class SubSum {
	public static int[] maxSum(int[] nums) {
		if (nums == null || nums.length == 0)
			throw new IllegalArgumentException();
		int[] re = new int[3];
		re[0] = re[1]= 0; // re[0] start,re[0] end,re[2] sum,
		re[2] = nums[0];
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (sum <= 0) {
				sum = nums[i];
				if(sum>re[2])
					re[0]=i;
				
			} else {
				sum += nums[i];
			}
			if (sum > re[2]) {
				re[2] = sum;
				re[1] = i;
			}
		}
		
		return re;
	}

	public static void main(String[] args) {
		int[] nums = { -1, -2, 4, -10, 3, 7, -2, -5 };
		int[] result = maxSum(nums);
		for (int i = result[0]; i <= result[1]; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.print("Sum is " + result[2]);
	}
}
