package com.nowcoder.interview;
/*
 * 请设计一个算法，计算n的阶乘有多少个尾随零。
	给定一个int n，请返回n的阶乘的尾零个数。保证n为正整数。
	测试样例：
	5
	返回：1
 */
public class FactorSuffixZero {
	public int getFactorSuffixZero(int n) {
		int count=0;
		for(int i=2;i<=n;i++){
			count+=getFiveCount(i);
		}
		return count;
    }
	private int getFiveCount(int n){
		int count=0;
		while(n%5==0){
			count++;
			n/=5;
		}
		return count;	
	}
	public static void main(String[] args) {
		FactorSuffixZero z=new FactorSuffixZero();
		System.out.println(z.getFactorSuffixZero(10));
	}
}
