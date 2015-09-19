package com.nowcoder.interview;

import java.util.Arrays;

/*
 * 我们现在有四个槽，每个槽放一个球，颜色可能是红色(R)、黄色(Y)、绿色(G)或蓝色(B)。
 * 例如，可能的情况为RGGB(槽1为红色，槽2、3为绿色，槽4为蓝色)，作为玩家，你需要试图猜出颜色的组合。
 * 比如，你可能猜YRGB。要是你猜对了某个槽的颜色，则算一次“猜中”。要是只是猜对了颜色但槽位猜错了，
 * 则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
	给定两个string A和guess。分别表示颜色组合，和一个猜测。请返回一个int数组，
	第一个元素为猜中的次数，第二个元素为伪猜中的次数。
	测试样例：
	"RGBY","GGRR"
	返回：[1,1]
 */
public class GuessColour {
	public int[] calcResult(String A, String guess) {
		if(A==null||guess==null||A.length()!=guess.length())
			throw new IllegalArgumentException();
		int[] ret=new int[2];
		int len=A.length();
		int succ=0;
		int succfail=0;
		int[] a=new int[4];
		int[] g=new int[4];
		for(int i=0;i<len;i++){
			if(A.charAt(i)==guess.charAt(i)){
				succ++;
			}else {
				switch (A.charAt(i)) {
				case 'R':
					a[0]++;
					break;
				case 'Y':
					a[1]++;
					break;
				case 'G':
					a[2]++;
					break;
				case 'B':
					a[3]++;
					break;
				}
				switch (guess.charAt(i)) {
				case 'R':
					g[0]++;
					break;
				case 'Y':
					g[1]++;
					break;
				case 'G':
					g[2]++;
					break;
				case 'B':
					g[3]++;
					break;
				}
			}
		}
		for(int i=0;i<4;i++){
			succfail+=min(a[i], g[i]);
		}
		ret[0]=succ;
		ret[1]=succfail;
		return ret;
    }
	private int min(int a,int b){
		return a<b?a:b;
	}
	public static void main(String[] args) {
		String a="RGRY";
		String b="YGRG";
		GuessColour colour=new GuessColour();
		int[] a1=colour.calcResult(a, b);
		System.out.println(Arrays.toString(a1));
	}
}
