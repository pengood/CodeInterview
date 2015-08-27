package com.nowcoder.offer;

import java.util.ArrayList;
import java.util.Stack;

/*
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 */
public class IsStackPopOrderTest {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
    	if(pushA==null||popA==null||pushA.length==0||popA.length==0||pushA.length!=popA.length)
    		return false;
        Stack<Integer> stack=new Stack<>();
        for(int i=0,j=0;i<pushA.length;i++){
        	stack.push(pushA[i]);
        	while(!stack.isEmpty()&&stack.peek()==popA[j]){
        		stack.pop();
        		j++;
        	}
        }
        return stack.isEmpty();
    }
    public boolean IsPopOrder1(int [] pushA,int [] popA) {
    	if(pushA==null||popA==null||pushA.length==0||popA.length==0||pushA.length!=popA.length)
    		return false;
    	ArrayList<Integer> list=new ArrayList<Integer>();
         for(int i=0,j=0;i<pushA.length;i++){
        	 list.add(pushA[i]);
        	while(!list.isEmpty()&&list.get(list.size()-1)==popA[j]){
        		list.remove(list.size()-1);
        		j++;
        	}
        }
        return list.isEmpty();
    }
    public static void main(String[] args) {
		IsStackPopOrderTest test=new IsStackPopOrderTest();
		int[] a={1,2,3,4,5};
		int[] b={4,5,3,2,1};
		int[] c={4,3,5,1,2};
		System.out.println(test.IsPopOrder1(a, b));
		System.out.println(test.IsPopOrder1(a, c));
	}
}
