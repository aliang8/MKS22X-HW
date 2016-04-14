import java.util.*;

public class FrontierQueue<T> implements Frontier<T>{
    private ArrayDeque<T> frontier;

    public FrontierQueue() {
	frontier = new ArrayDeque<T>();
    }


    public void add(T element) {
	frontier.addLast(element);
    }

    public T next() {
        if (hasNext()) {
	    return frontier.removeFirst();
	}
	else {
	    throw new NoSuchElementException();
	}
    }

    public boolean hasNext() {
        return !frontier.isEmpty();
    }
}