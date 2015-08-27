package com.nowcoder.offer;

/*
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 */
public class StrToIntTest {
	int StrToInt(String str) {
		if (str == null || str.length() == 0)
			return 0;
		int minus = 1;
		boolean min=false;
		int i = 0;
		if (str.charAt(i) == '-') {
			minus = -1;
			i = 1;
		} else if (str.charAt(i) == '+') {
			minus = 1;
			i = 1;
		}
		int ret = 0;
		for (; i < str.length(); i++) {
			int num = str.charAt(i) - '0';
			if (num < 0 || num > 9) {
				ret = 0;
				break;
			}
			if (ret * 10 + num -1>= Integer.MAX_VALUE) {
				ret = Integer.MAX_VALUE;
				min=true;
				break;
			}
			else if (ret * 10 + num == Integer.MAX_VALUE) {
				ret = Integer.MAX_VALUE;
				break;
			}else {
				ret = ret * 10 + num;
			}
			
		}
		if (minus == -1 && ret == Integer.MAX_VALUE&&min)
			ret = Integer.MIN_VALUE;
		else {
			ret = ret * minus;
		}
		return ret;
	}

	public static void main(String[] args) {
		String string = "2147483648";
		StrToIntTest test = new StrToIntTest();
		System.out.println(test.StrToInt(string));
	}
}
