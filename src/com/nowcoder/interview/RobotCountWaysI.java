package com.nowcoder.interview;

/*
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
 给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 测试样例：
 2,2
 返回：2
 */
public class RobotCountWaysI {
	public int countWays(int x, int y) {
		// write code here
		if(x<0||y<0)
			throw new IllegalArgumentException();
		int n=x-1;
		int m=x+y-2;
		int a=1;
		int i=m;
		while(i>=m-n+1){
			a*=i;
			i--;
		}
		int b=1;
		int j=n;
		while(j>=1){
			b*=j;
			j--;
		}
		return a/b;
	}
	public static void main(String[] args) {
		RobotCountWaysI waysI=new RobotCountWaysI();
		System.out.println(waysI.countWays(2, 2));
	}
}
