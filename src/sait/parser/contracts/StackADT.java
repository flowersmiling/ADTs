package sait.parser.contracts;

public interface StackADT<E> 
{
	//public void stack();
	
	public boolean push(E e);
	
	public E pop();
	
	public E peek();
	
}
