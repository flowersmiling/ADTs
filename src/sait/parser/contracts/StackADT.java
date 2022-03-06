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
	* Create a new Stack
	* 
	* Precondition: 
	* 
	* Postcondition: new a new Stack instance
	* 
	*/	
	public void MyStack();

	/** 
	* Add an element to the top of a stack
	* 
	* Precondition: input an object
	* 
	* Postcondition: add an object to the top of stack,will be popped next if no intervening push
	* 
	* @exception NullPointerException
	* @param object
	*/	
	public void push(E toAdd) throws NullPointerException;

	/** 
	* Remove the topmost element from a stack 
	* 
	* Precondition: the stack cannot be null/empty
	* 
	* Postcondition: delete an object from the top of stack
	* 
	* @exception EmptyStackException
	* @return object,a reference to the removed element.
	*/	
	public E pop() throws EmptyStackException;

	/** 
	* Retrieve the topmost element in a stack without removing it
	* 
	* Precondition: stack cannot be null/empty
	* 
	* Postcondition: retrieve an element from the top of stack without removing.
	* 
	* @exception EmptyStackException
	* 
	* @return object,a reference to the top element of the stack.
	*/	
	public E peek() throws EmptyStackException;

	/** 
	* delete/clear the whole stack
	* 
	* Precondition: has an existing stack instance
	* 
	* Postcondition: clear the stack, the size of the stack will become 0
	* 
	*/	
	public void clear();

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
	* change a stack into an array
	* 
	* Precondition: has an existing stack instance
	* 
	* Postcondition: change a stack to an array
	* 
	* @return an array Object[]
	*/	
	public Object[] toArray();

	/** 
	* put a stack object array into another array
	* 
	* Precondition: stack cannot be null/empty
	* 
	* Postcondition: put a stack object array into another array
	* 
	* @exception NullPointerException
	* @param object[]
	* @return an array Object[]
	*/	
	public E[] toArray(E[] holder) throws NullPointerException;

	/** 
	* check if the stack contains a specific object
	* 
	* Precondition: stack cannot be null/empty
	* 
	* Postcondition: check if the stack contains a specific object and return true if it does; otherwise, return false
	* 
	* @exception NullPointerException
	* @param object
	* @return boolean true or false
	*/	
	public boolean contains(E toFind) throws NullPointerException;

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
	* check if the stack equals to the StackADT element
	* 
	* Precondition: has an existing stack instance
	* 
	* Postcondition: check if the stack equals to the StackADT element and return true if it does; otherwise, false
	* 
	* @param StackADT element
	* @return boolean true or false
	*/
	public boolean equals(StackADT<E> E);

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
	
	/*
	 * Fetch a reference to the top element of the stack.
	 * 
	 * Returns: A reference to the top element of the stack.
	 * 
	 * Precondition: stack is not empty
	 * 
	 * Postcondition: top value (next to be popped)is returned.
	 */
	
	public Object get();
	
}
