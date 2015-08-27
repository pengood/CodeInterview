package net.mindview.test;

class BaseException extends Exception{}
class SubException extends BaseException{}

class Base{
	void f() throws BaseException{
		System.out.println("in base");
	}
}

class Sub extends Base{
	void f(){
		System.out.println("in sub");
	}
}
public class ExceptionTest {
	public static void main(String[] args) throws SubException{
		Base base=new Base();
	//	base.f();
		Sub base1=new Sub();
		base1.f();
		
	}

}
