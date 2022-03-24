package sait.parser.contracts;

import java.io.Serializable;


/**
 * @author Chaoling Lu,Sheng Ming Yan,Mengdan Liu 
 * Class Definition: This interface represents the public contract for the Queue Abstract Data Type. 
 * A first-in, first-out structure. Values are added at the tail, and removed
 * from the head. Used to process values in the order that they appear.
 */
public interface QueueADT<E> extends Serializable
{

	
	/** 
	* Add an element to the tail of a queue
	* 
	* Precondition: input an object
	* 
	* Postcondition: add an object to the tail of a queue
	* 
	* @throws NullPointerException to add an empty/null object, method will throw an exception
	* 
	*/	
	public void enqueue(E toAdd) throws NullPointerException;
	
	/** 
	* Remove the head element from a queue
	* 
	* Precondition: the queue cannot be null/empty
	* 
	* Postcondition: delete an object from head of a queue
	* 
	* @throws EmptyQueueException method will throw an exception when the queue is null/empty
	* 
	*/	
	public E dequeue() throws EmptyQueueException;
	
	/** 
	* Postcondition: retrieve an element from the head of queue without removing.
	* 
	* @exception EmptyStackException
	* @return object
	* @throws EmptyQueueException method will throw an exception when the queue is null/empty
	* @return Reference of the first value of the queue.
	*/	
	public E peek() throws EmptyQueueException;
	
	/** 
	* check if the queue is empty
	* 
	* Precondition: has an existing queue instance
	* 
	* Postcondition: to check if the queue is empty and return true if empty; otherwise, return false.
	* 
	* @return boolean true or false
	*/	
	public boolean isEmpty();
	
	/** 
	* check if the queue is empty
	* 
	*/
	
	public boolean isFull() throws IndexOutOfBoundsException;

	/** 
	* iterate the queue
	* 
	* Precondition: has an existing queue instance
	* 
	* Postcondition: iterate the queue contains a specific object and return the iterator
	* 
	* @return iterator generic
	*/
	public Iterator<E> iterator();


	/** 
	* Returns the number of elements in the queue.
	* 
	* Precondition: has an existing queue instance
	* 
	* Postcondition: check the size of the queue and return its size
	* 
	* @return number of elements in queue.
	*/
	public int size();
	
	/**
	 * get the first value at the head of the queue
	 * 
	 * Precondition: the queue is not empty 
	 * Postcondition: the element at the head of the queue is returned 
	 * @Return: Reference to the first value of the queue.
	 * @throws IndexOutOfBoundsException method will throw an exception when the index is not found.
	 */
	public E get(int index) throws IndexOutOfBoundsException;
	
}
	

