package com.seven;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSortedList {

	private class Node{
		int val;
		Node pre;
		Node next;
		ReentrantLock lock=new ReentrantLock();
		public Node() {
			// TODO Auto-generated constructor stub
		}
		
		Node(int val,Node pre,Node next){
			this.val=val;
			this.pre=pre;
			this.next=next;
		}
	}
	private final Node head;
	private final Node tail;
	public ConcurrentSortedList(){
		head=new Node();
		tail=new Node();
		head.next=tail;
		tail.pre=head;
	}
	public void insert(int x){
		Node current=head;
		current.lock.lock();
		Node next=current.next;
		try{
			while(true){
				next.lock.lock();
				try{
					if(next==tail||next.val<x){
						Node node=new Node(x, current, next);
						next.pre=node;
						current.next=node;
						return;
					}
				}finally{
					current.lock.unlock();
				}
				current=next;
				next=current.next;
			}
		}finally{
			next.lock.unlock();
		}
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder();
		Node current=head.next;
		while(current!=tail){
			ReentrantLock lock=current.lock;
			lock.lock();
			try{
				stringBuilder.append(current.val+" ");
				current=current.next;
			}finally{
				lock.unlock();
			}
		}
		return stringBuilder.toString();
	}
	public static void main(String[] args) throws InterruptedException{
		final ConcurrentSortedList list=new ConcurrentSortedList();
		Thread thread1=new Thread(){
			Random random=new Random(47);
			public void run(){
				for(int i=0;i<10;i++){
					int x=random.nextInt(100);
				//	System.out.print(x+" ");
					list.insert(x);
				}
			}
		};
		Thread thread2=new Thread(){
			Random random=new Random(67);
			public void run(){
				for(int i=0;i<10;i++){
					int x=random.nextInt(70);
				//	System.out.print(x+" ");
					list.insert(x);
					Thread.yield();
				}
			}
		};
		thread1.start();thread2.start();
		thread1.join();
		System.out.print(list);
		System.out.println();
		
		thread2.join();
		System.out.print(list);
	}
}
