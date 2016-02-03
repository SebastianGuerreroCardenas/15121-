/**
 * 
 * @author [First Name] [Last Name] <[Andrew ID]>
 * @setion [Section Letter]
 * @date [date]
 *    
 */

import java.util.*;

public class TwoStackQueue<E> implements MyQueue<E> {

	private MyStack<E> out;
	private MyStack<E> in;

	public TwoStackQueue() {

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
	 * Adds the specified element to the end of the queue.
	 * 
	 * @param The
	 *          element to add on to the end of the queue.
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
		//write your code for dequeue here
		return null; // remove this line when you are done
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
		//write your code for peek here
		return null; // remove this line when you are done
	}

	/**
	 * Returns a String representation of this queue. If the queue will dequeue
	 * values 5 7 8 in that order, and the out stack contains one value, the
	 * string will have following format.
	 * 
	 * front [ 5 | 7 8 ] back
	 * 
	 */
	public String toString() {
		//write your code for toString here
		return null; // remove this line when you are done
	}

}
