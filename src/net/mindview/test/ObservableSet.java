package net.mindview.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

interface SetObserver<E> {
	void added(ObservableSet<E> set, E element);
}

public class ObservableSet<E> {
	private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<SetObserver<E>>();
	private Set<E> set;

	public ObservableSet(Set<E> e) {
		this.set = e;
	}

	public void addObserver(SetObserver<E> observer) {
		/* synchronized (observers) */{
			observers.add(observer);
		}
	}

	public boolean removeobserver(SetObserver<E> observer) {
		/* synchronized (observers) */{
			return observers.remove(observer);
		}
	}

	private void notifyElementAdded(E element) {
		/* synchronized (observers) */{
			for (SetObserver<E> observer : observers)
				observer.added(this, element);
		}
	}

	public boolean add(E e) {
		boolean added = set.add(e);
		if (added)
			notifyElementAdded(e);
		return added;
	}

	public static void main(String[] args) {
		ObservableSet<Integer> set = new ObservableSet<Integer>(
				new HashSet<Integer>());
		set.addObserver(new SetObserver<Integer>() {
			@Override
			public void added(ObservableSet<Integer> set, Integer element) {
				// TODO Auto-generated method stub
				System.out.print(element + " ");
				if (element == 4) {
					set.removeobserver(this);
				}
			}
		});
		for (int i = 0; i < 10; i++) {
			set.add(i);
		}
	}
}
