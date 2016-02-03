/**
 * 
 * @author [First Name] [Last Name] <Andrew ID>
 * @section [Section Letter]
 * @date [date]
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
		
	}

	/**
	 * Determines if the stack is empty or not.
	 * 
	 * @return true if the stack is empty or false otherwise
	 * 
	 */
	public boolean isEmpty() {
		//write your code for isEmpty here
		return false; // remove this line when you are done
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
		//write your code for peek here
		return null; // remove this line when you are done
	}
	

	/**
	 * Pushes the given element on this stack
	 * 
	 * @param element
	 *          The element of type E to push on the stack.
	 *          
	 */
	public void push(E element) {
		//write your code for push here
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
		//write your code for pop here
		return null; // remove this line when you are done
	}

	/**
	 * Returns a String representation of the stack in the following format top [
	 * 3 5 ] bottom
	 * 
	 */
	public String toString() {
		// write your code for toString here
		return null; // remove this line when you are done
	}

}
