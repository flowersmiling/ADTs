/**
 * 
 */
package sait.parser.utility;

import java.util.EmptyStackException;
import java.util.Iterator;

import sait.parser.contracts.StackADT;

/**
 * @author Chaoling Lu,Sheng Ming Yan,Mengdan Liu
 * @param <E>
 *
 */
public class MyStack<E> implements StackADT<E> {



	@Override
	public void push(E toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int search(E toFind) {
		// TODO Auto-generated method stub
		return 0;
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
	public E get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() throws EmptyStackException {
		// TODO Auto-generated method stub
		return null;
	}


	}




