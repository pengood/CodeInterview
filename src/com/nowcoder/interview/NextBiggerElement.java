package com.nowcoder.interview;

import java.util.Arrays;

/*
 * 现在我们有一个int数组，请你找出数组中每个元素的下一个比它大的元素。
	给定一个int数组A及数组的大小n，请返回一个int数组，代表每个元素比他大的下一个元素,若不存在则为-1。保证数组中元素均为正整数。
	测试样例：
	[11,13,10,5,12,21,3],7
	返回：[13,21,12,12,21,-1,-1]
 */
public class NextBiggerElement {
	public int[] findNext(int[] A, int n) {
		if(A==null)
			return null;
		if(A.length==0)
			return new int[0];
		int[] re=new int[n];
		for(int i=0;i<n;i++){
			int j=i+1;
			for(;j<n;j++){
				if(A[j]>A[i]){
				re[i]=A[j];
				break;
				}
			}
			if(j==n)
				re[i]=-1;
		}
		return re;
    }
	public static void main(String[] args) {
		int[] a={11,13,10,5,12,21,3};
		NextBiggerElement biggerElement=new NextBiggerElement();
		System.out.println(Arrays.toString(biggerElement.findNext(a, a.length)));
	}
}
