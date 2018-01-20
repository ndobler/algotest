package com.nico;

public class ParenthesisMatcher {

	public static int match(String str, int index) {
		int parCount = 0;
		for (int i = index; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(')
				parCount++;
			else if (c == ')') {
				if (parCount == 0)
					return i;
				else
					parCount--;
			}
		}
		throw new IllegalArgumentException("Wrong parenthesis count");
	}

}
