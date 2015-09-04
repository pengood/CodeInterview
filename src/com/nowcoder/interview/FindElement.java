package com.nowcoder.interview;
/*
 * 有一个排过序的数组，包含n个整数，但是这个数组向左进行了一定长度的移位，例如，原数组为[1,2,3,4,5,6]，向左移位5个位置即
 * 变成了[6,1,2,3,4,5],现在对于移位后的数组，需要查找某个元素的位置。请设计一个复杂度为log级别的算法完成这个任务。
	给定一个int数组A，为移位后的数组，同时给定数组大小n和需要查找的元素的值x，请返回x的位置(位置从零开始)。保证数组中元素互异。
	测试样例：
	[6,1,2,3,4,5],6,6
	返回：0
 */
public class FindElement {
	 public int findElement(int[] A, int n, int x) {
		 int begin=0;
		 int end=n-1;
		 int mid=0;
		 while(begin<=end){
			  mid=begin+(end-begin)/2;
			 if(A[mid]==x)
				 break;
			 //左边排序
			 if(A[begin]<A[mid]){
				 if(A[begin]<=x&&A[mid]>x){
					 end=mid-1;
				 }else {
					begin=mid+1;
				}
			 }else {
				if(A[mid]<x&&A[end]>=x){
					begin=mid+1;
				}else {
					end=mid-1;
				}
			}
		 }
		 return mid;
	    }
	 public static void main(String[] args) {
		int[] a={10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,1,2,3,4,5,6,7,8,9};
		FindElement element=new FindElement();
		System.out.println(element.findElement(a, 80, 6));
	}
}
