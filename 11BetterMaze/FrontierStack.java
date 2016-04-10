import java.util.*;

public class FrontierStack<T> implements Frontier<T>{
    private Stack<T> frontier;

    public FrontierStack() {
	frontier = new Stack<>();
    }

    public void add(T element){
	frontier.push(element);
    }

    public T next(){
	return frontier.pop();
    }

    public boolean hasNext(){
	try {
	    frontier.peek();
	    return true;
	}
	catch (NoSuchElementException e) {
	    return false;
	}
    }
}