package com.leetcode.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	public String toString() {
		return start + " " + end;
	}
}

public class MergeIntervals {
	public static List<Interval> merge(List<Interval> intervals) {

		List<Interval> list = new ArrayList<Interval>();
		if (intervals.size() == 0)
			return list;
		intervals.sort(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if (o1.start > o2.start)
					return +1;
				return o1.start == o2.start ? 0 : -1;
			}
		});
		list.add(intervals.remove(0));
		int i = 0;
		for (Interval interval : intervals) {
			if (interval.start <= list.get(i).end) {
				if (interval.end > list.get(i).end)
					list.get(i).end = interval.end;
			} else {
				list.add(interval);
				i++;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		List<Interval> o1 = new ArrayList<>();
		// o1.add(new Interval(1, 3));
		// o1.add(new Interval(2, 6));
		// o1.add(new Interval(8, 10));
		// o1.add(new Interval(15, 18));
		System.out.print(merge(o1));
	}
}
