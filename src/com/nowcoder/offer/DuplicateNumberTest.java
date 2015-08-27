package com.nowcoder.offer;

import java.util.Arrays;

/*
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 */
public class DuplicateNumberTest {
	public boolean duplicate(int numbers[], int length, int[] duplication) {
		if(numbers==null||length<=1)
			return false;
		int[] times=new int[length];
		Arrays.fill(times, 0);
		for(int i=0;i<length;i++){
			if(times[numbers[i]]==1){
				duplication[0]=numbers[i];
				return true;
			}
			times[numbers[i]]++;
		}
		return false;
	}
}
