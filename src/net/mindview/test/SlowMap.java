package net.mindview.test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class MapEntry<K,V> implements Map.Entry<K, V>{
	private K key;
	private V value;
	public MapEntry(K next, V next2) {
		// TODO Auto-generated constructor stub
		this.key=next;
		this.value=next2;
	}
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}
	public V getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	public V setValue(V value) {
		// TODO Auto-generated method stub
		return this.value=value;
	}
	
}

public class SlowMap<K,V> extends AbstractMap<K,V> {
	  private List<K> keys = new ArrayList<K>();
	  private List<V> values = new ArrayList<V>();
	  public V put(K key, V value) {
	    V oldValue = get(key); // The old value or null
	    if(!keys.contains(key)) {
	      keys.add(key);
	      values.add(value);
	    } else
	      values.set(keys.indexOf(key), value);
	    return oldValue;
	  }
	  public V get(Object key) { // key is type Object, not K
	    if(!keys.contains(key))
	      return null;
	    return values.get(keys.indexOf(key));
	  }
	  public Set<Map.Entry<K,V>> entrySet() {
	    Set<Map.Entry<K,V>> set= new HashSet<Map.Entry<K,V>>();
	    Iterator<K> ki = keys.iterator();
	    Iterator<V> vi = values.iterator();
	    while(ki.hasNext())
	      set.add(new MapEntry<K,V>(ki.next(), vi.next()));
	    return set;
	  }
	  public static void main(String[] args) {
	    SlowMap<Integer,String> m= new SlowMap();
	    m.putAll(new MapData(new GeneratorTest(), 14));
//	    m.putAll(Countries.capitals(15));
	    System.out.println(m);
	    System.out.println(m.get(6));
//	    System.out.println(m.entrySet());
	  }
	} 
