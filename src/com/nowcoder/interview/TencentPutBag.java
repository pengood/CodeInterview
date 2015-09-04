package com.nowcoder.interview;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 22 “背包题目”的基本描述是：有一个背包，能盛放的物品总重量为S,设有N件物品，其重量分别为w1，w2，…，wn，
 * 希望从N件物品中选择若干物品，所选物品的重量之和恰能放进该背包，即所选物品的重量之和即是S。递归和非递归解法都
 * 能求得“背包题目”的一组解，试写出“背包题目”的非递归解法
 */
public class TencentPutBag {
	// 递归解法
	boolean[] visited;
	public ArrayList<ArrayList<Integer>> put(int s, int[] wn) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		Arrays.sort(wn);
		visited = new boolean[wn.length];
		for (int i = wn.length - 1; i >= 0; i--)
			helpput(list, s, wn, i);
		return list;
	}

	private void helpput(ArrayList<ArrayList<Integer>> list, int total,
			int[] wn, int i) {
		if (total < wn[i])
			return;
		if (total == wn[i]) {
			visited[i] = true;
			ArrayList<Integer> list2 = new ArrayList<>();
			for (int j = 0; j < wn.length; j++) {
				if (visited[j])
					list2.add(wn[j]);
			}
			list.add(list2);
			visited[i] = false;
			return;
		}
		visited[i] = true;
		for (int j = i - 1; j >= 0; j--) {
			helpput(list, total - wn[i], wn, j);
		}
		visited[i] = false;
	}

	public static void main(String[] args) {
		int[] wn = { 1, 2, 3, 4, 5, 6, 7, 8, 9 ,20};
		TencentPutBag bag = new TencentPutBag();
		System.out.println(bag.put(30, wn));
	}
}
