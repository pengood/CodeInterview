package com.nowcoder.interview;

/*
 * 有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。
 * 现在有两个结点a，b。请设计一个算法，求出a和b点的最近公共祖先的编号。
 给定两个int a,b。为给定结点的编号。请返回a和b的最近公共祖先的编号。
 注意这里结点本身也可认为是其祖先。
 测试样例：
 2，3
 返回：1
 */
public class GetLCA {
	public int getLCA(int a, int b) {
		if (a == b || a == 1)
			return a;
		if (b == 1)
			return b;
		int da = 0;
		while ((1 << da) <= a)
			da++;
		int db = 0;
		while ((1 << db) <= b)
			db++;
		// make sure a<=b
		if (da > db) {
			int tmp1 = da;
			int tmp2 = a;
			a = b;
			da = db;
			db = tmp1;
			b = tmp2;
		}
		while (b >= (1 << da)) {
			b >>= 1;
		}
		if (a == b)
			return a;
		while (a != b) {
			a >>= 1;
			b >>= 1;
			if (a == 1)
				break;
		}
		return a;
	}
	public int getLCA1(int a, int b){
		 if(a==b)
	            return a;
	        while(a != b)
	        {
	           if(a>b)
	               a = a/2;
	            else
	                b = b/2;
	        }
	        return a;
	}
public static void main(String[] args) {
	GetLCA getLCA=new GetLCA();
	System.out.println(getLCA.getLCA(12, 5));
}
}
