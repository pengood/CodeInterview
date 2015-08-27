package com.offer;

import java.util.Arrays;

public class InversePairs {
	public static int inversePairs(int[] nums){
		if(nums==null||nums.length<=1)
			throw new IllegalArgumentException();
		int[] tmp=new int[nums.length];
		
		return invertpair(nums, tmp,0,nums.length-1);
	}
	private static int invertpair(int[] nums,int[] tmp,int start,int end){
		int inversions = 0; 
		if(start<end){
			int mid=(start+end)/2;
			inversions+=invertpair(nums, tmp, start, mid);//找左半段的逆序对数目
			inversions+=invertpair(nums, tmp, mid+1, end);//找右半段的逆序对数目
			inversions+=merge(nums, tmp, start, mid, end);//在找完左右半段逆序对以后两段数组有序，然后找两段之间的逆序对。最小的逆序段只有一个元素。
		}
		System.out.println(Arrays.toString(tmp));
		return inversions;
	}
	private static int merge(int[] nums,int[] tmp,int start,int mid,int end){
		 //int leftLen=mid-start+1;//nums[start...mid]左半段长度
	    //int rightLlen=end-mid;//nums[mid+1...end]右半段长度
		int i=mid;
	    int j=end;
	    int k=end;//临时数组末尾坐标
	    int count=0;
	    while(i>=start&&j>mid)	{
	    	if(nums[i]>nums[j]){
	    		tmp[k--]=nums[i--];
	    		count+=j-mid;//因为arry[mid+1...j...end]是有序的，如果arry[i]>arry[j]，那么也大于arry[j]之前的元素，
	    					//从a[mid+1...j]一共有j-(mid+1)+1=j-mid
	    	}
	    	else {
				tmp[k--]=nums[j--];
			}
	    }
	  //表示前半段数组中还有元素未放入临时数组
	    while(i>=start){
	    	tmp[k--]=nums[i--];
	    }
	    while(j>mid){
	    	tmp[k--]=nums[j--];
	    }
	    //复制回原数组
	    for(int i1=0;i1<=end;i1++)
	    	nums[i1]=tmp[i1];
	    return count;
	}
	
	public static void main(String[] args){
		int[] nums={7,5,6};
		System.out.println(inversePairs(nums));
	}
}
