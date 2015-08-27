package net.mindview.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

class Element {
	  private String ident;
	  public Element(String id) { ident = id; }
	  public String toString() { return ident; }
	  public int hashCode() { return ident.hashCode(); }
	  public boolean equals(Object r) {
	    return r instanceof Element &&
	      ident.equals(((Element)r).ident);
	  }
	  protected void finalize() {
	    System.out.println("Finalizing " +
	      getClass().getSimpleName() + " " + ident);
	  }
	}

	class Key extends Element {
	  public Key(String id) { super(id); }
	}

	class Value extends Element {
	  public Value(String id) { super(id); }
	}

	public class CanonicalMapping {
	  public static void main(String[] args) {
	    int size = 1000;
	    // Or, choose size via the command line:
	    if(args.length > 0)
	      size = new Integer(args[0]);
	    Key[] keys = new Key[size];
	    WeakHashMap<Key,Value> map =
	      new WeakHashMap<Key,Value>();
	    for(int i = 0; i < size; i++) {
	      Key k = new Key(Integer.toString(i));
	      Value v = new Value(Integer.toString(i));
	      if(i % 3 == 0)
	        keys[i] = k; // Save as "real" references
	      map.put(k, v);
	    }
	    System.gc();
		  
//		  String a = new String("a");  
//	        String b = new String("b");  
//	        Map weakmap = new WeakHashMap();  
//	        Map map1 = new HashMap();  
//	        map1.put(a, "aaa");  
//	        map1.put(b, "bbb");  
//
//	          
//	        weakmap.put(a, "aaa");  
//	        weakmap.put(b, "bbb");  
//
//	        map1.remove(a);  
//
//	        a=null;  
//	        b=null;  
//
//	        System.gc();  
//	        Iterator i = map1.entrySet().iterator();  
//	        while (i.hasNext()) {  
//	            Map.Entry en = (Map.Entry)i.next();  
//	            System.out.println("map:"+en.getKey()+":"+en.getValue());  
//	        }  
//
//	        Iterator j = weakmap.entrySet().iterator();  
//	        while (j.hasNext()) {  
//	            Map.Entry en = (Map.Entry)j.next();  
//	            System.out.println("weakmap:"+en.getKey()+":"+en.getValue());  
//
//	        }  
	    }  
	  
	}