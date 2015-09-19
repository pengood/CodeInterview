package com.nowcoder.interview;
/*
 * 对于一个有正有负的整数数组，请找出总和最大的连续数列。
	给定一个int数组A和数组大小n，请返回最大的连续数列的和。保证n的大小小于等于3000。
	测试样例：
	[1,2,3,-6,1]
	返回：6
 */
public class MaxContiueArraySum {
	public int getMaxSum(int[] A, int n) {
        if(A==null||A.length==0)
        	return -1;
        int currentMax=Integer.MIN_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
        	if(currentMax<=0){
        		currentMax=A[i];
        	}else {
				currentMax+=A[i];
			}
        	if(currentMax>max)
        		max=currentMax;
        }
        return max;
    }
	public static void main(String[] args) {
		MaxContiueArraySum sum=new MaxContiueArraySum();
		int[] a={1,2,3,-6,1,1};
		System.out.println(sum.getMaxSum(a, 6));
	}
}
