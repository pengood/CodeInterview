package com.offer;

public class PrintABC {
	public static void main(String[] args) throws InterruptedException {
		while (true) {
			Thread thread1 = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.print("A");
				}
			});
			thread1.start();
			thread1.join();

			Thread thread2 = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.print("B");
				}
			});
			thread2.start();
			thread2.join();

			Thread thread3 = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("C");
				}
			});
			thread3.start();
			thread3.join();
		}
	}
}
