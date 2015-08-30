package com.nowcoder.interview;
/*
 * 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。请实现一个方法，
 * 计算小孩有多少种上楼的方式。为了防止溢出，请将结果Mod 1000000007
	给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
	测试样例：
	1
	返回：1
 */
public class GoUpstairs {
	public int countWays(int n) {
        // write code here
		if(n<=2)
			return n;
		if(n==3)
			return 4;
		long fn_1=4;
		long fn_2=2;
		long fn_3=1;
		long k=4;
		long fn=0;
		while(k<=n){
			fn=(fn_1+fn_2+fn_3)%1000000007;
			fn_3=fn_2;
			fn_2=fn_1;
			fn_1=fn;
			k++;
		}
		int ret=(int)fn%1000000007;
		return ret;	
    }
	public static void main(String[] args) {
		GoUpstairs goUpstairs=new GoUpstairs();
		System.out.println(goUpstairs.countWays(36196));
	}
}
