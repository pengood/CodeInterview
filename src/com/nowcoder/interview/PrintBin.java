package com.nowcoder.interview;

/*
 * 有一个介于0和1之间的实数，类型为double，返回它的二进制表示。如果该数字无法精确地用32位以内的二进制表示，返回“Error”。
 给定一个double num，表示0到1的实数，请返回一个string，代表该数的二进制表示或者“Error”。
 测试样例：
 0.625
 返回：0.101
 */
public class PrintBin {
	public String printBin(double num) {
		if(num>=1||num<=0)
			return "Error";
		StringBuilder builder=new StringBuilder();
		builder.append('.');
		double frac=0.5;
		while(num>0){
			if(builder.length()>32){
				return "Error";
			}
			if(num>=frac){
				builder.append('1');
				num-=frac;
			}else {
				builder.append('0');
			}
			frac/=2;
				
		}
		return builder.toString();
	}
	public static void main(String[] args) {
		PrintBin printBin=new PrintBin();
		System.out.println(printBin.printBin(0.625));
	}
}
