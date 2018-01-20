package com.nico;

import java.util.Set;
import java.util.TreeSet;

/**
 * Write a recursive function for generating all permutations of an input
 * string. Return them as a set. Don't worry about time or space complexity—if
 * we wanted efficiency we'd write an iterative version.
 * 
 * To start, assume every character in the input string is unique.
 * 
 * Your function can have loops—it just needs to also be recursive.
 * 
 * @author nico
 *
 */
public class RecursiveStringPermutations {

	public static void main(String[] args) {
		String myString = "12345";

		Set<String> permutations = permute(myString);
		System.out.println(permutations);
		System.out.println(permutations.size());
	}

	private static Set<String> permute(String myString) {
		Set<String> result = new TreeSet<>();
		// if (myString.length() == 0) {
		// return result;
		// } else
		if (myString.length() == 1) {
			return result;
		}
		for (int i = 0; i < myString.length(); i++) {
			String s = switchStr(myString, i);
			result.add(s);
			Set<String> maspeques = permute(s.substring(1));
			maspeques.forEach(p -> result.add(s.charAt(0) + p));
		}
		return result;
	}

	private static String switchStr(String myString, int i) {
		char[] a = myString.toCharArray();
		char t = a[i];
		a[i] = a[0];
		a[0] = t;
		return new String(a);
	}
}
