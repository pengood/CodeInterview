package com.leetcode.test;

import java.util.Arrays;

public class LongestCommonSubsequence {
	public static <T> void lcs(char[] a, char[] b) {
		int len1 = a.length, len2 = b.length;
		int[][] c = new int[len1 + 1][len2 + 1];
		for (int i = 0; i < len1 + 1; i++)
			Arrays.fill(c[i], 0);
		for(int i=1;i<=len1;i++)
			for(int j=1;j<=len2;j++){
				if(a[i-1]==b[j-1])
					c[i][j]=c[i-1][j-1]+1;
				else if(c[i-1][j]>=c[i][j-1])
					c[i][j]=c[i-1][j];
				else c[i][j]=c[i][j-1];
			}
		printLcs(c, a, len1, len2);
	}
	private static <T> void printLcs(int[][] c,char[] a,int i,int j){
		if(i==0||j==0){
			return;
		}
		if(c[i][j]==c[i-1][j-1]+1&&c[i][j]>c[i][j-1]&&c[i][j]>c[i-1][j]){
			printLcs(c, a, i-1, j-1);
			System.out.println(a[i-1]);
		}
		else if(c[i-1][j]>=c[i][j-1])
			printLcs(c, a, i-1, j);
		else  printLcs(c, a, i, j-1);
	}
	public static void main(String[] args) {
		char[] A={'A','B','C','B','D','A','B'};
		char[] B={'B','D','C','A','B','A'};
		lcs(A, B);
	}
}
