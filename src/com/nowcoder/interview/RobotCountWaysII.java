package com.nowcoder.interview;
/*
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。
 * 请设计一个算法，计算机器人有多少种走法。注意这次的网格中有些障碍点是不能走的。
	给定一个int[][] map(C++ 中为vector >),表示网格图，若map[i][j]为1
	则说明该点不是障碍点，否则则为障碍。另外给定int x,int y，表示网格的大小。
	请返回机器人从(0,0)走到(x - 1,y - 1)的走法数，为了防止溢出，
	请将结果Mod 1000000007。保证x和y均小于等于50
 */
public class RobotCountWaysII {
	public int countWays(int[][] map, int x, int y) {
        // write code here
		if(x<0||y<0)
			throw new IllegalArgumentException();
		if(map[0][0]!=1)
			return 0;
		//result[][]记录从第一个点到任意点的路径数
        int[][] result=new int[map.length][map[0].length];
        result[0][0]=1;//默认到自身的路径数为1
         
        //对第一列进行求值
        for(int i=1;i<x;i++){
            if(map[i][0]==1){
                result[i][0]=result[i-1][0];
            }else{
                result[i][0]=0;
            }
        }
         
        //对第一行进行求值
        for(int j=1;j<y;j++){
           if(map[0][j]==1){
                result[0][j]=result[0][j-1];
            }else{
                result[0][j]=0;
            }    
        }
        //出第一列第一行以外点的路径数等于上一个点的路径数与左一个点的路径数之和
        for(int i=1;i<x;i++){
            for(int j=1;j<y;j++){
                if(map[i][j]==1){
                    result[i][j]=(result[i][j-1]+result[i-1][j])%1000000007;
                }
            }
        }
         
        return result[x-1][y-1];
		
    }
	public static void main(String[] args) {
		
	}
}
