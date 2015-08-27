package com.nowcoder.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class MultiplyTest {
	 public int[] multiply(int[] A) {
		 if(A==null||A.length<2)
			 return null;
		 int[] B=new int[A.length];
		 List<Integer> list=new ArrayList<Integer>();
		 List<Integer> list2=new ArrayList<>();
		 list.add(1);
		 list2.add(1);
		 for(int i=0;i<A.length;i++){
			 int num1=list.get(i)*A[i];
			 int num2=list2.get(i)*A[A.length-i-1];
			 list.add(num1);
			 list2.add(num2);
		 }
		 for(int i=0;i<B.length;i++){
			 B[i]=list.get(i)*list2.get(B.length-i-1);
		 }
		 return B;
	    }
	 public static void main(String[] args) {
		int[] a={1,2};
		MultiplyTest test=new MultiplyTest();
		System.out.println(Arrays.toString(test.multiply(a)));
		int[] a1=new int[]{1,2,3,4,5};
		System.out.println(Arrays.toString(a1));
	}
}
