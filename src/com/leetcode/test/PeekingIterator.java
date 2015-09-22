package com.leetcode.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Given an Iterator class interface with methods: next() and hasNext(), 
 * design and implement a PeekingIterator that support the peek() operation 
 * -- it essentially peek() at the element that will be returned by the next call to next().

Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

Call next() gets you 1, the first element in the list.

Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

You call next() the final time and it returns 3, the last element. Calling hasNext() after 
that should return false.
 */
public class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> iterator;
	int peekPos;
	int nextPos;
	int posNum;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator=iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(peekPos<=nextPos){
        	peekPos=nextPos+1;
        	posNum=iterator.next();
        }
        return posNum;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(nextPos==peekPos-1){
	    	nextPos++;
	    	return posNum;
	    }
	    return iterator.next();
	}

	@Override
	public boolean hasNext() {
	    if(nextPos==peekPos-1){
	    	return true;
	    }
	    return iterator.hasNext();
	}
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<7;i++){
			list.add(i);
		}
		Iterator<Integer> iterator=list.iterator();
		PeekingIterator iterator2=new PeekingIterator(iterator);
		System.out.println(iterator2.peek());
		System.out.println(iterator2.peek());
		System.out.println(iterator2.next());
		System.out.println(iterator2.peek());
		System.out.println(iterator2.next());
		System.out.println(iterator2.peek());
		System.out.println(iterator2.next());
		System.out.println(iterator2.peek());
		System.out.println(iterator2.next());
		System.out.println(iterator2.peek());
		System.out.println(iterator2.hasNext());
		System.out.println(iterator2.peek());
		System.out.println(iterator2.next());
		System.out.println(iterator2.peek());
		System.out.println(iterator2.hasNext());
		System.out.println(iterator2.peek());
		System.out.println(iterator2.next());
		System.out.println(iterator2.peek());
		System.out.println(iterator2.hasNext());
		System.out.println(iterator2.peek());
		System.out.println(iterator2.next());
		//System.out.println(iterator2.peek());
		System.out.println(iterator2.hasNext());
	}
}
