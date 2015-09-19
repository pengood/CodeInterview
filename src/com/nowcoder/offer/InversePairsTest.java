package com.nowcoder.offer;

import java.util.Arrays;

/*
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 */
public class InversePairsTest {
	int count;
	public int InversePairs(int[] array) {
		if(array==null||array.length<=1)
			return 0;
		inverse(array, 0, array.length-1);
		return count;
	}
	private void inverse(int[] array,int start,int end){
		if(start==end)
			return;
		int mid=start+((end-start)>>1);
		inverse(array, start, mid);
		inverse(array, mid+1, end);
		merge(array, start, mid, end);
	}
	private void merge(int[] array,int start,int mid,int end){
		int i=start;
		int j=mid+1;
		for(;j<=end;j++){
			while(i<=mid&&array[j]>=array[i])
				i++;
			count+=(mid-i+1);
		}
		int[] aus=new int[end-start+1];
		int a=start;
		int b=mid+1;
		int c=0;
		while(a<=mid&&b<=end){
			if(array[a]<=array[b]){
				aus[c]=array[a];
				c++;
				a++;
			}else {
				aus[c]=array[b];
				c++;b++;
			}
		}
		while(a<=mid){
			aus[c]=array[a];
			c++;
			a++;
		}
		while(b<=end){
			aus[c]=array[b];
			c++;b++;
		}
		 for(int i1=start,j1=0;i1<=end;i1++,j1++){
			 array[i1]=aus[j1];
		 }
	}
	public static void main(String[] args) {
		InversePairsTest test=new InversePairsTest();
		int[] a={3,2,1};
		System.out.println(test.InversePairs(a));
		System.out.println(Arrays.toString(a));
	}
}
