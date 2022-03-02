package sait.parser.utility;

import java.util.NoSuchElementException;

import sait.parser.contracts.Iterator;
import sait.parser.contracts.ListADT;

public class MyArrayList <E> implements ListADT <E> , Iterator<E> {

	private int size;

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(int index, Object toAdd) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Object toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(ListADT toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object remove(Object toRemove) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object set(int index, Object toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object toFind) throws NullPointerException {
		
		return false;
	}

	@Override
	public Object[] toArray(Object[] toHold) throws NullPointerException {
		
		toHold = (E[])(new Object [this.size()]);
		
		System.arraycopy(array, 0, toHold, 0, size());
		
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		
		return new ArrayBasedIterator();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E next() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/*---------------------------------INNER CLASS------------------*/
	
	private class ArrayBasedIterator implements Iterator<E> {
		
		private int position = 0;
		private E[] copyOfElements;

		@Override
		public boolean hasNext() {
			if(position < copyOfElements.length) {
				return true;
			}
			else {
				
				return false;
			}
		
		}

		@Override
		public E next() throws NoSuchElementException {
			E toReturn = copyOfElements[position];
			position++;
						return toReturn;
		}
		
	}
	

}
