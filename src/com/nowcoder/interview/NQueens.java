package com.nowcoder.interview;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 请设计一种算法，解决著名的n皇后问题。这里的n皇后问题指在一个nxn的棋盘上放置n个棋子，
 * 使得每行每列和每条对角线上都只有一个棋子，求其摆放的方法数。
 给定一个int n，请返回方法数，保证n小于等于
 测试样例：
 1
 返回：1
 */
public class NQueens {
	int GRID_SIZE;
	public int nQueens(int n) {
		// write code here
		GRID_SIZE=n;
		int[] columns=new int[n];
		Arrays.fill(columns, 0);
		ArrayList<int[]> result=new ArrayList<>();
		placeQueens(0, columns, result);
		for(int[] a:result){
			System.out.println(Arrays.toString(a));
		}
		return result.size();
	}
	private void placeQueens(int row,int[] columns,ArrayList<int[]> results){
		if(row==GRID_SIZE){
			results.add(columns.clone());
		}else {
			for(int col=0;col<GRID_SIZE;col++){
				if(checkValid(columns, row, col)){
					columns[row]=col;
					placeQueens(row+1, columns, results);
				}
			}
		}
	}
	/*
	 * 检查(row1,column1)是否可以放Queen
	 */
	private boolean checkValid(int[] colnums,int row1,int column1){
		for(int row2=0;row2<row1;row2++){
			int column2=colnums[row2];
			if(column2==column1)
				return false;
			int columnDistance=Math.abs(column2-column1);
			int rowDistance=row1-row2;
			if(columnDistance==rowDistance)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		NQueens queens=new NQueens();
		System.out.println(queens.nQueens(8));
	}
}
