package com.nowcoder.interview;
/*
 * 数组A包含了0到n的所有整数，但其中缺失了一个。对于这个问题，我们设定限制，
 * 使得一次操作无法取得数组number里某个整数的完整内容。唯一的可用操作是询问
 * 数组中第i个元素的二进制的第j位(最低位为第0位)，该操作的时间复杂度为常数，
 * 请设计算法，在O(n)的时间内找到这个数。
	给定一个数组number，即所有剩下的数按从小到大排列的二进制各位的值，
	如A[0][1]表示剩下的第二个数二进制从低到高的第二位。同时给定一个int n，
	意义如题。请返回缺失的数。
	测试样例：
	[[0],[0,1]]
	返回：1
 */
public class FindMissing {
	//have bug
	public int findMissing(int[][] numbers, int n) {
		if(numbers==null||numbers.length==0)
			return -1;
        int x=0;
        for(int i=0;i<=n;i++)
        	x^=i;
        int m=numbers.length;
        int n1=numbers[0].length;
       
        for(int i=1;i<m;i++){
        	for(int j=0;j<n1;j++){
        		numbers[0][j]^=numbers[i][j];
        	}
        } 
        int tmp=0;
        for(int i=0;i<n1;i++){
        	if(numbers[0][i]==1){
        		tmp+=(1<<i);
        	}
        }
        return tmp^x;
    }
	public int findMissing1(int[][] numbers, int n){
		if(numbers==null||numbers.length==0)
			return -1;
		for(int row=0;row<n;row++){
			if(row%2!=numbers[row][0])
				return row;
		}
		return n;
	}
	public static void main(String[] args) {
		int[][] a={{0},{0,1},{1,1}};
		FindMissing missing=new FindMissing();
		System.out.println(missing.findMissing(a, 3));
	}
}
