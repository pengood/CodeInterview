package com.nowcoder.interview;

import java.util.Arrays;

/*
 * ����һ��СдӢ����ĸ��ɵ��ַ���s��һ�������϶�СдӢ���ַ���������p�������һ����Ч�㷨������p�е�ÿһ���϶��ַ������ж����Ƿ�Ϊs���Ӵ���
����һ��string����p�����Ĵ�Сn��ͬʱ����string s��Ϊĸ�����뷵��һ��bool���飬ÿ��Ԫ�ش���p�еĶ�Ӧ�ַ����Ƿ�Ϊs���Ӵ�����֤p�еĴ�����С�ڵ���8��
��p�еĴ��ĸ���С�ڵ���500��ͬʱ��֤s�ĳ���С�ڵ���1000��
����������
["a","b","c","d"],4,"abc"
���أ�[true,true,true,false]
 */
public class CheckSubString {
	 public boolean[] chkSubStr(String[] p, int n, String s) {
		 if(p==null||n<=0)
			 throw new IllegalArgumentException();
		 boolean[]  re=new boolean[n];
		 for(int i=0;i<n;i++){
			 if(s.contains(p[i]))
				 re[i]=true;
			 else {
				re[i]=false;
			}
		 }
		 return re;
	    }
	 public static void main(String[] args) {
		String[] strings={"a","b","c","d"};
		CheckSubString strin=new CheckSubString();
		String string="abc";
		System.out.println(Arrays.toString(strin.chkSubStr(strings, strings.length, string)));
	}
}
