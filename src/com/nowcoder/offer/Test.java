package com.nowcoder.offer;

import java.util.Arrays;
import java.util.Comparator;

class Order {
	int i;
public Order(int x) {
	// TODO Auto-generated constructor stub
	this.i=x;
}
}

class IntMaxCompartor implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o2-o1;
	}
	
}
public class Test {
	public static void eastbest(Shitang[] shitangs,int maxcost){
		int[] maxen=new int[shitangs.length];
		 for(int i1=0;i1<shitangs.length;i1++){
			 int foodlen=shitangs[i1].foos.length;
			 int[][] E=new int[foodlen+1][maxcost+1];
			 for(int a=0;a<=foodlen;a++)
				 E[a][0]=0;
			 for(int b=0;b<=maxcost;b++)
				 E[0][b]=0;
			 for(int food=1;food<=foodlen;food++){
				 for(int cost=1;cost<=maxcost;cost++){
					 if(shitangs[i1].foos[food-1].cost>cost){
						 E[food][cost]=E[food-1][cost];
					 }else {
						E[food][cost]=Math.max(E[food-1][cost],
								E[food-1][cost-shitangs[i1].foos[food-1].cost]+shitangs[i1].foos[food-1].enjoy);
					}
				 }
			 }
			 maxen[i1]=E[foodlen][maxcost];
		 }
		 Arrays.sort(maxen);
		 System.out.println(Arrays.toString(maxen));
	}
	
	public static void main(String[] args) {
		int i=-8;
		System.out.println((i>>1)+1);
		System.out.println(4.5%2);
	}
}
