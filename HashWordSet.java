package aa224fb_assign2;

import java.util.Iterator;

public class HashWordSet implements WordSet {
	
	private int size;
	private Node[] buckets = new Node[128];

	@Override
	public Iterator<Word> iterator() {
		return new wordIterator();
	}

	@Override
	public void add(Word word) {
		int pos = getBucketNumber(word); 
		Node node = buckets[pos]; // First node in list
		
		while (node != null) { 
			if (node.w.equals(word)) {
				
				return; // Element found! 
			} else {
				
				node = node.next; // Next node in list 
			}
		} 
		node = new Node(word); // Not found, add new node as ﬁrst entry 
		node.next = buckets[pos]; 
		buckets[pos] = node; 
		size++; 
		
		if (size == buckets.length) {
			rehash(); // Rehash if needed
		}
	}
	
	private int getBucketNumber(Word word) {
		int hc = word.hashCode(); // Use hashCode() from String class
		
		if (hc < 0){
			hc = -hc; // Make sure non−negative
		}
		return hc % buckets.length; // Simple hash function
	}
	
	private void rehash() {
		Node[] temp = buckets; // Reference to old buckets
		buckets = new Node[2*temp.length]; // New empty buckets
		size = 0;
		
		for (Node n : temp) { // Insert old values into new buckets
			if (n == null) {
				continue; // Empty bucket
			}
			while (n != null) {
					
			add(n.w ); // Add elements again
			n = n.next;
			}	
		}
	}

	@Override
	public boolean contains(Word word) {
		int pos = getBucketNumber(word);
		Node node = buckets[pos];
		
		while(node != null) {
			if(node.w == word) {
				return true; //Found!
			} else {
				node = node.next;
			}
		}
		return false;
	}

	// Return current set size
	public int size() {
		return size;
	}
	
	// Print contained words
	public String toString() {
		String wordString = "";
		return wordString;
	}
	
	//Node class
	private class Node {
		Word w;
		Node next = null;
		
		public Node(Word word) {
			this.w = word;
		}	
	}
	
	//Iterator
	private class wordIterator implements Iterator<Word> {
		private Node node;
		private int index = 0;
		
		public wordIterator() {
        	for(int i = 0; i < buckets.length; i++) {
        		if(buckets[i] != null) {
        			node = buckets[i];
        			index = i;
        		}
        	}
		}

		@Override
		public boolean hasNext() {
			 return node != null;
		}

		@Override
		public Word next() {
			Node nextNode = node;
        	
        	if(node.next != null){
        		node = node.next;
        	}
        	else {
        		index++;
        		while(buckets[index] == null && index < size) {
        			index++;
        		}
        		
        		node = buckets[index];
			}
        	return nextNode.w;
			}
		}
	}
	

