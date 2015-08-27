package net.mindview.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

interface A{
	void f();
}

class B implements A{
	private int i=2;
	private  final int j=9;
	private static  int k=7;
	
	public void f() {
		// TODO Auto-generated method stub
		System.out.println("B.f()");
	}
	public void g(){
		System.out.println("B.g()");
	}
	private void h(String string){
		System.out.println("B.h()"+string);
	}
	public String toString(){
		return "i= "+i+" j= "+j+" k="+k;
	}
}

public class ReflectTest {
	public static void main(String[] args){
		A a=new B();
		a.f();
		B b=(B)a;
		b.g();
		try {
			Method method=b.getClass().getDeclaredMethod("h",new Class[]{String.class});
			method.setAccessible(true);
			method.invoke(b,"haha");
			Field field=b.getClass().getDeclaredField("i");
			field.setAccessible(true);
			System.out.println(b);
			field.set(b, 67);
			System.out.println(b);
			Field field1=b.getClass().getDeclaredField("k");
			field1.setAccessible(true);
			System.out.println(b);
			field1.set(b, 67);
			System.out.println(b);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
