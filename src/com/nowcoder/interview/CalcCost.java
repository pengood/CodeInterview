package com.nowcoder.interview;

/*
 * 编写一个函数，确定需要改变几个位，才能将整数A转变成整数B。
 给定两个整数int A，int B。请返回需要改变的数位个数。
 测试样例：
 10,5
 返回：4
 */
public class CalcCost {
	public int calcCost(int A, int B) {
		int i=A^B;
		int count=0;
		for(int j=0;j<32;j++){
			if((i&(1<<j))>0)
				count++;
		}
		return count;
	}
	public static void main(String[] args) {
		CalcCost calcCost=new CalcCost();
		System.out.println(calcCost.calcCost(5, 10));
	}
}
