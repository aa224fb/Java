package aa224fb_assign2;

import static org.junit.Assert.*;
import org.junit.Test;

public class QueueTest {
	
	@Test
	public void testEnqueue() {
		
		Queue<Integer> queue = new Queue<>();
		for(int i = 0; i < 100000; i++ ) {
			queue.enqueue(i);
		}
		
		//Test that expected number of elements exists in queue (100 000)
		assertEquals(100000, queue.size());
		
	}
	
	@Test
	public void testSize() {
		Queue<Integer> smallQ = new Queue<>();
		Queue<Integer> queue = new Queue<>();
		for(int i = 0; i < 100000; i++ ) {
			queue.enqueue(i);
		}
		
		//Test if sizes are 0 and 100000
		assertEquals(0, smallQ.size());
		assertEquals(100000, queue.size());
	}
	
	@Test
	public void testIsEmpty() {
		Queue<Integer> smallQ = new Queue<>();
		Queue<Integer> queue = new Queue<>();
		for(int i = 0; i < 100000; i++ ) {
			queue.enqueue(i);
		}
		
		//Ensure that one queue is empty and the other is not
		assertTrue(smallQ.isEmpty());
		assertTrue(!queue.isEmpty());
	}
	
	@Test
	public void testDequeue() {
		Queue<Integer> queue = new Queue<>();
		for(int i = 0; i < 100000; i++ ) {
			queue.enqueue(i);
		}
		
		//Ensure that first object is removed and returned
		assertTrue( queue.dequeue() == 0);
		assertEquals(99999, queue.size());
		
		//Dequeue whole queue
		for(int i = 0; i < 99999; i++) {
			queue.dequeue();
		}
		
		//Ensure queue is empty
		assertEquals(0, queue.size());
		
		//Try to dequeue an empty queue
		try {
			queue.dequeue();
		}
		catch(IndexOutOfBoundsException e) {
			assertTrue("Can't dequeue empty queue", true);
		}
		
	}
	
	@Test
	public void testFirst() {
		Queue<Integer> smallQ = new Queue<>();
		Queue<Integer> queue = new Queue<>();
		for(int i = 1; i < 11; i++ ) {
			queue.enqueue(i);
		}
		
		//Ensure that first element (1) is returned
		assertTrue(queue.first() == 1);
		
		//Try to get first element in empty queue
		try {
			smallQ.first();
		}
		catch(IndexOutOfBoundsException e) {
			
			assertTrue(true);
		}
		
	}
	
	@Test
	public void testLast() {
		Queue<Integer> smallQ = new Queue<>();
		Queue<Integer> queue = new Queue<>();
		for(int i = 1; i < 11; i++ ) {
			queue.enqueue(i);
		}
		
		//Ensure that last element (10) is returned
		assertTrue(queue.last() == 10);
		
		//Try to get last element in empty queue
		try {
			smallQ.last();
		}
		catch(IndexOutOfBoundsException e) {
			
			assertTrue(true);
		}
	}

}
