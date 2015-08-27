package com.offer;

public class MoreThanHalfNum {
	public static int moreHalf(int[] nums){
		if(nums==null||nums.length==0)
			return 0;
		int len=nums.length;
		int mid=len/2;
		int start=0;
		int end=len-1;
		int result=0;
		int index=QiuckSort.myPartition(nums, 0, len-1);
		while(index!=mid){
			if(index<mid){
				start=index+1;
				index=QiuckSort.myPartition(nums, start, end);
			}
			else{
				end=index-1;
				index=QiuckSort.myPartition(nums, start, end);
			}
		}
		result=nums[mid];
		int times=0;
		for(int i=0;i<len;i++){
			if(nums[i]==result)
				times++;
		}
		if(times>mid)
			return result;
		return 0;
	}
	public static int morethanhalf(int[] nums){
		if(nums==null||nums.length==0)
			return 0;
		int times=0;
		int number=nums[0];
		for(int i=0;i<nums.length;i++){
			if(times==0){
				number=nums[i];
			}
			if(nums[i]==number)
				times++;
			else {
				times--;
			}
		}
		int result=number;
		times=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==result)
				times++;
		}
		if(times>nums.length/2)
			return result;
		return 0;		
	}
	public static void main(String[] args){
		int[] a={1,2,3,2,2};
		System.out.print(moreHalf(a));
	}
}
