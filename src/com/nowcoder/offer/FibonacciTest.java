package com.nowcoder.offer;

public class FibonacciTest {
	public int Fibonacci(int n) {
		if(n<=1)
			return n;
		int fn_1=1,fn_2=0;
		int i=2,fn=0;;
		while(i<=n){
			fn=fn_1+fn_2;
			fn_2=fn_1;
			fn_1=fn;
			i++;
		}
		return fn;
    }
	public static void main(String[] args) {
		 FibonacciTest aTest=new FibonacciTest();
		 System.out.println(aTest.Fibonacci(4));
	}
}
