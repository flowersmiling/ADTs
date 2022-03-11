/**
 * 
 */


import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sait.parser.contracts.ListADT;
import sait.parser.utility.MyArrayList;

/**
 * @author Chaoling Lu,Sheng Ming Yan,Mengdan Liu
 */
class MyArrayListTests {
	
	ListADT<String>list;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		list = new MyArrayList(5);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		list = null;
	}

	/**
	 * Test method for {@link sait.parser.utility.MyArrayList#size()}.
	 */
	@Test
	void testSizeEmpty() {
		assertEquals(0,list.size());
	}
	


	/**
	 * Test method for {@link sait.parser.utility.MyArrayList#clear()}.
	 */
	@Test
	void testClear() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link sait.parser.utility.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAdd() {
		
		list.add(0, "A");
		list.add(1, "B");
		assertEquals(2,list.size());
		
		
		
	}


	/**
	 * Test method for {@link sait.parser.utility.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	void testAddE() {
		list.add("C");
		assertEquals("C",list.get(3));
	//
	}

	/**
	 * Test method for {@link sait.parser.utility.MyArrayList#addAll(sait.parser.contracts.ListADT)}.
	 */
	@Test
	void testAddAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link sait.parser.utility.MyArrayList#get(int)}.
	 */
	@Test
	void testGet() {
		assertEquals("B",list.get(1));
	}

	/**
	 * Test method for {@link sait.parser.utility.MyArrayList#remove(int)}.
	 */
	@Test
	void testRemoveInt() {
		list.remove(0);
		assertEquals(2,list.size());
		
	}

	/**
	 * Test method for {@link sait.parser.utility.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveE() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link sait.parser.utility.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	void testSet() {
		fail("Not yet implemented");
	}



	/**
	 * Test method for {@link sait.parser.utility.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link sait.parser.utility.MyArrayList#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link sait.parser.utility.MyArrayList#toArray()}.
	 */
	@Test
	void testToArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link sait.parser.utility.MyArrayList#iterator()}.
	 */
	@Test
	void testIterator() {
		fail("Not yet implemented");
	}

}
