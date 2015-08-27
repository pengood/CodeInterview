package com.nowcoder.offer;

public class FindNum {
	public boolean Find(int [][] array,int target) {
		if(array==null||array.length==0)
			return false;
		int m=array.length;
		int n=array[0].length;
		int i=0,j=n-1;
		while(i<=m-1&&j>=0){
			if(array[i][j]==target)
				return true;
			if(array[i][j]<target){
				i++;
			}
			else if(array[i][j]>target){
				j--;
			}
		}
		return false;
		
    }
	public static void main(String[] args) {
		int[][] a={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		FindNum num=new FindNum();
		System.out.println(num.Find(a, 15));
	}
}
