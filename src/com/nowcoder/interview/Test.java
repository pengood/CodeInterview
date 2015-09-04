package com.nowcoder.interview;

public class Test {
	public static void main(String[] args) {
		System.out.println(max(194035,269441));
	}
	public static int max(int a,int b){
		return (a+b+Math.abs(a-b))/2;
	}
}
