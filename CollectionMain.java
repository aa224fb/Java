package aa224fb_assign2;

public class CollectionMain {

	public static void main(String[] args) {
		
		ArrayIntList list = new ArrayIntList(); 
		ArrayIntStack stack = new ArrayIntStack();
		
		//Add to list and stack
		for(int i = 1; i <= 5 ; i++) {
			list.add(i);
			stack.push(i);	
		}
		
		//Intlist 
		System.out.println("Elements in Intlist: " + list.toString());
		System.out.println("Element at index 3 in list: " + list.get(3) );
		list.addAt(50, 3);
		System.out.println("List after 50 has been added at index 3: " + list.toString());
		System.out.println("Index of 3: " + list.indexOf(3));
		System.out.println("Index of 8: " + list.indexOf(8));
		list.remove(4);
		list.remove(3);
		System.out.println("Elements after removal: " + list.toString());
		
		//Intstack
		System.out.println("Elements in Intstack: " + stack.toString());
		stack.push(30);
		stack.push(20);
		System.out.println("Stack after push: " + stack.toString());
		System.out.println("Latest addition to stack: " + stack.peek());
		stack.pop();
		System.out.println("Stack after pop: " + stack.toString());

	}

}
