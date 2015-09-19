package com.nowcoder.interview;

/*
 * 有一篇文章内含多个单词，现给定两个单词，请设计一个高效算法，
 * 找出文中这两个单词的最短距离(即最少相隔的单词数,也就是两个单词在文章中位置的差的绝对值)。
 给定一个string数组article，代表所给文章，同时给定文章的单词数n和待查找的两个单词x和y。
 请返回两个单词的最短距离。保证两个单词均在文中出现且不相同，同时保证文章单词数小于等于1000。
 */
public class WordsDistance {
	public int getDistance(String[] article, int n, String x, String y) {
		if(article==null||article.length<2)
			throw new IllegalArgumentException();
		int lastx=-1;
		int lasty=-1;
		int result=Integer.MAX_VALUE;
		for(int i=0;i<article.length;i++){
			if(article[i].equals(x)){
				int dis=i-lasty;
				if(dis<result)
					result=dis;
				lastx=i;
			}else if (article[i].equals(y)) {
				int dis=i-lastx;
				if(dis<result)
					result=dis;
				lasty=i;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		String[] a={"lab","lab","nhb","nhb","lab","nhb","nhb","nhb","lab"};
		WordsDistance distance=new WordsDistance();
		String x="nhb";
		String y="lab";
		System.out.println(distance.getDistance(a, a.length, x, y));
	}
}
