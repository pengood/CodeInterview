package com.nowcoder.offer;

import java.util.ArrayList;

public class PrintMatrixTest {
	public ArrayList<Integer> printMatrix(int [][] matrix) {
	       ArrayList<Integer> list=new ArrayList<>();
	       if(matrix==null||matrix.length==0)
	    	   return list;
	       int m=matrix.length;
	       int n=matrix[0].length;
	       int rowBegin=0,rowEnd=m-1;
	       int columnBegin=0,columnEnd=n-1;
	       while(rowBegin<=rowEnd&&columnBegin<=columnEnd){
	    	   int a=rowBegin,b=columnBegin;
	    	   while(b<=columnEnd){
	    		   list.add(matrix[a][b]);
	    		   b++;
	    	   }
	    	   if(rowBegin==rowEnd)
	    		   break;
	    	   b=columnEnd;
	    	   a=rowBegin+1;
	    	   while(a<=rowEnd){
	    		   list.add(matrix[a][b]);
	    		   a++;
	    	   }
	    	   if(columnBegin==columnEnd)
	    		   break;
	    	   a=rowEnd;
	    	   b=columnEnd-1;
	    	   while(b>=columnBegin){
	    		   list.add(matrix[a][b]);
	    		   b--;
	    	   }
	    	   b=columnBegin;
	    	   a=rowEnd-1;
	    	   while(a>rowBegin){
	    		   list.add(matrix[a][b]);
	    		   a--;
	    	   }
	    	   rowBegin++;rowEnd--;
	    	   columnBegin++;columnEnd--;
	       }
	       return list;
    }
	public static void main(String[] args) {
		int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
		int[][] b={{1,2,3},{4,5,6},{7,8,9}};
		int[][] c={{1},{2},{3},{4},{5}};
		int[][] d={{1,2,3,4,5}};
		PrintMatrixTest test=new PrintMatrixTest();
		System.out.println(test.printMatrix(a));
		System.out.println(test.printMatrix(b));
		System.out.println(test.printMatrix(c));
		System.out.println(test.printMatrix(d));
	}
}
