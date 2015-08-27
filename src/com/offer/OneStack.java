package com.offer;

import java.util.Arrays;
import java.util.Stack;

public class OneStack {
	public static boolean isOneStack(int[] nums1,int[] nums2){
		int len=nums1.length;
		if(len!=nums2.length)
			return false;
		Stack<Integer> stack=new Stack<>();
		int i=0,j=0;
		while(i<len){
			stack.push(nums1[i]);
			i++;
			while(!stack.isEmpty()&&j<len&&stack.peek()==nums2[j]){
				stack.pop();
				j++;
			}
		}
		if(stack.isEmpty())
			return true;
		return false;
	}
	public static void main(String[] args){
		int[] a={1,2,3,4,5};
		int[] b={4,3,5,2,1};
		System.out.println(isOneStack(a, b));
		int[] c=Arrays.copyOfRange(a, 0, 3);
		c[2]=9;
		System.out.print(Arrays.toString(a)+" "+Arrays.toString(c)+a+c);
	}
}
