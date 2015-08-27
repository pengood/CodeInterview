package com.nowcoder.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/*
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *  {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， 
 *  {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindowsTest {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> list = new ArrayList<>();
		if (num == null || num.length == 0 || size > num.length||size==0)
			return list;
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for(int i=0;i<size;i++){
			while(!deque.isEmpty()&&num[i]>=num[deque.getLast()])
				deque.pollLast();
			deque.add(i);
		}
		for(int i=size;i<num.length;i++){
			list.add(num[deque.getFirst()]);
			while(!deque.isEmpty()&&num[i]>=num[deque.getLast()])
				deque.pollLast();
			if(!deque.isEmpty()&&deque.getFirst()<=i-size)
				deque.pollFirst();
			deque.add(i);
		}
		list.add(num[deque.getFirst()]);
		return list;
	}

	public static void main(String[] args) {
		int[] a = { 16, 14, 12, 10, 8, 6, 4 };
		MaxInWindowsTest test = new MaxInWindowsTest();
		System.out.println(test.maxInWindows(a, 0));
	}
}
