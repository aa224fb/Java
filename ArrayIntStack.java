package aa224fb_assign2;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {

	/* Add integer at top of stack. */
	public void push(int n) {
		
		if(size() == values.length) {
			resize();
		}
		values[size++] = n;
	}

	/* Returns and removes integer at top of stack  */
	public int pop() throws IndexOutOfBoundsException {
		if(size == 0) { 
			throw new IndexOutOfBoundsException();
		}
		return values[--size];
	}

	/* Returns without removing integer at top of stack */
	public int peek() throws IndexOutOfBoundsException {
		if(size == 0) {
			throw new IndexOutOfBoundsException();
		}
			return values[size-1];
	}

}
