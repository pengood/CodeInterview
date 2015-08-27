package com.offer;

public class FindNumAppearence {
	public static void findonetime(int[] nums){
		if(nums==null||nums.length<2)
			throw new IllegalArgumentException();
		int intxor=0;
		for(int i=0;i<nums.length;i++)
			intxor^=nums[i];
		if(intxor==0)
			throw new IllegalArgumentException();
		int n=findfirst1bit(intxor);
		int num1=0,num2=0;
		for(int i=0;i<nums.length;i++){
			if(nthnumberis1(nums[i], n))
				num1^=nums[i];
			else {
				num2^=nums[i];
			}
		}
		System.out.println("num1:"+num1+" num2:"+num2);
		
	}
	private static int findfirst1bit(int num){
		int index=0;
		while((num&(1<<index))==0&&index<=16)
			index++;
		return index;
	}
	
	private static boolean nthnumberis1(int num,int n){
		if((num&(1<<n))==0)
			return false;
		return true;
	}
	public static void main(String[] args) {
		int[] nums={-2,3,4,3,4,5,5,7,7,9,9,-10,-1000,-10};
		findonetime(nums);
		int intxor=0;
		for(int i=0;i<nums.length;i++)
			intxor^=nums[i];
		System.out.println(intxor);
		System.out.println(findfirst1bit(4));
		System.out.println(nthnumberis1(4, 3));
	}
}
