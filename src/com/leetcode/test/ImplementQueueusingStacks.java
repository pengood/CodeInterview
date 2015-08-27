package com.leetcode.test;

import java.util.Stack;

public class ImplementQueueusingStacks {
	private Stack<Integer> stack1=new Stack<>();
	private Stack<Integer> stack2=new Stack<>();
	 // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(stack2.isEmpty())
        	while(!stack1.isEmpty()){
        		stack2.push(stack1.pop());
        	}
        stack2.pop();
    }

    // Get the front element.
    public int peek() {
        if(stack2.isEmpty()){
        	while(!stack1.isEmpty()){
        		stack2.push(stack1.pop());
        	}
        }
        return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
    	 return stack2.isEmpty()&&stack1.isEmpty();
    }
    public static void main(String[] args) {
		ImplementQueueusingStacks queue=new ImplementQueueusingStacks();
		for(int i=0;i<9;i++)
			queue.push(i);
		System.out.println(queue.empty());
		for(int i=0;i<9;i++){
			System.out.print(queue.peek()+" ");
			queue.pop();
		}
		System.out.println(queue.empty());	
	}
}
