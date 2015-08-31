package com.nowcoder.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
 * 请编写一个方法，返回某集合的所有非空子集。
	给定一个int数组A和数组的大小int n，请返回A的所有非空子集。保证A的元素个数小于等于20，且元素互异。
	各子集的顺序为其元素p从大到小排序后按字典序从大到小，见样例。
	测试样例：
	[123,456,789]
	返回：[[789],[456,789],[456],[123,789],[123,456,789],[123,456],[123]]
 */
public class GetSubsets {
	public ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
		ArrayList<ArrayList<Integer>> retArrayList=subset(A, n-1);
		retArrayList.remove(0);
		return retArrayList;
	}
	private ArrayList<ArrayList<Integer>> subset(int[] set,int index){
		ArrayList<ArrayList<Integer>> sublist;
		if(index==-1){
			sublist=new ArrayList<>();
			ArrayList<Integer> list2=new ArrayList<>();
			sublist.add(list2);
			return sublist;
		}else {
			sublist=subset(set, index-1);
			ArrayList<ArrayList<Integer>> addList=new ArrayList<>();
			int item=set[index];
			for(ArrayList<Integer> list:sublist){
				ArrayList<Integer> newList=new ArrayList<>();
				newList.addAll(list);
				newList.add(item);
				addList.add(newList);
			}
			sublist.addAll(addList);
		}
		return sublist;
	}
	public ArrayList<ArrayList<Integer>> getSubsets1(int[] A, int n){
		Arrays.sort(A);
		reserve(A, 0, n-1);
		int mask=(1<<n)-1;
		ArrayList<ArrayList<Integer>> ret=new ArrayList<>();
		for(int i=mask;i>0;i--){
			int j=n-1;
			ArrayList<Integer> list=new ArrayList<>();
			while(j>=0){
				if((i&(1<<j))>0){
					list.add(A[n-j-1]);
				}
				j--;
			}
			ret.add(list);
		}
		return ret;
		
	}
	private void reserve(int[] array,int begin,int end){
		while(begin<end){
			int tmp=array[begin];
			array[begin]=array[end];
			array[end]=tmp;
			begin++;
			end--;
		}
	}
	public static void main(String[] args) {
		int[] a={0,1};
		GetSubsets subsets=new GetSubsets();
		System.out.println(subsets.getSubsets1(a, a.length));
	}
}
