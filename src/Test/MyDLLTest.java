package Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sait.parser.contracts.ListADT;
import sait.parser.utility.MyDLL;


/**
 * 
 */

/**
 * @author Sheng Ming Yan, Chaoling Lu, Mengdan Liu
 * @param <E>
 *
 */
class MyDLLTest<E> {
	
	/**
	 * Contains the doubleLinkedList that is manipulated in each test.
	 */
	private MyDLL<E> doubleLinkedList;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// Create concrete doubleLinkedList class and assign to to MydoubleLinkedList.
		this.doubleLinkedList = new MyDLL<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		this.doubleLinkedList.clear();
	}

	/**
	 * Test the doubleLinkedList is empty.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(this.doubleLinkedList.isEmpty());
		assertEquals(0, this.doubleLinkedList.size());
	}
	
	/**
	 * Test the doubleLinkedList is not empty and its size
	 */
	@Test
	void testIsNotEmpty() {
		this.doubleLinkedList.add((E) "a");
		this.doubleLinkedList.add((E) "b");
		this.doubleLinkedList.add((E) "c");
		this.doubleLinkedList.add((E) "d");
		assertFalse(this.doubleLinkedList.isEmpty());
		assertTrue(this.doubleLinkedList.size()!=0);
		assertEquals(4,this.doubleLinkedList.size());
	}
	
	/**
	 * Tests to add elements to the doubleLinkedList.
	 */
	@Test
	void testAdd() {
		this.doubleLinkedList.add((E) "a");
		this.doubleLinkedList.add((E) "b");
		this.doubleLinkedList.add((E) "c");
		this.doubleLinkedList.add((E) "d");
		
		/**
		 * doubleLinkedList should now be:
		 * 
		 * a, b, c, d
		 */
		
		// Test the doubleLinkedList is not empty.
		assertFalse(this.doubleLinkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.doubleLinkedList.size());

		// Test the first value is a
		assertEquals("a", this.doubleLinkedList.get(0));

		// Test the second value is b
		assertEquals("b", this.doubleLinkedList.get(1));
		
		// Test the third value is c
		assertEquals("c", this.doubleLinkedList.get(2));
		
		// Test the fourth value is d
		assertEquals("d", this.doubleLinkedList.get(3));
		
		// test the try-throw in MydoubleLinkedList methods 
		try {			
			assertNull(this.doubleLinkedList.get(-1));
			assertNull(this.doubleLinkedList.get(4));
		}catch(IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Tests to add elements with index to the doubleLinkedList.
	 */
	@Test
	void testAddwithIndex() {
		this.doubleLinkedList.add((E) "a");
		this.doubleLinkedList.add((E) "b");
		this.doubleLinkedList.add((E) "c");
		this.doubleLinkedList.add(1, (E) "d");
		
		/**
		 * doubleLinkedList should now be:
		 * 
		 * a, d, b, c
		 */
		
		// Test the doubleLinkedList is not empty.
		assertFalse(this.doubleLinkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.doubleLinkedList.size());

		// Test the first value is a
		assertEquals("a", this.doubleLinkedList.get(0));

		// Test the second value is b
		assertEquals("d", this.doubleLinkedList.get(1));
		
		// Test the third value is c
		assertEquals("b", this.doubleLinkedList.get(2));
		
		// Test the fourth value is d
		assertEquals("c", this.doubleLinkedList.get(3));
		
		// test the try-throw in MydoubleLinkedList methods 
		try {			
			assertNull(this.doubleLinkedList.get(-1));
			assertNull(this.doubleLinkedList.get(4));
		}catch(IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Tests to addAll elements to the doubleLinkedList.
	 */
	@Test
	void testAddAll() {
		this.doubleLinkedList.add((E) "a");
		this.doubleLinkedList.add((E) "b");
		this.doubleLinkedList.add((E) "c");
		this.doubleLinkedList.add((E) "d");
		
		/**
		 * doubleLinkedList should now be:
		 * 
		 * a, b, c, d
		 */
		
		MyDLL<E> doubleLinkedList2 = new MyDLL<>();
		
		doubleLinkedList2.add(0, (E) "AA");
		doubleLinkedList2.add(1, (E) "BB");
		doubleLinkedList2.add(2, (E) "CC");
		doubleLinkedList2.add(3, (E) "DD");
		
		/**
		 * doubleLinkedList2 should now be:
		 * 
		 * AA, BB, CC, DD
		 */
		
		this.doubleLinkedList.addAll(doubleLinkedList2);
		
		/**
		 * Now doubleLinkedList should now be:
		 * 
		 * a, b, c, d, AA, BB, CC, DD
		 */
		
		// Test the doubleLinkedList is not empty.
		assertFalse(this.doubleLinkedList.isEmpty());
		
		// Test the size is 8
		assertEquals(8, this.doubleLinkedList.size());

		// Test the first value is a
		assertEquals("AA", this.doubleLinkedList.get(4));

		// Test the second value is b
		assertEquals("BB", this.doubleLinkedList.get(5));
		
		// Test the third value is c
		assertEquals("CC", this.doubleLinkedList.get(6));
		
		// Test the fourth value is d
		assertEquals("DD", this.doubleLinkedList.get(7));
		
		// test the try-throw in MydoubleLinkedList methods 
		try {			
			assertNull(this.doubleLinkedList.get(-1));
			assertNull(this.doubleLinkedList.get(8));
		}catch(IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Tests deleting element from doubleLinkedList by index.
	 */
	@Test
	void testRemoveIndex() {
		this.doubleLinkedList.add((E) "a");
		this.doubleLinkedList.add((E) "b");
		this.doubleLinkedList.add((E) "c");
		this.doubleLinkedList.add((E) "d");
		
		this.doubleLinkedList.remove(2);
		
		// test the try-throw in MydoubleLinkedList methods 
		try {
			this.doubleLinkedList.remove(-1);
			this.doubleLinkedList.remove(4);
		}catch(IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
		
		
		/**
		 * doubleLinkedList should now be:
		 * 
		 * a, b, d
		 */
		
		// Test the doubleLinkedList is not empty.
		assertFalse(this.doubleLinkedList.isEmpty());
		
		// Test the size is 3
		assertEquals(3, this.doubleLinkedList.size());

		// Test the first value is a
		assertEquals("a", this.doubleLinkedList.get(0));

		// Test the second value is b
		assertEquals("b", this.doubleLinkedList.get(1));
		
		// Test the third value is d
		assertEquals("d", this.doubleLinkedList.get(2));
		
	}
	
	/**
	 * Tests deleting element from doubleLinkedList by element.
	 */
	@Test
	void testRemove() {
		this.doubleLinkedList.add((E) "a");
		this.doubleLinkedList.add((E) "b");
		this.doubleLinkedList.add((E) "c");
		this.doubleLinkedList.add((E) "d");
		
		this.doubleLinkedList.remove((E)"c");
		
		// test the try-throw in MydoubleLinkedList methods 
		try {
			this.doubleLinkedList.remove((E)"k");
		}catch(NullPointerException ex) {
			ex.printStackTrace();
		}
		
		
		/**
		 * doubleLinkedList should now be:
		 * 
		 * a, b, d
		 */
		
		// Test the doubleLinkedList is not empty.
		assertFalse(this.doubleLinkedList.isEmpty());
		
		// Test the size is 3
		assertEquals(3, this.doubleLinkedList.size());

		// Test the first value is a
		assertEquals("a", this.doubleLinkedList.get(0));

		// Test the second value is b
		assertEquals("b", this.doubleLinkedList.get(1));
		
		// Test the thid value is d
		assertEquals("d", this.doubleLinkedList.get(2));
		
	}
	
	
	/**
	 * Tests set element to doubleLinkedList .
	 */
	@Test
	void testSet() {
		this.doubleLinkedList.add((E) "a");
		this.doubleLinkedList.add((E) "b");
		this.doubleLinkedList.add((E) "c");
		this.doubleLinkedList.add((E) "d");
		
		this.doubleLinkedList.set(1, (E) "c");
		
		// test the try-throw in MydoubleLinkedList methods 
		try {
			this.doubleLinkedList.set(-1, (E) "k");
			this.doubleLinkedList.set(4, (E) "m");
			this.doubleLinkedList.set(1, (E) "");
		}catch(NullPointerException ex) {
			ex.printStackTrace();
		}catch(IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
		
		
		/**
		 * doubleLinkedList should now be:
		 * 
		 * a, c, c, d
		 */
		
		// Test the doubleLinkedList is not empty.
		assertFalse(this.doubleLinkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.doubleLinkedList.size());

		// Test the first value is a
		assertEquals("a", this.doubleLinkedList.get(0));

		// Test the second value is b
		assertEquals("c", this.doubleLinkedList.get(1));
		
		// Test the third value is d
		assertEquals("c", this.doubleLinkedList.get(2));
		
		// Test the fourth value is d
		assertEquals("d", this.doubleLinkedList.get(3));
		
	}
	
	
	/**
	 * Tests doubleLinkedList contains a specific element.
	 */
	@Test
	void testContains() {
		this.doubleLinkedList.add((E) "a");
		this.doubleLinkedList.add((E) "b");
		this.doubleLinkedList.add((E) "c");
		this.doubleLinkedList.add((E) "d");
		
		this.doubleLinkedList.contains((E) "c");
		
		// test the try-throw in MydoubleLinkedList methods 
		try {
			this.doubleLinkedList.contains((E) "");
		}catch(NullPointerException ex) {
			ex.printStackTrace();
//		}catch(IndexOutOfBoundsException ex) {
//			ex.printStackTrace();
//		}
		
		
		/**
		 * doubleLinkedList should now be:
		 * 
		 * a, b, c, d
		 */
		
		// Test the doubleLinkedList is not empty.
		assertFalse(this.doubleLinkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.doubleLinkedList.size());
		
		//Test the return value of contains()
		boolean contains = this.doubleLinkedList.contains((E) "b");
		assertTrue(contains);
		
		boolean notContains = this.doubleLinkedList.contains((E) "k");
		assertFalse(notContains);
		
		}
	}
	
	/**
	 * Tests to toArray(E[] toHold).
	 */
	@Test
	void testToArray() {
		this.doubleLinkedList.add((E) "a");
		this.doubleLinkedList.add((E) "b");
		this.doubleLinkedList.add((E) "c");
		this.doubleLinkedList.add((E) "d");
		
		/**
		 * doubleLinkedList should now be:
		 * 
		 * a, b, c, d
		 */
		
		String[] elements = new String[4];
		
		
		doubleLinkedList.toArray((E[])elements);
		
		/**
		 * Now E[] should now be:
		 * 
		 * a, b, c, d
		 */
		
		// Test the doubleLinkedList is not empty.
		assertFalse(this.doubleLinkedList.isEmpty());
		
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
		
		// test the try-throw in MydoubleLinkedList methods 
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
		this.doubleLinkedList.add((E) "a");
		this.doubleLinkedList.add((E) "b");
		this.doubleLinkedList.add((E) "c");
		this.doubleLinkedList.add((E) "d");
		
		/**
		 * doubleLinkedList should now be:
		 * 
		 * a, b, c, d
		 */
		
		String[] array = (String[]) this.doubleLinkedList.toArray();
		
		/**
		 * Now array should now be:
		 * 
		 * a, b, c, d
		 */
		
		// Test the doubleLinkedList is not empty.
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
		
		// test the try-throw in MydoubleLinkedList methods 
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
