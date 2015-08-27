package com.offer;

import java.util.Arrays;

public class MyPower {
	public static double power(double base, int exp) {
		if (Math.abs(base - 0.0) < 0.0000001 && exp < 0)
			throw new IllegalArgumentException();
		if(exp==0)
			return 1;
		if(exp==1)
			return base;
		int absExp = Math.abs(exp);
		double result = 1.0;
		for (int i = 0; i < absExp; i++)
			result *= base;
		if (exp < 0)
			return 1.0 / result;
		return result;

	}
	public static void main(String[] args){
		System.out.print(power(0.9, -3));
		int[] a={1,2,3,4,1};
		System.out.print(Arrays.toString(a));
	}
}
