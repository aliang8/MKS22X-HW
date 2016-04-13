import java.util.*;

public class FrontierQueue<T> implements Frontier<T>{
    private Queue<T> frontier;

    public FrontierQueue() {
	frontier = new LinkedList<>();
    }


    public void add(T element) {
	frontier.add(element);
    }

    public T next() {
        if (hasNext()) {
	    return frontier.peek();
	}
	else {
	    return null;
	}
    }

    public boolean hasNext() {
        try {
	    frontier.peek();
	    return true;
	}
	catch (NoSuchElementException e) {
	    return false;
	}
    }


    public T remove() {
	return frontier.remove();
    }
    
}