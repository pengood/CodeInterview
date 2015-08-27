package com.nowcoder.offer;
/*
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 */
public class MinNumberInRotateArray {
	 public int minNumberInRotateArray(int [] array) {
		    if(array==null)
		    	throw new IllegalArgumentException();
		    if(array.length==0)
		    	return 0;
		 int i=0,j=array.length-1;
		 int mid=i;
		 while(array[i]>=array[j]){
			 if(j-i==1){
				 mid=j;
				 break;
			 }
			 mid=i+((j-i)>>1);
			 if(array[i]==array[mid]&&array[mid]==array[j])
				 return minByOrder(array, i, j);
			 if(array[i]<=array[mid])
				 i=mid;
			 else if(array[j]>=array[mid])
				 j=mid;
		 }
		 return array[mid];
	    }
	 private int minByOrder(int[] array,int begin,int end){
		 int result=array[begin];
		 for(int i=begin+1;i<=end;i++){
			 if(array[i]<result)
				 result=array[i];
		 }
		 return result;
	 }
	 public static void main(String[] args) {
		MinNumberInRotateArray array=new MinNumberInRotateArray();
		int[] a={3,4,5,0,1,2};
		System.out.println(array.minNumberInRotateArray(a));
	}
}
