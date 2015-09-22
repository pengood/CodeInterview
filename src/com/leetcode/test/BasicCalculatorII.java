package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Implement a basic calculator to evaluate a simple expression string.
 The expression string contains only non-negative integers, +, -, *, / operators 
 and empty spaces . The integer division should truncate toward zero.
 You may assume that the given expression is always valid.
 Some examples:
 "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5
 */
public class BasicCalculatorII {
	//time out
	public int calculate(String s) {
		if(s==null||s.length()==0)
			throw new IllegalArgumentException();
		s=s.trim();
		List<Integer> nums=new ArrayList<Integer>();
		List<Character> operators=new ArrayList<>();
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(c==' ')
				continue;
			if(c=='+'||c=='-'||c=='*'||c=='/'){
				operators.add(c);
				continue;
			}
			if(c>='0'&&c<='9'){	
				StringBuilder builder=new StringBuilder();
				builder.append(c);
				int j=i+1;
				for(;j<s.length();j++){
					char c2=s.charAt(j);
					if(c2>='0'&&c2<='9')
						builder.append(c2);
					else {
						break;
					}
				}
				i=j-1;
				nums.add(stoi(builder.toString()));
			}
		}
		assert nums.size()-operators.size()==1;
		for(int i=0;i<operators.size();i++){
			char c=operators.get(i);
			if(c=='*'||c=='/'){
				int x=nums.get(i);
				int y=nums.get(i+1);
				nums.remove(i+1);
				operators.remove(i);
				nums.set(i, helpCal(x, y, c));
				i--;
			}
		}
		assert nums.size()-operators.size()==1;
		for(int i=0;i<operators.size();i++){
			char c=operators.get(i);
			int x=nums.get(i);
			int y=nums.get(i+1);
			nums.remove(i);
			operators.remove(i);
			nums.set(i, helpCal(x, y, c));
			i--;
		}
		assert nums.size()==1;
		return nums.get(0);
	}
	private int stoi(String string){
		int num=0;
		for(int i=0;i<string.length();i++){
			char c=string.charAt(i);
			num=num*10+(c-'0');
		}
		return num;
	}
	private int helpCal(int x,int y,char c){
		int result = -1;
		switch (c) {
		case '+':
			result=x+y;
			break;
		case '-':
			result=x-y;
			break;
		case '*':
			result=x*y;
			break;
		case '/':
			result=x/y;
		default:
			break;
		}
		return result;
	}
	Stack<Integer> numStack=new Stack<>();
	Stack<Character> operStack=new Stack<>();
	public int calculate2(String s) {
		if(s==null||s.length()==0)
			throw new IllegalArgumentException();
		s=s.trim();
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(c==' ')
				continue;
			if(c=='+'||c=='-'||c=='*'||c=='/'){
				operStack.push(c);
				continue;
			}
			if(c>='0'&&c<='9'){
				int num=0;
				while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
					num=num*10+(int)(s.charAt(i)-'0');
					i++;
				}
				i--;
				pushNum(num);
			}
		}
		Stack<Integer> numtmp=new Stack<>();
		Stack<Character> opertmp=new Stack<>();
		while(!numStack.isEmpty()){
			numtmp.push(numStack.pop());
		}
		while(!operStack.isEmpty()){
			opertmp.push(operStack.pop());
		}
		while(!opertmp.isEmpty()){
			char c=opertmp.pop();
			int left=numtmp.pop();
			int right=numtmp.pop();
			numtmp.push(helpCal(left, right, c));
		}
		return numtmp.pop();
	}
	private void pushNum(int x){
		if(numStack.isEmpty()){
			numStack.push(x);
		}
		else {
			char op=operStack.peek();
			if(op=='*'||op=='/'){
				operStack.pop();
				int last=numStack.pop();
				numStack.push(helpCal(last, x, op));
			}
			else {
				numStack.push(x);
			}
		}
		
	}
	
	public static void main(String[] args) {
		String s="1-1+1";
		BasicCalculatorII calculatorII=new BasicCalculatorII();
		System.out.println(calculatorII.calculate2(s));
	}
}
