package com.offer;

public class GetUgly {
public  static int getugly(int index){
	int[] nums=new int[index];
	nums[0]=1;
	int m2,m3,m5;
	m2=m3=m5=0;
	int i=0,nextugly=1;
	while(nextugly<index){
		int min=min(nums[m2]*2, nums[m3]*3, nums[m5]*5);
		nums[nextugly]=min;
		while(nums[m2]*2<=nums[nextugly])
			m2++;
		while(nums[m3]*3<=nums[nextugly])
			m3++;
		while(nums[m5]*5<=nums[nextugly])
			m5++;
		nextugly++;
	}
	return nums[nextugly-1];
	
}
private static int min(int a,int b,int c){
	int min=(a<b)?a:b;
	min=(min<c)?min:c;
	return min;
}
public static void main(String[] args){
	System.out.print(getugly(1500));
}
}
