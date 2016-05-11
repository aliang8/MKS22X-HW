import java.util.*
public class RunningMedian{
    MyHeap<Integer> minHeap= new MyHeap<>(false);
    MyHeap<Integer> maxHeap= new MyHeap<>(true);
    double median;
    public RunningMedian(){			 
    }
	
    public double getMedian(){
	if (minHeap.size() == 0 && maxHeap.size() == 0){
	    throw new NoSuchElementException;
	} else if (!median == null){
	    return median;
	} else {
	    return (minHeap.peek() + maxHeap.peek()) / 2;
	}
    }
			   
    public void add(Integer x){
	if (x < median){
	    minHeap.add(x);
	} else {
	    maxHeap.add(x);
	}
    }
}


