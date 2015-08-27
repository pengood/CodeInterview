package com.offer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

interface f{
	void f1();
}
abstract class NU implements f{
	boolean flag;
	Lock lock=new ReentrantLock();
	abstract  void f();
	Condition condition=lock.newCondition();
	private void te(){
		lock.lock();
		while(flag){
			//condition.
		}
	}
public static void main(String[] args) {
	
}
}
class Dog {
	int x;

	public Dog(int i) {
		this.x = i;
	}
	public void f1(int i,float x){
		System.out.println("I am in f1 int float");
		int[] nums=new int[2];
		nums[0]++;
		System.out.println(nums[0]);
		
	}
	public void f1(float x,int i){
		System.out.println("I am in f1 float int");
	}
	public String toString() {
		return "dog:" + x;
	}
}

class A{
	static void f9(){
		System.out.println("in A");
	}
}
class B extends A{
	 void f9(int i){
		System.out.println("in B");
	}
}

public class Test {
	static Dog dog1 = new Dog(1);
	static Dog dog4=new Dog(4);
	static int i=0;
	private static void swap(Dog dog,Dog dog2){
		Dog dog3=dog1;
		dog=dog4;
		dog2=dog3;
		i=9;
	}

	private static void changedog(Dog dog){
		//dog=dog1;
		dog.x=6;
		System.out.println(dog);
	}
	
	public static void main(String[] args) {
		Integer a=1;
		Integer b=2;
		Integer c=3;
		Integer d=3;
		Integer e=321;
		Integer f=321;
		Integer l=new Integer(3);
		Integer m=Integer.valueOf(3);
		Long g=3L;
////		System.out.println(c==3);
//		System.out.println(d==m);
//		System.out.println(c==d);
//		System.out.println(l==c);
//		System.out.println(e==f);
//		System.out.println(c==(a+b));
//		System.out.println(c.equals(a+b));
//		System.out.println(g==(a+b));
//		System.out.println(g.equals(a+b));
		B b2=new B();
		b2.f9();
	}

}
