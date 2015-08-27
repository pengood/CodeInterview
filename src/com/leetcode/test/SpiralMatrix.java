package com.leetcode.test;

public class SpiralMatrix {

	public static int[][] generateMatrix(int n) {
		int i = 1, direct = 0, a = 0, b = -1;
		int len = n * n;
		boolean[][] marked = new boolean[n][n];
		int[][] rt = new int[n][n];
		while (i <= len) {
			switch (direct) {
			case 0:
				int j = b + 1;
				for (; j < n; j++) {
					if (marked[a][j])
						break;
					rt[a][j] = i;
					i++;
					marked[a][j] = true;
				}
				b = j - 1;
				direct = 1;
				break;
			case 1:
				int k = a + 1;
				for (; k < n; k++) {
					if (marked[k][b])
						break;
					rt[k][b] = i;
					i++;
					marked[k][b] = true;
				}
				a = k - 1;
				direct = 2;
				break;
			case 2:
				int l = b - 1;
				for (; l >= 0; l--) {
					if (marked[a][l])
						break;
					rt[a][l] = i;
					i++;
					marked[a][l] = true;
				}
				b = l + 1;
				direct = 3;
				break;
			case 3:
				int m = a - 1;
				for (; m >= 0; m--) {
					if (marked[m][b])
						break;
					rt[m][b] = i;
					i++;
					marked[m][b] = true;
				}
				a = m + 1;
				direct = 0;
				break;
			default:
				break;
			}
		}
		return rt;
	}

	public static int[][] generateMatrix1(int n) {
		int[][] rt = new int[n][n];
		int end = n / 2, start = 0;
		int num = 1;
		while (start < end) {
			for (int i = start; i <= n - start - 1; i++) {
				rt[start][i] = num;
				num++;
			}
			for(int i=start+1;i<=n-start-1;i++){
				rt[i][n-start-1] = num;
				num++;
			}
			for (int i = n-start-2; i >=start; i--) {
				rt[n-start-1][i] = num;
				num++;
			}
			for(int i=n-start-2;i>=start+1;i--){
				rt[i][start] = num;
				num++;
			}
			start++;
		}
		if((n&1)!=0)
			rt[end][end]=num;
		return rt;
	}

	public static void main(String[] args) {
		int[][] a = generateMatrix1(5);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}
}
