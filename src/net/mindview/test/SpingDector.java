package net.mindview.test;

import java.util.HashMap;
import java.util.Random;

class GroundHog{
	private int num;
	public GroundHog(int i){
		this.num=i;
	}
	public String toString(){
		return "GroundHog#"+this.num;
	}
	public boolean equals(Object o){
		return o instanceof GroundHog &&(((GroundHog)o).num==num);
	}
	public int hashCode(){
		return num;
	}
}

class Spring{
	static Random random=new Random(47);
	boolean shadow=random.nextDouble()>0.5;
	public String toString(){
		if(shadow)
			return "Spring";
		else{
			return "Winter";
		}
	}
}

public class SpingDector {
	public static void main(String[] args){
		HashMap<GroundHog, Spring> hashMap=new HashMap();
		for(int i=0;i<10;i++){
			hashMap.put(new GroundHog(i), new Spring());
		}
		System.out.println(hashMap);
		GroundHog groundHog=new GroundHog(3);
		System.out.println(hashMap.get(groundHog));
	}

}
