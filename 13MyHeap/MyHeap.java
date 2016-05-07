import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
   private int size;
   private boolean isMax;
   private T[] data;

   public MyHeap(){
	data = (T[])new Comparable[10];
	isMax = true;
	size = 0; 
   }
   public MyHeap(boolean max){
	data = (T[])new Comparable[10];
	isMax = max;
	size = 0;
    }
   public MyHeap(T[] array){
        size = array.length;
        data = array;
       	heapify();
	isMax = true;
   }
   private void pushDown(int k){
	T temp = data[k];
	//System.out.println(size);
	if (size >= k*2+1 && compare(data[k*2+1].compareTo(data[k*2]))) {
	    data[k] = data[k*2];
	    data[k*2] = temp;
	}
	else {
	    data[k] = data[k*2+1];
	    data[k*2+1] = temp;
	    
	}
   }
   private void pushUp(int pos) {
	if(pos>1&&compare(data[pos],data[pos/2])){
	    T temp=data[pos/2];
	    data[pos/2]=data[pos];
	    data[pos]=temp;
	    pushUp(pos/2);
	}
   }
   
   private void heapify(){
	T [] temp = (T[])new Comparable[data.length*2+1];
	int start = size/2-1;	
	for (int i = start; i > 1; i--) {
	    if (compare(data[i].compareTo(data[i/2]))) {
		pushDown(i);
	    }
	}
	for (int i = 0; i < data.length; i++) {
	    temp[i+1] = data[size-i-1];
	}
	data = temp;
   }
   //public T delete()
   public void add(T value){
	if (size+1 >= data.length) {
	    doubleSize();
	}
	data[size+1] = value;
	size++;
	pushUp(size);
    }

   private void doubleSize(){
	T[]temp = (T[])new Comparable[data.length*2];
	for (int i = 1; i <= size; i++) {
	    temp[i] = data[i];
	}
	data = temp;
   }
   private boolean compare(int n) {
	if (isMax) {
	    return n < 0;
	}
	return n > 0;
    }
   public String toString(){
	String s = "[";
	for (int i = 1; i <= size; i++) {
	    if (i == size) {
		s += data[i];
	    }
	    else {
		s += (data[i] + ", ");
	    }
	}
	s += "]";
	return s;
    }

    public static void main(String[]args) {
	MyHeap<Integer> a = new MyHeap<>();
	a.add(56);
	System.out.println(a);
	a.add(40);
	a.add(35);
	a.add(87);
	a.add(7);
	a.add(27);
	a.add(18);
	System.out.println(a);
	//a.delete();
	System.out.println(a);
	Integer [] r = {7,18,27,35,40,56,87};
	MyHeap<Integer> b = new MyHeap<>(r);
	System.out.println(b);
    }
}
