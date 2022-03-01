package sait.parser.contracts;

/**
 * Class Definition: This interface represents the public contract for the Stack Abstract Data Type. 
 */
public interface StackADT<E> 
{	
	
	/** 
	* Add an element to the top of a stack
	* 
	* Precondition:
	* 
	* Postcondition:
	* 
	* @param e
	* @return
	*/	
	public boolean push(E e);
	
	/** 
	* Remove the topmost element from a stack 
	* 
	* Precondition:
	* 
	* Postcondition:
	* 
	* @return
	*/	
	public E pop();
	
	/** 
	* Retrieve the topmost element in a stack without removing it
	* 
	* Precondition:
	* 
	* Postcondition:
	* 
	* @return
	*/	
	public E peek();
	
}
