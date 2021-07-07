package aa224fb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import graphs.DirectedGraph;
import graphs.Node;

public class MyGraph<E> implements DirectedGraph<E> {
	
	private Map<E, Node<E>> itemToNode;
	private Set<Node<E>> heads;
	private Set<Node<E>> tails;
	
	public MyGraph() {
		itemToNode = new HashMap<>();
		heads = new HashSet<>();
		tails = new HashSet<>();
	}

	@Override
	public Node<E> addNodeFor(E item) {
		if(item == null) {
			throw new RuntimeException("Input was null!");
		}
		
		//Get node from graph
		Node<E> node = itemToNode.get(item);
		
		//Add node to graph if not in it
		if(node == null) {
			node = new MyNode<E>(item);
			heads.add(node);
			tails.add(node);
			itemToNode.put(item, node);
			return node;
		}
		
		return node;
	}

	@Override
	public Node<E> getNodeFor(E item) {
		if(item == null) {
			throw new RuntimeException("Input was null!");
		}
		
		Node<E> node = itemToNode.get(item);
		if(node == null) {
			throw new RuntimeException("No node was found!");
		}
		
		return node;
	}

	@Override
	public boolean addEdgeFor(E from, E to) {
		if(from == null || to == null) {
			throw new RuntimeException("Input was null!");
		} 
		
		//Add nodes
		MyNode<E> src = (MyNode<E>) addNodeFor(from);
		MyNode<E> tgt = (MyNode<E>) addNodeFor(to);
		
		if(src.hasSucc(tgt)) { //Edge already exists
			return false;
		} else {
			
			src.addSucc(tgt);
			tgt.addPred(src);
			
			heads.remove(tgt);
			tails.remove(src);
			return true;
		}
	}

	@Override
	public boolean containsNodeFor(E item) {
		if(item == null) {
			throw new RuntimeException("Input was null!");
		}
		
		return itemToNode.containsKey(item);
	}

	@Override
	public int nodeCount() {
		return itemToNode.size();
	}

	@Override
	public Iterator<Node<E>> iterator() {
		return itemToNode.values().iterator();
	}

	@Override
	public Iterator<Node<E>> heads() {
		return heads.iterator();
	}

	@Override
	public int headCount() {
		return heads.size();
	}

	@Override
	public Iterator<Node<E>> tails() {
		return tails.iterator();
	}

	@Override
	public int tailCount() {
		return tails.size();
	}

	@Override
	public List<E> allItems() {
		return new LinkedList<E>(itemToNode.keySet());
	}

	@Override
	public int edgeCount() {
		int edges = 0;
		
		for(Node<E> node : itemToNode.values()) {
			
			edges += node.outDegree();
		}
		return edges;
	}

	@Override
	public void removeNodeFor(E item) {
		//Check input and then if node exists in graph
		if(item == null) {
			throw new RuntimeException("Input was null!");
		}
		
		MyNode<E> node = (MyNode<E>)itemToNode.get(item);
		if(node == null) {
			throw new RuntimeException("No node was found!");
		}
		
		for(Iterator<Node<E>> nodePre = node.predsOf(); nodePre.hasNext();) {
			MyNode<E> pred = (MyNode<E>) nodePre.next();
			pred.removeSucc(node);
			
			if(pred.isTail()) {
				tails.add(pred);
			}
			
			nodePre.remove();
		}
		
		for(Iterator<Node<E>> nodeSucc = node.succsOf(); nodeSucc.hasNext();) {
			MyNode<E> succ = (MyNode<E>) nodeSucc.next();
			succ.removePred(node);
			
			if(succ.isHead()) {
				heads.add(succ);
			}
			
			nodeSucc.remove();
		}
		
		node.disconnect();
		heads.remove(node);
		tails.remove(node);
		itemToNode.remove(item);	
	}

	@Override
	public boolean containsEdgeFor(E from, E to) {
		if(from == null || to == null) {
			throw new RuntimeException("Input was null!");
		}
		
		//Add nodes from graph
		Node<E> src = itemToNode.get(from);
		Node<E> tgt = itemToNode.get(to);
		
		//Return true if src exists and has tgt as successor
		if(src != null && src.hasSucc(tgt)) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean removeEdgeFor(E from, E to) {
		if(from == null || to == null) {
			throw new RuntimeException("Input was null!");
		}
		
		//Add nodes from graph
		MyNode<E> src = (MyNode<E>) itemToNode.get(from);
		MyNode<E> tgt = (MyNode<E>) itemToNode.get(to);
		
		if(src != null && src.hasSucc(tgt)) {
			//Remove successor and predecessor
			src.removeSucc(tgt);
			tgt.removePred(src);
			
			//Check if head or tail
			if(src.isTail()) {
				tails.add(src);
			}
			if(tgt.isHead()) {
				heads.add(tgt);
			}
			
			return true;
		}
		
		return false;
	}

}
