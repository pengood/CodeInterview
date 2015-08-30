package com.nowcoder.interview;
/*
 * 请编写一个方法，实现整数的乘法、减法和除法运算(这里的除指整除)。只允许使用加号。
	给定两个正整数int a,int b,同时给定一个int type代表运算的类型，1为求a ＊ b，
	0为求a ／ b，-1为求a － b。请返回计算的结果，保证数据合法且结果一定在int范围内。
	测试样例：
	1,2,1
	返回：2
 */
public class CalcByAdd {
	public int calc(int a, int b, int type) {
        // write code here
		if(type==-1){
			return a+negate(b);
		}
		if(type==1){
			return multiply(a, b);
		}
		if(type==0){
			return divide(a, b);
		}
		return -1;
    }
	private int negate(int a){
		int num=0;
		int d=a>0?-1:1;
		while(a!=0){
			num+=d;
			a+=d;
		}
		return num;
	}
	private int multiply(int a,int b){
		if(a<b){
			return multiply(b, a);
		}
		int sum=0;
		for(int i=0;i<Math.abs(b);i++){
			sum+=a;
		}
		if(b<0)
			sum=negate(sum);
		return sum;
	}
	private int divide(int a,int b){
		if(b==0)
			throw new ArithmeticException();
		int a1=Math.abs(a);
		int b1=Math.abs(b);
		int product=0;
		int x=0;
		while(product+b1<=a1){
			product+=b1;
			x++;
		}
		if(a<0&&b<0||a>0&&b>0)
			return x;
		else {
			return negate(x);
		}
	}
	public static void main(String[] args) {
		CalcByAdd add=new CalcByAdd();
		System.out.println(add.calc(9082,2801,0));
	}
}
