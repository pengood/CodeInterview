package com.nowcoder.interview;

/*
 * 请编写一个算法，若MxN矩阵中某个元素为0，则将其所在的行与列清零。
 给定一个MxN的int[][]矩阵(C++中为vector>)mat和矩阵的阶数n，请返回完成操作后的int[][]矩阵(C++中为vector>)，
 保证n小于等于300，矩阵中的元素为int范围内。
 测试样例：
 [[1,2,3],[0,1,2],[0,0,1]]
 返回：[[0,0,3],[0,0,0],[0,0,0]]
 */
public class ClearZeroTest {
	public int[][] clearZero(int[][] mat, int n) {
		if(mat==null||mat.length==0)
			return mat;
		boolean[] row=new  boolean[mat.length];
		boolean[] col=new boolean[mat[0].length];
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
				if(mat[i][j]==0){
					row[i]=true;
					col[j]=true;
				}
			}
		}
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
				if(row[i]||col[j]){
					mat[i][j]=0;
				}
			}
		}
		return mat;
	}
}
