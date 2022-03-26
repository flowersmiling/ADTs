package Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sait.parser.contracts.Iterator;
import sait.parser.contracts.ListADT;
import sait.parser.utility.MyArrayList;

/**
 * 
 */

/**
 * @author Sheng Ming Yan, Chaoling Lu, Mengdan Liu
 * @param <E>
 *
 */
class MyArrayListTest<E> {
	
	/**
	 * Contains the arrayList that is manipulated in each test.
	 */
	private MyArrayList<E> arrayList;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// Create concrete arrayList class and assign to to MyArrayList.
		this.arrayList = new MyArrayList<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		this.arrayList.clear();
	}

	/**
	 * Test the arraylist is empty.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(this.arrayList.isEmpty());
		assertEquals(0, this.arrayList.size());
	}
	
	/**
	 * Test the arraylist is not empty and its size
	 */
	@Test
	void testIsNotEmpty() {
		this.arrayList.add((E) "a");
		this.arrayList.add((E) "b");
		this.arrayList.add((E) "c");
		this.arrayList.add((E) "d");
		assertFalse(this.arrayList.isEmpty());
		assertTrue(this.arrayList.size()!=0);
		assertEquals(4,this.arrayList.size());
	}
	
	/**
	 * Tests to add elements to the arraylist.
	 */
	@Test
	void testAdd() {
		this.arrayList.add((E) "a");
		this.arrayList.add((E) "b");
		this.arrayList.add((E) "c");
		this.arrayList.add((E) "d");
		
		/**
		 * arraylist should now be:
		 * 
		 * a, b, c, d
		 */
		
		// Test the arrayList is not empty.
		assertFalse(this.arrayList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.arrayList.size());

		// Test the first value is a
		assertEquals("a", this.arrayList.get(0));

		// Test the second value is b
		assertEquals("b", this.arrayList.get(1));
		
		// Test the third value is c
		assertEquals("c", this.arrayList.get(2));
		
		// Test the fourth value is d
		assertEquals("d", this.arrayList.get(3));
		
		// test the try-throw in MyArrayList methods 
		try {			
			assertNull(this.arrayList.get(-1));
			assertNull(this.arrayList.get(4));
		}catch(IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Tests to add elements with index to the arraylist.
	 */
	@Test
	void testAddwithIndex() {
		this.arrayList.add(3, (E) "a");
		this.arrayList.add(0, (E) "b");
		this.arrayList.add(1, (E) "c");
		this.arrayList.add(2, (E) "d");
		
		/**
		 * arraylist should now be:
		 * 
		 * b, c, d, a
		 */
		
		// Test the arrayList is not empty.
		assertFalse(this.arrayList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.arrayList.size());

		// Test the first value is a
		assertEquals("b", this.arrayList.get(0));

		// Test the second value is b
		assertEquals("c", this.arrayList.get(1));
		
		// Test the third value is c
		assertEquals("d", this.arrayList.get(2));
		
		// Test the fourth value is d
		assertEquals("a", this.arrayList.get(3));
		
		// test the try-throw in MyArrayList methods 
		try {			
			assertNull(this.arrayList.get(-1));
			assertNull(this.arrayList.get(4));
		}catch(IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Tests to addAll elements to the arraylist.
	 */
	@Test
	void testAddAll() {
		this.arrayList.add((E) "a");
		this.arrayList.add((E) "b");
		this.arrayList.add((E) "c");
		this.arrayList.add((E) "d");
		
		/**
		 * arraylist should now be:
		 * 
		 * a, b, c, d
		 */
		
		MyArrayList<E> arraylist2 = new MyArrayList<>();
		
		arraylist2.add(0, (E) "AA");
		arraylist2.add(1, (E) "BB");
		arraylist2.add(2, (E) "CC");
		arraylist2.add(3, (E) "DD");
		
		/**
		 * arraylist2 should now be:
		 * 
		 * AA, BB, CC, DD
		 */
		
		this.arrayList.addAll(arraylist2);
		
		/**
		 * Now arrayList should now be:
		 * 
		 * a, b, c, d, AA, BB, CC, DD
		 */
		
		// Test the arrayList is not empty.
		assertFalse(this.arrayList.isEmpty());
		
		// Test the size is 8
		assertEquals(8, this.arrayList.size());

		// Test the first value is a
		assertEquals("AA", this.arrayList.get(4));

		// Test the second value is b
		assertEquals("BB", this.arrayList.get(5));
		
		// Test the third value is c
		assertEquals("CC", this.arrayList.get(6));
		
		// Test the fourth value is d
		assertEquals("DD", this.arrayList.get(7));
		
		// test the try-throw in MyArrayList methods 
		try {			
			assertNull(this.arrayList.get(-1));
			assertNull(this.arrayList.get(8));
		}catch(IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Tests deleting element from arrayList by index.
	 */
	@Test
	void testRemoveIndex() {
		this.arrayList.add((E) "a");
		this.arrayList.add((E) "b");
		this.arrayList.add((E) "c");
		this.arrayList.add((E) "d");
		
		this.arrayList.remove(2);
		
		// test the try-throw in MyArrayList methods 
		try {
			this.arrayList.remove(-1);
			this.arrayList.remove(4);
		}catch(IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
		
		
		/**
		 * arraylist should now be:
		 * 
		 * a, b, d
		 */
		
		// Test the arrayList is not empty.
		assertFalse(this.arrayList.isEmpty());
		
		// Test the size is 3
		assertEquals(3, this.arrayList.size());

		// Test the first value is a
		assertEquals("a", this.arrayList.get(0));

		// Test the second value is b
		assertEquals("b", this.arrayList.get(1));
		
		// Test the third value is d
		assertEquals("d", this.arrayList.get(2));
		
	}
	
	/**
	 * Tests deleting element from arrayList by element.
	 */
	@Test
	void testRemove() {
		this.arrayList.add((E) "a");
		this.arrayList.add((E) "b");
		this.arrayList.add((E) "c");
		this.arrayList.add((E) "d");
		
		this.arrayList.remove((E)"c");
		
		// test the try-throw in MyArrayList methods 
		try {
			this.arrayList.remove((E)"k");
		}catch(NullPointerException ex) {
			ex.printStackTrace();
		}
		
		
		/**
		 * arraylist should now be:
		 * 
		 * a, b, d
		 */
		
		// Test the arrayList is not empty.
		assertFalse(this.arrayList.isEmpty());
		
		// Test the size is 3
		assertEquals(3, this.arrayList.size());

		// Test the first value is a
		assertEquals("a", this.arrayList.get(0));

		// Test the second value is b
		assertEquals("b", this.arrayList.get(1));
		
		// Test the thid value is d
		assertEquals("d", this.arrayList.get(2));
		
	}
	
	
	/**
	 * Tests set element to arrayList .
	 */
	@Test
	void testSet() {
		this.arrayList.add((E) "a");
		this.arrayList.add((E) "b");
		this.arrayList.add((E) "c");
		this.arrayList.add((E) "d");
		
		this.arrayList.set(1, (E) "c");
		
		// test the try-throw in MyArrayList methods 
		try {
			this.arrayList.set(-1, (E) "k");
			this.arrayList.set(4, (E) "m");
			this.arrayList.set(1, (E) "");
		}catch(NullPointerException ex) {
			ex.printStackTrace();
		}catch(IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
		
		
		/**
		 * arraylist should now be:
		 * 
		 * a, c, c, d
		 */
		
		// Test the arrayList is not empty.
		assertFalse(this.arrayList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.arrayList.size());

		// Test the first value is a
		assertEquals("a", this.arrayList.get(0));

		// Test the second value is b
		assertEquals("c", this.arrayList.get(1));
		
		// Test the third value is d
		assertEquals("c", this.arrayList.get(2));
		
		// Test the fourth value is d
		assertEquals("d", this.arrayList.get(3));
		
	}
	
	
	/**
	 * Tests arrayList contains a specific element.
	 */
	@Test
	void testContains() {
		this.arrayList.add((E) "a");
		this.arrayList.add((E) "b");
		this.arrayList.add((E) "c");
		this.arrayList.add((E) "d");
		
		this.arrayList.contains((E) "c");
		
		// test the try-throw in MyArrayList methods 
		try {
			this.arrayList.contains((E) "");
		}catch(NullPointerException ex) {
			ex.printStackTrace();
//		}catch(IndexOutOfBoundsException ex) {
//			ex.printStackTrace();
//		}
		
		
		/**
		 * arraylist should now be:
		 * 
		 * a, b, c, d
		 */
		
		// Test the arrayList is not empty.
		assertFalse(this.arrayList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.arrayList.size());
		
		//Test the return value of contains()
		boolean contains = this.arrayList.contains((E) "b");
		assertTrue(contains);
		
		boolean notContains = this.arrayList.contains((E) "k");
		assertFalse(notContains);
		
		}
	}
	
	/**
	 * Tests to toArray(E[] toHold).
	 */
	@Test
	void testToArray() {
		this.arrayList.add((E) "a");
		this.arrayList.add((E) "b");
		this.arrayList.add((E) "c");
		this.arrayList.add((E) "d");
		
		/**
		 * arraylist should now be:
		 * 
		 * a, b, c, d
		 */
		
		String[] elements = { "aa","bb","cc","dd"};
		
		
		this.arrayList.toArray((E[])elements);
		
		/**
		 * Now E[] should now be:
		 * 
		 * aa, bb, cc, dd, a, b, c, d
		 */
		
		// Test the size is 8
		assertEquals(8, elements.length);

		// Test the forth value is a
		assertEquals("a", elements[4]);

		// Test the fifth value is b
		assertEquals("b", elements[5]);
		
		// Test the sixth value is c
		assertEquals("c", elements[6]);
		
		// Test the seventh value is d
		assertEquals("d", elements[7]);
		
		// test the try-throw in MyArrayList methods 
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
		this.arrayList.add((E) "a");
		this.arrayList.add((E) "b");
		this.arrayList.add((E) "c");
		this.arrayList.add((E) "d");
		
		/**
		 * arraylist should now be:
		 * 
		 * a, b, c, d
		 */
		
		String[] array = (String[]) this.arrayList.toArray();
		
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
