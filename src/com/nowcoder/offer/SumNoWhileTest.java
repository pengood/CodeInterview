package com.nowcoder.offer;

/*
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class SumNoWhileTest {
	public int Sum_Solution(int n) {
		int sum=n;
		boolean i=(n>0)&&((sum+=Sum_Solution(n-1))>0);
		return sum;
	}
	public static void main(String[] args) {
		 SumNoWhileTest test=new SumNoWhileTest();
		 System.out.println(test.Sum_Solution(3));
	}
}
