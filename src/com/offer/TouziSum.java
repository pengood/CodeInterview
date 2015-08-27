package com.offer;

public class TouziSum {
	static int gMax=6;
	public static void rateOfSum(int n){
		if(n<1)
			throw new IllegalArgumentException();
		int[] sum=new int[gMax*n-n+1];
		setSum(sum, n);
		double total=Math.pow(gMax, n);
		for(int i=0;i<sum.length;i++){
			double rate=sum[i]/total;
			System.out.println("sum"+(i+n)+":"+rate);
		}
	}
	private static void setSum(int[] sum,int n){
		for(int i=1;i<=gMax;i++){
			setsum1(sum, n, n, i);
		}
	}
	private static void setsum1(int[] sums,int orginl,int current,int sum){
		if(current==1){
			sums[sum-orginl]++;
		}
		else {
			for(int i=1;i<=gMax;i++){
				setsum1(sums, orginl, current-1, sum+i);
			}
		}
		
	}
	private static void rateOfSum2(int n){
		if(n<1)
			throw new IllegalArgumentException();
		int[][] sums=new int[2][gMax*n+1];
		for(int i=1;i<=gMax;i++)
			sums[0][i]=1;
		int flag=0;
		for(int k=2;k<=n;k++){
			for(int i=0;i<k;i++)
				sums[1-flag][i]=0;
			for(int i=k;i<=gMax*n;i++){
				sums[1-flag][i]=0;
				for(int j=1;j<=i&&j<=gMax;j++){
					sums[1-flag][i]+=sums[flag][i-j];
				}
			}
			flag=1-flag;
		}
		double total=Math.pow(gMax, n);
		for(int i=n;i<=gMax*n;i++){
			double rate=sums[flag][i]/total;
			System.out.println("sum"+(i)+":"+rate);
		}
		
	}
	public static void main(String[] args) {
		rateOfSum(3);
		rateOfSum2(3);
	}

}
