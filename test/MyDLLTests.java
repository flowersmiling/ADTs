import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sait.parser.contracts.ListADT;
import sait.parser.utility.MyDLL;

/**
 * test class for doubly linked list
 * @param <E>
 */
class MyDLLTests<E> 
{
	private ListADT<E> dLinkedList;
	
	/** 
	* concrete the doubly linked list class assign to dLinkedList
	* @throws Exception - java.lang.Exception
	*/
	@BeforeEach
	void setUp() throws Exception 
	{
		this.dLinkedList = new MyDLL();
	}

	/** 
	* clear doubly linked list object 
	* @throws Exception - java.lang.Exception
	*/
	@AfterEach
	void tearDown() throws Exception 
	{
		this.dLinkedList.clear();
	}

	/** 
	* test is empty 
	*/
	@Test
	void testIsEmpty() 
	{
		assertTrue(this.dLinkedList.isEmpty());
		assertEquals(0,this.dLinkedList.size());
	}
	
	/** 
	* Appends the specified element to the end of this doubly linked list. 
	*/
	@Test
	void testAdd()
	{
		this.dLinkedList.add((E) "abc");
		this.dLinkedList.add((E) "def");
		this.dLinkedList.add((E) "ghi");
		this.dLinkedList.add((E) "jkl");
		this.dLinkedList.add((E) "mno");
	}

}
