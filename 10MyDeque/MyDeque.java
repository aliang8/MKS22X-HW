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
    private void grow() {
	T [] temp = (T[])new Object[data.length*2];
	int index = start;
	
	for (int i = 0; i < data.length; i++) {
	    temp[i] = data[index];
	    if (index == data.length-1) {
		index = 0;
	    }
	    else {
		index++;
	    }
	}
	start = 0;
	end = data.length-1;
	data = temp;
    }

    //When the array is full, re-size, then add.
    //No exceptions are required since you will re-size.
    public void addFirst(T value){
        if(isFull()){
            grow();
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

    public void addLast(T value){
        if(isFull()){
            grow();
        }
        if(end==data.length-1 || data[end]==null){
            end=0;
        }else{
            end++;
        }
        data[end]=value;
        size++;
    }

    //NoSuchElementException is thrown when there are no elements.
    public T removeFirst(){
        if(size == 0){
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
    public T removeLast(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        T ans = data[end];
        data[end]=null;
        if(end==0){
            end = data.length-1;
        }else{
            end--;
        }
        size--;
        return data[end];
    }
    public boolean isFull() {
	return size == data.length;
    }
    //NoSuchElementException is thrown when there are no elements.
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

    public String toString(){
        String ans="[ ";
        for(int i=0; i<data.length-1; i++){
            ans+=data[i]+", ";
        }
        ans+=data[data.length-1]+"]" + "   size:" + size+ "   start:"+start+"   end:" + end;
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