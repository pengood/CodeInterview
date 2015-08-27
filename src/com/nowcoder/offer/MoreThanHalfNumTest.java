package com.nowcoder.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/*
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 */
public class MoreThanHalfNumTest {
	public int MoreThanHalfNum_Solution(int[] array) {
		if(array==null||array.length==0)
			throw new IllegalArgumentException();
		HashMap<Integer, Integer>map=new HashMap<>();
		for(int i=0;i<array.length;i++){
				if(map.get(array[i])==null)
					map.put(array[i], 1);
				else {
					map.put(array[i], map.get(array[i])+1);
				}
		}
		int max=0;
		int num=array[0];
		Iterator<Entry<Integer, Integer>> iterator=map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Integer, Integer> entry=iterator.next();
			int key=entry.getKey();
			int value=entry.getValue();
			if(max<value){
				max=value;
				num=key;
			}
		}
		if(max<=array.length/2)
			throw new IllegalArgumentException();
		return num;
	}
	public static void main(String[] args) {
		int[] a={1,2,3,2,4,2,5,2,3};
		MoreThanHalfNumTest test=new MoreThanHalfNumTest();
		System.out.println(test.MoreThanHalfNum_Solution(a));
	}

}
