package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		mypermute(list, nums, 0, nums.length);
		return list;
	}

	public static void mypermute(List<List<Integer>> list, int[] a, int start,
			int end) {
		if (start == end - 1){
			List<Integer> list2=new ArrayList<>();
			for(int i=0;i<end;i++)
				list2.add(new Integer(a[i]));
			list.add(list2);
		}
			
		else {
			for (int i = start; i <= end-1; i++) {
				swap(a, start, i);
				mypermute(list, a, start + 1, end);
				swap(a, i, start);
			}
		}

	}

	public static void swap(int[] b, int i, int j) {
		int tmp = b[i];
		b[i] = b[j];
		b[j] = tmp;
	}
	//测试八皇后问题
	public static void main(String[] args) {
		int[] a = { 0,1,2,3,4,5,6,7 };
		List<List<Integer>> list = permute(a);
		List<List<Integer>> list3 =new ArrayList<List<Integer>>();
		int count=0;
		for (List<Integer> list2 : list) {
		//System.out.println(list2);
			boolean isbreak=false;
			for(int i=0;i<8;i++){
				for(int j=i+1;j<8;j++){
					if(i-j==list2.get(i)-list2.get(j)||j-i==list2.get(i)-list2.get(j))
						{isbreak=true;
							break;
						}
				}
				if(isbreak)
					break;
			}
			if(!isbreak)
				{count++;
				list3.add(list2);
				}
		}
		System.out.println(count);
		for(List<Integer> list2:list3){
			System.out.println(list2);
		}
	}
}
