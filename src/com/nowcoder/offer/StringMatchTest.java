package com.nowcoder.offer;

/*
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * 
 * 思路：假设字符串为str，模式串为pattern，考虑以下情况：
 * A. 模式串下一个字符为*，即*(pattern+1)=='*'：如果当前字符匹配，即*str=*pattern或者*str='.' && *pattern!='\0'，
 * 三种可能： 
 * 1、模式串当前字符出现0次，即*表示当前字符出现0次，则str=str,pattern=pattern+2; 
 * 2、模式串当前字符出现1次，即*表示当前字符出现1次，则str=str+1,pattern=pattern+2; 
 * 3、模式串当前字符出现2次或2次以上，即*表示当前字符出现2次或以上，则str=str+1,pattern=pattern;
 * 如果当前字符不匹配，则只能让*表示当前字符出现0次，则str=str，pattern=pattern+2;
 * B. 模式串下一个字符不为*如果当前字符匹配，即*str=*pattern或者*str='.' && *pattern!='\0'，
 * 则str=str+1,pattern=pattern+
 * by Solaris_xy
 */
public class StringMatchTest {
	public boolean match(char[] str, char[] pattern) {
		return helpMatch(str, 0, pattern, 0);
	}

	private boolean helpMatch(char[] str, int i, char[] pattern, int j) {
		if (i == str.length && j == pattern.length)
			return true;
		if (j >= pattern.length )
			return false;
		if (j < pattern.length - 1) {
			if (pattern[j + 1] == '*') {
				if (i < str.length
						&& ('.' == pattern[j] || pattern[j] == str[i]))
					return helpMatch(str, i, pattern, j + 2)
							|| helpMatch(str, i + 1, pattern, j + 2)
							|| helpMatch(str, i + 1, pattern, j);
				else {
					return helpMatch(str, i, pattern, j + 2);
				}
			}
		}
		if (i == str.length)
			return false;
		if (str[i] == pattern[j] || pattern[j] == '.')
			return helpMatch(str, i + 1, pattern, j + 1);
		return false;
	}

	public static void main(String[] args) {
		char[] a = { 'a' };
		char[] b = { '.' };
		StringMatchTest test = new StringMatchTest();
		System.out.println(test.match(a, b));
	}
}
