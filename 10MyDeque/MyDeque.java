import java.util.*;

public class MyDeque<T> {

    private T [] data;
    private int start;
    private int end;
    private int size;

    @SuppressWarnings("unchecked")
    public MyDeque() {
        data = (T[]) new Object[10];
	start = 0;
	end = 0;
 	size = 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
	T [] bigger = (T[])new Object[data.length*2];
	int arrayPlace = start;
	
	for (int i = 0; i < data.length; i++) {
	    bigger[i] = data[arrayPlace];
	    if (arrayPlace == data.length-1) {
		arrayPlace = 0;
	    }
	    else {
		arrayPlace++;
	    }
	}
	start = 0;
	end = data.length-1;
	data = bigger;
    }

    void addFirst(T value) {
	if (isFull()) {
	    resize();
	}
	if (size == 0) {	    
	    data[0] = value;
	}
	else {
	    if (start == 0) {
		start = data.length-1;
	    }
	    else {
		start--;
	    }
	    data[start] = value;
	}
	size++;
    }

    void addLast(T value) {
	if (isFull()) {
	    resize();
	}
	if (size == 0) {
	    data[0] = value;
	}
        else {
	    if (end == data.length-1) {
		end = 0;
	    }
	    else {
		end++;
	    }
	    data[end] = value;
	}
	size++;
    }
 
    T removeFirst()  {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	T tmp = data[start];
	data[start] = null;
	size--;
	if (start == data.length-1) {
	    start = 0;
	}
	else {
	    start++;
	}
	return tmp;
    }

    T removeLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	T tmp = data[end];
	data[end] = null;
	size--;
	if (end == 0) {
	    end = data.length-1;
	}
	else {
	    end--;
	}
	return tmp;
    } 

    T getFirst() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return data[start];
    }

    T getLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return data[end];
    }

    public boolean isFull() {
	return size == data.length;
    }

    public String toString(){
	String ans = "[";
	for(int i = 0; i < size; i ++){
		if (i == size-1) {
			ans += data[i];
	   	 }else {
		ans += data[i] + ", ";
	}

	}
	ans+="]" + "   size:" + size + "   start:"+start+"   end:" + end;
	return ans;
    }

    public static void main(String[]args) {
	MyDeque<Integer> d = new MyDeque<>();
	d.addFirst(3);  //3
	d.addFirst(4);  //4,3
	System.out.println(d.getFirst());
	d.addLast(1);   //4,3,1
	System.out.println(d.getLast());
	d.addLast(6);  //4,3,1,6
	System.out.println(d.getLast());
	d.addFirst(9);  //9,4,3,1,6
	d.addLast(54);  //9,4,3,1,6,54
	d.addLast(5);  //9,4,3,1,6,54,5
	d.addFirst(90);  //90,9,4,3,1,6,54,5,10,44,34
	d.removeLast();  //90,9,4,3,1,6,54,5,10,44
	d.removeFirst();  //9,4,3,1,6,54,5,10,44
	
	//d.addLast(58);  //9,4,3,1,6,54,5,10,44,34,58
	System.out.println(d);
	
    }

}