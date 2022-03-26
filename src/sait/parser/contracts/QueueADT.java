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
	 * (Optional Method) Returns true if the number of items in the queue
	 * equals the length.  This operation is only implement when a fixed length
	 * queue is required.
	 * @return <code>true</code> if queue is at capacity.
	 */
	public boolean isFull();
	
	/**
	 * dequeueAll removes all items in the queue.
	 */
	public void dequeueAll();


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
	 * Used to compare two Queue ADT's. To be equal two queues must contain
	 * equal items appearing in the same order.
	 * 
	 * @param that the Queue ADT to be compared to this queue.
	 * @return <code>true</code> if the queues are equal.
	 */
	public boolean equals( QueueADT<E> that );
	
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
	 *            the array into which the elements of this queue are to be
	 *            stored, if it is big enough; otherwise, a new array of the
	 *            same runtime type is allocated for this purpose.
	 * @return an array containing the elements of this queue.
	 * @throws NullPointerException
	 *          if the specified array is null.
	 */
	public E[] toArray( E[] holder ) throws NullPointerException;

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
	
}
	

