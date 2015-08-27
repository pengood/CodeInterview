package com.leetcode.test;

public class Searcha2DMatrixII {
	 public boolean searchMatrix(int[][] matrix, int target) {
		 if(matrix==null||matrix.length==0)
			 return false;
		 int m=matrix.length;
		 int n=matrix[0].length;
		 int i=0,j=n;
		 boolean ret=false;
		 while(true){
			 if(i>=m||j<0)
				 break;
			 if(target==matrix[i][j]){
				 ret=true;
				 break;
			 }
			 else if(target<matrix[i][j]){
				 j--;
				 continue;
			 }
			 else if (target>matrix[i][j]) {
				i++;
				continue;
			}
		 }
		 
		return ret;
	    }
	 public static void main(String[] args) {
		int [][] a=new int[3][4];
		System.out.println(a[0].length);
	}
}
