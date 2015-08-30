package com.nowcoder.interview;

import java.util.Arrays;

/*
 * 在二维平面上，有两个正方形，请找出一条直线，能够将这两个正方形对半分。假定正方形的上下两条边与x轴平行。
	给定两个vecotrA和B，分别为两个正方形的四个顶点。请返回一个vector，代表所求的平分直线的斜率和截距，保证斜率存在。
	测试样例：
	[(0,0),(0,1),(1,1),(1,0)],[(1,0),(1,1),(2,0),(2,1)]
	返回：[0.0，0.5]
 */
class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
        this.x = 0;
        this.y = 0;
    }
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x+","+y;
	}
    
}
public class GetBipartition {
	public double[] getBipartition(Point[] A, Point[] B) {
        // write code here
		if(A.length!=4||B.length!=4)
			throw new IllegalArgumentException();
		double midAx=(A[0].x+A[1].x+A[2].x+A[3].x)/4.0;
		double midAy=(A[0].y+A[1].y+A[2].y+A[3].y)/4.0;
		double midBx=(B[0].x+B[1].x+B[2].x+B[3].x)/4.0;
		double midBy=(B[0].y+B[1].y+B[2].y+B[3].y)/4.0;
		double[] ret=new double[2];
		if(midAx==midBx&&midAy==midBy){
			ret[0]=midAy/midAx;
			ret[1]=0;
			return ret;
		}
		if(midAx==midBx){
			ret[0]=Double.POSITIVE_INFINITY;
			ret[1]=0;
			return ret;
		}
		ret[0]=(midBy-midAy)/(midBx-midAx);
		ret[1]=(midBx*midAy-midAx*midBy)/(midBx-midAx);
		return ret;
			
    }
	public static void main(String[] args) {
		Point p1=new Point(0, 0);
		Point p2=new Point(0, 1);
		Point p3=new Point(1, 1);
		Point p4=new Point(1, 0);
		Point p5=new Point(1, 0);
		Point p6=new Point(1, 1);
		Point p7=new Point(2, 0);
		Point p8=new Point(2, 1);
		Point[] A=new Point[]{p1,p2,p3,p4};
		Point[] B=new Point[]{p5,p6,p7,p8};
		GetBipartition pBipartition=new GetBipartition();
		System.out.println(Arrays.toString(pBipartition.getBipartition(A, B)));
	}
}
