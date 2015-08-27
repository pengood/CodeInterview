package com.nowcoder.offer;

public class PowerTest {
	public double Power(double base, int exponent) {
		if (exponent < 0) {
			if (exponent == Integer.MIN_VALUE)
				return 1.0/(Power(base, Integer.MAX_VALUE) * base);
			else {
				return 1.0/Power(base, -exponent);
			}
		}
		if (exponent == 0)
			return 1.0;
		double ans = 1.0;
		for (; exponent > 0; base *= base, exponent >>= 1) {
			if ((exponent & 1) > 0)
				ans *= base;
		}
		return ans;
	}
	public static void main(String[] args) {
		PowerTest test=new PowerTest();
		System.out.println(test.Power(3.0, -4));
	}
}
