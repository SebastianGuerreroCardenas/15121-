/**
 * 
 * @author Sebastian Guerrero <sguerrer>
 * @section A
 * @date 10/20/15
 *
 */

import java.util.*;

public class ArrayStack<E> implements MyStack<E> {

	private E[] dataArray;
	private int top;

	/**
	 * Creates an empty stack.
	 * 
	 */
	public ArrayStack() {
		dataArray = (E[])new Object[10];
		top = -1;
	}

	/**
	 * Determines if the stack is empty or not.
	 * 
	 * @return true if the stack is empty or false otherwise
	 * 
	 */
	public boolean isEmpty() {
		return (top == -1); 
	}
	
	/**
	 * Returns but does not remove the top element of the stack if the stack is
	 * not empty.
	 * 
	 * @return The top element of the stack
	 * @throws NoSuchElementException
	 *           if the stack is empty
	 *           
	 */
	public E peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		else{
			return dataArray[top];
		}
	}
	

	/**
	 * Pushes the given element on this stack
	 * 
	 * @param element
	 *          The element of type E to push on the stack.
	 *          
	 */
	public void push(E element) {
		top++;
		if (top == dataArray.length - 1){
			resize();
		}
		dataArray[top] = element;
	}

	

	/**
	 * Returns and removes the top element of the stack if the stack is not empty.
	 * 
	 * @return The top element of the stack
	 * @throws NoSuchElementException
	 *           if the stack is empty
	 *           
	 */
	public E pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		else{
			return dataArray[top--];
		}
	}

	/**
	 * Returns a String representation of the stack in the following format top [
	 * 3 5 ] bottom
	 * 
	 */
	public String toString() {
		StringBuffer printedV = new StringBuffer("top [ ");
		for (E e : dataArray) {
			if (e == null) {
				
			}
			else {
				printedV.append(e);
				printedV.append(" ");
			}
		}
		printedV.append("] bottom");
		return printedV.toString(); 
	}
	
	private void resize() {
		E[] Atemp = (E[]) new Object[2* dataArray.length];
		System.arraycopy(dataArray,0,Atemp,0,dataArray.length);
		dataArray = Atemp;
	}
	

}
