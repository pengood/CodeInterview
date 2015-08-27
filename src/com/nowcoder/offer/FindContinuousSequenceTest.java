package com.nowcoder.offer;

import java.util.ArrayList;

/*
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */

public class FindContinuousSequenceTest {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		if(sum<1)
			return list;
		if(sum==1){
			ArrayList<Integer> list2=new ArrayList<>();
			list2.add(1);
			list.add(list2);
			return list;
		}
		int i=1,j=1;
		while(i<(sum+1)/2){
			int num=0;
			for(int a=i;a<=j;a++){
				num+=a;
			}
			if(num==sum){
				ArrayList<Integer> list2=new ArrayList<>();
				for(int a=i;a<=j;a++){
					list2.add(a);
				}
				list.add(list2);
				i++;
			}
			else if (num<sum) {
				j++;
			}
			else {
				i++;
			}
		}
		return list;
	}
	public static void main(String[] args) {
		FindContinuousSequenceTest test=new FindContinuousSequenceTest();
		System.out.println(test.FindContinuousSequence(100));
	}
}
