package aa224fb_assign2;

import static org.junit.Assert.*;
import org.junit.Test;

import aa224fb_assign2.ArrayIntList;
import aa224fb_assign2.ArrayIntStack;

public class CollectionTest {
	
	//Test ArrayIntList
	
	@Test
	public void testAdd() {
		
		ArrayIntList list = new ArrayIntList();
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		//Check if correct number of elements are added to list
		assertEquals(10, list.size());	
	}
	
	@Test
	public void testAddAt() {
		ArrayIntList list = new ArrayIntList();
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		//Add and ensure that size is correct
		list.addAt(20, 2);
		assertEquals(11, list.size());
		
		//Try add at index not in list
		try {
			list.addAt(50, 20);
		}
		catch(IndexOutOfBoundsException e) {
			assertTrue("Index not in list", true);
		}
		
	}
	
	@Test
	public void testRemove() {
		ArrayIntList list = new ArrayIntList();
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		//Remove index 0 and check if size has changed
		list.remove(0);
		assertEquals(9, list.size());
		
		//Trying to remove index not in list
		try {
			list.remove(10);
		}
		catch(IndexOutOfBoundsException e) {
			assertTrue("Index does not exist in list", true);
		}
	}

	@Test
	public void testGet() {
		ArrayIntList list = new ArrayIntList();
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		//Get correct values in list
		for(int i = 0; i < list.size(); i++) {
			assertEquals(i, list.get(i));
		}
		
		//Try to get non existent value
		try {
			
			list.get(11);
		} 
		catch(IndexOutOfBoundsException e) {
			assertTrue("Index does not exist in list", true);
		}
		
	}
	
	@Test
	public void testIndexOf() {
		ArrayIntList list = new ArrayIntList();
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		//Get correct values in list
		for(int i = 0; i < list.size(); i++) {
			assertEquals(i, list.indexOf(i));
		}
		
		//Return -1 if value does not exist
		assertEquals(-1, list.indexOf(11));
	}
	
	//Test ArrayIntStack
	@Test
	public void testPush() {
		ArrayIntStack stack = new ArrayIntStack();
		for(int i = 0; i < 10; i++) {
			stack.push(i);
		}
		
		//Ensure that stack contains correct amount of elements
		assertEquals(10, stack.size());
	}
	
	@Test
	public void testPop() {
		ArrayIntStack stack = new ArrayIntStack();
		ArrayIntStack emptyStack = new ArrayIntStack();
		
		for(int i = 0; i < 10; i++) {
			stack.push(i);
		}
		
		//Test if value on top has been removed and returned (9)
		assertEquals(9, stack.pop());
		
		//Empty stack should throw exception
		try {
			emptyStack.pop();
		}
		catch(IndexOutOfBoundsException e) {
			assertTrue("Stack is empty", true);
		}
		
	}
	
	@Test
	public void testPushPeek() {
		ArrayIntStack stack = new ArrayIntStack();
		ArrayIntStack emptyStack = new ArrayIntStack();
		
		for(int i = 0; i < 10; i++) {
			stack.push(i);
		}
		
		//Test if the top value is returned (9)
		assertEquals(9, stack.peek());
		
		//Empty stack should throw exception
		try {
			emptyStack.peek();
		}
		catch(IndexOutOfBoundsException e) {
			assertTrue("Stack is empty", true);
		}
	}

}
