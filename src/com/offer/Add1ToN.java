package com.offer;
class Add{
	static int n=0;
	static int sum=0;
	public Add(){
		n++;
		sum+=n;
	}
}
public class Add1ToN {
	public static void main(String[] args) {
		Add[] adds=new Add[10];
		System.out.println(Add.sum);
	}
}
