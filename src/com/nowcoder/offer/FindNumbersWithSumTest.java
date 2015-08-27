package com.nowcoder.offer;

import java.util.ArrayList;

/*
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSumTest {
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		if (array == null || array.length < 2
				|| array[array.length - 1] * 2 < sum)
			return list;
		int i = 0;
		int j = array.length - 1;
		while (i < j) {
			int num = array[i] + array[j];
			if (num == sum) {
				list.add(array[i]);
				list.add(array[j]);
				return list;
			} else if (num < sum) {
				i++;
			} else {
				j--;
			}
		}
		return list;
	}
	public static void main(String[] args) {
		int[] a={2,2,4,5,6,8};
		FindNumbersWithSumTest test=new FindNumbersWithSumTest();
		System.out.println(test.FindNumbersWithSum(a, 9));
	}
}
