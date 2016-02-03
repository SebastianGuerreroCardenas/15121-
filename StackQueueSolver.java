/**
 * 
 * @author Sebastian Guerrero <sguerrer>
 * @section A
 * @date 10/20/15
 *
 */

public class StackQueueSolver {
	//worst case is O(n*m) where n is the size fo the array, and m is the int of numtoback
	public static int lastCustomer(int numPersons, int numToBack) {
		MyQueue<Integer> line = new ArrayQueue(); 
		for (int i = 1; i<= numPersons; i++) {
			line.enqueue(i);
		}
		int lastC = numPersons;
		while (!line.isEmpty()) {
			for(int i = 0; i<numToBack;i++) {
				line.enqueue(line.dequeue());
			}
			lastC = line.dequeue();
		}
		return lastC;
	}
	// Worst case Runtime is O(n)
	// Runtime O(n)
	public static boolean areEqual(MyStack<String> stack1, MyStack<String> stack2) {
		MyStack<String> storage = new ArrayStack<String>();
		while(!stack1.isEmpty()) {
			if (!stack2.isEmpty()) {
				if (stack1.peek() == stack2.peek()) {
					storage.push(stack1.pop());
					stack2.pop();
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		while(!storage.isEmpty()) {
			stack1.push(storage.peek());
			stack2.push(storage.pop());
		}
		return true; 
	}
	//Worst case Runtime is O(n)
	// Runtime O(n)
	public static MyStack<Integer> duplicateStack(MyStack<Integer> original) {
		MyQueue<Integer> storage = new ArrayQueue<Integer>(); 
		MyStack<Integer> copy = new ArrayStack<Integer>();
		while(!original.isEmpty()) {
			copy.push(original.pop());
		}
		while(!copy.isEmpty()) {
			storage.enqueue(copy.pop());
		}
		while(!storage.isEmpty()) {
			original.push(storage.peek());
			copy.push(storage.dequeue());
		}
		return copy;
	}
}