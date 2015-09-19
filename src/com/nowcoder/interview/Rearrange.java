package com.nowcoder.interview;

import java.util.Arrays;

/*
 * 有一个整数数组，请编写一个函数，找出索引m和n，只要将m和n之间的元素排好序，整个数组就是有序的。
 * 注意：n-m应该越小越好，也就是说，找出符合条件的最短序列。
	给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的起点和终点。
	(原序列位置从0开始标号,若原序列有序，返回[0,0])。保证A中元素均为正整数。
	测试样例：
	[1,4,6,5,9,10],6
返回：[2,3]
 */
public class Rearrange {
	 public int[] findSegment(int[] A, int n) {
		 int[] ret=new int[2];
		 if(A==null||A.length<=1)
			 return ret;
		 int m=0;
		 int max=A[0];
		 for(int i=1;i<A.length;i++){
			 if(A[i]>=max)
				 max=A[i];
			 else {
				m=i;
			}
		 }
		 int n1=0;
		 int min=A[A.length-1];
		 for(int i=A.length-2;i>=0;i--){
			 if(A[i]<=min)
				 min=A[i];
			 else {
				n1=i;
			}
		 }
		 ret[0]=n1;
		 ret[1]=m;
		 return ret;
	    }
	 public static void main(String[] args) {
		int[] a={1,4,5,6,9,10};
		Rearrange rearrang=new Rearrange();
		int[] re=rearrang.findSegment(a, 6);
		System.out.println(Arrays.toString(re));
	}
}
