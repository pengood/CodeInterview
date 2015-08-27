package com.offer;

import java.util.Arrays;

public class VerifySquenceBST {
	public static boolean verify(int[] seq){
		if(seq==null||seq.length==0)
			return false;
		int len=seq.length;
		int root=seq[len-1];
		int i=0;
		for(;i<len-1;i++){
			if(seq[i]>root)
				break;
		}
		for(int j=i;j<len-1;j++){
			if(seq[j]<root)
				return false;
		}
		boolean left=true;
		if(i>0){
			int[] leftArr=Arrays.copyOfRange(seq, 0, i);
			left=verify(leftArr);
		}
		boolean right=true;
		if(i<len-1){
			int[] rightArr=Arrays.copyOfRange(seq, i, len-1);
			right=verify(rightArr);
		}
		return left&&right;
	}

	public static void main(String[] args){
		int[] a={5,7,6,9,11,10,8};
		int[] b={7,4,6,5};
		System.out.print(verify(b));
	}
}
