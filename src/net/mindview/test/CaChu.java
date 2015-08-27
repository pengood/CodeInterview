package net.mindview.test;


interface A1 {
	void f();

	void g();
}

class B1 implements A1 {

	public void f() {
		// TODO Auto-generated method stub
		System.out.print("B1.f()");
	}

	public void g() {
		// TODO Auto-generated method stub
		System.out.print("B1.g()");
	}

	public static <T> void test(T a) {
		System.out.println(a.getClass().getTypeParameters());
		// .a.f();
	}
}

public class CaChu<T> {
	T[] array;
	public CaChu(int size){
		array= (T[])new Object[size];
	}
	public static <U> U[] makeArray(){
		return (U[])new Object[3];
	//	return new U[2];
	}
	public static void main(String[] args) {
		B1.test(new B1());
	}
}
