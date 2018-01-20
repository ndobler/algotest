package com.nico;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ParenthesisMatcherTest {

	@Test
	public void testMatch() {
		String str = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
		int r = ParenthesisMatcher.match(str, 5);
		assertTrue(r == 79);
	}

}
