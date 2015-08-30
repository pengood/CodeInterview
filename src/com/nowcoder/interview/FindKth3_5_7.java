package com.nowcoder.interview;

/*
 * 有一些数的素因子只有3、5、7，请设计一个算法，找出其中的第k个数。
 给定一个数int k，请返回第k个数。保证k小于等于100。
 测试样例：
 3
 返回：7
 */
public class FindKth3_5_7 {
	public int findKth(int k) {
		// write code here
		int[] nums=new int[k+1];
		nums[0]=1;
		int m3=0;
		int m5=0;
		int m7=0;
		int index=0;
		while(index<k){
			index++;
			nums[index]=min(nums[m3]*3, nums[m5]*5, nums[m7]*7);
			
			while(nums[m3]*3<=nums[index])
				m3++;
			while(nums[m5]*5<=nums[index])
				m5++;
			while(nums[m7]*7<=nums[index])
				m7++;
		}
		return nums[index];
	}
	private int min(int a,int b,int c){
		if(a>b)
			a=b;
		return a<c?a:c;
	}
	public static void main(String[] args) {
		FindKth3_5_7 findKth3_5_7=new FindKth3_5_7();
		System.out.println(findKth3_5_7.findKth(3));
	}
}
