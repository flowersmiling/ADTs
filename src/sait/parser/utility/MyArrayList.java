/**
 * 
 */
package sait.parser.utility;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import sait.parser.contracts.Iterator;
import sait.parser.contracts.ListADT;

/**
 * @author Chaoling Lu,Sheng Ming Yan,Mengdan Liu
 * @param <E>
 *
 */
public class MyArrayList<E> implements ListADT<E> {
	
	//attributes
	private static final long serialVersionUID =1L;
	private E[] array;
	//capacity of a array
	private int size;
	private MyArrayList<E>.ArrayBasedIterator myIter;
	
	
	
	public void MyArrayList() {
		array = (E[]) new Object [10];
		this.size =0;
		this.myIter = new ArrayBasedIterator();
		
		
		
	}

	@Override
	public int size() {
		
		return this.size;
	}

	@Override
	public void clear() {
		this.size =0;
		
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (size == this.array.length) {
		//array has no room,create a new array with double the size
		System.arraycopy(this.array, 0,this.array, index+1, (int) Math.pow(this.array.length, 2));
		
	} // if the index of a array is empty ,add the element.
		if(this.array[index] == null ) {
			this.array[index] = toAdd;
			size++;
			return true;
			
		}
		// if the index of a array is not empty, move elements to the right.
		if(this.array[index] != null) {
			for(int i = size -2; i >= index; i--) {
				this.array[i] = this.array[i-1];
				size++;
				
			}
		}
		return false;
		
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if( toAdd ==null) {
		return false;
		}
		for(int i = 0; i<this.array.length;i++) {
			if(this.array[i] == null) {
				this.array[i] =toAdd;
				return true;
			}
			
		}
		return false;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		Iterator iterator = toAdd.iterator();
		boolean success = true;
		
		while (success && iterator.hasNext()) {
		Object next = iterator.next();
		success = this.add((E) next);
		}
		return success;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		
		return (E)this.array[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		Object arr = this.array[index];
		
		if(index < array.length -1) {
			System.arraycopy(this.array, index-1, this.array, index, this.array.length - index -1);
		}
		return null;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		
		this.myIter = new ArrayBasedIterator();
		return myIter;
	}
	
	/*---------------------------------INNER CLASS------------------*/
	 private class ArrayBasedIterator implements Iterator<E> {
	 private int position = 0;
	private E[] copyOfElements;
	 private ArrayBasedIterator() {
	copyOfElements = (E[]) toArray();
	}
	 @Override
	public boolean hasNext() {
	if (position < copyOfElements.length) {
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
