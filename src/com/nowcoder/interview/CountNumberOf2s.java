package com.nowcoder.interview;
/*
 * 请编写一个方法，输出0到n(包括n)中数字2出现了几次。
	给定一个正整数n，请返回0到n的数字中2出现了几次。
	测试样例：
	10
返回：1
 */
public class CountNumberOf2s {
	public int countNumberOf2s(int n) {
		int count=0;
		int len=String.valueOf(n).length();
		for(int i=0;i<len;i++){
			count+=count2Atdigit(n, i);
		}
		return count;
    }
	
	private int count2Atdigit(int num,int d){
		int power10=(int)Math.pow(10, d);
		int nextPower=power10*10;
		int right=num%power10;
		
		int roundDown=num-num%nextPower;
		int roundUp=roundDown+nextPower;
		int digt=(num/power10)%10;
		if(digt<2){
			return roundDown/10;
		}else if (digt>2) {
			return roundUp/10;
		}else {
			return roundDown/10+right+1;
		}
	}
	public static void main(String[] args) {
		CountNumberOf2s countNumberOf2s=new CountNumberOf2s();
		System.out.println(countNumberOf2s.countNumberOf2s(10));
	}
}
