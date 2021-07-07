package aa224fb;

import graphs.DirectedGraph;
import graphs.GML;
import graphs.Node;
import java.util.Iterator;

public class MyGML<E> extends GML<E> {

	public MyGML(DirectedGraph<E> dg) {
		super(dg);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toGML() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("graph [ \n");
		
		//Nodes
		for(Node<E> node : graph ) {
			sb.append("node [ \n");
			sb.append("\t id: " + node + "\n");
			sb.append("\t label: " + node + "\n");
			sb.append("\t ] \n");	
		}
		
		//Edges
		for(Node<E> node : graph) {
			//Get target node
			for(Iterator<Node<E>> successor = node.succsOf(); successor.hasNext();) {
			Node<E> target = successor.next();
			
			sb.append("edge [ \n");
			sb.append("\t source: " + node + "\n");
			sb.append("\t target: " + target + "\n");
			sb.append("\t label: Edge from node " + node + " to node " + target + "\n" );
			sb.append("\t ] \n");
			
			}
			
		}
		
		sb.append("]");
		
		return sb.toString();
	}

}
