package com.nowcoder.offer;

import java.util.ArrayList;
import java.util.List;

/*
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。 
	输出描述:
	如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FirstAppearingOnceTest {
	 //Insert one char from stringstream
	List<Character> list=new ArrayList<Character>();
	int[] haschar=new int[256];
    public void Insert(char ch)
    {
        list.add(ch);
        haschar[ch]++;;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	for(char c: list){
    		if(haschar[c]==1)
    			return c;
    	}
    	return '#';
    }
    public static void main(String[] args) {
		char[] a="google".toCharArray();
		FirstAppearingOnceTest test=new FirstAppearingOnceTest();
		for(int i=0;i<a.length;i++){
			test.Insert(a[i]);
			System.out.print(test.FirstAppearingOnce()+" ");
		}
	}
}
