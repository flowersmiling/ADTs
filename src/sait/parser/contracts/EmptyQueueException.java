package sait.parser.contracts;

@SuppressWarnings("serial")
public class EmptyQueueException extends Exception
{
	/** 
	* define an empty queue exception
	* 
	* Precondition: exception package and class must be imported
	* 
	* Postcondition: throw an empty Queue Exception with queue is empty
	* 
	*/
	public EmptyQueueException() 
	{
		super();
    }
	
	/**
	 * @param message error message specific to cause of error.
	 */
	public EmptyQueueException(String message) 
	{
		super(message);
	}
}
