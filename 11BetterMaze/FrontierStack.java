import java.util.*;

public class FrontierStack<T> implements Frontier<T>{
    private Stack<T> frontier;

    public FrontierStack() {
	frontier = new Stack<>();
    }

    public void add(T element){
	frontier.push(element);
    }

    public T next() {
	if (hasNext()) {
	    return frontier.peek();
	}
	else {
	    return null;
	}
    }

    public boolean hasNext(){
	return !frontier.empty();
    }

    public T remove(){
	return frontier.pop();
    }
}