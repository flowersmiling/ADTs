package sait.parser.models;

public class MyDLLNode<E>
{
	private E element;
	private MyDLLNode<E> prev,next;
	
	public MyDLLNode(E element) {
		super();
		this.element = element;
	}

	public MyDLLNode(E elem, MyDLLNode<E> prev, MyDLLNode<E> next)
	{
		this.element = elem;
		this.prev = prev;
		this.next = next;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public MyDLLNode<E> getPrev() {
		return prev;
	}

	public void setPrev(MyDLLNode<E> prev) {
		this.prev = prev;
	}

	public MyDLLNode<E> getNext() {
		return next;
	}

	public void setNext(MyDLLNode<E> next) {
		this.next = next;
	}
	
}
