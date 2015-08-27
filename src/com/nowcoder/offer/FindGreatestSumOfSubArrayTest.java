package com.nowcoder.offer;

/*
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,
 * 他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？
 */
public class FindGreatestSumOfSubArrayTest {
	public int FindGreatestSumOfSubArray(int[] array) {
		if(array==null||array.length==0)
			throw new IllegalArgumentException();
		int maxsum=Integer.MIN_VALUE;
		int cursum=-1;
		for(int i=0;i<array.length;i++){
			if(cursum<0){
				cursum=array[i];
			}else {
				cursum+=array[i];
			}
			if(cursum>maxsum)
				maxsum=cursum;
		}
		return maxsum;
	}
	public static void main(String[] args) {
		FindGreatestSumOfSubArrayTest test=new FindGreatestSumOfSubArrayTest();
		int[] a={-6,-3,-2,-7,-15,-15,-2,-2};
		System.out.println(test.FindGreatestSumOfSubArray(a));
	}
}
