package aa224fb;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import graphs.BFS;
import graphs.DirectedGraph;
import graphs.Node;

public class MyBFS<E> implements BFS<E> {

	private Set<Node<E>> visited = new HashSet<Node<E>>();
	private List<Node<E>> nodeList = new LinkedList<Node<E>>();
	private Queue<Node<E>> queue = new LinkedList<Node<E>>();
	private int brfNumber = 0;
	
	public void bfs(Node<E> node) {
		//Add to visited an queue
		visited.add(node);
		queue.add(node);
		
		while(queue.size() != 0) {
			//Remove head from queue - add it to nodeList
			Node<E> n = queue.remove();
			nodeList.add(n);
			
			//Assign BRF number
			n.num = brfNumber++;
			
			for(Iterator<Node<E>> iterator = n.succsOf(); iterator.hasNext();) {
				 Node<E> nextNode = iterator.next();
				 
				 //Check if node has been visited
				 if(!visited.contains(nextNode)) {
					 visited.add(nextNode);
					 queue.add(nextNode);
				 }
				
			}
			
		}
		
		
	}

	@Override
	public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
		//Empty lists
		nodeList.clear();
		visited.clear();
		queue.clear();
		
		//BFS starting from root
		bfs(root);
		
		return nodeList;
	}

	@Override
	public List<Node<E>> bfs(DirectedGraph<E> graph) {
		//Empty lists
		nodeList.clear();
		visited.clear();
		queue.clear();
		
		//BFS on unvisited nodes in graph
		for(Node<E> node : graph) {
			if(!visited.contains(node)) {
				bfs(node);
			}
		}
		return nodeList;
	}

}
