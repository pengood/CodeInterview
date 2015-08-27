package com.nowcoder.offer;

import java.util.Arrays;

/*
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBSTTest {
public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0)
        	return false;
        if(sequence.length<=2)
        	return true;
        int root=sequence[sequence.length-1];
        int i=0;
        while(sequence[i]<root)
        	i++;
        int j=i;
        for(;j<sequence.length-1;j++){
        	if(sequence[j]<root)
        		return false;
        }
        if(i==0)
        	return VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length-1));
        if(i==sequence.length-1)
        	return VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        return VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i))&&
        		VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length-1));
    }
public static void main(String[] args) {
	int[] a={1,2,3,4,5};
	VerifySquenceOfBSTTest test=new VerifySquenceOfBSTTest();
	System.out.println(test.VerifySquenceOfBST(a));
}
}
