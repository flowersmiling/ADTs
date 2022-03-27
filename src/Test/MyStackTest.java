package Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sait.parser.utility.MyStack;


/**
 * 
 */

/**
 * @author Sheng Ming Yan, Chaoling Lu, Mengdan Liu
 * @param <E>
 *
 */
class MyStackTest<E> {
	
	private E[] e;
	
	/**
	 * Contains the mystack that is manipulated in each test.
	 */
	private MyStack<E> mystack;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// Create concrete mystack class and assign to to mystack.
		this.mystack = new MyStack<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		this.mystack.clear();
	}

	/**
	 * Test the mystack is empty.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(this.mystack.isEmpty());
		assertEquals(0, this.mystack.size());
	}
	
	/**
	 * Test the mystack is not empty and its size
	 */
	@Test
	void testIsNotEmpty() {
		this.mystack.push((E) "a");
		this.mystack.push((E) "b");
		this.mystack.push((E) "c");
		this.mystack.push((E) "d");
		assertFalse(this.mystack.isEmpty());
		assertTrue(this.mystack.size()!=0);
		assertEquals(4,this.mystack.size());
	}
	
	/**
	 * Tests to push elements to the mystack.
	 */
	@Test
	void testPush() {
		this.mystack.push((E) "a");
		this.mystack.push((E) "b");
		this.mystack.push((E) "c");
		this.mystack.push((E) "d");
		
		/**
		 * mystack should now be:
		 * 
		 * a, b, c, d
		 */
		
		// Test the mystack is not empty.
		assertFalse(this.mystack.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.mystack.size());
		
		// test the try-throw in mystack methods 
		try {	
			// Test the first value is a
			assertEquals("d", this.mystack.peek());

			this.mystack.pop();
			// Test the second value is b
			assertEquals("c", this.mystack.peek());
			this.mystack.pop();
			// Test the third value is c
			assertEquals("b", this.mystack.peek());
			this.mystack.pop();
			// Test the fourth value is d
			assertEquals("a", this.mystack.peek());
		}catch(NullPointerException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Tests to pop elements from the mystack.
	 */
	@Test
	void testPop() {
		this.mystack.push((E) "a");
		this.mystack.push((E) "b");
		this.mystack.push((E) "c");
		this.mystack.push((E) "d");
		
		/**
		 * mystack should now be:
		 * 
		 * b, c, d, a
		 */
		
		// Test the mystack is not empty.
		assertFalse(this.mystack.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.mystack.size());
		
		// test the try-throw in mystack methods 
		try {	
			// Test the first value is a
			assertEquals("d", this.mystack.peek());

			this.mystack.pop();
			// Test the second value is b
			assertEquals("c", this.mystack.peek());
			this.mystack.pop();
			// Test the third value is c
			assertEquals("b", this.mystack.peek());
			this.mystack.pop();
			// Test the fourth value is d
			assertEquals("a", this.mystack.peek());
		}catch(EmptyStackException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Tests equalization element from mystack by element.
	 */
	@Test
	void testEqual() {
		this.mystack.push((E) "a");
		this.mystack.push((E) "b");
		this.mystack.push((E) "c");
		this.mystack.push((E) "d");
		
		/**
		 * mystack should now be:
		 * 
		 * a, b, c, d
		 */
		
		MyStack<E> mystack2 = new MyStack<>();
		
		mystack2.push((E) "a");
		mystack2.push((E) "b");
		mystack2.push((E) "c");
		mystack2.push((E) "d");
		
		/**
		 * mystack2 should now be:
		 * 
		 * a, b, c, d
		 */
		
		// Test both size
		assertTrue(mystack.size()==mystack2.size());
		
		// Test equal
		assertTrue(mystack.equals(mystack2));
		
		
		MyStack<E> mystack3 = new MyStack<>();
		
		mystack3.push((E) "aa");
		mystack3.push((E) "bb");
		mystack3.push((E) "cc");
		mystack3.push((E) "dd");
		
		/**
		 * mystack3 should now be:
		 * 
		 * aa, bb, cc, dd
		 */
		
		// Test both size
		assertTrue(mystack.size()==mystack3.size());
		// Test not equal
		assertFalse(mystack.equals(mystack3));
		
		
		MyStack<E> mystack4 = new MyStack<>();
		
		mystack4.push((E) "a");
		mystack4.push((E) "b");
		mystack4.push((E) "c");
		
		/**
		 * mystack4 should now be:
		 * 
		 * a, b, c
		 */
		// Test both size
		assertFalse(mystack.size()==mystack4.size());
		// Test not equal
		assertFalse(mystack.equals(mystack4));
		
	}
	
	
	/**
	 * Tests to the top elements of the mystack.
	 */
	@Test
	void testPeek() {
		this.mystack.push((E) "a");
		this.mystack.push((E) "b");
		
		/**
		 * mystack should now be:
		 * 
		 * a, b
		 */
		
		// Test the mystack is not empty.
		assertFalse(this.mystack.isEmpty());
		
		// Test the size is 2
		assertEquals(2, this.mystack.size());
		
		//test the try-throw in mystack methods 
		try {	
			// Test the first value is a
			assertEquals("b", this.mystack.peek());
		}catch(EmptyStackException ex) {
			ex.printStackTrace();
		}
		
		
	}
	

	/**
	 * Tests mystack contains a specific element.
	 */
	@Test
	void testContains() {
		this.mystack.push((E) "a");
		this.mystack.push((E) "b");
		this.mystack.push((E) "c");
		this.mystack.push((E) "d");
		
		this.mystack.contains((E) "c");
		
		// test the try-throw in Mymystack methods 
		try {
			this.mystack.contains((E) "");
		}catch(NullPointerException ex) {
			ex.printStackTrace();
		
		
		/**
		 * mystack should now be:
		 * 
		 * a, b, c, d
		 */
		
		// Test the mystack is not empty.
		assertFalse(this.mystack.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.mystack.size());
		
		//Test the return value of contains()
		boolean contains = this.mystack.contains((E) "b");
		assertTrue(contains);
		
		boolean notContains = this.mystack.contains((E) "k");
		assertFalse(notContains);
		
		}
	}
	
	
	/**
	 * Tests search an element from mystack.
	 */
	@Test
	void testSearch() {
		this.mystack.push((E) "a");
		this.mystack.push((E) "b");
		this.mystack.push((E) "c");
		this.mystack.push((E) "d");
		
		/**
		 * mystack should now be:
		 * 
		 * a, b, c, d
		 */
		
		int searchIndex = this.mystack.search((E) "b");
		
		// Test both size
		assertEquals(1, searchIndex);
		
		
		//test the try-throw in mystack methods 
		try {	
			// Test the first value is a
			this.mystack.search((E) "k");
		}catch(NullPointerException ex) {
			ex.printStackTrace();
		}
		
	}
	
	
	
	/**
	 * Tests to toArray(E[] toHold).
	 */
	@Test
	void testToArray() {
		this.mystack.push((E) "a");
		this.mystack.push((E) "b");
		this.mystack.push((E) "c");
		this.mystack.push((E) "d");
		
		/**
		 * mystack should now be:
		 * 
		 * a, b, c, d
		 */
		
		String[] elements = new String[4];
		
		
		e = mystack.toArray((E[])elements);
		
		/**
		 * Now E[] should now be:
		 * 
		 * a, b, c, d
		 */
		
		// Test the mystack is not empty.
		assertFalse(this.mystack.isEmpty());
		
		// Test the size is 4
		assertEquals(4, e.length);

		// Test the forth value is a
		assertEquals("a", e[0]);

		// Test the fifth value is b
		assertEquals("b", e[1]);
		
		// Test the sixth value is c
		assertEquals("c", e[2]);
		
		// Test the seventh value is d
		assertEquals("d", e[3]);
		
		// test the try-throw in Mymystack methods 
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
		this.mystack.push((E) "a");
		this.mystack.push((E) "b");
		this.mystack.push((E) "c");
		this.mystack.push((E) "d");
		
		/**
		 * mystack should now be:
		 * 
		 * a, b, c, d
		 */
		
		Object[] array = (Object[]) this.mystack.toArray();
		
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
