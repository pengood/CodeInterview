package com.nowcoder.offer;

import java.util.Arrays;

public class ReOrderArrayTest {
	 public void reOrderArray(int [] array) {
	        if(array==null||array.length<=2)
	        	return;
	        int len=array.length;
	        int[] aux=new int[len>>1];
	        int jishuLen;
	        if((len&1)>0)
	        	jishuLen=(len>>1)+1;
	        else {
				jishuLen=len>>1;
			}
	        int[] jishu=new int[jishuLen];
	        int i=0,j=0;
	        for(;i<len-1;j++){
	        	jishu[j]=array[i];
	        	aux[j]=array[i+1];
	        	i+=2;
	        }
	        if(i<len&&j<jishuLen)
	        	jishu[j]=array[i];
	        int k=0;
	        for(;k<jishuLen;k++)
	        	array[k]=jishu[k];
	        for(;k<len;k++)
	        	array[k]=aux[k-jishuLen];
	    }
	 public void reOrderArray1(int[] array){
		 if(array==null||array.length<=1)
			 return;
		 int i=0,j=0;
		 while(i<array.length&&j<array.length){
			 while(i<array.length){
				 if((array[i]&1)==0)
					 break;
				 i++;
			 }
			 while(j<array.length){
				 if((array[j]&1)>0)
					 break;
				 j++;
			 }
			 if(i>j){
				 j++;
				 continue;
			 }
			 if(j>=array.length)
				 break;
			int tmp=array[j];
			for(int k=j;k>i;k--){
				array[k]=array[k-1];
			}
			array[i]=tmp;
			 i++;
		 }
	 }
	 public static void main(String[] args) {
		ReOrderArrayTest test=new ReOrderArrayTest();
		int[] a={1,2,3,4,5,6,7,9};
		test.reOrderArray1(a);
		System.out.println(Arrays.toString(a));
	}
}
