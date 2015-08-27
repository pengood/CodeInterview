package com.leetcode.test;

public class StringToInteger {
	 public static int myAtoi(String str) {
	       if (str == null) {
	            return 0;
	        }
	       
	        String s = str.trim();
	        
	        boolean minus = false;
	        long num = 0,pre=0;
	        for (int i = 0; i < s.length(); i++) {
	       
	            if (i == 0 && s.charAt(i) == '+') {
	                continue;
	            } else if (i == 0 && s.charAt(i) == '-'){
	                // get the 
	                minus = true;
	                continue;
	            }
	            
	            int c = s.charAt(i) - '0';
	            if (c > 9 || c < 0) {
	                // invalid character.
	                break;
	            }
	            num = num * 10 + c;
	            if(num<pre)
	            	return minus?Integer.MIN_VALUE:Integer.MAX_VALUE;
	            pre=num;
	        }
	        
	    
	        if (minus) {
	            num = -num;
	            num = Math.max(num, Integer.MIN_VALUE);
	        } else {
	            num = Math.min(num, Integer.MAX_VALUE);
	        }
	        
	        return (int)num;
	    }
	 
	 public static void main(String[] args){
		 String string="9223372036854775809";
		 System.out.println(Long.MAX_VALUE);
		 System.out.print(myAtoi(string));
	 }
}
