package com.nowcoder.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * A，B两个整数集合，设计一个算法求他们的交集，尽可能的高效。
 */
public class TencentSet {
	public List<Integer> getSet(int[] A,int[] B){
		List<Integer> list=new ArrayList<Integer>();
		HashMap<Integer, Boolean> map=new HashMap<>();
		for(int i=0;i<A.length;i++){
			map.put(A[i], true);
		}
		for(int i=0;i<B.length;i++){
			if(map.get(B[i])!=null&&map.get(B[i]))
				list.add(B[i]);
		}
		return list;
	}
}
