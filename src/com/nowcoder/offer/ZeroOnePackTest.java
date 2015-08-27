package com.nowcoder.offer;

public class ZeroOnePackTest {
	public int zeroonepack(int[] weights, int[] values, int maxWeight) {
		int items = weights.length;
		int[][] V = new int[items + 1][maxWeight + 1];
		for (int i = 0; i <= maxWeight; i++)
			V[0][i] = 0;
		for (int i = 0; i <= items; i++)
			V[i][0] = 0;
		for (int item = 1; item <= items; item++) {
			for (int weight = 1; weight <= maxWeight; weight++) {
				if (weights[item-1] > weight) {
					V[item][weight] = V[item - 1][weight];
				} else {
						V[item][weight] = Math.max(V[item - 1][weight],
								V[item - 1][weight- weights[item - 1]]+ values[item - 1]);
					
				}
			}
		}
		return V[items][maxWeight];

	}

	public static void main(String[] args) {
		ZeroOnePackTest test = new ZeroOnePackTest();
		int[] v = { 10, 40, 30, 50 };
		int[] w = { 5, 4, 6, 3 };
		int W = 10;
		System.out.println(test.zeroonepack(w, v, W));
	}
}
