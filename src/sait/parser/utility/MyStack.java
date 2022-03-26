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
		
//		list = new MyDLL<E>();
	}
	

	@Override
	public void push(E toAdd) throws NullPointerException {
		if(isFull()) {
			throw new IndexOutOfBoundsException("Stack is full");
		}
		top++;
		array[top] = toAdd;
		
//		list.add(toAdd);
	}

	@Override
	public E pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
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


	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public E next() {
		// TODO Auto-generated method stub
		return null;
	}


	}




