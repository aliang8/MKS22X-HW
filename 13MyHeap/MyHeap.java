import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
   private int size;
   private boolean isMax;
   private T[] data;

   public MyHeap(){
	data = (T)new Comparable[10];
	isMax = true;
	size = 0; 
   }
   public MyHeap(boolean max){
	heap = (T)new Comparable[10];
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
       if (data[k].compareTo(data[2*k-1])< 0){
	   swap(data[k], data[2*k-1]);
       } else if (data[k].compareTo(data[2*k+1]) < 0){
	   swap(data[k], data[2*k+1]);
       } 
   }
   private void pushUp(int k) {
	T temp = data[k/2];
	data[k/2] = data[k];
	data[k] = temp;
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
   public T delete()
   public void add(T x){
	if (size+1 >= data.length) {
	    doubleSize();
	}
	data[size+1] = value;
	size++;
	data[size] = value;
	pushUp(size);
    }

   private void doubleSize(){
	T[]temp = (T[])new Comparable[data.length*2];
	for (int i = 1; i <= size; i++) {
	    temp[i] = data[i];
	}
	data = temp;
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

   //do this last
   public MyHeap(boolean isMax)
   public MyHeap(T[] array, boolean isMax)

}
