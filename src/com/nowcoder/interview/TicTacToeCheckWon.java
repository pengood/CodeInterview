package com.nowcoder.interview;

/*
 * 对于一个给定的井字棋棋盘，请设计一个高效算法判断当前玩家是否获胜。
 给定一个二维数组board，代表当前棋盘，其中元素为1的代表是当前玩家的棋子，为0表示没有棋子，为-1代表是对方玩家的棋子。
 测试样例：
 [[1,0,1],[1,-1,-1],[1,-1,0]]
 返回：true
 */
public class TicTacToeCheckWon {
	public boolean checkWon(int[][] board) {
		boolean[] row=new boolean[3];
		boolean[] col=new boolean[3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(board[i][j]!=1){
					row[i]=false;
					col[j]=false;
				}
			}
		}
		for(int i=0;i<3;i++){
			if(row[i]){
				if(board[i][0]==1&&board[i][1]==1&&board[i][2]==1)
					return true;
			}
		}
		for(int i=0;i<3;i++){
			if(col[i]){
				if(board[0][i]==1&&board[1][i]==1&&board[2][i]==1)
					return true;
			}
		}
		if(board[0][0]==1&&board[1][1]==1&&board[2][2]==1) return true;
		if(board[0][2]==1&&board[1][1]==1&&board[2][0]==1) return true;
		return false;
	}
}
