import java.util.*;

public class MyStack<T> {

    private MyLinkedList<T> stack = new MyLinkedList<T>();
    private int size;

    public MyStack() {
    }
    
    /**
     * Adds the given item to the top of the stack.
     */
    void push(T item) {
	stack.add(0,item);
    }

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T pop() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	T thing=stack.get(0);
	stack.remove(0);
	return thing;
    }

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T peek() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return stack.get(0);
    }

    /**
     * Returns the number of items currently in the stack.
     */
    int size() {
	return stack.size();
    }

    /**
     * Returns whether the stack is empty or not.
     */
    boolean isEmpty() {
	return stack.size() == 0;
    }
    public static void main(String[]args){
        MyStack<Integer> myStack = new MyStack<Integer>();
	Stack<Integer> stack = new Stack<Integer>();

	for(int i=0; i<1000000; i++){
	    myStack.push(i);
	    stack.push(i);
	}
	
	boolean match=true;
	while(!myStack.isEmpty()){
	    if(! myStack.peek().equals( stack.peek() ) ){
		match = false;
	    }
	    if(! myStack.pop().equals( stack.pop() ) ){
		match = false;
	    }
	}
	System.out.println(match);
    }
}
