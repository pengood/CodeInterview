package com.nowcoder.offer;

public class JumpStep {
	 public int JumpFloor(int target) {
		 if(target<=2)
			 return target;
		 int fn_2=1,fn_1=2,fn=0;
		 int n=3;
		 while(n<=target){
			 fn=fn_1+fn_2;
			 fn_2=fn_1;
			 fn_1=fn;
			 n++;
		 }
		 return fn;
 }
	 public static void main(String[] args) {
		JumpStep step=new JumpStep();
		System.out.println(step.JumpFloor(7));
	}
}
