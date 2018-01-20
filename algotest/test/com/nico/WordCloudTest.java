package com.nico;

import java.util.Map;

import org.junit.Test;

public class WordCloudTest {

	@Test
	public void testGetCloud1() {
		String sentence = "After beating the eggs, Dana read the next step:\nAdd milk and eggs, then add flour and sugar. correct Correct";
		Map<String, Integer> cloud = new WordCloud(sentence).getCloud();
		System.out.println(cloud);

	}

}
