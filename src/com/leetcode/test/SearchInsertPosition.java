package com.leetcode.test;

public class SearchInsertPosition {
	 public int searchInsert(int[] nums, int target) {
	      if(nums==null||nums.length==0)
	    	  return 0;
	      int ret=-1;
	      for(int i=0;i<nums.length;i++){
	    	  if(nums[i]>=target){
	    		  ret=i;
	    		  break;
	    	  }
	      }
	      if(ret==-1)
	    	  ret=nums.length;
	      return ret;
	    }
	 public static void main(String[] args) {
		
	}
}
