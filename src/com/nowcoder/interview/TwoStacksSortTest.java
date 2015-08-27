package com.nowcoder.interview;

import java.util.ArrayList;
import java.util.Stack;

/*
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
	给定一个int[] numbers(C++中为vector<int>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，
	意味着排序过程中你只能访问到第一个元素。
 	测试样例：
 	[1,2,3,4,5]
 	返回：[5,4,3,2,1]
 */
public class TwoStacksSortTest {
	public ArrayList<Integer> twoStacksSort(int[] numbers) {
		ArrayList<Integer> list=new ArrayList<>();
		if(numbers==null||numbers.length==0)
			return list;
		Stack<Integer> stack=new Stack<>();
		Stack<Integer> tmp=new Stack<>();
		for(int i=0;i<numbers.length;i++){
			while(!stack.isEmpty()&&numbers[i]<stack.peek()){
				tmp.push(stack.pop());
			}
			stack.push(numbers[i]);
			while(!tmp.isEmpty()){
				stack.push(tmp.pop());
			}
		}
		while(!stack.isEmpty())
			list.add(stack.pop());
		return list;
	}
	public static void main(String[] args) {
		int[] a={1,2,3,4,5,9,3};
		TwoStacksSortTest test=new TwoStacksSortTest();
		System.out.println(test.twoStacksSort(a));
	}
}
