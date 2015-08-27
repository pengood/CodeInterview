package com.nowcoder.offer;

import java.util.ArrayList;

/*
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbersTest {
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		if (input == null || input.length == 0 || k < 1||k>input.length)
			return list;
		int begin = 0;
		int end = input.length - 1;
		int index = partion(input, begin, end);
		while (index != k - 1) {
			if (index > k - 1) {
				end = index - 1;
				index = partion(input, begin, end);
			} else if (index < k - 1) {
				begin = index + 1;
				index = partion(input, begin, end);
			}
		}
		for (int i = 0; i < k; i++)
			list.add(input[i]);
		return list;
	}

	private int partion(int[] array, int begin, int end) {
		int root = array[begin];
		int i = begin + 1;
		int j = end;
		while (i < end && j > begin) {
			while (i < end && array[i] < root)
				i++;
			while (j > begin && array[j] > root)
				j--;
			if (i >= j)
				break;
			int tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
		}
		if (root > array[j]) {
			array[begin] = array[j];
			array[j] = root;
		}

		return j;
	}

	public static void main(String[] args) {
		GetLeastNumbersTest test = new GetLeastNumbersTest();
		int[] a = { 4, 5, 1, 6, 2, 7, 3, 8 };
		System.out.println(test.GetLeastNumbers_Solution(a, 4));
	}
}
