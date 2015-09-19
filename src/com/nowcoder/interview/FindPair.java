package com.nowcoder.interview;

import java.util.Arrays;

/*
 * 请设计一个高效算法，找出数组中两数之和为指定值的所有整数对。
	给定一个int数组A和数组大小n以及需查找的和sum，请返回和为sum的整数对的个数。保证数组大小小于等于3000。
	测试样例：
	[1,2,3,4,5],5,6
	返回：2
 */
public class FindPair {
	  public int countPairs(int[] A, int n, int sum) {
		  if(A==null||A.length<=1)
	            return -1;
	        Arrays.sort(A);
	        int begin=0;
	        int end=n-1;
	        int count=0;
	        while(begin<end){
	            int sumtmp=A[begin]+A[end];
	            if(sumtmp==sum){
	                if(A[begin]==A[end]){
	                      int x = end-begin+1;
	                      count += x*(x-1)/2;
	                    break;
	                }
	                int x=1;
	                int y=1;
	                int begintmp=A[begin];
	                int endtmp=A[end];
	                while(A[++begin]==begintmp)
	                    x++;
	                while(A[--end]==endtmp)
	                    y++;
	                count+=x*y;
	            }
	            else if (sumtmp>sum) {
	                end--;
	            }else {
	                begin++;
	            }
	        }
	        return count;
	    }
	  public static void main(String[] args) {
		int[] a={11,7,7,6,14,2,14,15,2,1,2,12,13,9,8,15,13,8,10,11,14,10,2,9,4,9,3,7,6,10,15,4,7,6,15,3,9,13,5,2,6,10,10,1,12,4,3,3,8,8,1,4,7,11,13,5,13,15,4,3,1,11,6,11,9,9,11,15,12,10,13,3,11,4,8,9,7,3,13,9,11,3,2,11,10,1,4,2,3,3,14,11,5,10,1,14,8,1,11,3,1,9,14,6,1,7,15,10,14,6,4,12,11};
		FindPair pair=new FindPair();
		System.out.println(pair.countPairs(a, a.length, 16));
	}
}
