package Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sait.parser.contracts.EmptyQueueException;
import sait.parser.contracts.ListADT;
import sait.parser.contracts.QueueADT;
import sait.parser.utility.MyDLL;
import sait.parser.utility.MyQueue;


/**
 * 
 */

/**
 * @author Sheng Ming Yan, Chaoling Lu, Mengdan Liu
 * @param <E>
 *
 */
class MyQueueTest<E> {
	
	/**
	 * Contains the myqueue that is manipulated in each test.
	 */
	private MyQueue<E> myqueue;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// Create concrete myqueue class and assign to to MyQueue.
		this.myqueue = new MyQueue<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		this.myqueue.dequeueAll();
	}

	/**
	 * Test the myqueue is empty.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(this.myqueue.isEmpty());
		assertEquals(0, this.myqueue.size());
	}
	
	/**
	 * Test the myqueue is not empty and its size
	 */
	@Test
	void testIsNotEmpty() {
		this.myqueue.enqueue((E) "a");
		this.myqueue.enqueue((E) "b");
		this.myqueue.enqueue((E) "c");
		this.myqueue.enqueue((E) "d");
		assertFalse(this.myqueue.isEmpty());
		assertTrue(this.myqueue.size()!=0);
		assertEquals(4,this.myqueue.size());
	}
	
	/**
	 * Tests to enqueue elements to the myqueue.
	 */
	@Test
	void testEnqueue() {
		this.myqueue.enqueue((E) "a");
		this.myqueue.enqueue((E) "b");
		this.myqueue.enqueue((E) "c");
		this.myqueue.enqueue((E) "d");
		
		/**
		 * myqueue should now be:
		 * 
		 * a, b, c, d
		 */
		
		// Test the myqueue is not empty.
		assertFalse(this.myqueue.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.myqueue.size());
		
		// test the try-throw in MyQueue methods 
		try {	
			// Test the first value is a
			assertEquals("a", this.myqueue.peek());

			this.myqueue.dequeue();
			// Test the second value is b
			assertEquals("b", this.myqueue.peek());
			this.myqueue.dequeue();
			// Test the third value is c
			assertEquals("c", this.myqueue.peek());
			this.myqueue.dequeue();
			// Test the fourth value is d
			assertEquals("d", this.myqueue.peek());
		}catch(EmptyQueueException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Tests to dequeue elements with index to the myqueue.
	 */
	@Test
	void testDequeue() {
		this.myqueue.enqueue((E) "a");
		this.myqueue.enqueue((E) "b");
		this.myqueue.enqueue((E) "c");
		this.myqueue.enqueue((E) "d");
		
		/**
		 * myqueue should now be:
		 * 
		 * b, c, d, a
		 */
		
		// Test the myqueue is not empty.
		assertFalse(this.myqueue.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.myqueue.size());
		
		// test the try-throw in MyQueue methods 
		try {	
			// Test the first value is a
			assertEquals("a", this.myqueue.peek());

			this.myqueue.dequeue();
			// Test the second value is b
			assertEquals("b", this.myqueue.peek());
			this.myqueue.dequeue();
			// Test the third value is c
			assertEquals("c", this.myqueue.peek());
			this.myqueue.dequeue();
			// Test the fourth value is d
			assertEquals("d", this.myqueue.peek());
		}catch(EmptyQueueException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Tests to dequeueAll elements to the myqueue.
	 */
	@Test
	void testDequeueAll() {
		this.myqueue.enqueue((E) "a");
		this.myqueue.enqueue((E) "b");
		this.myqueue.enqueue((E) "c");
		this.myqueue.enqueue((E) "d");
		
		/**
		 * myqueue should now be:
		 * 
		 * a, b, c, d
		 */
		
		this.myqueue.dequeueAll();
		
		// Test the myqueue is not empty.
		assertTrue(this.myqueue.isEmpty());
		
		// Test the size is 0
		assertEquals(0, this.myqueue.size());
		
		
	}
	
	
	/**
	 * Tests if it is full of element of a queue.
	 */
	@Test
	void testIsFull() {
		MyQueue<E> fullQueue = new MyQueue<>(4);
		
		fullQueue.enqueue((E) "a");
		fullQueue.enqueue((E) "b");
		fullQueue.enqueue((E) "c");
		fullQueue.enqueue((E) "d");
		
		// Test the myqueue is not empty.
		assertFalse(fullQueue.isEmpty());
		
		// Test the size is 4
		assertEquals(4, fullQueue.size());
		
		// Test if it is full
		assertTrue(fullQueue.isFull());
		
	}
	
	/**
	 * Tests equalization for two queues.
	 */
	@Test
	void testEqual() {
		this.myqueue.enqueue((E) "a");
		this.myqueue.enqueue((E) "b");
		this.myqueue.enqueue((E) "c");
		this.myqueue.enqueue((E) "d");
		
		/**
		 * myqueue should now be:
		 * 
		 * a, b, c, d
		 */
		
		MyQueue<E> myqueue2 = new MyQueue<>();
		
		myqueue2.enqueue((E) "a");
		myqueue2.enqueue((E) "b");
		myqueue2.enqueue((E) "c");
		myqueue2.enqueue((E) "d");
		
		/**
		 * myqueue2 should now be:
		 * 
		 * a, b, c, d
		 */
		
		// Test both size
		assertTrue(myqueue.size()==myqueue2.size());
		
		// Test equal
		assertTrue(myqueue.equals(myqueue2));
		
		
		MyQueue<E> myqueue3 = new MyQueue<>();
		
		myqueue3.enqueue((E) "aa");
		myqueue3.enqueue((E) "bb");
		myqueue3.enqueue((E) "cc");
		myqueue3.enqueue((E) "dd");
		
		/**
		 * myqueue3 should now be:
		 * 
		 * aa, bb, cc, dd
		 */
		
		// Test both size
		assertTrue(myqueue.size()==myqueue3.size());
		// Test not equal
		assertFalse(myqueue.equals(myqueue3));
		
		
		MyQueue<E> myqueue4 = new MyQueue<>();
		
		myqueue4.enqueue((E) "a");
		myqueue4.enqueue((E) "b");
		myqueue4.enqueue((E) "c");
		
		/**
		 * myqueue4 should now be:
		 * 
		 * a, b, c
		 */
		// Test both size
		assertFalse(myqueue.size()==myqueue4.size());
		// Test not equal
		assertFalse(myqueue.equals(myqueue4));
		
	}
	
	
	/**
	 * Tests to Peek the top elements from myqueue.
	 */
	@Test
	void testPeek() {
		this.myqueue.enqueue((E) "a");
		this.myqueue.enqueue((E) "b");
		
		/**
		 * myqueue should now be:
		 * 
		 * a, b
		 */
		
		// Test the myqueue is not empty.
		assertFalse(this.myqueue.isEmpty());
		
		// Test the size is 2
		assertEquals(2, this.myqueue.size());
		
		// test the try-throw in MyQueue methods 
		try {	
			// Test the first value is a
			assertEquals("a", this.myqueue.peek());
		}catch(EmptyQueueException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
	
	/**
	 * Tests to toArray(E[] toHold).
	 */
	@Test
	void testToArray() {
		this.myqueue.enqueue((E) "a");
		this.myqueue.enqueue((E) "b");
		this.myqueue.enqueue((E) "c");
		this.myqueue.enqueue((E) "d");
		
		/**
		 * myqueue should now be:
		 * 
		 * a, b, c, d
		 */
		
		String[] elements = new String[4];
		
		
		myqueue.toArray((E[])elements);
		
		/**
		 * Now E[] should now be:
		 * 
		 * a, b, c, d
		 */
		
		// Test the myqueue is not empty.
		assertFalse(this.myqueue.isEmpty());
		
		// Test the size is 8
		assertEquals(4, elements.length);

		// Test the forth value is a
		assertEquals("a", elements[0]);

		// Test the fifth value is b
		assertEquals("b", elements[1]);
		
		// Test the sixth value is c
		assertEquals("c", elements[2]);
		
		// Test the seventh value is d
		assertEquals("d", elements[3]);
		
		// test the try-throw in Mymyqueue methods 
		try {			
			assertNull(elements[-1]);
			assertNull(elements[8]);
		}catch(IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}catch(NullPointerException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Tests to toArray().
	 */
	@Test
	void testObjectToArray() {		
		this.myqueue.enqueue((E) "a");
		this.myqueue.enqueue((E) "b");
		this.myqueue.enqueue((E) "c");
		this.myqueue.enqueue((E) "d");
		
		/**
		 * myqueue should now be:
		 * 
		 * a, b, c, d
		 */
		
		Object[] array = (Object[]) this.myqueue.toArray();
		
		/**
		 * Now array should now be:
		 * 
		 * a, b, c, d
		 */
		
		// Test the arrayList is not empty.
		assertFalse(array.length==0);
		
		// Test the size is 4
		assertEquals(4, array.length);

		// Test the first value is a
		assertEquals("a", array[0]);

		// Test the second value is b
		assertEquals("b", array[1]);
		
		// Test the third value is c
		assertEquals("c", array[2]);
		
		// Test the forth value is d
		assertEquals("d", array[3]);
		
		// test the try-throw in MyArrayList methods 
		try {			
			assertNull(array[-1]);
			assertNull(array[5]);
		}catch(IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}catch(NullPointerException ex) {
			ex.printStackTrace();
		}
		
	}
	
	/**
	 * Tests Iterator.
	 */
	@Test
	void testIterator() {
		
		
	}
	
	
	
	
	
	
	
}
