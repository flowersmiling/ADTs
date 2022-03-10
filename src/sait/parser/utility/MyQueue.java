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


	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	
}
