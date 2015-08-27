package com.offer;

import java.util.Arrays;

public class QiuckSort {
	public static int myPartition(int[] data,int begin,int end){
		int  v=data[begin];
		int i=begin;
		int j=end+1;
		while(true){
			while(data[++i]<v)
				if(i==end)
					break;
			while(data[--j]>v)
				if(j==begin)
					break;
			if(i>=j)
				break;
			swap(data, i, j);
		}
		swap(data, begin, j);
		return j;
	}

	public static int partion(int[] data,int start,int end){
		if(data==null||data.length==0||start<0||end>=data.length)
			throw new IllegalArgumentException();
		int mid=(end+start)>>1;
		if(data[mid]<data[start])
			swap(data, start, mid);
		if(data[end]<data[start])
			swap(data, end, start);
		if(data[end]<data[mid])
			swap(data, end, mid);
		swap(data, mid, end-1);
		int small=start-1;
		for(int index=start;index<end-1;index++){
			if(data[index]<data[end-1]){
				small++;
				if(small!=index)
					swap(data, small, index);
			}
		}
		small++;
		swap(data, small, end-1);
		return small;
	}
	
	private static void swap(int[] data,int a,int b){
		int tmp=data[a];
		data[a]=data[b];
		data[b]=tmp;
	}
	public static void sort(int[] data,int start,int end){
		if(start==end)
			return;
		int index=myPartition(data, start, end);
		if(index>start)
			sort(data, start, index-1);
		if(index<end)
			sort(data, index+1, end);
	}
	public static void main(String[] args){
		int[] data={1,2,3,2,1};
		sort(data, 0, data.length-1);
		System.out.println(Arrays.toString(data));
	}
}
