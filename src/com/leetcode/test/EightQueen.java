package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

class Queen {
	public int x;
	public int y;

	public Queen(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class EightQueen {
	public int totalNQueens(int n) {
		Queen[]  queens=new Queen[n];
		for(int i=0;i<n;i++){
			queens[i]=new Queen(i+1, 0);
		}
		while(queens[0].y<=n){
			queens[0].y++;
			
		}
		return n;
		
	}
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		list.add(2, 2);
	}
}
