package com.nowcoder.offer;

/*
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class RobotMovingCountTest {
	int count;
	boolean[][] visited;
	public int movingCount(int threshold, int rows, int cols) {
		if(rows<=0||cols<=0||threshold<0)
			return 0;
		visited=new boolean[rows][cols];
		move(0, 0, threshold, rows, cols);
		return count;
	}
	private void move(int i,int j,int threshold,int rows,int cols){
		if(checkThreshold(i, j, threshold))
			return;
		visited[i][j]=true;
		count++;
		if(i-1>=0&&!visited[i-1][j])
			move(i-1, j, threshold, rows, cols);
		if(j+1<cols&&!visited[i][j+1])
			move(i, j+1, threshold, rows, cols);
		if(i+1<rows&&!visited[i+1][j])
			move(i+1, j, threshold, rows, cols);
		if(j-1>=0&&!visited[i][j-1])
			move(i, j-1, threshold, rows, cols);
	}
	private boolean checkThreshold(int i,int j,int threshold){
		int sum=0;
		while(i%10!=0){
			sum+=i%10;
			i/=10;
		}
		while(j%10!=0){
			sum+=j%10;
			j/=10;
		}
		if(sum>threshold)
			return true;
		return false;
	}
	public static void main(String[] args) {
		RobotMovingCountTest test=new RobotMovingCountTest();
		System.out.println(test.movingCount(15,20,20));
	}
}
