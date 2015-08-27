package com.nowcoder.offer;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
class MinNumCompertor implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		StringBuilder builder1=new StringBuilder();
		StringBuilder builder2=new StringBuilder();
		builder1.append(o1);
		builder1.append(o2);
		builder2.append(o2);
		builder2.append(o1);
		int i=Integer.valueOf(builder1.toString());
		int j=Integer.valueOf(builder2.toString());
		if(i>j)
			return +1;
		if(i<j)
			return -1;
		return 0;
	}
	
}
public class PrintMinNumberTest {
	public String PrintMinNumber(int[] numbers) {
		StringBuilder builder=new StringBuilder();
		if(numbers==null||numbers.length==0)
			return builder.toString();
		String[]  strings=new String[numbers.length];
		for(int i=0;i<numbers.length;i++){
			strings[i]=String.valueOf(numbers[i]);
		}
		Arrays.sort(strings, new MinNumCompertor());
		for(int i=0;i<strings.length;i++)
			builder.append(strings[i]);
		return builder.toString();
	}
	public static void main(String[] args) {
		int[] a={3,32,321,1};
		PrintMinNumberTest test=new PrintMinNumberTest();
		System.out.println(test.PrintMinNumber(a));
	}
}
