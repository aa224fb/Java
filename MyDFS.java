package aa224fb;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

public class MyDFS<E> implements DFS<E> {
	
	private Set<Node<E>> visited = new HashSet<Node<E>>();
	private List<Node<E>> nodeList = new LinkedList<Node<E>>();
	private int dfsNumber = 0;
	private int postOrderNumber = 0;
	
	public void dfs(Node<E> node) {
		//Increase dfs-number and add to list
		node.num = dfsNumber++;
		nodeList.add(node);
		visited.add(node);
		
		//Find successors of node
		Iterator<Node<E>> iterator = node.succsOf();
		while(iterator.hasNext()) {
			Node<E> successor = iterator.next();
			//Keep going through nodes that have not been visited
			if(!visited.contains(successor)) {
				
				dfs(successor);
			}
		}	
	}
	
	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
		//Empty lists
		nodeList.clear();
		visited.clear();
		
		dfs(root);
		
		return nodeList;
	}

	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph) {
		//Empty lists
		nodeList.clear();
		visited.clear();
		
		for(Node<E> node : graph) {
			
			if(!visited.contains(node)) {
				dfs(node);
			}
		}
		
		return nodeList;
	}
	
	public void postOrder(Node<E> node) {
		
		//Add to visited
		visited.add(node);
		
		Iterator<Node<E>> iterator = node.succsOf();

		while(iterator.hasNext()) {
			Node<E> successor = iterator.next();
			if(!visited.contains(successor)) {
				
				postOrder(successor);
			}
			
		}
		//Add postorder number to last node and add it to list
		node.num = postOrderNumber++;
		nodeList.add(node);
	}
	

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
		//Empty lists
		nodeList.clear();
		visited.clear();
				
		postOrder(root);
		
		return nodeList;
	}

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g) {
		//Empty lists
		nodeList.clear();
		visited.clear();
		
		for(Node<E> node : g) {
			
			if(!visited.contains(node)) {
				postOrder(node);
			}
		}
		
		return nodeList;
	}

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
		//Empty lists
		nodeList.clear();
		visited.clear();
		
		for(Node<E> node : g) {
			//Check if boolean is true
			if(attach_dfs_number == true) {
				node.num = dfsNumber++;
				postOrder(node);
			} else {
				postOrder(node);
			}
		}
		return nodeList;
	}

	@Override
	public boolean isCyclic(DirectedGraph<E> graph) {
		for(Node<E> node : postOrder(graph)) {
			//Iterate through successor nodes
			for(Iterator<Node<E>> iterator = node.succsOf(); iterator.hasNext();) {
				//source <= target = backward edge = cyclic
				if(node.num <= iterator.next().num) {
					return true; 
				}
			}	
		}
		return false;
	}

	@Override
	public List<Node<E>> topSort(DirectedGraph<E> graph) {
		
		//List to store nodes in graph in postorder
		List<Node<E>> topList = new LinkedList<Node<E>>();
		topList = postOrder(graph);
		
		//Reverse list with nodes in postorder
		Collections.reverse(topList);
		
		return topList;
	}

}
