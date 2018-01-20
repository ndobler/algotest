package com.nico;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ShortesRouteTest {

	private ShortesRoute sr;

	@Before
	public void setUp() {
		Map<String, String[]> network = new HashMap<>();
		network.put("Min", new String[] { "William", "Jayden", "Omar" });
		network.put("William", new String[] { "Min", "Noam" });
		network.put("Jayden", new String[] { "Min", "Amelia", "Ren", "Noam" });
		network.put("Ren", new String[] { "Jayden", "Omar" });
		network.put("Amelia", new String[] { "Jayden", "Adam", "Miguel" });
		network.put("Adam", new String[] { "Amelia", "Miguel", "Sofia", "Lucas" });
		network.put("Miguel", new String[] { "Amelia", "Adam", "Liam", "Nathan" });
		network.put("Nico", new String[] { "Ele" });
		network.put("Ele", new String[] { "Celi" });
		network.put("Celi", new String[] { "Angelines" });

		this.sr = new ShortesRoute(network);

	}

	@Test
	public void testR1() {

		List<String> route = sr.shortestRoute("Jayden", "Adam");
		System.out.println(route);
	}

	@Test
	public void testR2() {

		List<String> route = sr.shortestRoute("Jayden", "Nathan");
		System.out.println(route);
	}

	@Test
	public void test31() {

		List<String> route = sr.shortestRoute("Jayden1", "Nathan");
		System.out.println(route);
	}

	@Test
	public void testR4() {

		List<String> route = sr.shortestRoute("Jayden", "Nathan1");
		System.out.println(route);
	}

	@Test
	public void testR5() {

		List<String> route = sr.shortestRoute("Jayden", "Jayden");
		System.out.println(route);
	}

	@Test
	public void testR6() {

		List<String> route = sr.shortestRoute("Jayden", "Omar");
		System.out.println(route);
	}

	@Test
	public void testR7() {

		List<String> route = sr.shortestRoute("Nico", "Jayden");
		System.out.println(route);
	}

}
