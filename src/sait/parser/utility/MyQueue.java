package sait.parser.utility;

import java.util.NoSuchElementException;

import sait.parser.contracts.EmptyQueueException;
import sait.parser.contracts.Iterator;
import sait.parser.contracts.QueueADT;

/**
 * @author Chaoling Lu,Sheng Ming Yan,Mengdan Liu
 * @param <E> - Element
 *
 */

public class MyQueue<E> implements QueueADT<E>,Iterator<E> {

	
	/**
	 *The version number for Queue class  
	 */
	private static final long serialVersionUID = 1L;
	private MyDLL<E> dLinkedList;
	private int size;
	private int maxsize;

	/**
	 * MyQueue data model constructor
	 */
	public MyQueue() 
	{
		this.dLinkedList = new MyDLL<E>();
	}

	/**
	 * MyQueue data model constructor with capacity
	 * @param maxsize - MyQueue's capacity
	 */
	public MyQueue(int maxsize) 
	{
		this.dLinkedList = new MyDLL<E>();
		this.maxsize = maxsize;

	}

	@Override
	public void enqueue(E toAdd) throws NullPointerException 
	{
		if( toAdd == null) { throw new NullPointerException(); }
		if( this.dLinkedList.add(toAdd) )
			size++;
	}

	@Override
	public E dequeue() throws EmptyQueueException 
	{
		if( this.dLinkedList.isEmpty() ) 
		{ 
			return null; 
		}else {
			size--;
			return this.dLinkedList.remove(0);
		}
	}
		
	@Override
	public boolean isEmpty() 
	{
		if( this.dLinkedList.isEmpty() )
			return true;
		return false;
	}

	@Override
	public Iterator<E> iterator() 
	{
		return this.dLinkedList.iterator();
	}

	
	@Override
	public int size() 
	{
		return this.size;
	}

	@Override
	public E peek() throws EmptyQueueException 
	{
		return this.dLinkedList.get(0);
	}


	@Override
	public void dequeueAll() 
	{
		this.dLinkedList.clear();
		this.size = 0;
	}


	@Override
	public boolean equals(QueueADT<E> that) 
	{
		boolean isEqual = true;
		if(that.size() != this.size)
			return false;
		for( int i = 0; i < this.size; i++) 
		{
			if( !this.dLinkedList.toArray()[i].equals(that.toArray()[i]))
				isEqual = false;
		}
		return isEqual;
	}


	@Override
	public Object[] toArray() 
	{
		return this.dLinkedList.toArray();
	}


	@Override
	public E[] toArray(E[] holder) throws NullPointerException 
	{
		return this.dLinkedList.toArray(holder);
	}


	@Override
	public boolean hasNext() 
	{
		return this.dLinkedList.hasNext();
	}


	@Override
	public E next() throws NoSuchElementException 
	{
		return this.dLinkedList.next();
	}

}
