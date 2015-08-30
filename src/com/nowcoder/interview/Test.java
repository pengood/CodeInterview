package com.nowcoder.interview;

public class Test {
public static void main(String[] args) {
	int x=Integer.MAX_VALUE^(1<<5);
	System.out.println(x);
	int y=96&x;
	System.out.println(y);
	int z=2|(1<<2);
	System.out.println(z);
	int p=z&(Integer.MAX_VALUE^(1<<(1)));
	System.out.println(p);
}
}
