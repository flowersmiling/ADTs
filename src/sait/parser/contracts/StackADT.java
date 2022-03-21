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
