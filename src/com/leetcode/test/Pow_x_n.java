package com.leetcode.test;

public class Pow_x_n {
	public double myPow(double x, int n){
		if(n<0){
			if(n==Integer.MIN_VALUE)
				return 1.0/(myPow(x, Integer.MAX_VALUE)*x);
			else {
				return 1.0/(myPow(x, -n));
			}
		}
		if(n==0)
			return 1.0;
		double ans=1.0;
		for(;n>0;x*=x,n>>=1){
			if((n&1)>0)
				ans*=x;
		}
		return ans;
	}
	public static void main(String[] args) {
		Pow_x_n pow_x_n=new Pow_x_n();
		System.out.println(pow_x_n.myPow(34.00515, -3));
	}
}
