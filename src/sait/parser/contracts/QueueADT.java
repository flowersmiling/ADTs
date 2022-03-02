package sait.parser.contracts;

public interface QueueADT <E>{
	
	
	public void enqueue (E e);
	// Removes and returns the element at the front of the queue
    //Precondition:
	 
	//Postcondition:
	
	
	public E dequeue();
	// Returns without removing the element at the front of the queue
	//Precondition:
	 
	//Postcondition:
	
	
	public E first();
	// Returns true if the queue contains no elements
	//Precondition:
	 
	//Postcondition:
	
	public boolean isEmpty();
	// Returns the number of elements in the queue
	//Precondition:
	 
	//Postcondition:
	
	public int size();
	// Returns a string representation of the queue
	//Precondition:
	 
	//Postcondition:
	
	
	public String toString();

}
	

