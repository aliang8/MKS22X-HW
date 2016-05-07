import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
   private int size;
   private T[] data;

   public MyHeap(){}
   public MyHeap(T[] array){
       size = array.length + 1;
       data = new T[size];
       for (int i = 0; i < size; i++){
	   data[i] = array[i-1];
       }
   }
   private void pushDown(int k){
       if (data[k].compareTo(data[2*k-1])< 0){
	   swap(data[k], data[2*k-1]);
       } else if (data[k].compareTo(data[2*k+1]) < 0){
	   swap(data[k], data[2*k+1]);
       } 
   }
	   
   private void pushUp(int k){
       if (data[k].compareTo(data[k/2
   private void heapify()
   public T delete()
   public void add(T x)
   private void doubleSize()
   public String toString()

   //do this last
   public MyHeap(boolean isMax)
   public MyHeap(T[] array, boolean isMax)

}
