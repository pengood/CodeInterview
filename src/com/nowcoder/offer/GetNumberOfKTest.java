package com.nowcoder.offer;

/*
 * 统计一个数字在排序数组中出现的次数
 */
public class GetNumberOfKTest {
	public int GetNumberOfK(int[] array, int k) {
		if(array==null||array.length==0)
			return 0;
		int count=0;
		int start=0;
		int end=array.length-1;
		int mid = 0;
		while(start<=end){
			mid=start+((end-start)>>1);
			if(array[mid]==k){
				break;
			}
			else if (array[mid]<k) {
				start=mid+1;
			}
			else {
				end=mid-1;
			}
		}
		
		for(int i=mid;i>=0;i--){
			if(array[i]!=k)
				break;
			count++;
		}
		for(int i=mid+1;i<array.length;i++){
			if(array[i]!=k)
				break;
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		int[] a={1,2,4,4,4,5,6};
		GetNumberOfKTest test=new GetNumberOfKTest();
		System.out.println(test.GetNumberOfK(a, 4));
	}
}
