package com.nowcoder.interview;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * 在二维平面上，有一些点，请找出经过点数最多的那条线。
 给定一个点集vector p和点集的大小n，请返回一个vector，
 代表经过点数最多的那条直线的斜率和截距。
 */
class Line {
	public static double epsilon = .0001;
	public double slope, intercept;// 斜率、截距
	private boolean infinite_slope = false;

	public Line(Point p, Point q) {
		if (Math.abs(p.x - q.x) > epsilon) {
			slope = (p.y - q.y) / (p.x - q.x);
			intercept = p.y - slope * p.x;
		} else {
			infinite_slope = true; // 垂直x轴
			intercept = p.x;
		}
	}

	// double作key
	public static double floorToNear(double d) {
		int r = (int) (d / epsilon);
		return ((double) r) * epsilon;
	}

	public boolean isEquvitent(double a, double b) {
		return (Math.abs(a - b) < epsilon);
	}

	public boolean isEquvient(Object o) {
		Line line = (Line) o;
		if (isEquvitent(line.slope, slope)
				&& isEquvitent(line.intercept, intercept)
				&& (infinite_slope == line.infinite_slope)) {
			return true;
		}
		return false;
	}
}

public class GetMaxPointLine {
	public double[] getLine(Point[] p, int n) {
		// write code here
		Line bestLine = null;
		int bestCount = 0;
		HashMap<Double, ArrayList<Line>> lineByScope = new HashMap<>();
		for (int i = 0; i < p.length; i++) {
			for (int j = i + 1; j < p.length; j++) {
				Line line = new Line(p[i], p[j]);
				insertMap(lineByScope, line);
				int count=countLine(lineByScope, line);
				if(count>bestCount){
					bestCount=count;
					bestLine=line;
				}
			}
		}
		double[] ret=new double[2];
		ret[0]=bestLine.slope;
		ret[1]=bestLine.intercept;
		return ret;
	}

	public int countLine(ArrayList<Line> lines, Line line) {
		if (lines == null)
			return 0;
		int count = 0;
		for (Line line2 : lines) {
			if (line2.isEquvient(line))
				count++;
		}
		return count;
	}

	private int countLine(HashMap<Double, ArrayList<Line>> map, Line line) {
		double key = Line.floorToNear(line.slope);
		double eps = Line.epsilon;
		int count = countLine(map.get(key), line)
				+ countLine(map.get(key + eps), line)
				+ countLine(map.get(key - eps), line);
		return count;
	}

	private void insertMap(HashMap<Double, ArrayList<Line>> map, Line line) {
		ArrayList<Line> lines = null;
		double key = Line.floorToNear(line.slope);
		if (!map.containsKey(key)) {
			lines = new ArrayList<>();
			map.put(key, lines);
		} else {
			lines = map.get(key);
		}
		lines.add(line);
	}
}
