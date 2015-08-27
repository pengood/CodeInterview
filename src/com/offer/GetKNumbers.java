package com.offer;

public class GetKNumbers {
	public static int getfirstK(int[] nums,int k,int start,int end){
		if(start>end)
			return -1;
		int mid=(start+end)/2;
		int midnum=nums[mid];
		if(midnum==k){
			if((mid>0&&nums[mid-1]!=k)||mid==0)
				return mid;
			else {
				end=mid-1;
			}
		}
		else if(midnum<k)
			start=mid+1;
		else {
			end=mid-1;
		}
		return getfirstK(nums, k, start, end);
	}
	
	public static int getlastK(int[] nums,int k,int start,int end){
		if(start>end)
			return -1;
		int mid=(start+end)/2;
		int midnum=nums[mid];
		if(midnum==k){
			if((mid<nums.length-1&&nums[mid+1]!=k)||mid==nums.length-1){
				return mid;
			}
			else {
				start=mid+1;
			}
		}
		else if(midnum>k) {
			end=mid-1;
		}
		else {
			start=mid+1;
		}
		return getlastK(nums, k, start, end);
	}
	
	public static int getKnum(int[] nums,int k){
		if(nums==null||nums.length==0)
			throw new IllegalArgumentException();
		int last= getlastK(nums, k, 0, nums.length-1);
		int first=getfirstK(nums, k, 0, nums.length-1);
		int number=0;
		if(first>-1&&last>-1)
			number=last-first+1;
		return number;
	}
	public static void main(String[] args) {
		int[] nums={1,2,3,3,3,3,4,5};
		System.out.println(getKnum(nums, 3));
	}
}
