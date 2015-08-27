package com.nowcoder.offer;

/*
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class AddTest {
	public int Add(int num1, int num2) {
		int sum,jinwei;
		do{
			sum=num1^num2;
			jinwei=(num1&num2)<<1;
			num1=sum;
			num2=jinwei;
		}while(num2!=0);
		return num1;
	}
	public static void main(String[] args) {
		AddTest test=new AddTest();
		System.out.println(test.Add(23, 8));
	}
}
