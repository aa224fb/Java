package aa224fb_assign2;

import java.util.Iterator;

public class Queue<E> implements QueueInterface<E> {
	private Node head;
	private Node tail;
	int size = 0;
	
	// current queue size 
	public int size() {
		return this.size;
	}     
	
	public Iterator<E> iterator() {
		return new ListIterator();
	}
	
	 // true if queue is empty 
    public boolean isEmpty() {
    	return size() == 0;
    }     
    
    // add element at end of queue 
    public void enqueue(E element) {
    	//If list is empty set head and tail to be the same node
    	//Else new node is tail
    	if(head == null) {
    		
    		head = new Node(element);
    		tail = head;
    	} else {
    		
    		tail.setNext(new Node(element));
    		tail = tail.getNext();
    	}
    	size++;
    }    
    
    // return and remove first element. 
    public E dequeue() {
    	//If list is not empty - set next node as head (unlink first object)
		if(head != null) {
			Node removed = head;
			
			//Get next node and make it head
			head = removed.getNext();
			
			size--;
			
			return removed.getObject();
			
		} else {
			
			throw new IndexOutOfBoundsException();
		}
    }
    
    // return (without removing) first element 
    public E first() {
    	if(head != null) {
    		return head.getObject();
    	} else {
    		
    		throw new IndexOutOfBoundsException();
    	}
    	
    } 
    
    // return (without removing) last element
    public E last() {
    	if(head != null) {
    		return tail.getObject();
    	} else {
    		
    		throw new IndexOutOfBoundsException();
    	}
    	
    } 
    
	//Node class
	public class Node {
		
		private E node;
		private Node next = null;
		
		public Node(E object) {
            this.node = object;
        }

		public E getObject(){
			return node;
		}
        
        public void setNext(Node nextNode) {
            this.next = nextNode;
        }
        
        public Node getNext() {
			return next;
        }
	}
	
	//Iterator class
	private class ListIterator implements Iterator<E> {
		private Node node = head;
	       
	    public boolean hasNext() {
	    	return node != null;
	    }
	        
	    public E next() {
	        	
	    	if(node != null) {
	    		
	    		E value = node.getObject();
	            node = node.getNext();
	            return value;
	         } else {
	        		
	        	 throw new IndexOutOfBoundsException();
	         }
	     }
	}	
}




