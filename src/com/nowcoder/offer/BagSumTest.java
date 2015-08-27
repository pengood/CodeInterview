package com.nowcoder.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * 背包题目”的基本描述是：有一个背包，能盛放的物品总重量为S,设有N件物品，其重量分别为w1，w2，…，wn，
 * 希望从N件物品中选择若干物品，所选物品的重量之和恰能放进该背包，即所选物品的重量之和即是S。
 * 递归和非递归解法都能求得“背包题目”的一组解，试写出“背包题目”的非递归解法
 */
public class BagSumTest {
	public ArrayList<ArrayList<Integer>> findSumToTarget(int[] array, int target) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (array == null || array.length == 0)
			return list;
		boolean[] visited = new boolean[array.length];
		Arrays.fill(visited, false);
		helpFind(array, target, visited, list);
		return list;
	}

	HashMap<String, Integer> map = new HashMap<String, Integer>();
	private void helpFind(int[] array, int target, boolean[] visited,
			ArrayList<ArrayList<Integer>> list) {
		if(target<0)
			return;
		for (int i = 0; i < array.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if (array[i] == target) {
					StringBuilder builder = new StringBuilder();
					ArrayList<Integer> list2 = new ArrayList<Integer>();
					for (int j = 0; j < array.length; j++) {
						if (visited[j]) {
							list2.add(array[j]);
							builder.append(j);
						}
					}
					if (map.get(builder.toString()) == null){
						list.add(list2);
						map.put(builder.toString(), i);
					}
				}else {
					helpFind(array, target-array[i], visited, list);
				}
				visited[i]=false;
			}
		}
	}
	public static void main(String[] args) {
		int[] a={132,28,37,43,54,6,7,89,23};
		BagSumTest test=new BagSumTest();
		System.out.println(test.findSumToTarget(a, 67));
	}
}
