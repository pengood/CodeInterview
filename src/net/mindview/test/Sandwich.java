//: polymorphism/Sandwich.java
// Order of constructor calls.
package net.mindview.test;

import static net.mindview.util.Print.*;

class Meal {
	private Lettuce l = new Lettuce();
	Meal(int i) {
		print("Meal()");
	}
}

class Bread {
	Bread() {
		print("Bread()");
	}
}

class Cheese {
	Cheese() {
		print("Cheese()");
	}
}

class Lettuce {
	Lettuce() {
		print("Lettuce()");
	}
}

class Lunch extends Meal {
	Lunch() {
		super(1);
		print("Lunch()");
	}
}

class PortableLunch extends Lunch {
	PortableLunch() {
		print("PortableLunch()");
	}
}

public class Sandwich extends PortableLunch {
	private Bread b = new Bread();
	private Cheese c = new Cheese();
	private Lettuce l = new Lettuce();

	public Sandwich() {
		print("Sandwich()");
	}

	public static void main(String[] args) {
		new Sandwich();
	}
} /*
 * Output: Meal() Lunch() PortableLunch() Bread() Cheese() Lettuce() Sandwich()
 */// :~
