package com.nowcoder.interview;
/*
 * 有数量不限的硬币，币值为25分、10分、5分和1分，请编写代码计算n分有几种表示法。
	给定一个int n，请返回n分有几种表示法。保证n小于等于100000，为了防止溢出，请将答案Mod 1000000007。
	测试样例：
	6
	返回：2
 */

public class CoinCountWays {
		//bug
	 public int countWays(int n) {
		 	int[] nums={1,5,10,25};
		 	return slove(n, nums[3], nums);
	    }
	 private int slove(int n,int num,int[] nums){
		 if(n<=0)
			 return 0;
		 int result=0;
		 if(num==nums[0]){
			 return 1;
		 }
		 for(int i=nums.length-1;i>=1;i--){
			 if(num==nums[i]){
				 for(int j=0;j<=n/num;j++){
				 result+=slove(n-num*j, nums[i-1], nums);
			 }
			 }
			 
		 }
		 return result;
	 }
	 public int countWays1(int n){
		    int[] coins={1,5,10,25};
	        int[] dp=new int[100000];
	        dp[0]=1;
	        for(int i=0;i<4;++i){
	            for(int j=coins[i];j<=n;++j){
	                dp[j]=(dp[j]+dp[j-coins[i]])%1000000007;
	            }
	        }
	         
	        return dp[n];
	 }
	 int[] coins={1,5,10,25};
	 public int countWays2(int n){
		 return helpCount(n, 3);
		 
	 }
	 private int helpCount(int total,int i){
		 if(total<5||i==0)
			 return 1;
		 int result=0;
		 for(int j=0;j<=total/coins[i];j++){
			 result+=helpCount(total-j*coins[i], i-1);
		 }
		 return result;
	 }
	 public static void main(String[] args) {
		CoinCountWays coinCountWays=new CoinCountWays();
		System.out.println(coinCountWays.countWays1(111));
		System.out.println(coinCountWays.countWays2(111));
		for(int i=1;i<1000;i++){
			int a=coinCountWays.countWays1(i);
			int b=coinCountWays.countWays2(i);
			if(a!=b)
				System.out.println("error i:"+i+" a:"+a+" b: "+b);
		}
	}
}
