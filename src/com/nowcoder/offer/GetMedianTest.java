package com.nowcoder.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class GetMedianTest {
	static class IntMaxCompartor implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2-o1;
		}
	}
	//最小堆，最小值在堆顶，存储较大的半边数据，堆顶是中位数
	PriorityQueue<Integer> minQueue=new PriorityQueue<>();
	PriorityQueue<Integer> maxQueue=new PriorityQueue<>(new IntMaxCompartor());
	int size=0;
	public void Insert(Integer num) {
		if((size&1)>0){
			minQueue.add(num);
			maxQueue.add(minQueue.poll());
			size++;
		}else {
			if(size==0){
				minQueue.add(num);
				size++;
			}else {
				maxQueue.add(num);
				minQueue.add(maxQueue.poll());
				size++;
			}
		}
	}

	public Double GetMedian() {
		if(size==0)
			return 0.0;
		if((size&1)>0){
			return minQueue.peek()*1.0;
		}else {
			return (minQueue.peek()+maxQueue.peek())/2.0;
		}

	}
	public static void main(String[] args) {
		int[] a={1,2,3,4,5,6};
		GetMedianTest test=new GetMedianTest();
		for(int i=0;i<a.length;i++){
			test.Insert(a[i]);
			System.out.print(test.GetMedian()+" ");
		}
	}
}
