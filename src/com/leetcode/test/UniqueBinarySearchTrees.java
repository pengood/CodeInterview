package com.leetcode.test;

import java.util.HashMap;

public class UniqueBinarySearchTrees { 
	HashMap<Integer, Integer> map=new HashMap<>();
public int numTrees(int n) {
	assert n>=0;
        if(n<=1)
        	return n;
        int sum=0,num=0;
        for(int i=1;i<=n;i++){
        	if(map.get(i-1)==null)
        		map.put(i-1, numTrees(i-1));
        	int left=map.get(i-1);
        	if(map.get(n-i)==null)
        		map.put(n-i, numTrees(n-i));
        	int right=map.get(n-i);
        	if(left==0)
        		num=right;
        	else if(right==0)
        		num=left;
        	else {
				num=left*right;
			}
        	sum+=num;
        }
        return sum;
    }
public static void main(String[] args) {
	UniqueBinarySearchTrees trees=new UniqueBinarySearchTrees();
	System.out.println(trees.numTrees(19));
}
}
