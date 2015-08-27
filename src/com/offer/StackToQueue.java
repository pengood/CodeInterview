package com.offer;

import java.util.NoSuchElementException;
import java.util.Stack;

public class StackToQueue {
	 Stack<Integer> stack1 = new Stack<>();
	 Stack<Integer> stack2 = new Stack<>();
	public  void appendTail(int x){
		stack1.push(x);
	}
	public  int deleteHead(){
		if(!stack2.isEmpty())
			return stack2.pop();
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		if(stack2.isEmpty())
			throw new NoSuchElementException("no element");
		return stack2.pop();
	}
	public static void main(String[] args){
		StackToQueue queue=new StackToQueue();
		for(int i=0;i<10;i++){
			queue.appendTail(i);
		}
		for(int i=0;i<7;i++){
			System.out.print(queue.deleteHead()+" ");
		}
		queue.appendTail(14);
		for(int i=7;i<11;i++){
			System.out.print(queue.deleteHead()+" ");
		}
		System.out.print(queue.deleteHead()+" ");

	}
}
