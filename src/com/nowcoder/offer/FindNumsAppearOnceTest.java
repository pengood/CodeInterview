package com.nowcoder.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/*
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
 * 
 */
public class FindNumsAppearOnceTest {
	// num1,num2分别为长度为1的数组。传出参数
	// 将num1[0],num2[0]设置为返回结果
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if(array==null||array.length<2){
			num1[0]=0;
			num2[0]=0;
			return;
		}
		
		HashMap<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<array.length;i++){
			if(map.get(array[i])==null){
				map.put(array[i], 1);
			}else {
				map.put(array[i], map.get(array[i])-1);
			}
		}
		int[] a=new int[2];
		int i=0;
		Iterator<Entry<Integer, Integer>> iterator=map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Integer, Integer> entry=iterator.next();
			if(entry.getValue()==1){
				a[i]=entry.getKey();
				i++;
			}
		}
		num1[0]=a[0];
		num2[0]=a[1];
	}
}
