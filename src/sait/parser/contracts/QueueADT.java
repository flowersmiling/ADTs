package sait.parser.contracts;

import java.io.Serializable;


/**
 * @author Chaoling Lu,Sheng Ming Yan,Mengdan Liu
 * @param <E>
 *
 */
 



/* 
 * A first-in, first-out structure. Values are added at the tail, and removed
 * from the head. Used to process values in the order that they appear.
 */
public interface QueueADT<E> extends Serializable
{
	/** 
	* Create a new Queue
	* 
	* Precondition: 
	* 
	* Postcondition: new a new Queue instance
	* 
	*/	
	public E MyQueue();
	
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
	* Retrieve the head element in a queue without removing it
	* 
	* Precondition: queue cannot be null/empty
	* 
	* Postcondition: retrieve an element from the head of queue without removing.
	* 
	* @throws EmptyQueueException method will throw an exception when the queue is null/empty
	* @return Reference of the first value of the queue.
	*/	
	public E peek() throws EmptyQueueException;

	/** 
	* delete/clear the whole queue
	* 
	* Precondition: has an existing queue instance
	* 
	* Postcondition: clear the queue, the size of the queue will become 0
	* 
	*/	
	public void dequeueAll() ;

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
	* check if the queue equals to the QueueADT element
	* 
	* Precondition: has an existing queue instance
	* 
	* Postcondition: check if the queue equals to the QueueADT element and return true if it does; otherwise, false
	* 
	* @param QueueADT element
	* @return boolean true or false
	*/
	public boolean equals(QueueADT<E> E);

	/** 
	* change a queue into an array
	* 
	* Precondition: has an existing queue instance
	* 
	* Postcondition: change a queue to an array
	* 
	* @return an array Object[]
	*/	
	public Object[] toArray() ;

	/** 
	* put a queue object array into another array
	* 
	* Precondition: queue cannot be null/empty
	* 
	* Postcondition: put a queue object array into another array
	* 
	* @throws NullPointerException to arrange an empty/null object, method will throw an exception
	* @param object[]
	* @return an array Object[]
	*/	
	public E[] toArray(E[] holder) throws NullPointerException;

	/** 
	* check if the queue is full
	* 
	* Precondition: has an existing queue instance
	* 
	* Postcondition: to check if the queue is full and return true if full; otherwise, return false.
	* 
	* @return boolean true or false
	*/	
	public boolean isFull();

	/** 
	* Returns the number of elements in the queue.
	* 
	* Precondition: has an existing queue instance
	* 
	* Postcondition: check the size of the queue and return its size
	* 
	* @return number of elements in queue.
	*/
	public int size() ;
	
	
}
	

