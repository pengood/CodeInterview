package com.nowcoder.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

//数据类
class Data{}

//Window-LFU缓存类
public class WindowLFU {
	
	//DataEntry类保存数据,访问频率及访问时间
	static class DataEntry{
		Data data;
		AtomicInteger freq;
		AtomicLong visitedTime;
		
		public DataEntry(Data d,int fre,long time) {
			// TODO Auto-generated constructor stub
			this.data=d;
			this.freq=new AtomicInteger(fre);
			this.visitedTime=new AtomicLong(time);
		}
	}
	
	HashMap<String, DataEntry> map;
	static final int initCapacity=16;
	int capacity;
	static final long initTimeWindow=1000;
	volatile long timeWindow;
	
	public WindowLFU() {
		// TODO Auto-generated constructor stub
		this(initCapacity);
	}
	public WindowLFU(int c) {
		// TODO Auto-generated constructor stub
		this.capacity=c;
		map=new HashMap<>(c);
	}
	
	public void setTimeWindow(long time){
		this.timeWindow=time;
	}
	
	//获取数据
	public Data get(String key){
		if(!map.containsKey(key))
			return null;
		map.get(key).freq.incrementAndGet();
		long preTime;
		do{
			preTime=map.get(key).visitedTime.get();
		}while(!map.get(key).visitedTime.compareAndSet(preTime, System.currentTimeMillis()));
		return map.get(key).data;
	}
	
	//放入数据
	public void  put(String key,Data d){
		if(map.containsKey(key)){
			DataEntry dataEntry=map.get(key);
			dataEntry.freq.incrementAndGet();
			long preTime;
			synchronized (map) {
			do{
				preTime=dataEntry.visitedTime.get();
				
					dataEntry.data=d;
				
			}while(!dataEntry.visitedTime.compareAndSet(preTime, System.currentTimeMillis()));
			}
			return;
		}
		synchronized (map){
			if(map.size()>=capacity){
				DataEntry minFreq = null;
				Iterator<Entry<String, DataEntry>> iterator=map.entrySet().iterator();
				while(iterator.hasNext()){
					Entry<String, DataEntry> iEntry=iterator.next();
					if(iEntry.getValue().visitedTime.get()-System.currentTimeMillis()>timeWindow){
						minFreq=iEntry.getValue();
						break;
						}
					else {
						if(minFreq==null)
							minFreq=iEntry.getValue();
						else {
							if(iEntry.getValue().freq.get()<minFreq.freq.get())
								minFreq=iEntry.getValue();
						}
					}
						
					}
					map.remove(minFreq);
					map.put(key, new DataEntry(d,1,System.currentTimeMillis()));
			}else {
				map.put(key, new DataEntry(d,1,System.currentTimeMillis()));
			}
		}
		
	}
	

	//移除数据
	public boolean remove(String key){
		if(map.containsKey(key))
			return false;
		synchronized (map) {
			Data data=map.get(key).data;
			 return data==map.remove(key).data;
		}
	}
	
	//获取缓存命中率
	public int getHitrate(String key){
		if(!map.containsKey(key))
			return 0;
		return map.get(key).freq.get();
	}
	
	
}
