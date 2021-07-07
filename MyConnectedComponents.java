package aa224fb;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import graphs.ConnectedComponents;
import graphs.DirectedGraph;
import graphs.Node;

public class MyConnectedComponents<E> implements ConnectedComponents<E> {
	
	//Sets for collection of node collections, visited nodes and connected nodes
	private Set<Collection<Node<E>>> nodeCollections;
	private Set<Node<E>> visited;
	private Set<Node<E>> connectedNodes;

	@Override
	public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
		
		nodeCollections = new HashSet<Collection<Node<E>>>();
		visited = new HashSet<Node<E>>();
		connectedNodes = new HashSet<Node<E>>();
		
		for(Node<E> node : dg) {
			
			if(!visited.contains(node)) {
				
				nodeConnections(node);
			
			//Check the existing collections before adding the newly created set of connected nodes to it
			Iterator<Collection<Node<E>>> iterator = nodeCollections.iterator();
			while(iterator.hasNext()) {
				
				Collection<Node<E>> collection = iterator.next();
				if(!Collections.disjoint(collection, connectedNodes)) {
					
					collection.addAll(connectedNodes);
					connectedNodes = new HashSet<Node<E>>();
				}
			}
				
				if(!connectedNodes.isEmpty()) {
					
					nodeCollections.add(connectedNodes);
					connectedNodes = new HashSet<Node<E>>();
				}
			}
		}
		
		return nodeCollections;
	}
	
	private void nodeConnections(Node<E> node) {
		//Add node to set for visited and connected nodes
		visited.add(node);
		connectedNodes.add(node);
		
		//Check for unconnected successors and add as connected nodes
		Iterator<Node<E>> successors = node.succsOf();
		while(successors.hasNext()) {
			
			Node<E> nextNode = successors.next();
			if(!connectedNodes.contains(nextNode)) {
				
				nodeConnections(nextNode);
			}
			
			
		}
	}
}