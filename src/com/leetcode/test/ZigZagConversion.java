package com.leetcode.test;

public class ZigZagConversion {
public String convert(String s, int numRows) {
        if(numRows<=0)
        	throw new IllegalArgumentException();
        if(s==null||s.length()==1||numRows==1)
        	return s;
        StringBuilder[] stringBuilders=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
        	stringBuilders[i]=new StringBuilder();
        }
        int j=0;
        boolean up=false;
        for(int i=0;i<s.length();i++){
        	if(j==numRows){
        		up=true;
        		j-=2;
        	}else if(j<0){
				up=false;
				j+=2;
			}
        	stringBuilders[j].append(s.charAt(i));
        	if(up){
        		j--;
        	}
        	else {
				j++;
			}
        }
        for(int k=1;k<numRows;k++){
        	stringBuilders[0].append(stringBuilders[k].toString());
        }
        return stringBuilders[0].toString();
    }
public static void main(String[] args) {
	String string="PAYPALISHIRING";
	ZigZagConversion zagConversion=new ZigZagConversion();
	System.out.println(zagConversion.convert(string, 4));
}
}
