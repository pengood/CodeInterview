package com.nowcoder.offer;

public class NumberOf1Test {
	public int NumberOf1(int n) {
		int count = 0;
		while (n != 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		NumberOf1Test test=new NumberOf1Test();
		System.out.println(test.NumberOf1(Integer.MIN_VALUE));
	}
}
