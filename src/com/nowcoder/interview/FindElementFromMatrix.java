package com.nowcoder.interview;

import java.util.Arrays;

/*
 * 有一个NxM的整数矩阵，矩阵的行和列都是从小到大有序的。请设计一个高效的查找算法，查找矩阵中元素x的位置。
	给定一个int有序矩阵mat，同时给定矩阵的大小n和m以及需要查找的元素x，请返回一个二元数组，代表该元素的行号和列号(均从零开始)。保证元素互异。
	测试样例：
	[[1,2,3],[4,5,6]],2,3,6
	返回：[1,2]
 */
public class FindElementFromMatrix {
	 public int[] findElement(int[][] mat, int n, int m, int x) {
		 int[] ret=new int[2];
		 int row=0;
		 int col=m-1;
		 while(row<=n-1&&col>=0){
			 int num=mat[row][col];
			 if(num==x){
				 ret[0]=row;
				 ret[1]=col;
				 break;
			 }
			 if(num>x){
				 col--;
			 }else {
				row++;
			}
		 }
		 return ret;
	    }
	 public static void main(String[] args) {
		int[][] a={{1,2,3},{4,5,6}};
		FindElementFromMatrix elementFromMatrix=new FindElementFromMatrix();
		int[] re=elementFromMatrix.findElement(a, 2, 3, 6);
		System.out.println(Arrays.toString(re));
	}
}
