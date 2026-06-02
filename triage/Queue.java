// Benjamin Laughton
// CIS 2353
// Fall 2025
// Prof. Noah Clark

package triage;

import java.util.LinkedList;

/**
 * LinkedList Queue implementation
 */
public class Queue<T> {
    private LinkedList<T> list;
    
    public Queue() {
        list = new LinkedList<>();
    }
    
    /**
     * adds an element to the back of the queue
     */
    public void enqueue(T item) {
        list.addLast(item);
    }
    
    /**
     * removes and returns the element at the front of the queue
     */
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }
    
    /**
     * returns true if the queue is empty
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    /**
     * returns the number of elements in the queue
     */
    public int size() {
        return list.size();
    }
    
    /**
     * returns the front element without removing it
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return list.getFirst();
    }
}