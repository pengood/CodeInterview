package com.offer;

public class Reorderoddeven {
	public static void reorder(int[] nums){
		if(nums==null||nums.length==1)
			return;
		int len=nums.length;
		int i=0,j=len-1;
		for(;i<j;i++){
			if((nums[i]&1)==0){
				while(j>i&&(nums[j]&1)==0)
					j--;
				if(j==i)
					break;
				int tmp=nums[i];
				nums[i]=nums[j];
				nums[j]=tmp;
			}
		}
	}

	public static void main(String[] args){
		int[] a={2,1,4,2,5,1,6,2,6,7,3};
		reorder(a);
		MyArrays.print(a);
	}
}
