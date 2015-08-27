package com.nowcoder.offer;

/*
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class IsNumericTest {
	public boolean isNumeric(char[] str) {
		if (str == null || str.length == 0)
			return false;
		int i = 0;
		if (str[i] == '+' || str[i] == '-')
			i++;
		else if (str[i] < '0' || str[i] > '9') {
			return false;
		}
		for (; i < str.length; i++) {
			if ((str[i] == 'e' || str[i] == 'E') && i + 1 < str.length) {
				if (str[i + 1] == '+' || str[i + 1] == '-')
					return isInt(str, i + 2,true);
				if (str[i + 1] < '0' || str[i + 1] > '9')
					return false;
				return isInt(str, i + 1,true);
			} else if (str[i] == '.' ){
				if(i==str.length-1)
					return true;
				else {
					return isInt(str, i + 1,false);
				}
				
			}
				
			else if (str[i] >= '0' && str[i] <= '9') {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	private boolean isInt(char[] str, int i,boolean inE) {
		if (i >= str.length)
			return false;
		for (int j = i; j < str.length; j++) {
			if(!inE&&j>i&&j+1<str.length&&(str[j]=='E'||str[j]=='e')){
				if (str[j + 1] == '+' || str[j + 1] == '-')
					return isInt(str, j + 2,true);
				if (str[j + 1] < '0' || str[j + 1] > '9')
					return false;
				return isInt(str, j + 1,true);
			}
			if (str[j] < '0' || str[j] > '9')
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		char[] a = "12.".toCharArray();
		IsNumericTest test = new IsNumericTest();
		System.out.println(test.isNumeric(a));
		//System.out.println(a[3] < '0');
	}
}
