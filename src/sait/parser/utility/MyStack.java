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
	private E[] array;
	private int top;
	
	private MyDLL<E> list;
		
	public MyStack() {		
		this.list = new MyDLL<E>();
	}
	
	public MyStack(int size) {
		this.size = size;
		this.array = (E[]) new Object [this.size];
		this.top = -1;
		
		list = new MyDLL<E>();
	}
	

	@Override
	public void push(E toAdd) throws NullPointerException {
		if(isFull()) {
			throw new IndexOutOfBoundsException("Stack is full");
		}
		top++;
		array[top] = toAdd;
		
		list.add(toAdd);
	}

	@Override
	public E pop() throws EmptyStackException {
			E e = this.list.get(this.list.size()-1);
			list.remove(list.size()-1);
		return e;
	}

	@Override
	public boolean isEmpty() {
		if(top ==-1) {
			return true;
		}
		else {
		return false;
		}
	}
	@Override
	public boolean isFull() {
		
		if (top == size-1) {
			return true;
			
		}
		else {
			return false;
		}
		
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
	public E get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
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


	}




