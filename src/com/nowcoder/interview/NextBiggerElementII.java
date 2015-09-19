package com.nowcoder.interview;

import java.util.Arrays;

/*
 * 现在有一个数组，请找出数组中每个元素的后面比它大的最小的元素，若不存在则为-1。
 给定一个int数组A及数组的大小n，请返回每个元素所求的值组成的数组。保证A中元素为正整数，且n小于等于1000。
 测试样例：
 [11,13,10,5,12,21,3],7
 [12,21,12,12,21,-1,-1]
 */
public class NextBiggerElementII {
	public int[] findNext(int[] A, int n) {
		if(A==null||n<=0)
			throw new IllegalArgumentException();
		int[] result=new int[n];
		for(int i=0;i<n;i++){
			int j=i+1;
			int min=Integer.MAX_VALUE;
			for(;j<n;j++){
				if(A[j]>A[i]&&A[j]<min){
					min=A[j];
					result[i]=min;
				}
			}
			if(min==Integer.MAX_VALUE)
				result[i]=-1;
		}
		return result;	
	}
	public static void main(String[] args) {
		NextBiggerElementII nextBiggerElementII=new NextBiggerElementII();
		int[] a={11,13,10,5,12,21,3};
		System.out.println(Arrays.toString(nextBiggerElementII.findNext(a, a.length)));
	}
}
