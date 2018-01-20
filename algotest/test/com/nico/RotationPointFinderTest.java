package com.nico;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class RotationPointFinderTest {

	@Test
	public void test1() {
		String[] words = new String[] { "ptolemaic", "retrograde", "supplant", "undulate", "xenoepist", "z",
				"asymptote", // <--
								// rotates
								// here!
				"babka", "banoffee", "engender", "karpatka", "othellolagkage", };
		int rp = RotationPointFinder.findRotationPoint(words, 0, words.length - 1);
		assertTrue(rp == 6);
	}

	@Test
	public void test2() {
		String[] words = new String[] { "ptolemaic", "retrograde", "supplant", "undulate", "xenoepist", "asymptote", // <--
																														// rotates
																														// here!
				"babka", "banoffee", "engender", "karpatka", "othellolagkage", };
		int rp = RotationPointFinder.findRotationPoint(words, 0, words.length - 1);
		assertTrue(rp == 5);
	}

	@Test
	public void test3() {
		String[] words = new String[] { "ptolemaic", "retrograde", "supplant", "undulate", "aaarsenal", // <-- rotate/
																										// here!
				"asymptote", "babka", "banoffee", "engender", "karpatka", "othellolagkage", };
		int rp = RotationPointFinder.findRotationPoint(words, 0, words.length - 1);
		assertTrue(rp == 4);
	}

	@Test
	public void test4() {
		String[] words = new String[] { "undulate", "aaarsenal", "asymptote", "babka", "banoffee", "engender",
				"karpatka", "othellolagkage", "ptolemaic", "retrograde", "supplant", };
		int rp = RotationPointFinder.findRotationPoint(words, 0, words.length - 1);
		assertTrue(rp == 1);
	}

	@Test
	public void test6() {
		String[] words = new String[] { "aaarsenal", "asymptote", "babka", "banoffee", "engender", "karpatka",
				"othellolagkage", "ptolemaic", "retrograde", "supplant", "undulate", "aaaaaaaaaaa" };
		int rp = RotationPointFinder.findRotationPoint(words, 0, words.length - 1);
		assertTrue(rp == 11);
	}

	@Test
	public void test7() {
		long time = System.currentTimeMillis();

		ArrayList<String> words = new ArrayList<>();
		char[] alfa = "abcdefghijklmnropqrstuvwxyz".toCharArray();
		for (int i = 0; i < alfa.length; i++) {
			System.out.println(alfa[i]);
			for (int j = 0; j < alfa.length; j++) {
				for (int k = 0; k < alfa.length; k++) {
					for (int l = 0; l < alfa.length; l++) {
						for (int m = 0; m < alfa.length; m++) {
							words.add("" + alfa[i] + alfa[j] + alfa[k] + alfa[l] + alfa[m]);
						}
					}
				}
			}
		}
		System.out.println("gen" + (System.currentTimeMillis() - time));
		time = System.currentTimeMillis();

		int pivot = (int) (Math.random() * 10000000L);
		String[] wordArray = new String[words.size()];
		int j = 0;
		for (int i = pivot; i < wordArray.length; i++) {
			wordArray[j++] = words.get(i);
		}
		for (int i = 0; i < pivot; i++) {
			wordArray[j++] = words.get(i);
		}

		System.out.println("length" + wordArray.length);
		System.out.println("prepare " + (System.currentTimeMillis() - time));
		time = System.currentTimeMillis();
		int rp = RotationPointFinder.findRotationPoint(wordArray, 0, words.size() - 1);
		System.out.println("Find " + (System.currentTimeMillis() - time));
		assertTrue(wordArray[rp].equals(words.get(0)));
	}

}
