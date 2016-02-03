/**
 * 
 * @author Sebastian Guerrero <sguerrer>
 * @section A
 * @date 10/20/15
 *
 */

import java.util.*;

public class TwoStackQueue<E> implements MyQueue<E> {

	private MyStack<E> out;
	private MyStack<E> in;

	public TwoStackQueue() {
		out = new ArrayStack<E>();
		in = new ArrayStack<E>();
	}

	/**
	 * Returns true if this queue no elements.
	 * 
	 * @return true if this queue is empty, false otherwise.
	 * 
	 */
	public boolean isEmpty() {
		return out.isEmpty() && in.isEmpty(); 
	}

	/**
	 * Adds the specified element to the end of the queue.
	 * 
	 * @param The
	 *          element to add on to the end of the queue.
	 *          
	 */
	public void enqueue(E element) {
		
		in.push(element);
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
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		if (out.isEmpty()){
			moveElements();
		}
		return out.pop();
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
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		if (out.isEmpty()){
			moveElements();
		}
		return out.peek();
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
		MyStack<E> storage = new ArrayStack<E>();
		StringBuffer printedV = new StringBuffer("front [ ");
		while (!out.isEmpty()) {
			printedV.append(out.peek());
			storage.push(out.pop());
			printedV.append(" ");
		}
		printedV.append("| ");
		while (!storage.isEmpty()) {
			out.push(storage.pop());
		}
		while (!in.isEmpty()) {
			storage.push(in.pop());
		}
		while (!storage.isEmpty()) {
			printedV.append(storage.peek());
			in.push(storage.pop());
			printedV.append(" ");
		}
		printedV.append("] back");
		return printedV.toString(); 
	}
	

	private void moveElements() {
		while(!in.isEmpty()) {
			out.push(in.pop());
		}
	}
}
