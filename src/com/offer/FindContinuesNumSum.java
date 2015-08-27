package com.offer;

public class FindContinuesNumSum {
	public static void findNum(int sum){
		if(sum<3)
			return;
		int small=1;
		int big=2;
		int mid=sum/2;
		int curSum=small+big;
		while(small<=mid){
			if(curSum==sum)
				printnum(small, big);
			while(curSum<=sum&&big<sum){
				big++;
				curSum+=big;
				if(curSum==sum)
					printnum(small, big);
			}
			curSum-=small;
			small++;
		}
	}
	private static void printnum(int small,int big){
		for(int i=small;i<=big;i++)
			System.out.print(i+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		findNum(9);
	}
}
