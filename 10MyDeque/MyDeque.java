import java.util.*;

public class MyDeque<T>{
    T[] data;
    int start,end;
    int size;

    @SuppressWarnings("unchecked")
    public MyDeque(){
        data = (T[]) new Object[10];
	size = 0;
	start = 0;
	end = 0;
    }

    @SuppressWarnings("unchecked")
    //You need a private method to grow the array and copy over the values.
     private void grow(){
        T[] copy = (T[]) new Object[data.length*2];
        int counter1 = 0;
        int counter2 = start;
        while(counter1 < data.length){
            if(counter2 == data.length){
                counter2 = 0;
            }
            copy[counter1] = data[counter2];
            counter1++;
            counter2++;
        }
        start=0;
        end = counter1 - 1;
        data = copy;
    }

    //When the array is full, re-size, then add.
    //No exceptions are required since you will re-size.
    public void addFirst(T value){
        if(isFull()){
            grow();
        } if (size == 0) {	    
	    data[0] = value;
	} else {
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

    public void addLast(T value){
        if(isFull()){
            grow();
        } if (end == data.length - 1 || data[end] == null){
            end = 0;
        } else { 
            end++;
        }
        data[end] = value;
        size++;
    }

    //NoSuchElementException is thrown when there are no elements.
    public T removeFirst(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        T temp = data[start];
        data[start] = null;
        if(start == data.length-1){
            start=0;
        } else {
            start++;
        }
        size--;
        return temp;
    }

    public T removeLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	T tmp = data[end];
	data[end] = null;
	size--;
	if (end == 0) {
	    end = data.length-1;
	}else {
	    end--;
	}
	return tmp;
    } 
    public boolean isFull() {
	return size == data.length;
    }

    public T getFirst(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        return data[start];
    }

    public T getLast(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        return data[end];
    }

    public int size() {
	return size;
    }

    public String toString(){
        String ans = "[ ";
        for(int i = 0; i < data.length - 1; i++){
            ans += data[i] + ", ";
        }
        ans += data[data.length - 1] + "]" + "   size:" + size + "   start:" + start + "   end:" + end;
        return ans;
    }
    
    public static void main(String[]args) {
	MyDeque<Integer> d = new MyDeque<>();
	d.addFirst(6);  //6
	d.addFirst(3);  //3,6
	System.out.println(d.getFirst());
	d.addLast(21);  //3,6,21
	System.out.println(d.getLast());
	d.addFirst(9);  //9,3,6,21
	d.addLast(24);  //9,3,6,21,24
	d.addLast(5);  //9,3,6,21,24,5
	d.addFirst(14);  //14,9,3,6,21,24,5
	d.removeLast();  //14,9,3,6,21,24
	d.removeFirst();  //9,3,6,21,24,5
	System.out.println(d);
	
    }

}
