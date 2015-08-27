package net.mindview.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PuzzlerTest {
	ThreadLocal<Long> longLocal = new ThreadLocal<>();
	ThreadLocal<String> stringLocal = new ThreadLocal<>();

	public void set() {
		longLocal.set(Thread.currentThread().getId());
		stringLocal.set(Thread.currentThread().getName());
	}

	public long getLong() {
		return longLocal.get();
	}

	public String getString() {
		return stringLocal.get();
	}

	public static void printSet(Set<?> s) {
		System.out.println();
		
		for (Object o : s) {
			System.out.print(o+" ");
		}
	}

	public static void main(String[] args) {
		System.out.println("2+2=" + 2 + 2);
		// System.out.printf("%c%c",'H','a');
		char[] num = { '1', '2', '3' };
		System.out.println("Num=" + Arrays.toString(num));

		final PuzzlerTest test = new PuzzlerTest();
		test.set();
		System.out.println(test.getLong() + " " + test.getString());
		Thread thread = new Thread() {
			public void run() {
				test.set();
				System.out.println(test.getLong() + " " + test.getString());
			}
		};
		thread.start();
		

		 HashSet<Integer> s1 = new HashSet<Integer>(Arrays.asList(1, 2, 3));
		        printSet(s1);
		 
		 HashSet<String> s2 = new HashSet<String>(Arrays.asList("a", "b", "c"));
		        printSet(s2);
		        
		        HashMap<Integer, String> map;
		        
	}
}
