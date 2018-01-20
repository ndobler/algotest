package com.nico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You wrote a trendy new messaging app, MeshMessage, to get around flaky cell
 * phone coverage. Instead of routing texts through cell towers, your app sends
 * messages via the phones of nearby users, passing each message along from one
 * phone to the next until it reaches the intended recipient. (Don't worry—the
 * messages are encrypted while they're in transit.)
 * 
 * Some friends have been using your service, and they're complaining that it
 * takes a long time for messages to get delivered. After some preliminary
 * debugging, you suspect messages might not be taking the most direct route
 * from the sender to the recipient.
 * 
 * Given information about active users on the network, find the shortest route
 * for a message from one user (the sender) to another (the recipient). Return
 * an array of users that make up this route.
 * 
 * There might be a few shortest delivery routes, all with the same length. For
 * now, let's just return any shortest route.
 * 
 * Your network information takes the form of a hash map mapping username
 * strings to an array of other users nearby:
 * 
 * Map<String, String[]> network = new HashMap<String, String[]>() {{ put("Min",
 * new String[] { "William", "Jayden", "Omar" }); put("William", new String[] {
 * "Min", "Noam" }); put("Jayden", new String[] { "Min", "Amelia", "Ren", "Noam"
 * }); put("Ren", new String[] { "Jayden", "Omar" }); put("Amelia", new String[]
 * { "Jayden", "Adam", "Miguel" }); put("Adam", new String[] { "Amelia",
 * "Miguel", "Sofia", "Lucas" }); put("Miguel", new String[] { "Amelia", "Adam",
 * "Liam", "Nathan" }); ... }};
 * 
 * For the network above, a message from Jayden to Adam should have this route:
 * 
 * { "Jayden", "Amelia", "Adam" }
 * 
 * @author nico
 *
 */
public class ShortesRoute {

	private Map<String, String[]> network = new HashMap<>();

	public ShortesRoute(Map<String, String[]> network) {
		this.network = network;
	}

	public List<String> shortestRoute(String src, String dst) {
		return shortestRoute(src, dst, new ArrayList<>());
	}

	private List<String> shortestRoute(String src, String dst, List<String> visited) {
		if (src.equals(dst)) {
			List<String> result = new ArrayList<>();
			result.add(src);
			return result;
		}
		String[] paths = network.get(src);
		if (paths != null) {
			// SortedSet<List<String>> routes = new TreeSet<>(new SizeArrayComp());
			List<String> bestRoute = null;
			for (String curNod : paths) {
				List<String> newVisited = new ArrayList<>(visited);
				if (newVisited.contains(curNod))
					continue;
				else
					newVisited.add(curNod);
				List<String> cr = shortestRoute(curNod, dst, newVisited);
				if (cr == null)
					continue;
				cr.add(0, src);
				if (bestRoute == null || cr.size() < bestRoute.size())
					bestRoute = cr;
			}
			return bestRoute;
		} else
			return null;
	}
}
