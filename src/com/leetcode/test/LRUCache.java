package com.leetcode.test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 get(key) - Get the value (will always be positive) of the key if the key exists 
 in the cache, otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present. 
 When the cache reached its capacity, it should invalidate the least recently 
 used item before inserting a new item.
 */

//un pass
public class LRUCache {
	static  class Data{
		int value;
		long visitedTime;
		public Data(int v,long t) {
			this.value=v;
			this.visitedTime=t;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return value+" "+visitedTime;
		}
		
	}
	int capacity;
	LinkedHashMap<Integer, Data> map=new LinkedHashMap<>();
	
	public LRUCache(int capacity) {
		this.capacity=capacity;
	}

	public int get(int key) {
		if(map.containsKey(key)){
			Data d=map.get(key);
			d.visitedTime=System.currentTimeMillis();
			return d.value;
		}
		return -1;
	}

	public void set(int key, int value) {
		if(map.containsKey(key)){
			Data d=map.get(key);
			d.visitedTime=System.currentTimeMillis();
			d.value=value;
			return;
		}
		if(map.size()<capacity){
			map.put(key, new Data(value, System.currentTimeMillis()));
		}else {
			Iterator<Map.Entry<Integer, Data>> iterator=map.entrySet().iterator();
			long lastTimes=Long.MIN_VALUE;
			int deleteKey=-1;
			while(iterator.hasNext()){
				Map.Entry<Integer, Data> entry=iterator.next();
				if(System.currentTimeMillis()-entry.getValue().visitedTime>lastTimes){
					lastTimes=entry.getValue().visitedTime;
					deleteKey=entry.getKey();
				}
			}
			map.remove(deleteKey);
			map.put(key, new Data(value, System.currentTimeMillis()));
		}
	}
	
	public static void main(String[] args) {
		LRUCache cache=new LRUCache(3);
		System.out.println(cache.get(2));
		cache.set(2, 3);
		System.out.println(cache.get(2));
		cache.set(1, 2);
		cache.set(3, 5);
		cache.set(4, 3);
		System.out.println(cache.get(2));
		System.out.println(cache.map);
	}
}
