/**
 * 
 * @author Sebastian Guerrero <sguerrer>
 * @section A
 * 
 */

import java.util.*;

public class ArrayQueue<E> implements MyQueue<E> {

	private E[] dataArray;
	private int front; //index of first item to remove
	private int back;  //index of last item to remove
	private int numOfElements; // for convenience
	private int MAX_AMOUNT = 10;

	public ArrayQueue() {
		front = 0;
		numOfElements = 0;
		back = MAX_AMOUNT - 1;
		dataArray = (E[])new Object[MAX_AMOUNT];

	}

	/**
	 * Returns true if this queue no elements.
	 * 
	 * @return true if this queue is empty, false otherwise.
	 * 
	 */
	public boolean isEmpty() {
		return numOfElements == 0;
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
		return dataArray[front];
	}
	
	
	/**
	 * Adds the specified element to the back of this queue.
	 * 
	 * @param element
	 *          to add on to the back of this queue.
	 *          
	 */
	public void enqueue(E element) {
		if (isFull()) {
			resize();
		}
		numOfElements++;
		back = (back + 1) % (MAX_AMOUNT);
		dataArray[back] = element;
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
		if (!isEmpty()) {
			E frontValue = dataArray[front];
			front = (front+1) % MAX_AMOUNT;
			numOfElements--;
			return frontValue;
		}
		else {
			throw new NoSuchElementException();
		}
	}


	/**
	 * Returns a String representation of this queue in the format described in
	 * the writeup
	 * 
	 */
	public String toString() {
		StringBuffer printedV = new StringBuffer("front: ");
		printedV.append(front);
		printedV.append(" back: ");
		printedV.append(back);
		printedV.append("\nfront [ ");
		for (int i = 0;i < MAX_AMOUNT; i++) {
			E newValue = dataArray[(front + i) % (MAX_AMOUNT)];
			if (newValue == null) {
				
			}
			else {
				printedV.append(dataArray[(front + i) % (MAX_AMOUNT)]);
				printedV.append(" ");
			}
		}
		printedV.append("] back");
		return printedV.toString();
	}

	public boolean isFull() {
		return numOfElements == MAX_AMOUNT; 
	}
	
	private void resize() {
		int newSize = 2* dataArray.length;
		E[] Atemp = (E[]) new Object[newSize];
		for (int i = 0;i < MAX_AMOUNT; i++) {
			E newValue = dataArray[(front + i) % (MAX_AMOUNT)];
			Atemp[i] = newValue;
		}
		front = 0;
		back = MAX_AMOUNT -1;
		MAX_AMOUNT = newSize;
		dataArray = Atemp;
	}
	
}
