package com.offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinK {
	public static int[] getminK(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0 || k > nums.length)
			throw new IllegalArgumentException();
		int[] ret = new int[k];
		int start = 0;
		int end = nums.length - 1;
		int index = QiuckSort.myPartition(nums, start, end);
		while (index != k - 1) {
			if (index >= k) {
				end = index - 1;
				index = QiuckSort.myPartition(nums, start, end);
			} else {
				start = index + 1;
				index = QiuckSort.myPartition(nums, start, end);
			}
		}
		for (int i = 0; i < k; i++)
			ret[i] = nums[i];
		return ret;
	}

	public static int[] getminKbymaxQueue(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0 || k > nums.length)
			throw new IllegalArgumentException();
		PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return -o1.compareTo(o2);
			}
		});
		int[] ret=new int[k];
		for(int i=0;i<nums.length;i++){
			if(queue.size()>=k){
				if(queue.peek()>nums[i]){
					queue.poll();
					queue.add(nums[i]);
				}
			}
			else {
				queue.add(nums[i]);
			}
		}
		int i=k-1;
		while(!queue.isEmpty()&&i>=0){
			ret[i]=queue.poll();
			i--;
		}
			return ret;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 4, 6, 3, 1, 4, 1 };
		System.out.print(Arrays.toString(getminKbymaxQueue(nums, 1)));

	}
}
