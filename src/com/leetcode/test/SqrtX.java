package com.leetcode.test;

public class SqrtX {
	 public int mySqrt(int x) {
		 long num=x;
		 long begin=0;
		 long end=(num+1)>>1;
		 long mid=0;
		 long tmp=0;
		 while(begin<=end){
			 mid=begin+((end-mid)>>1);
			 tmp=mid*mid;
			 if (tmp==x) {
				return (int) mid;
			}
			 else if (tmp>x) {
				end=mid-1;
			}
			 else {
				begin=mid+1;
			}
		 }
		 tmp=end*end;
		 if(tmp>x)
			 return (int) (end-1);
		 return (int) end;
	    }
	 public static void main(String[] args) {
		SqrtX sqrtX=new SqrtX();
		System.out.println(sqrtX.mySqrt(Integer.MAX_VALUE));
	}
}
