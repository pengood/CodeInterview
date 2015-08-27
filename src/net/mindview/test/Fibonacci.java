package net.mindview.test;

import java.util.Collection;

interface Generator<T>{
	T next();
}

class Generators{
	public static <T> Collection<T> fill(Collection<T> coll,Generator<T> gen,int n){
		for(int i=0;i<n;i++){
			coll.add(gen.next());
		}
		return coll;
	}
}

public class Fibonacci implements Generator<Integer> {
	private int count=0;
	private int fib(int n){
		if(n<2)
			return 1;
		return fib(n-2)+fib(n-1);
	}
	public Integer next() {
		// TODO Auto-generated method stub
		return fib(count++);
	}
	
	public static void main(String[] args){
		Generator tFibonacci=new Fibonacci();
		for(int i=0;i<10;i++)
			System.out.print(tFibonacci.next()+" ");
	}

}
