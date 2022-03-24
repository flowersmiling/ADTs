/**
 * 
 */
package sait.parser.utility;

import sait.parser.contracts.EmptyQueueException;
import sait.parser.contracts.Iterator;
import sait.parser.contracts.QueueADT;

/**
 * @author Chaoling Lu,Sheng Ming Yan,Mengdan Liu
 * @param <E>
 *
 */
public class MyQueue<E> implements QueueADT<E> {
	
	private int size;
	private int head;
	private int tail;
	private E[] array;
	private int capacity;
	
	
	public MyQueue( int maxSize) {
		
		this.capacity = maxSize;
		this.head = -1;
		this.tail = -1;	
		array = (E[]) new Object [this.capacity];
	}


	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		
		if( isFull() ) {
			
			throw new IndexOutOfBoundsException ("queue is full");
			
		}
		else {
			tail++;
			
			array[tail] = toAdd;
	}
	}
	@Override
	public E dequeue() throws EmptyQueueException {
		if(isEmpty()) {
			throw new EmptyQueueException("Queue is Empty");
		}
		
		head++;
		return array[head];
		
	}
	
	@Override
	public boolean isFull() throws IndexOutOfBoundsException{
		
		if(size == capacity) {
		return true;
	}
		else
			return false;
	}

	@Override
	public boolean isEmpty() {
		
		if(head == tail) {
		return true;
	}
		else
			return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() throws EmptyQueueException {
		if(isEmpty()) {
			throw new EmptyQueueException("Queue is Empty");
		}
		else
		return array[head];
	}

	
}
