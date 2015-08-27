package net.mindview.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class Pair<K,V>{
	public  final K key;
	public final V value;
	public Pair(K k,V v){
		this.key=k;
		this.value=v;
	}
}

class MapData<K,V> extends LinkedHashMap<K, V>{
	public MapData(Generator<Pair<K, V>> gen,int qu){
		for(int i=0;i<qu;i++){
			Pair<K, V> pair=gen.next();
			put(pair.key, pair.value);
		}
	}
	
	public MapData(Generator<K> genK,Generator<V> genV,int qu){
		for(int i=0;i<qu;i++){
			put(genK.next(), genV.next());
		}
	}
}

class GeneratorTest<K,V> implements Generator<Pair<K, V>>{
	String[] foundation = ("strange women lying in ponds "
			+ "distributing swords is no basis for a system of " + "government")
			.split(" ");
	private int index;
	public Pair<K, V> next() {
		// TODO Auto-generated method stub
		return new Pair(index++, foundation[index]);
	}
	
}

public class MapDataTest {

	public static void main(String[] args){
		HashMap<Integer, String> hashMap=new LinkedHashMap(new MapData(new GeneratorTest(), 14));
		System.out.println(hashMap);
		for(Map.Entry<Integer, String> entry:hashMap.entrySet()){
			entry.setValue(entry.getValue()+1);
		}
		System.out.println(hashMap);
		
	}
}
