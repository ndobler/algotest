package com.nico.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class GraphNodeTest {

	@Test
	public void testColor() {

		GraphNode a = new GraphNode("a");
		GraphNode b = new GraphNode("b");
		GraphNode c = new GraphNode("c");
		GraphNode d = new GraphNode("d");
		GraphNode e = new GraphNode("e");

		a.addNeighbor(b);
		b.addNeighbor(c);
		c.addNeighbor(d);
		d.addNeighbor(e);
		d.addNeighbor(a);
		b.addNeighbor(e);

		List<GraphNode> graph = new ArrayList<>();
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		graph.add(e);

		Integer graphDegree = graph.stream().mapToInt(GraphNode::getDegree).max().getAsInt();
		List<String> colores = Arrays.asList(Arrays.copyOfRange(
				new String[] { "rojo", "azul", "verde", "amarillo", "gris", "blanco", "negro" }, 0, graphDegree + 1));
		System.out.println("Degree is " + graphDegree + ". Color list: " + colores);
		int attempt = 0;
		for (GraphNode graphNode : graph) {
			System.out.println("Attempt " + ++attempt);
			boolean valid = graphNode.color(colores);
			boolean validCheck = graph.stream().map(GraphNode::checkColor).allMatch(n -> n);
			System.out.println(String.format("Attempt %s result %s %s:\n%s", attempt, valid, validCheck,
					graph.stream().map(GraphNode::toString).collect(Collectors.joining("\n"))));
			if (validCheck) {
				break;
			}
			graph.stream().forEach(GraphNode::resetColor);
		}

	}

}
