package com.leetcode.test;

import java.util.Arrays;

public class SurroundedRegions {
	public void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;
		int m = board.length;
		int n = board[0].length;
		boolean[][] shouldO = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			Arrays.fill(shouldO[i], false);
		}
		for (int i = 1; i < m - 1; i++) {
			if (board[i][0] == 'O')
				changgeToO(board, shouldO, i, 0, 2);
			if (board[i][n - 1] == 'O')
				changgeToO(board, shouldO, i, n - 1, 4);
		}
		for (int j = 1; j < n - 1; j++) {
			if (board[0][j] == 'O')
				changgeToO(board, shouldO, 0, j, 3);
			if (board[m - 1][j] == 'O')
				changgeToO(board, shouldO, m - 1, j, 1);
		}
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++){
				if(shouldO[i][j])
					board[i][j]='O';
				else {
					board[i][j]='X';
				}
			}

	}

	private void changgeToO(char[][] boards, boolean[][] a, int i, int j,
			int diretion) {
		switch (diretion) {
		case 1:
			a[i][j] = true;
			if (i>0&&!a[i-1][j]&&boards[i - 1][j] == 'O') {
				changgeToO(boards, a, i - 1, j, 1);
				changgeToO(boards, a, i - 1, j, 2);
				changgeToO(boards, a, i - 1, j, 4);
			}
			break;
		case 2:
			a[i][j] = true;
			if (j<boards[0].length-1&&!a[i][j+1]&&boards[i][j + 1] == 'O') {
				changgeToO(boards, a, i, j + 1, 1);
				changgeToO(boards, a, i, j + 1, 2);
				changgeToO(boards, a, i, j + 1, 3);
			}
			break;
		case 3:
			a[i][j] = true;
			if (i<boards.length-1&&!a[i+1][j]&&boards[i + 1][j] == 'O') {
				changgeToO(boards, a, i + 1, j, 2);
				changgeToO(boards, a, i + 1, j, 3);
				changgeToO(boards, a, i + 1, j, 4);
			}
			break;
		case 4:
			a[i][j] = true;
			if (j>0&&!a[i][j-1]&&boards[i ][j-1] == 'O') {
				changgeToO(boards, a, i, j-1, 1);
				changgeToO(boards, a, i, j-1, 3);
				changgeToO(boards, a, i, j-1, 4);
			}
			break;
		}
	}
	public static void main(String[] args) {
		SurroundedRegions regions=new SurroundedRegions();
		char[][] board={{'O','O','O'},{'O','O','O'},{'O','O','O'}};
		regions.solve(board);
		System.out.println(Arrays.toString(board[0]));
	}
}
