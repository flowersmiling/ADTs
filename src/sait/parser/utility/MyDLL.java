package sait.parser.utility;

import java.util.NoSuchElementException;
import sait.parser.contracts.Iterator;
import sait.parser.contracts.ListADT;
import sait.parser.models.MyDLLNode;

/**
 * doubly-linked List data model implements ListADT and Iterator
 */
public class MyDLL<E> implements ListADT<E>, Iterator<E> 
{
	/**
	 *define doubly-linked List node head and tail
	 */
	private MyDLLNode<E> head,tail;
	/**
	 *the doubly-linked List size 
	 */
	private int size;
	/**
	 *the max number of items in the doubly-linked List data model 
	 */
	private int maxsize;
	/**
	 *Iterator for the doubly-linked List data model
	 */
	private MyDLL<E>.DoubleListIterator dllIterator;
	
	/**
	 * the doubly-linked List data model constructor
	 */
	public MyDLL()
	{
		this.head = this.tail = null;
	}
	
	/**
	 * the doubly-linked List data model constructor with the max items
	 * @param maxsize
	 */
	public MyDLL(int maxsize)
	{
		this.maxsize = maxsize;
		this.head = this.tail = null;
	}
	
	@Override
	public int size() 
	{
		return this.size;
	}

	@Override
	public void clear() 
	{
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException 
	{
		MyDLLNode<E> new_node = new MyDLLNode<E>(toAdd);
		
		if( index < 0 || index > size ) { return false; }
		if( toAdd == null ) { return false; }
		if( index == 0 ) {
			new_node.setNext(head);
			head = new_node;
			size++;
		}else if( index == size ) {
			return add( toAdd );
		}else {
			MyDLLNode<E> previousNode = head;
			//Loop until node at index¨C1 (previous) is reached
			for(int i = 0; i < index-1; i++) {
				previousNode = previousNode.getNext();
			}
			MyDLLNode<E> nextNode = previousNode.getNext(); //Get the next of node at index ¨C 1
			previousNode.setNext(new_node); //Set next of previous node to new node
			new_node.setNext(nextNode); //Set next of new node to next node
			size++;
		}
		
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if( toAdd != null ) {
			/* 1. allocate node
		     * 2. put in the data */
			MyDLLNode<E> new_node = new MyDLLNode<E> (toAdd);
			tail = head; /* used in step 5*/
		 
		    /* 3. This new node is going to be the last node, so
		     * make next of it as NULL*/
		    new_node.setNext(null);
		 
		    /* 4. If the Linked List is empty, then make the new
		     * node as head */
		    if (head == null) {
		        new_node.setPrev(null);
		        head = new_node;
		    }else {
		    	/* 5. Else traverse till the last node */
			    while (tail.getNext() != null)
			    	tail = tail.getNext();
			 
			    /* 6. Change the next of last node */
			    tail.setNext(new_node);
			 
			    /* 7. Make last node as previous of new node */
			    new_node.setPrev(tail);
		    }
		    size++;
		    return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		int lenght = toAdd.size();
		boolean isAdd = false;
		
		if( lenght > 0 ) 
		{
			for(int i = 0;i < lenght; i++ ) 
			{
				if( add( toAdd.get(i) ) ) 
				{
					isAdd = true;
				}
				else {
					isAdd = false;
					break;
				}
			}
			return isAdd;
		}else {
			return false;
		}
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException 
	{
		if(index < 0 || index > size) { throw new IndexOutOfBoundsException(); }
		
		if(head==null) 
		{
			return null;
		}else 
		{
			MyDLLNode<E> node = head;
			for( int i = 0; i < index; i++ ) 
			{
				node = node.getNext();
			}
			return node.getElement();
		}
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException 
	{
		E retElem;
		
		if(index < 0 || index > size) { throw new IndexOutOfBoundsException(); }

		MyDLLNode<E> temp = head;
		if(index == 0)
		{
			head = temp.getNext(); // Changed head
			temp.setNext(null); //Set next of node to delete to nothing
			retElem = temp.getElement();
		}
		else
		{
			//Loop until node at index¨C1 (previous) is reached
			for(int i = 0; i < index-1; i++) {
				temp = temp.getNext();
			}
			MyDLLNode<E> toDelNode = temp.getNext(); //Get node next of previous(node to delete) 
			temp.setNext(toDelNode.getNext()); //Set next of previous node to node next of node to delete
			toDelNode.setNext(null); //Set next of node to delete to null
			retElem = toDelNode.getElement();
		}
		
		size--;
		return retElem;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException 
	{
		MyDLLNode<E> current = head;    //Initialize current
        while (current != null)
        {
            if (current.getElement().equals(toRemove))
            {
            	current.getNext().setPrev(current.getPrev());
            	current.getPrev().setNext(current.getNext());
            	size--;
            	return current.getElement();
            }
            current = current.getNext();
        }
        return null;    //data not found
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException 
	{
		E retElem;
		
		if(index < 0 || index > size) { throw new IndexOutOfBoundsException(); }
		
		if(index == 0) 
		{
			retElem = head.getNext().getElement();
			head.getNext().setElement(toChange);
		}
		else 
		{
			MyDLLNode<E> currentNode = this.head;
			//Loop through until node at index (current)
			for(int i = 0; i < index; i++) {
				currentNode = currentNode.getNext(); //Replace old data in current node with new data
			}
			retElem = currentNode.getElement();
			currentNode.setElement(toChange);
		}
		
		return retElem;
	}

	@Override
	public boolean isEmpty() 
	{
		return (head==null && tail==null);
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException 
	{
		MyDLLNode<E> current = head;    //Initialize current
        while (current != null)
        {
            if (current.getElement().equals(toFind))
                return true;    //data found
            current = current.getNext();
        }
        return false;    //data not found
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException 
	{
		MyDLLNode<E> temp = head;
		if (toHold.length < size()) 
		{
	        int currentIndex = 0;
	        while (currentIndex < size) 
	        {
	        	toHold[currentIndex] = temp.getElement();
	            currentIndex++;
	            temp = temp.getNext();
	        }
	    }

	    if (toHold.length > size()) 
	    {
	    	toHold[size] = null;         
	    }

	    for (int i = 0; i < size; i++) 
	    {
	    	toHold[i] = temp.getElement();
	        temp = temp.getNext();
	    }

	    return toHold;
	}

	@Override
	public Object[] toArray() 
	{
		Object[] objs = new Object[size()];
		MyDLLNode<E> temp = head;
		for (int i = 0; i < size; i++) 
	    {
			objs[i] = temp.getElement();
	        temp = temp.getNext();
	    }
		return objs;
	}

	@Override
	public Iterator<E> iterator() 
	{
		this.dllIterator = new DoubleListIterator();
		return this.dllIterator;
	}
	
	@Override
	public boolean hasNext() 
	{
		MyDLLNode<E> current = head;
		return current != null;
	}

	@Override
	public E next() throws NoSuchElementException 
	{
		MyDLLNode<E> current = head;
		
		if (!hasNext()) throw new NoSuchElementException();
	    E tmp = current.getElement();
	    current = current.getNext();  // if next is null, hasNext will return false.
	    return tmp;
	}
	
	/*---------------------INNER CLASS(implement iterator)------------------*/
    private class DoubleListIterator implements Iterator<E> 
    {
    	// instance variable
        private MyDLLNode<E> current = head;

		@Override
		public boolean hasNext() 
		{
			return current != null;
		}

		@Override
		public E next() throws NoSuchElementException 
		{
			if (!hasNext()) throw new NoSuchElementException();
		    E tmp = current.getElement();
		    current = current.getNext();  // if next is null, hasNext will return false.
		    return tmp;
		}
    }
    
}
