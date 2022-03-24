package sait.parser.contracts;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * @author Chaoling Lu,Sheng Ming Yan,Mengdan Liu
 * Class Definition: This interface represents the public contract for the Stack Abstract Data Type. 
 */
public interface StackADT<E> extends Serializable
{	


	/** 
	* Add an element to the top of a stack
	* 
	* Precondition: input an object
	* 
	* Postcondition: add an object to the top of stack,will be popped next if no intervening push
	* 
	* @throws NullPointerException to add an empty/null object, method will throw an exception
	* 
	*/	
	public void push(E toAdd) throws NullPointerException;

	/** 
	* Remove the topmost element from a stack 
	* 
	* Precondition: the stack cannot be null/empty
	* 
	* Postcondition: delete an object from the top of stack
	* 
	* @throws EmptyStackException method will throw an exception when the stack is null/empty
	* @return a reference of the removed element.
	*/	
	public E pop() throws EmptyStackException;
	
	/** 
	* Postcondition: retrieve an element from the top of stack without removing.
	* 
	* @exception EmptyStackException
	* @throws EmptyStackException method will throw an exception when the stack is null/empty
	* 
	* @return object,a reference to the top element of the stack.
	* @return a reference to the top element of the stack.
	*/	
	public E peek() throws EmptyStackException;

	/** 
	* check if the stack is empty
	* 
	* Precondition: has an existing stack instance
	* 
	* Postcondition: to check if the stack is empty and return true if empty; otherwise, return false.
	* 
	* @return boolean true or false
	*/	
	public boolean isEmpty();
	
	/**
	 * Clears all the items from this Stack. This method returns, unless there
	 * is an Exception (Runtime) thrown.
	 */
	public void clear();
	
	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence. Obeys the general contract of the Collection.toArray method.
	 * 
	 * @return an array containing all of the elements in this list in proper
	 *         sequence.
	 */
	public Object[] toArray();
	
	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence; the runtime type of the returned array is that of the specified
	 * array. Obeys the general contract of the Collection.toArray(Object[])
	 * method.
	 * 
	 * @param toHold
	 *            the array into which the elements of this stack are to be
	 *            stored, if it is big enough; otherwise, a new array of the
	 *            same runtime type is allocated for this purpose.
	 * @return an array containing the elements of this stack.
	 * @throws NullPointerException
	 *             if the specified array is null.
	 */
	public E[] toArray( E[] holder ) throws NullPointerException;
	
	/**
	 * Returns true if this list contains the specified element. More formally,
	 * returns true if and only if this list contains at least one element e
	 * such that (o==null ? e==null : o.equals(e)).
	 * 
	 * @param toFind
	 *            element whose presence in this list is to be tested.
	 * @return true if this list contains the specified element.
	 * @throws NullPointerException
	 *             if the specified element is null and this list does not
	 *             support null elements.
	 */
	public boolean contains( E toFind ) throws NullPointerException;
	
	/**
	 * Used to compare two Stack ADT's. To be equal two stacks must contain
	 * equal items appearing in the same order.
	 * 
	 * @param that the Stack ADT to be compared to this stack.
	 * @return <code>true</code> if the stacks are equal.
	 */
	public boolean equals( StackADT<E> that );

	/** 
	* search the stack for a specific object
	* 
	* Precondition: has an existing stack instance
	* 
	* Postcondition: search the stack contains a specific object and return the index of the object
	* 
	* @param object
	* @return integer,the index of the object in a stack.
	*/
	public int search(E toFind);

	/** 
	* iterate the stack
	* 
	* Precondition: has an existing stack instance
	* 
	* Postcondition: iterate the stack contains a specific object and return the iterator
	* 
	* @return iterator generic
	*/
	public Iterator<E> iterator();


	/** 
	* check the size of the stack
	* 
	* Precondition: has an existing stack instance
	* 
	* Postcondition: check the size of the stack and return its size
	* 
	* @return integer, number of elements in the stack.
	*/
	public int size();
	
}
