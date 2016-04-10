import java.util.*;

public class FrontierQueue<T> implements Frontier<T>{
    private Queue<T> frontier;

    public FrontierQueue() {
	frontier = new LinkedList<>();
    }

    public void add(T element){
	frontier.add(element);
    }

    public T next(){
	return frontier.peek();
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