package com.leetcode.test;

/*
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3
 */
public class NumberofIslands {
	public int numIslands(char[][] grid) {
		if(grid==null||grid.length==0)
			return 0;
		boolean[][] visited=new boolean[grid.length][grid[0].length];
		int count=0;
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j]=='0'||visited[i][j])
					continue;
				count++;
				dfs(grid, visited, i, j);
			}
		}
		return count;
	}
	
	private void dfs(char[][] grid,boolean[][] visited,int i,int j){
		if(i<0||j<0||i>=grid.length||j>=grid[0].length)
			return;
		if(grid[i][j]=='0'||visited[i][j])
			return;
		visited[i][j]=true;
		dfs(grid, visited, i-1, j);
		dfs(grid, visited, i+1, j);
		dfs(grid, visited, i, j-1);
		dfs(grid, visited, i, j+1);
	}
	public static void main(String[] args) {
		char[][] chars={"11000".toCharArray(),"11000".toCharArray(),"00100".toCharArray(),"00011".toCharArray()};
		NumberofIslands islands=new NumberofIslands();
		System.out.println(islands.numIslands(chars));
	}
}
