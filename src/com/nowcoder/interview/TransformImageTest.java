package com.nowcoder.interview;

import java.util.Arrays;

/*
 * 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
 测试样例：
 [[1,2,3],[4,5,6],[7,8,9]],3
 返回：[[7,4,1],[8,5,2],[9,6,3]]
 */
public class TransformImageTest {
	public int[][] transformImage(int[][] mat, int n) {
		if(mat==null||mat.length<=1)
			return mat;
		for(int layer=0;layer<n/2;layer++){
			int first=layer;
			int last=n-layer-1;
			for(int i=first;i<last;i++){
				int offset=i-first;
				//保存顶部
				int top=mat[first][i];
				//顶部等于左边
				mat[first][i]=mat[last-offset][first];
				//左边等于下边
				mat[last-offset][first]=mat[last][last-offset];
				//下边等于右边
				mat[last][last-offset]=mat[i][last];
				//右边等于保存的顶部
				mat[i][last]=top;
			}
		}
		
		return mat;
	}
	public static void main(String[] args) {
		int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		TransformImageTest test=new TransformImageTest();
		int[][] b=test.transformImage(a, 4);
		for(int i=0;i<a.length;i++){
		System.out.println(Arrays.toString(b[i]));	
		}
		
	}
}
