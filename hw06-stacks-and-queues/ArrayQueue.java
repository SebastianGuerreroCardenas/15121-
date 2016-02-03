/**
 * 
 * @author [First Name] [Last Name] <Andrew ID>
 * @section [Section Letter]
 * 
 */

import java.util.*;

public class ArrayQueue<E> implements MyQueue<E> {

	private E[] dataArray;
	private int front; //index of first item to remove
	private int back;  //index of last item to remove
	private int numOfElements; // for convenience

	public ArrayQueue() {

	}

	/**
	 * Returns true if this queue no elements.
	 * 
	 * @return true if this queue is empty, false otherwise.
	 * 
	 */
	public boolean isEmpty() {
		//write your code for isEmpty here
		return false; // remove this line when you are done
	}
	
	

	/**
	 * Returns, but does not remove, the element at the front of this queue.
	 * 
	 * @return The element at the front of this queue.
	 * @throws NoSuchElementException
	 *           if the queue is empty.
	 *           
	 */
	public E peek() {
		// write your code for peek here
		return null; // remove this line when you are done
	}
	
	
	/**
	 * Adds the specified element to the back of this queue.
	 * 
	 * @param element
	 *          to add on to the back of this queue.
	 *          
	 */
	public void enqueue(E element) {
		//write your code for enqueue here
	}
	
	

	/**
	 * Removes and returns the element at the front of this queue.
	 * 
	 * @return The element removed from the front of this queue.
	 * @throws NoSuchElementException
	 *           if the queue is empty.
	 *           
	 */
	public E dequeue() {
		// write your code for dequeue here
		return null; // remove this line when you are done
	}


	/**
	 * Returns a String representation of this queue in the format described in
	 * the writeup
	 * 
	 */
	public String toString() {
		// write your code for toString here
		return null; // remove this line when you are done
	}

}
