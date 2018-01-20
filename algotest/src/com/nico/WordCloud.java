package com.nico;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WordCloud {

	private Map<String, Integer> cloud = new HashMap<>();

	public Map<String, Integer> getCloud() {
		return Collections.unmodifiableMap(cloud);
	}

	public WordCloud(String sentence) {
		int beginWordIndex = 0;
		int endWordIndex = 0;
		boolean inWord = false;
		for (int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			if (!inWord) {
				if (Character.isAlphabetic(c)) {
					inWord = true;
					beginWordIndex = i;
				} else
					continue;
			} else {
				if (Character.isAlphabetic(c)) {
					endWordIndex = i;
					continue;
				} else {
					String word = sentence.substring(beginWordIndex, endWordIndex + 1);
					addToCloud(word);
					inWord = false;
				}

			}
		}
		if (inWord) {
			String word = sentence.substring(beginWordIndex, endWordIndex + 1);
			addToCloud(word);
			inWord = false;
		}
	}

	private void addToCloud(String word) {
		if (cloud.containsKey(word)) {
			cloud.put(word, cloud.get(word) + 1);
		} else {
			if (Character.isUpperCase(word.charAt(0))) {
				if (cloud.containsKey(word.toLowerCase())) {
					cloud.put(word.toLowerCase(), cloud.get(word.toLowerCase()) + 1);
				} else {
					cloud.put(word, 1);
				}
			} else {
				// word es lowecase
				String wordCapital = Character.toUpperCase(word.charAt(0)) + word.substring(1, word.length());
				if (cloud.containsKey(wordCapital)) {
					cloud.put(word, cloud.get(wordCapital) + 1);
					cloud.remove(wordCapital);
				} else {
					cloud.put(word, 1);
				}
			}
		}
	}

}
