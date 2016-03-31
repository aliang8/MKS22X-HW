import java.util.*;

public class MyQueue<T> {
    /**
     * Adds the given item to the rear of the queue.
     */

    private MyLinkedList<T> queue;
    
    public MyQueue() {
	queue = new MyLinkedList<T>();
    }

    /**
     * Adds the given item to the rear of the queue.
     */
    void enqueue(T item) {
	queue.add(item);
    }

    /**
     * Removes the front item from the queue and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T dequeue() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return queue.remove(0);
    }

    /**
     * Returns the front item from the queue without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T peek() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return queue.get(0);
    }

    /**
     * Returns the number of items currently in the queue.
     */
    int size() {
	return queue.size();
    }

    /**
     * Returns whether the queue is empty or not.
     */
    boolean isEmpty() {
	return queue.size == 0;
    }

    public static void main(String[]args){
	MyQueue<Integer> mine = new MyQueue<Integer>();
	//Queue<Integer> its = new Queue<Integer>();

	for(int i=0; i<1000000; i++){
	    mine.enqueue(i);
	    //its.enqueue(i);
	}
	
	boolean match=true;
	for(int i=0; i<1000000; i++){
	    if(mine.dequeue()!= i){
		match = false;
	    }
	}
	System.out.println(match);
    }    
}

