/**
 * 
 * @author [First Name] [Last Name] <[Andrew ID]>
 * @section [Section Letter]
 * @date [date]
 * 
 * 
 */

// You may not import any additional classes or packages

import java.util.ArrayList;

public class SinglyLinkedList {

	private int numElements;
	public SingleNode head;
	
	public SinglyLinkedList() {
		numElements = 0;
		head = null;
	}
	
	/**
	 * The add method creates a SingleNode given data and inserts 
     * it at the beginning of the SinglyLinkedList.
     *
     * Do not change this method!
	 */
	public void add(String newData) {
		SingleNode node = new SingleNode(newData);
		node.next = head;
		head = node;
		numElements++;
	}
	
	/**
     * Do not change this method!
	 */
	public int size() {
		return numElements;
	}
	
	/**
	 * Complete the concatenate method which combines the data attributes 
	 * from all SingleNodes in the SinglyLinkedList. Beginning with the head, 
	 * combine all the data together in order into one string. Return an empty 
	 * string if the list is empty.
	 */
	public String concatenate() {
		return null; // remove this line when you implement this method
	}
	
	/**
	 * Complete the insertAfter method which searches through the SingleNodes 
	 * in the SinglyLinkedList for the findData parameter. At the first 
	 * occurrence of findData, it should create a new SingleNode with the 
	 * given insertData and insert that directly after the node with findData. 
	 * If there are multiple occurrences of findData, only the closest to the 
	 * front of the SinglyLinkedList should be used. If there are no 
	 * occurrences of findData, the SinglyLinkedList should remain unchanged.
	 */
	public void insertAfter(String insertData, String findData) {
	}
	
	/**
	 * Complete the buildList method which constructs a SinglyLinkedList from 
	 * the given ArrayList parameter. The SinglyLinkedList's data must be in 
	 * the same order as the original ArrayList. This method should do nothing 
	 * if ArrayList is empty. 
	 * 
	 * NOTE: You MUST use the add method defined for you.
	 */
	public void buildList(ArrayList<String> arrayList) {
	}
	
	/**
	 * Complete the equals method. Two LinkedLists are considered "equal" 
	 * if they contain all the same SingleNodes (i.e. not literally the some 
	 * node objects, but nodes with the same data), in the same order. The 
	 * following is the algorithm you should use to implement this method. 
	 * 
	 * NOTE: If you use a different algorithm, you will NOT receive credit.
     *
     * 1. Compare the sizes of the 2 lists using the size method provided 
     * for you. If two lists are not the same size, there is no way 
     * they can be equal.
     * 2. If the lists are the same length, we can check each individual 
     * SingleNode and compare it against the SingleNode in the same relative 
     * position in the other list.
     * 3. If any two Nodes differ, this method should return false.
     * 4. Once you have checked every Node, this method should return true.
	 */
	public boolean equals(SinglyLinkedList otherList) {
		return true; // remove this line when you implement this method
	}
	
	/**
	 * Complete the bringToFront method which takes an index as a parameter. 
	 * The SingleNode at that index is moved to the front (i.e. made the 
	 * first item) in the SinglyLinkedList. The rest of the SingleNodes 
	 * should remain in their same relative positions.
	 * If the given index is larger or equal than the number of Nodes in the 
	 * SinglyLinkedList, this method should do nothing. You may assume that 
	 * index will be greater than or equal to zero.
	 */
	public void bringToFront(int index) {
	}
	
	/**
	 * Complete the removeAll method which removes all SingleNodes from the 
	 * SinglyLinkedList whose data exactly match the given length parameter. 
	 * If more than one occurrence of a SingleNode's String of length length 
	 * exist in the SinglyLinkedList, all occurrences of should be removed. 
	 * If there are no strings of length length, this method should not 
	 * change the list.
	 */
	public void removeAll(int length) {
	}
	
	/**
	 * Complete the reverse method which reverses the order of all the Nodes 
	 * in the LinkedList in place. 
	 * 
	 * NOTE: You may not create another LinkedList or any other data structure.
	 */
	public void reverse() {
	}
	
	/**
	 * Pretty print SinglyLinkedLists.
     *
     * Do not modify this method!
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		if(head == null) {
			sb.append("[HEAD] -> null -> [TAIL]");
		} else {
			SingleNode nodeRef = head;
			sb.append("[HEAD] -> ");
			while(nodeRef != null) {
				sb.append(nodeRef.data);
				sb.append(" -> ");
				nodeRef = nodeRef.next;
			}
			sb.append("[TAIL]");
		}
		
		return sb.toString();
	}
}
