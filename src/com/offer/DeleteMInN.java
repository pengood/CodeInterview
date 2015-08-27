package com.offer;

import java.util.LinkedList;
import java.util.List;

public class DeleteMInN {
	public static int findlast(int n,int m){
		if(n<1||m<1)
			return -1;
		List<Integer> list=new LinkedList<Integer>();
		for(int i=0;i<=n;i++)
			list.add(i);
		int start=0;
		int index=0;
		while(list.size()>1){
			index=(start+m-1)%list.size();
			System.out.println("remove:"+list.remove(index));
			start=index;
		}
		return list.get(0);
	}
	public static void main(String[] args) {
		System.out.println(findlast(2, 7));
	}

}
