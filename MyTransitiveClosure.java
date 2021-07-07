package aa224fb;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import graphs.DirectedGraph;
import graphs.Node;
import graphs.TransitiveClosure;

public class MyTransitiveClosure<E> implements TransitiveClosure<E> {
	
	private Map<Node<E>, Collection<Node<E>>> transitiveClosure = new HashMap<Node<E>, Collection<Node<E>>>();
	private List<Node<E>> visited = new LinkedList<Node<E>>();
	private List<Node<E>> reachable = new LinkedList<Node<E>>();
	private int depthNumber = 0;

	@Override
	public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
		//Clear map and lists
		transitiveClosure.clear();
		visited.clear();
		reachable.clear();
		
		//Loop through nodes in graph and compute transitive closure
		for(Node<E> node : dg) {
			
			visited = new LinkedList<Node<E>>();
			reachableNodes(node);
			transitiveClosure.put(node, visited);
		}
		
		return transitiveClosure;
	}
	
	private void reachableNodes(Node<E> node) {
		//Assign depthnumber to the node before adding it as visited.
		node.num = depthNumber++;
		visited.add(node);
		
		//Search for more unvisited successor to current node
		Iterator<Node<E>> iterator = node.succsOf();
		while(iterator.hasNext()) {
			
			Node<E> nextNode = iterator.next();
			if(!visited.contains(nextNode)) {
				
				reachableNodes(nextNode);
			}
			
		}
	}

}