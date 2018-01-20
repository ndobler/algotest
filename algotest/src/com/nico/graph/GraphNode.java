package com.nico.graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

@MyAnnotation
public class GraphNode {

	private String label;
	private Set<GraphNode> neighbors;
	private Optional<String> color;

	public GraphNode(String label) {
		this.label = label;
		neighbors = new HashSet<GraphNode>();
		color = Optional.empty();
	}

	public String getLabel() {
		return label;
	}

	public Set<GraphNode> getNeighbors() {
		return Collections.unmodifiableSet(neighbors);
	}

	public void addNeighbor(GraphNode neighbor) {
		neighbors.add(neighbor);
		neighbor.neighbors.add(this);
	}

	public boolean hasColor() {
		return color.isPresent();
	}

	public String getColor() {
		return color.get();
	}

	public void setColor(String color) {
		this.color = Optional.ofNullable(color);
	}

	public void resetColor() {
		this.color = Optional.empty();
	}

	@Override
	public String toString() {
		return String.format("%s (%s) [%s]", label, color,
				neighbors.stream().map(n -> n.label).collect(Collectors.joining(",")));
	}

	public int getDegree() {
		return this.neighbors.size();
	}

	public boolean color(List<String> colors) {
		return color(0, colors);
	}

	/**
	 * O(n) ? Recorre en total nodos x aristas
	 * 
	 * @param minColor
	 * @param colors
	 * @return
	 */
	private boolean color(int minColor, List<String> colors) {
		if (this.hasColor())
			return true;
		// O(n) (la parte de buscar en el string la puedo hacer como antes con int
		// directamente. Recorre aristas
		OptionalInt maxNeighbourColor = neighbors.stream().filter(GraphNode::hasColor)
				.mapToInt(c -> colors.indexOf(c.getColor())).max();
		if (maxNeighbourColor.isPresent()) {
			int nextColor = Math.max(minColor, 1 + maxNeighbourColor.getAsInt());
			if (nextColor >= colors.size())
				return false;
			else
				setColor(colors.get(nextColor));
		} else {
			setColor(colors.get(minColor));
		}
		boolean valid = true;
		// O(n) ?
		valid = neighbors.stream().map(node -> node.color(colors.indexOf(this.getColor()) + 1, colors))
				.allMatch(res -> res);
		return valid;
	}

	public boolean checkColor() {
		if (hasColor()) {
			boolean stillValid = neighbors.stream().filter(GraphNode::hasColor)
					.noneMatch(n -> n.getColor().equals(this.getColor()));
			return stillValid;
		} else
			return false;
	}
}
