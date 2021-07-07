package aa224fb_assign2;

import java.util.Iterator;

public class TreeWordSet implements WordSet {
	
	private int size;
	private TreeNode root = null;

	@Override
	public Iterator<Word> iterator() {
		return new TreeIterator();
	}

	// Add word if not already added
	public void add(Word word) {
		if(root == null) {
			
			root = new TreeNode(root, word);
			
		} else if(!root.contains(word)) {
			
			root.add(word);
		} else {
			
			return;
		}
		size++;
	}

	// Return true if word contained
	public boolean contains(Word word) {
		return root.contains(word);
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
	
	//TreeNode class
	private class TreeNode {
		Word word;
		TreeNode left = null;
		TreeNode right = null;
		TreeNode parent = null;
		
		public TreeNode(TreeNode parent, Word word){
			this.word = word;
			this.parent = parent;
		}
		
		public void add(Word w) {
			//Add to left or right in tree
			if(w.compareTo(word) < 0) {
				if(left == null) {
					
					left = new TreeNode(this, w);
				} else {
					
					left.add(w);
				}
			}
			
			if(w.compareTo(word) > 0) {
				if(right == null) {
					
					right = new TreeNode(this, w);
				} else {
					right.add(w);
				}
			}
			
		}
		
		public boolean contains(Word w) {
			if(w.compareTo(word) < 0) {
				if( left== null) {
					
					return false;
				} else {
					
					return left.contains(w);
				}
			} else if(w.compareTo(word) > 0) {
				if(right == null) {
					
					return false;
				} else {
					
					return right.contains(w);
				}
			}
			return true;	
		}
	}
	
	//Iterator
	private class TreeIterator implements Iterator<Word> {
		
		TreeNode next;
		
		public TreeIterator() {
			next = root;
			
			if(next == null) {
				return;
			}
			
			// Go to the left
			while (next.left != null) {
				next = next.left;
			}
}
		
		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public Word next() {
			TreeNode node = next;
			
			//Go right if possible
			if(next.right != null) {
				
				next = next.right;
				
				//Go to the most left
				while (next.left != null) {
					
			    	   next = next.left;
			       }
				
				return node.word;
				
			} else while (true) {
				
				// If reaching root.
		    	 if(next.parent == null){
		    		 
		    		 next = null;
		    		 return node.word;
	    		 }
		    	 
		    	 // If next parents left is next.
		    	 if(next.parent.left == next){
		    		 
			         next = next.parent;
			         return node.word;
		    	 }
		    	 
		    	 next = next.parent;
			}
			
			
		} 
		
	}

}
