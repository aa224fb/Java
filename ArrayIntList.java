package aa224fb_assign2;

public class ArrayIntList extends AbstractIntCollection implements IntList {

	/* Add integer n to the end of the list. */
	public void add(int n) {
		
		if(size() == values.length) {
			resize();
		}
		
		values[size()] = n;
		size++; 
	}

	/* Inserts integer n at position index. Shifts the element currently at that 
	 * position (if any) and any subsequent elements to the right.  */
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
			if(!checkIndex(index, size())) {
			
				throw new IndexOutOfBoundsException();
			}
			
			int temp;
			int shifted = values[index]; 
			values[index] = n;
			
			for(int i = 3; i < size(); i++){
				
				if(size() > index){
					resize();
				}
				
				temp = values[i+1];
				values[i+1] = shifted;
				shifted = temp;	
			}
			
			size++; 	
	}

	/* Remove integer at position index. */
	public void remove(int index) throws IndexOutOfBoundsException {
		if(!checkIndex(index, size())){
			
			throw new IndexOutOfBoundsException();
		}
			
		for (int i = index; i < size(); i++){
			values[i] = values[i+1];			
		}
		
		size--;
	}

	/* Get integer at position index. */
	public int get(int index) throws IndexOutOfBoundsException {
		if(!checkIndex(index, size())){
			throw new IndexOutOfBoundsException();
		}
		return values[index];
	}

	/* Find position of integer n, otherwise return -1 */
	public int indexOf(int n) {
		for(int i = 0; i < size; i++) {
			if(n == values[i]) {
				return i;
			}
		}
		return -1;
	}

}
