package com.nowcoder.offer;

/*
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数。
 */
public class NumberOf1Between1AndNTest {
	public int NumberOf1Between1AndN_Solution(int n) {
		int count=0;
		int ifactor=1;
		int lowernum=0;
		int curnum=0;
		int highernum=0;
		while(n/ifactor!=0){
			lowernum=n-(n/ifactor)*ifactor;	//地位数
			curnum=(n/ifactor)%10;	//当前位上的数
			highernum=n/(ifactor*10);	//高位的数
			switch (curnum) {
			case 0:
				count+=highernum*ifactor;
				break;
			case 1:
				count+=highernum*ifactor+lowernum+1;
				break;
			default:
				count+=(highernum+1)*ifactor;
				break;
			}
			ifactor*=10;
		}
		return count;
		
	}
	public static void main(String[] args) {
		NumberOf1Between1AndNTest test=new NumberOf1Between1AndNTest();
		System.out.println(test.NumberOf1Between1AndN_Solution(3));
	}
}
