package com.nowcoder.interview;

import java.util.LinkedList;

/*
 * 约瑟夫问题是一个非常著名的趣题，即由n个人坐成一圈，按顺时针由1开始给他们编号。然后由第一个人开始报数，
 * 数到m的人出局。现在需要求的是最后一个出局的人的编号。
	给定两个int n和m，代表游戏的人数。请返回最后一个出局的人的编号。保证n和m小于等于1000。
	测试样例：
	5 3
	返回：4
 */
public class Joseph_I {
	public int getResult(int n, int m) {
		LinkedList<Integer> linkedList=new LinkedList<>();
		for(int i=1;i<=n;i++)
			linkedList.add(i);
		int pos=0;
		while(linkedList.size()>1){
			pos=(pos+m-1)%linkedList.size();
			linkedList.remove(pos);
		}
		return linkedList.getFirst();
    }
	public static void main(String[] args) {
		Joseph_I joseph_I=new Joseph_I();
		System.out.println(joseph_I.getResult(5, 3));
	}
}
