import java.util.*;

@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>> {
    private int size;            
   private T[] heap;  
   private boolean isMax = true;   

   public MyHeap()
   {
      size = 0;
      heap = (T[]) new Comparable[2];
   }

   public MyHeap(T[] array)
   {
      size = array.length;
      heap = (T[]) new Comparable[array.length+1];
      System.arraycopy(array, 0, heap, 1, array.length);
      heapify();
   }
   
   public MyHeap(boolean isMax)
   {
        heap = (T[]) new Comparable[2];
        size = 0;
        this.isMax = isMax;
   }
   
   public MyHeap(T[] array, boolean isMax)
   {
      size = array.length;
      heap = (T[]) new Comparable[array.length+1];
      System.arraycopy(array, 0, heap, 1, array.length);
      this.isMax = isMax;
      heapify();

   }

    public int size() {
	return size;
    }

    public T peek() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return heap[1];
    }

    /**pushDown
      precondition: heap is a heap with at most one item
      out of place (element at k)
      postconditions:-the element at index k has been
                     shifted to the correct spot.
                     -heap is a valid heap
    **/
    private void pushDown(int k) {
	if (size >= 2*k) {
	    if (size >= 2*k + 1) {
		int swapIndex = 0;
		if (compare(heap[2*k], heap[2*k + 1]) >= 0) { swapIndex = 2*k; }
		else { swapIndex = 2*k + 1; }
		if (compare(heap[k], heap[swapIndex]) < 0) {
			swap(k, swapIndex);
			pushDown(swapIndex);
		}
	    } else {
		if (compare(heap[k], heap[2*k]) < 0) {
		    swap(k, 2*k);
		    pushDown(2*k); 
		}
	    } 
	} 
    }

    /**pushUp
       precondition: heap is a heap with at most one item
       out of place (element at k)
       postconditions:-the element at index k has been
       shifted to the correct spot.
       -heap is a valid heap
    **/
    private void pushUp(int k) {
	if (k >= 2) {
	    if (compare(heap[k], heap[k/2]) >= 1) {
		swap(k, k/2);
		pushUp(k/2); // recursive call
	    }
	} // end outer if
    }

    private void swap(int ind1, int ind2) {
	T temp = heap[ind1];
	heap[ind1] = heap[ind2];
	heap[ind2] = temp;
    }

    private void heapify() {
	for (int i = size/2; i > 0; i--) {
	    pushDown(i);
	}
    }

    // delete the root
    public T delete() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	T store = heap[1];
	int index = size;
	heap[1] = heap[index];
	heap[size] = null;
	int p = 1;
	pushDown(p);
	for (int i = index+1; i <= size; i++) {
	    heap[i-1] = heap[i];
	}
	size--;
	return store;
    }

    public void add(T x) {
	if (size+1 >= heap.length) {
	    doubleSize();
	}
	heap[size+1] = x;
	size++;
	int p = size;
	pushUp(p);
    }

    private void doubleSize(){
      T [] old = heap;
      heap = (T []) new Comparable[heap.length * 2];
      System.arraycopy(old, 1, heap, 1, size);
   }

    
    private int compare(T value1, T value2) {
	if (isMax) {
	    return value1.compareTo(value2);
	} else {
	    return value2.compareTo(value1);
	}   
    }

    public String toString() {
	return Arrays.toString(heap);
    }

   public static void main(String[]args) {
	//MyHeap<Integer> a = new MyHeap<>();
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
	a.delete();
	a.delete();
	System.out.println(a);
	//Integer [] r = {7,18,27,35,40,56,87};
	Integer [] r= {10,15,9,2000,2,6,7,5000,60,3,15,100,20,3,1};
	MyHeap<Integer> b = new MyHeap<>(r);
	System.out.println(b);
    }
}