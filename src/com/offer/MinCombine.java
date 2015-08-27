package com.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinCombine {
	public static void minnumber(int[] nums) {
		if (nums == null || nums.length == 0)
			throw new IllegalArgumentException();
		if (nums.length == 1)
			System.out.print(nums[0]);
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < nums.length; i++) {
			char[] num = new char[10];
			Arrays.fill(num, '0');
			int number = nums[i];
			for (int j = 9; j >= 0; j--) {
				num[j] = (char) ((number % 10) + '0');
				number = number / 10;
				if (number == 0)
					break;
			}
			list.add(String.valueOf(num));
		}
		for (String string : list)
			System.out.print(string + " ");
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int i = 0, j = 0;
				while (o1.charAt(i) == '0')
					i++;
				while (o2.charAt(j) == '0')
					j++;
				StringBuilder sb1 = new StringBuilder();
				StringBuilder sb2 = new StringBuilder();
				sb1.append(o1, i, 10).append(o2, j, 10);
				sb2.append(o2, j, 10).append(o1, i, 10);
				for (i = 0; i < sb1.length(); i++) {
					if (sb1.charAt(i) == sb2.charAt(i))
						continue;
					if (sb1.charAt(i) > sb2.charAt(i))
						return +1;
					else {
						return -1;
					}
				}
				return 0;
			}
		});
		System.out.println();
		for (String string : list)
			System.out.print(string + " ");
		int[] first = new int[nums.length];
		Arrays.fill(first, 0);
		for (int i = 0; i < nums.length; i++) {
			while (list.get(i).charAt(first[i]) == '0')
				first[i]++;
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			stringBuilder.append(list.get(i), first[i], 10);
		}
		System.out.println();
		System.out.print(stringBuilder);
	}

	public static void main(String[] args) {
		int[] nums = { 3, 31, 321, 12, 1211 };
		minnumber(nums);
	}
}
