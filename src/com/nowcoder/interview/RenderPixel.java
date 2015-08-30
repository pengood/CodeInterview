package com.nowcoder.interview;

import java.util.Arrays;

/*
 * 有一个单色屏幕储存在一维数组中，其中数组的每个元素代表连续的8位的像素的值，请实现一个函数，
 * 将第x到第y个像素涂上颜色(像素标号从零开始)，并尝试尽量使用最快的办法。
	给定表示屏幕的数组screen(数组中的每个元素代表连续的8个像素，且从左至右的像素分别对应元素的二进制的从低到高位)，
	以及int x,int y，意义如题意所述，保证输入数据合法。请返回涂色后的新的屏幕数组。
	测试样例：
	[0,0,0,0,0,0],0,47
	返回：[255,255,255,255,255,255]
 */
public class RenderPixel {
	public int[] renderPixel(int[] screen, int x, int y) {
		int i=0,numx=x/8,numy=y/8,endx=x%8,endy=y%8;
		int mask=1;
		if(numx==numy){
			mask=mask<<endx;
			for(i=endx;i<=endy;i++){
				screen[numx]=screen[numx]|mask;
				mask=mask<<1;
			}
		}else {
			mask=mask<<endx;
			for(i=endx;i<8;i++){
				screen[numx]=screen[numx]|mask;
				mask=mask<<1;
			}
			for(i=0,mask=1;i<=endy;i++){
				screen[numy]=screen[numy]|mask;
				mask=mask<<1;
			}
			for(i=numx+1;i<numy;i++){
				screen[i]=255;
			}
		}
		return screen;
    }
	public static void main(String[] args) {
		int[] a={0,0,0,0,0,0};
		RenderPixel pixel=new RenderPixel();
		System.out.println(Arrays.toString(pixel.renderPixel(a, 0, 46)));
	}
}
