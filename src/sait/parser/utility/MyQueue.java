/**
 * 
 */
package sait.parser.utility;

import java.util.NoSuchElementException;

import sait.parser.contracts.EmptyQueueException;
import sait.parser.contracts.Iterator;
import sait.parser.contracts.QueueADT;

/**
 * @author Chaoling Lu,Sheng Ming Yan,Mengdan Liu
 * @param <E>
 *
 */
public class MyQueue<E> implements QueueADT<E>, Iterator<E> {
	
	private int size;
	private int head;
	private int tail;
	private E[] array;
	private int capacity;
	
	//private MyDLL<E> list;
	
//	public MyQueue() {
//		list = new MyDLL<E>();
//	}
	
	public MyQueue( int maxSize) {
		
		this.capacity = maxSize;
		this.head = -1;
		this.tail = -1;	
		array = (E[]) new Object [this.capacity];
		
		//list = new MyDLL<E>();
	}


	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		
		if( isFull() ) {
			
			throw new IndexOutOfBoundsException ("queue is full");
			
		}
		else {
			tail++;
			
			array[tail] = toAdd;
			
			//list.add(toAdd);
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
		return array[head+1];
	}


	@Override
	public boolean hasNext() {
		
		return false;
	}


	@Override
	public E next() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
