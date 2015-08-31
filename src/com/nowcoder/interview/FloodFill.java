package com.nowcoder.interview;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 在一个nxm矩阵形状的城市里爆发了洪水，洪水从(0,0)的格子流到这个城市，在这个矩阵中有的格子有一些建筑，
 * 洪水只能在没有建筑的格子流动。请返回洪水流到(n - 1,m - 1)的最早时间(洪水只能从一个格子流到其相邻
 * 的格子且洪水单位时间能从一个格子流到相邻格子)。
	给定一个矩阵map表示城市，其中map[i][j]表示坐标为(i,j)的格子，值为1代表该格子有建筑，0代表没有建筑。
	同时给定矩阵的大小n和m(n和m均小于等于100)，请返回流到(n - 1,m - 1)的最早时间。保证洪水一定能流到终点。
 */
class Cell{
	int x;
	int y;
	Cell last;
	public Cell(int i,int j,Cell c) {
		// TODO Auto-generated constructor stub
		this.x=i;
		this.y=j;
		this.last=c;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x+","+y;
	}
	
}
public class FloodFill {
    public int floodFill(int[][] map, int n, int m) {
    	if(map==null||map.length==0||n<=0||m<=0)
    		throw new IllegalArgumentException();
    	boolean[][] visited=new boolean[n][m]; 
    	Queue<Cell> queue=new LinkedList<>();
    	Cell startCell=new Cell(0, 0, null);
    	queue.add(startCell);
    	visited[0][0]=true;
    	Cell end=null;
    	while(!queue.isEmpty()){
    		Cell cell=queue.poll();
    		System.out.println(cell);
    		int x=cell.x,y=cell.y;
    		if(x+1==n-1&&y==m-1||x==n-1&&y+1==m-1){
    		 end=new Cell(n-1, m-1, cell);
    			break;
    		}
    		if(x+1<n&&!visited[x+1][y]&&map[x+1][y]!=1){
    			Cell cell2=new Cell(x+1, y, cell);
    			visited[x+1][y]=true;
    			queue.add(cell2);
    		}
    		if(y+1<m&&!visited[x][y+1]&&map[x][y+1]!=1){
    			Cell cell2=new Cell(x, y+1, cell);
    			visited[x][y+1]=true;
    			queue.add(cell2);
    		}
    		if(x-1>=0&&!visited[x-1][y]&&map[x-1][y]!=1){
    			Cell cell2=new Cell(x-1, y, cell);
    			visited[x-1][y]=true;
    			queue.add(cell2);
    		}
    		if(y-1>=0&&!visited[x][y-1]&&map[x][y-1]!=1){
    			Cell cell2=new Cell(x, y-1, cell);
    			visited[x][y-1]=true;
    			queue.add(cell2);
    		}
    	}
    	System.out.println(queue.isEmpty());
    	if(end==null)
    		throw new IllegalArgumentException();
    	Cell cell=end;
    	int ret=1;
    	while(cell.last!=startCell){
    		ret++;
    		cell=cell.last;
    	}
    	return ret;
    }
    public static void main(String[] args) {
		int[][] a={
				{0,0,0,0,1,1,0,0},
				{0,1,1,0,1,0,0,0},
				{0,1,0,0,1,0,0,0},
				{0,1,0,1,0,0,1,0},
				{0,1,0,0,1,0,1,0},
				{1,1,0,0,0,0,1,0}};
		FloodFill fill=new FloodFill();
		System.out.println(fill.floodFill(a, a.length, a[0].length));
	}
}
