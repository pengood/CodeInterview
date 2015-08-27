package com.leetcode.test;

import java.util.Stack;

/*
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c
 */

public class SimplifyPath {
	public String simplifyPath(String path) {
		if (path == null || path.equals(""))
			return null;
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < path.length(); i++) {
			if (path.charAt(i) == '/')
				continue;
			StringBuilder stringBuilder = new StringBuilder();
			while (i<path.length()&&path.charAt(i) != '/') {
				stringBuilder.append(path.charAt(i));
				i++;
			}
			if(stringBuilder.toString().equals("..")){
				if(!stack.isEmpty())
					stack.pop();
			}
				
			else if(stringBuilder.toString().equals("."))
				continue;
			else {
				stack.add(stringBuilder.toString());
			}
		}
		StringBuilder retBuilder = new StringBuilder();
		Stack<String> stack2 = new Stack<>();
		while (!stack.isEmpty()) {
			stack2.add(stack.pop());
		}
		retBuilder.append('/');
		while (!stack2.isEmpty()) {
			retBuilder.append(stack2.pop());
			retBuilder.append('/');
		}
		if (retBuilder.length() > 1)
			retBuilder.deleteCharAt(retBuilder.length() - 1);
		return retBuilder.toString();
	}

	public static void main(String[] args) {
		SimplifyPath path = new SimplifyPath();
		String pString = "/home/";
		String pString2 = "/a/./b/../../c/";
		String pString3="/home/foo/.ssh/../.ssh2/authorized_keys/";
		System.out.println(path.simplifyPath(pString3));
	}
}
