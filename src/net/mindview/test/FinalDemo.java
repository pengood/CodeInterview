package net.mindview.test;
class FinalClass{
	private static int i;
	private static int i1;
	static void f(){
		
	}
	static class Inner{
		int j,k;
		public  Inner() {
			// TODO Auto-generated constructor stub
			j=i1;
			k=i;
			f();
	}
	}
	public FinalClass(int i){
		
	}
}
public class FinalDemo extends FinalClass{

	public FinalDemo(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args){
		FinalClass demo=new FinalDemo(9);
		System.out.print(demo instanceof FinalDemo);
	}
}
