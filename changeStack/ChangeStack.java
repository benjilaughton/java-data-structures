// Benjamin Laughton
// Project 3
// CIS 2353

package proj3;

/**
 * a stack-like data structure implemented using a linked chain of nodes
 * that supports increment and decrement operations on bottom k elements.
 */
public class ChangeStack {
    private Node top;
    private int numElements;
    
    /**
     * inner class representing a node in the linked chain
     */
    private class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    /**
     * constructor - initializes an empty stack
     */
    public ChangeStack() {
        this.numElements = 0;
        this.top = null;
    }
    
    /**
     * adds a new element to the top of the stack
     * @param item the integer value to add
     */
    public void push(int item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
        numElements++;
    }
    
    /**
     * removes and returns the top element from the stack
     * @return the integer value at the top of the stack
     * @throws StackEmptyException if the stack is empty
     */
    public int pop() {
        if (top == null) {
            throw new StackEmptyException("Cannot pop from an empty stack");
        }
        
        int value = top.data;
        top = top.next;
        numElements--;
        return value;
    }
    
    /**
     * returns the value at the top of the stack without removing it
     * @return the integer value at the top of the stack
     * @throws StackEmptyException if the stack is empty
     */
    public int peekTop() {
        if (top == null) {
            throw new StackEmptyException("Cannot peek at an empty stack");
        }
        
        return top.data;
    }
    
    /**
     * increases the bottom k elements in the stack by the given amount
     * @param k the number of bottom elements to increase
     * @param amount the amount to increase each element by
     */
    public void increaseValues(int k, int amount) {
        if (numElements == 0) {
            return; // do nothing if stack is empty
        }
        
        // determine how many elements to actually modify
        int elementsToModify = Math.min(k, numElements);
        
        // navigate to the bottom k elements and modify them
        modifyBottomK(elementsToModify, amount);
    }
    
    /**
     * decreases the bottom k elements in the stack by the given amount
     * @param k the number of bottom elements to decrease
     * @param amount the amount to decrease each element by
     */
    public void decreaseValues(int k, int amount) {
        if (numElements == 0) {
            return; // do nothing if stack is empty
        }
        
        // determine how many elements to actually modify
        int elementsToModify = Math.min(k, numElements);
        
        // navigate to the bottom k elements and modify them
        modifyBottomK(elementsToModify, -amount);
    }
    
    /**
     * helper method to modify the bottom k elements
     * @param k the number of bottom elements to modify
     * @param change the amount to change (positive or negative)
     */
    private void modifyBottomK(int k, int change) {
        // calculate which position to start modifying from
        // (numElements - k) positions from the top
        int startPosition = numElements - k;
        
        Node current = top;
        int position = 0;
        
        // traverse to the starting position
        while (current != null) {
            if (position >= startPosition) {
                current.data += change;
            }
            current = current.next;
            position++;
        }
    }
    
    /**
     * returns the number of elements in the stack
     * @return the number of elements
     */
    public int size() {
        return numElements;
    }
    
    /**
     * checks if the stack is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return numElements == 0;
    }
    
    /**
     * returns a string representation of the stack (for testing)
     * @return string showing stack contents from top to bottom
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack is empty";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Stack (top to bottom): ");
        Node current = top;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }
}