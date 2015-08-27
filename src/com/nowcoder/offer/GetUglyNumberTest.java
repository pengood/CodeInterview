package com.nowcoder.offer;

/*
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 *  习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumberTest {
	public int GetUglyNumber_Solution(int index) {
		if (index <=0)
			return 0;
		int[] uglys = new int[index];
		uglys[0] = 1;
		int m2 =0;
		int m3 =0;
		int m5 =0;
		int nextindex = 1;
		while (nextindex < index) {
			uglys[nextindex]=min(uglys[m2]*2, uglys[m3]*3, uglys[m5]*5);
			while(uglys[m2]*2<=uglys[nextindex])
				m2++;
			while(uglys[m3]*3<=uglys[nextindex])
				m3++;
			while(uglys[m5]*5<=uglys[nextindex])
				m5++;
			nextindex++;
		}
		return uglys[nextindex-1];
	}

	private int min(int a, int b, int c) {
		if(a>b)
			a=b;
		return a<c?a:c;
	}
	public static void main(String[] args) {
		GetUglyNumberTest test=new GetUglyNumberTest();
		System.out.println(test.GetUglyNumber_Solution(0));
	}
}
