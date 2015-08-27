package com.nowcoder.offer;

import java.util.Arrays;
import java.util.Scanner;
class Food{
	int cost;
	int enjoy;
	public Food(int co,int en){
		this.cost=co;
		this.enjoy=en;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return cost+" "+enjoy;
	}
	
}
class Shitang{
	Food[] foos;
	public Shitang(int num){
		this.foos=new Food[num];
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<foos.length;i++)
			builder.append(foos[i]+" ");
		return builder.toString();
	}
	
}
public class EatBestTest {
	public static void main(String[] args) {
		 Scanner cin = new Scanner(System.in);
		 int T=cin.nextInt();
		 int[][] tests=new int[T][3];
		 for(int i=0;i<T;i++){
			 tests[i][0]=cin.nextInt();
			 tests[i][1]=cin.nextInt();
			 tests[i][2]=cin.nextInt();
			 Shitang[] shitangs=new Shitang[tests[i][0]];
			 for(int j=0;j<tests[i][0];j++){
				 int foodnum=cin.nextInt();
				 shitangs[j]=new Shitang(foodnum);
				 for(int k=0;k<foodnum;k++){
					 int co=cin.nextInt();
					 int en=cin.nextInt();
					 shitangs[j].foos[k]=new Food(co, en);
				 }
	//			 System.out.println(shitangs[j]);
			 }
			 int[] maxen=new int[shitangs.length];
			 int[] bot=new int[shitangs.length];
			 for(int i1=0;i1<shitangs.length;i1++){
				 int foodlen=shitangs[i1].foos.length;
				 int maxcost=tests[i][2];
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
				// System.out.println(Arrays.toString(E[foodlen]));
				 for(int c=maxcost;c>0&&E[foodlen][c]==maxen[i1];c--){
					bot[i1]=c;
				 }
			 }
			 int maxenj=maxen[0];
			 int e=0;
			 for(int d=1;d<shitangs.length;d++){
				 if(maxen[d]>maxenj&&bot[d]>=tests[i][1]){
					 maxenj=maxen[d];
					 e=d;
				 }
			 }
			 System.out.println(e);
			 System.out.println(Arrays.toString(bot));
			 System.out.println(Arrays.toString(maxen));
			 if(bot[e]<tests[i][1]){
				 System.out.println(0);
			 }
			 else {
				System.out.println(maxenj);
			}
			 
		 }
//		 for(int i=0;i<T;i++){
//			 System.out.println(Arrays.toString(tests[i]));
//		 }
		 cin.close();
	}
}
