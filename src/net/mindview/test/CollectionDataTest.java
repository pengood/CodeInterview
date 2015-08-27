package net.mindview.test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

class CollectionData<T> extends ArrayList<T> {
	public CollectionData(Generator<T> gen, int qu) {
		for (int i = 0; i < qu; i++) {
			add(gen.next());
		}
	}
	public static <T> CollectionData<T> list(Generator<T> gen,int qu){
		return new CollectionData<T>(gen, qu);
	}
}

class Government implements Generator<String> {
	String[] foundation = ("strange women lying in ponds "
			+ "distributing swords is no basis for a system of " + "government")
			.split(" ");
	private int index;

	public String next() {
		return foundation[index++];
	}
}

public class CollectionDataTest {
	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<String>(new CollectionData<String>(new Government(), 15));
		// Using the convenience method:
		set.addAll(CollectionData.list(new Government(), 15));
		System.out.println(set);
	}
}
