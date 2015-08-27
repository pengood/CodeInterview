package com.nowcoder.offer;

public class ReplaceSpace {
public String replaceSpace(StringBuffer str) {
    	if(str==null||str.length()==0)
    		return str.toString();
    	StringBuilder builder=new StringBuilder();
    	for(int i=0;i<str.length();i++){
    		if(str.charAt(i)==' ')
    			builder.append("%20");
    		else {
				builder.append(str.charAt(i));
			}
    	}
    	return builder.toString();
    }
public static void main(String[] args) {
	ReplaceSpace pReplaceSpace=new ReplaceSpace();
	System.out.println(pReplaceSpace.replaceSpace(new StringBuffer("we are happy")));
}
}
