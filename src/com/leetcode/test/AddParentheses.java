package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class AddParentheses {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> ret = new ArrayList<>();
		if (input == null || input.equals(""))
			return ret;
		List<Integer> listnum = new ArrayList<Integer>();
		List<Character> listoperator = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				listoperator.add(c);
				continue;
			}
			int num = 0;
			while (i < input.length() && input.charAt(i) >= '0'
					&& input.charAt(i) <= '9') {
				num = num * 10 + (input.charAt(i) - '0');
				i++;
			}
			listnum.add(num);
			i--;
		}
		compute(ret, listnum, listoperator);
		return ret;
	}

	private void compute(List<Integer> re, List<Integer> num, List<Character> op) {
		if (num.size() == 1) {
			re.add(num.get(0));
			return;
		}
		for (int i = 1; i < num.size(); i++) {
			int oper = (2 * i - 1)>>1;
			char opertor = op.get(oper);
			List<Character> opList = new ArrayList<>(op);
			opList.remove(oper);
			List<Integer> numIntegers = new ArrayList<>(num);
			numIntegers.remove(i);
			int result = 0;
			switch (opertor) {
			case '+': {
				result = num.get(i - 1) + num.get(i);
				break;
			}
			case '-': {
				result = num.get(i - 1) - num.get(i);
				break;
			}
			case '*': {
				result = num.get(i - 1) * num.get(i);
				break;
			}
			}
			numIntegers.set(i - 1, result);
			compute(re, numIntegers, opList);
		}

	}

	public static void main(String[] args) {
		AddParentheses addParentheses = new AddParentheses();
		String iString = "2*3-4*5+3";
		System.out.println(addParentheses.diffWaysToCompute(iString));
	}
}
