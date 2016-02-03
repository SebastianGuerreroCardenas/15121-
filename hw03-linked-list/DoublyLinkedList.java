/**
 * 
 * @author [First Name] [Last Name] <[Andrew ID]>
 * @section [Section Letter]
 * @date [date]
 * 
 * 
 */

import java.util.*;

public class DoublyLinkedList<E> {
	// Do not change these fields.
	public DoubleNode<E> currNode;
	public int numElements;

	public DoublyLinkedList() {
		currNode = null;
		numElements = 0;
	}

	/**
	 * Complete the size method, which returns the number of data values in 
	 * the DoublyLinkedList in O(1) time.
	 */
	public int size() {
		//write your code for the size method here
		return -1; //remove this line when you are done
	}

	/**
	 * Complete the get method, which returns the current data value in 
	 * O(1) time. If the DoublyLinkedList is empty, this method should 
	 * throw a NoSuchElementException.
	 */
	public E get() {
		//write your code for the get method here
		return null; //remove this line when you are done
	}

	/**
	 * Complete the add method, which adds the given element after the 
	 * current data value (if any). After this method executes, currNode 
	 * should refer to the node with the new element, and currNode.prev 
	 * should refer to the node that used to be currNode (if any) in O(1) time.
	 * 
	 */
	public void add(E item) {
		//write your code for the add method here
	}

	/**
	 * Complete the toList method, which should return a List (an instance 
	 * of a class that implements Java's List interface) containing all 
	 * the data values in the DoublyLinkedList, ending with the current 
	 * data value in O(n) time.
	 */
	public List<E> toList() {
		//write your code for the toList method here
		return null; //remove this line when you are done
	}

	/**
	 * Complete the contains method, which returns true if the given element 
	 * appears in the DoublyLinkedList, and returns false otherwise. This 
	 * method must run in worst-case O(n) time and best-case O(1) time.
	 * This method should not remove any elements from the DoublyLinkedList.
	 */
	public boolean contains(E item) {
		//write your code for the contains method here
		return false; //remove this line when you are done
	}

	/**
	 * Complete the scroll method, which should advance currNode forward 
	 * (following "next" references) by the given number of nodes. 
	 * If the given number is negative, then scroll will scroll backward 
	 * (following "prev" references) in the cycle. If the DoublyLinkedList is 
	 * empty, this method should throw a NoSuchElementException. Otherwise, 
	 * this method must run in O(n) time, where n is the absolute value 
	 * of the argument value.
	 */
	public void scroll(Integer n) {
		//write your code for the scroll method here
	}

	/**
	 * Complete the remove method, which removes and returns the current data 
	 * value (if any). After the method has executed, currNode should refer 
	 * to the node before the removed one (if any). Thus, if any nodes remain 
	 * after remove has executed, currNode.next will refer to the node that 
	 * used to be currNode. If the DoublyLinkedList is empty (and therefore 
	 * there is no element to remove), then remove should throw a 
	 * NoSuchElementException. Otherwise this method must run in O(1) time.
	 */
	public E remove() {
		//write your code for the remove method here
		return null; //remove this line when you are done
	}
}
