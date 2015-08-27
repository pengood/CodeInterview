package com.nowcoder.offer;

import java.util.Arrays;

/*
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 
 * 例如 a b c e s f c s a d e e 3*4矩阵中包含一条字符串"bccced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class MatrixhasPathTest {
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if(matrix==null||matrix.length==0||rows<=0||cols<=0)
			return false;
		boolean[] visited=new boolean[matrix.length];
		Arrays.fill(visited, false);
		boolean ret=false;
		for(int i=0;i<matrix.length;i++){
			ret=helpHasPath(matrix, rows, cols, i,0, visited, str);
			if(ret)
				break;
		}
		return ret;
	}
	private boolean helpHasPath(char[] matrix,int rows,int cols,int i,int j,boolean[]visited,char[] str){
		if(j==str.length-1&&matrix[i]==str[j])
			return true;
		if(matrix[i]!=str[j])
			return false;
		boolean ret=false;
		visited[i]=true;
		if(i-cols>=0&&!visited[i-cols])
			ret=helpHasPath(matrix, rows, cols, i-cols, j+1, visited, str);
		if(!ret&&i+1<matrix.length&&!visited[i+1])
			ret=helpHasPath(matrix, rows, cols, i+1, j+1, visited, str);
		if(!ret&&i+cols<matrix.length&&!visited[i+cols])
			ret=helpHasPath(matrix, rows, cols, i+cols, j+1, visited, str);
		if(!ret&&i-1>=0&&!visited[i-1])
			ret=helpHasPath(matrix, rows, cols, i-1, j+1, visited, str);
		if(!ret)
			visited[i]=false;
		return ret;
	}
public static void main(String[] args) {
	char[] a={'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e' ,'e'};
	char[] t={'b','c','c','e','d','f'};
	char[] b="ABCESFCSADEE".toCharArray();
	char[] c="ABCB".toCharArray();
	MatrixhasPathTest test=new MatrixhasPathTest();
	System.out.println(test.hasPath(a, 3, 4, t));
	System.out.println(test.hasPath(b, 3, 4, c));
}
}
