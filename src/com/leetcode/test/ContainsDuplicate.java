package com.leetcode.test;

import java.util.HashMap;

/*
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 */
public class ContainsDuplicate {
	  public boolean containsDuplicate(int[] nums) {
		  if(nums==null)
			  throw new IllegalArgumentException();
		  if(nums.length==0)
			  return false;
		  HashMap<Integer, Boolean> map=new HashMap<>();
		  for(int i=0;i<nums.length;i++){
			  if(map.get(nums[i])==null)
				  map.put(nums[i], true);
			  else {
				return true;
			}
		  }
	      return false;  
	    }
	  public static void main(String[] args) {
		int[] nums={1,2,3,4,5,6,6};
		ContainsDuplicate duplicate=new ContainsDuplicate();
		System.out.println(duplicate.containsDuplicate(nums));
	}
}
