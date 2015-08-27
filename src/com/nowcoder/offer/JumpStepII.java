package com.nowcoder.offer;

public class JumpStepII {
	public int JumpFloorII(int target) {
		if(target<=2)
			return target;
		int fn_1=2;
		int fn=0;
		int n=3;
		while(n<=target){
			fn=fn_1<<1;
			fn_1=fn;
			n++;
		}
		return fn;
	}
	public static void main(String[] args) {
		JumpStepII stepII=new JumpStepII();
		System.out.println(stepII.JumpFloorII(3));
	}
}
