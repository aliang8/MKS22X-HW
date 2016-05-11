import java.util.*;

public class RunningMedian{
    private MyHeap<Integer> min;
    private MyHeap<Integer> max;
    private double median;

    public RunningMedian(){
	min=new MyHeap<Integer>();
	max=new MyHeap<Integer>(false);
    }

    public double getMedian(){
	if(min.size() == 0 && max.size() == 0){
	    throw new NoSuchElementException();
	}
	if (min.size() == max.size()){
	    return (min.peek() + max.peek()) / 2.0;
	}else if (min.size() > max.size()){
	    return min.peek();
	}else{
	    return max.peek();
	}
    }

     public void add(Integer x) {
	if (min.size() == 0 && max.size() == 0) {
	    min.add(x);
	    median = x;
	} else {
	    if (x < median) {
		min.add(x);
	    } else {
		max.add(x);
	    }
	    while (min.size() - max.size() > 1) {
		max.add(min.delete());
	    }
	    while (max.size() - min.size() > 1) {
		min.add(max.delete());
	    }
	    getMedian();
	}
    }

    public static void main(String[]args){
	RunningMedian r = new RunningMedian();
	r.add(34);
	System.out.println(r.getMedian());
	r.add(2);
	System.out.println(r.getMedian());
	r.add(8);
	System.out.println(r.getMedian());
	r.add(2);
	System.out.println(r.getMedian());
	r.add(15);
	System.out.println(r.getMedian());
	r.add(0);
	System.out.println(r.getMedian());
	r.add(12);
	System.out.println(r.getMedian());
    }
}

