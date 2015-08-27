package com.nowcoder.offer;

import java.util.Stack;
/*
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class MinStackTest {
	Stack<Integer> stack=new Stack<>();
	Stack<Integer> minStack=new Stack<>();
	public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty()||minStack.peek()>node)
        	minStack.push(node);
        else {
			minStack.push(minStack.peek());
		}
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
    public static void main(String[] args) {
		MinStackTest test=new MinStackTest();
		test.push(1);
		System.out.println(test.min());
		test.push(0);
		System.out.println(test.min());
		test.push(3);
		System.out.println(test.min());
		test.push(2);
		System.out.println(test.min());
		test.pop();
		test.pop();
		test.pop();
		System.out.println(test.min());
	}
}
