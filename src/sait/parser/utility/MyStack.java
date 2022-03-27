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
public class MyStack<E> implements StackADT<E>, Iterator<E> {
	private int size;
//	private E[] array;
	private int top;
	private int capacity;
	
	private MyArrayList<E> list;
		
	public MyStack() {		
		list = new MyArrayList<E>();
	}
	
	public MyStack(int capacity) {
		this.capacity = capacity;
//		this.array = (E[]) new Object [this.size];
//		this.top = -1;
		list = new MyArrayList<E>(capacity);
	}
	

	@Override
	public void push(E toAdd) throws NullPointerException {
		list.add(toAdd);
	}

	@Override
	public E pop() throws EmptyStackException {
			E e = list.get(list.size()-1);
			list.remove(list.size()-1);
		return e;
	}

	@Override
	public boolean isEmpty() {
		
		if(list.size()==0) {
			return true;
		}
		
		return false;
		
//		if(top ==-1) {
//			return true;
//		}
//		else {
//		return false;
//		}
	}


	@Override
	public int search(E toFind) {
		for(int i=0;i<this.list.size()-1;i++) {
			if(toFind.equals(this.list.get(i)) || toFind == this.list.get(i)) {
				return i;
			}
		}
		return -1;
	}


	@Override
	public int size() {
		return this.list.size();
	}


	@Override
	public E peek() throws EmptyStackException {
		
		return this.list.get(this.list.size()-1);
	}


	@Override
	public boolean hasNext() {
		
		return this.list.hasNext();
	}


	@Override
	public E next() {
		
		return this.list.next();
	}

	@Override
	public void clear() {
		this.list.clear();
		
	}

	@Override
	public Object[] toArray() {
		
		return this.list.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		
		return this.list.toArray(holder);
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		
		return this.list.contains(toFind);
	}

	@Override
	public boolean equals(StackADT<E> that) {
		if(that.size()!=this.list.size()) {
			return false;
		}
		for(int i = 0 ; i<that.size()-1;i++) {
			if(!(((that.toArray())[i]).equals(this.list.get(i)))) {
				return false;
			}
		}
		return true;
	}


	}




