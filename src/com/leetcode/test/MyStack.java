package com.leetcode.test;

import java.util.LinkedList;
import java.util.List;


public class MyStack {
	LinkedList<Integer> list1=new LinkedList<>();
	LinkedList<Integer> list2=new LinkedList<>();
	// Push element x onto stack.
    public void push(int x) {
        list1.addLast(x);
    }
    // Removes the element on top of the stack.
    public void pop() {
    	int size=list1.size();
    	for(int i=0;i<size-1;i++){
        	list2.addLast(list1.pollFirst());
        }
    	list1.pollFirst();
        LinkedList<Integer> tmp=list1;
        list1=list2;
        list2=tmp;
    }
 // Get the top element.
    public int top() {
    	int size=list1.size();
    	for(int i=0;i<size-1;i++){
        	list2.addLast(list1.pollFirst());
        }
    	int re=list1.pollFirst();
    	list2.addLast(re);
        LinkedList<Integer> tmp=list1;
        list1=list2;
        list2=tmp;
        return re;
    }
    // Return whether the stack is empty.
    public boolean empty() {
        return list1.isEmpty();
    }
    
    public static void main(String[] args){
    	MyStack stack=new MyStack();
    	stack.push(1);
    	stack.push(2);
    	System.out.print(stack.top());
    	stack.pop();
    	System.out.print(stack.top());
    	stack.pop();
    	System.out.print(stack.empty());
    }
}
