package com.nowcoder.interview;

import java.util.ArrayList;

/*
 * 叠罗汉是一个著名的游戏，游戏中一个人要站在另一个人的肩膀上。为了使叠成的罗汉更稳固，
 * 我们应该让上面的人比下面的人更轻一点。已知参加游戏的每个人的体重，请编写代码计算通过选择参与游戏的人，
 * 我们多能叠多少个人。注意这里的人都是先后到的，意味着参加游戏的人的先后顺序与原序列中的顺序应该一致。
	给定一个int数组men，代表依次来的每个人的身高。同时给定总人数n，请返回做多能叠的人数。保证n小于等于500。
	测试样例：
	[1,6,2,5,3,4],6
	返回：4
 */
public class GetArhatHeight {
	//获取最长递增数列
	public int getHeight(int[] men, int n) {
		if(men==null||men.length==0)
			return -1;
		ArrayList<Integer>[] lists=new ArrayList[n];
		ArrayList<Integer> emptyList=new ArrayList<>();
		int maxsize=0;
		for(int i=0;i<n;i++){
			lists[i]=new ArrayList<>();
			ArrayList<Integer> cur=emptyList;
			for(int j=0;j<i;j++){
				if(lists[j].size()>cur.size()&&men[j]<=men[i])
					cur=lists[j];
			}
			lists[i].addAll(cur);
			lists[i].add(men[i]);
			if(lists[i].size()>maxsize)
				maxsize=lists[i].size();
		}
		return maxsize;
    }
	public static void main(String[] args) {
		int[] a={1,6,2,5,3,4};
		GetArhatHeight height=new GetArhatHeight();
		System.out.println(height.getHeight(a, 6));
	}
}
