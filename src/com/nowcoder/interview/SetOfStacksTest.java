package com.nowcoder.interview;

import java.util.ArrayList;

/*
 * 请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，当前一个栈填满时，新建一个栈。
 * 该数据结构应支持与普通栈相同的push和pop操作。
 给定一个操作序列int[][2] ope(C++为vector<vector<int>>)，每个操作的第一个数代表操作类型，
 若为1，则为push操作，后一个数为应push的数字；若为2，则为pop操作，后一个数无意义。
 请返回一个int[][](C++为vector<vector<int>>)，为完成所有操作后的SetOfStacks，
 顺序应为从下到上，默认初始的SetOfStacks为空。保证数据合法。
 */
public class SetOfStacksTest {
	public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		if(ope==null||ope.length==0)
			return list;
		int len=ope.length;
		for(int i=0;i<len;i++){
			if(ope[i][0]==1){
				if(list.isEmpty()||list.get(list.size()-1).size()==size){
					list.add(new ArrayList<Integer>());
				}
				list.get(list.size()-1).add(ope[i][1]);
			}else if (ope[i][0]==2) {
				if(list.isEmpty())
					throw new IllegalArgumentException();
				int listsize=list.get(list.size()-1).size();
				list.get(list.size()-1).remove(listsize-1);
				if(listsize-1==0)
					list.remove(list.size()-1);
			}
		}
		return list;
	}
	public static void main(String[] args) {
		int[][] a={{1,2},{2,1},{1,5},{1,7},{1,4},{2,4},{1,8},{1,9},{1,10}};
		SetOfStacksTest test=new SetOfStacksTest();
		System.out.println(test.setOfStacks(a, 2));
	}
	
}
