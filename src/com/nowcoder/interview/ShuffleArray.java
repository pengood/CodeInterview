package com.nowcoder.interview;

import java.util.Arrays;
import java.util.Collections;

/*
 * 编写一个方法，洗一副牌，要求做到完美洗牌，换言之这副牌52！种排列组合出现的概率相同
 */
public class ShuffleArray {

	private int rand(int low,int high){
		return low+(int)(Math.random()*(high-low+1));
	}
	public int[] shuffleArrayRecursively(int[] cards,int i){
		if(i==0)
			return cards;
		shuffleArrayRecursively(cards, i-1);
		int k=rand(0, i);
		int tmp=cards[k];
		cards[k]=cards[i];
		cards[i]=tmp;
		return cards;
	}
	
	public int[] shuffleArrayInteratively(int[] cards){
		for(int i=0;i<cards.length;i++){
			int k=rand(0, i);
			int tmp=cards[k];
			cards[k]=cards[i];
			cards[i]=tmp;
		}
		return cards;
	}
	public static void main(String[] args) {
		int[] a={1,2,3,4,5,6,7};
		ShuffleArray array=new ShuffleArray();
		int[] re=array.shuffleArrayRecursively(a, a.length-1);
		System.out.println(Arrays.toString(re));
		int[] a1={1,2,3,4,5,6,7};
		int[] re2=array.shuffleArrayInteratively(a1);
		System.out.println(Arrays.toString(re2));
		int[] a3={1,2,3,4,5,6,7};
		Collections.shuffle(Arrays.asList(a3));
		System.out.println(Arrays.toString(a3));
	}
}
