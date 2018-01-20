package com.nico;

public class RotationPointFinder {

	public static int findRotationPoint(String[] words, int begin, int end) {
		return findRotationPoint(words, begin, end, 0);
	}

	private static int findRotationPoint(String[] words, int begin, int end, int iteration) {
		if (end - begin == 1) {
			System.out.println(iteration);
			return end;
		}
		int pivot = (end - begin) / 2 + begin;
		int compare = words[begin].compareTo(words[pivot]);
		if (compare > 0)
			return findRotationPoint(words, begin, pivot, ++iteration);
		else
			return findRotationPoint(words, pivot, end, ++iteration);

	}

}
