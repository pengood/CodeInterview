package com.seven;

public class HelloWorld {
	public static void main(String[] args) throws InterruptedException{
		Thread myThread=new Thread(){
			public void run(){
				System.out.println("hello world in new thread");
			}
		};
		myThread.start();
		Thread.yield();
		System.out.println("hello world in main");
		myThread.join();
	}

}
