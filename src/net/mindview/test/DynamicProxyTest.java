package net.mindview.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

interface Interface {
	void doSomethins();

	void doSomethingElse(String string);
}

class RealObject implements Interface {

	public void doSomethins() {
		// TODO Auto-generated method stub
		System.out.println("do something");
	}

	public void doSomethingElse(String string) {
		// TODO Auto-generated method stub
		System.out.println("do something else " + string);
	}

}

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;

	public DynamicProxyHandler(Object pObject) {
		this.proxied = pObject;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("**** proxy: " + proxy.getClass() + ",method: "
				+ method + ",args: " + args);
		if (args != null)
			for (Object arg : args) {
				System.out.println(" " + arg);
			}
		return method.invoke(proxied, args);
	}

}

public class DynamicProxyTest {
	public static void comsumer(Interface iface) {
		iface.doSomethins();
		iface.doSomethingElse("bobono");
	}

	public static void main(String[] args) {
		RealObject realObject = new RealObject();
		comsumer(realObject);
		Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class
				.getClassLoader(), new Class[] { Interface.class },
				new DynamicProxyHandler(realObject));
	//	comsumer(proxy);
		Class<?> class1 = proxy.getClass();
		System.out.println(class1.getSimpleName());
		Type types1[] = class1.getGenericInterfaces();
		for (int i = 0; i < types1.length; i++) {
			System.out.println(types1[i].toString());
		}
		Type type1 = class1.getGenericSuperclass();
		System.out.println(type1.toString());
		
	}
}
