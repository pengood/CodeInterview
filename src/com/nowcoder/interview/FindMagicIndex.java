package com.nowcoder.interview;
/*
 * 在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个升序数组，元素值各不相同，
 * 编写一个方法，判断在数组A中是否存在魔术索引。请思考一种复杂度优于o(n)的方法。
	给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引。
	测试样例：
	[1,2,3,4,5]
	返回：false
 */
public class FindMagicIndex {
	public boolean findMagicIndex(int[] A, int n) {
        // write code here
		int begin=0;
		int end=n-1;
		while(begin<=end){
			int mid=begin+(end-begin)/2;
			if(A[mid]==mid)
				return true;
			if(A[mid]<mid){
				begin=mid+1;
			}else {
				end=mid-1;
			}
		}
		return false;
    }
	public static void main(String[] args) {
		int[] a={0,1,2,3,4,5};
		FindMagicIndex index=new FindMagicIndex();
		System.out.println(index.findMagicIndex(a, 6));
	}
}
