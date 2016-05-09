import java.util.*;
public class MyHeap{
    private int[] heap;
    boolean isMax;
    
    public MyHeap(){
	this(true);
    }
    
    public MyHeap(boolean isMax){
	heap = new int[5];
	this.isMax = isMax;
    }

    public int remove(){
	int ret = heap[1];
	int val = heap[heap[0]];
	heap[heap[0]] = 0;
	heap[1] = val;
	heap[0] = heap[0] - 1;
	pushDown(1);
	return ret;
    }
    
    public void pushDown(int index){
	if ( index < heap[0] && ( !compare(index, index*2) || !compare(index, index*2+1) ) ){
	    if ( compare(index*2,index*2+1) ){
		swap(index,index*2);
		pushUp(index*2);
	    }else{
		swap(index,index*2+1);
		pushUp(index*2+1);
	    }
	}
    }

    public void add(int value){
	if ( heap[0] == heap.length - 1){
	    heap = Arrays.copyOf(heap, heap.length*2);
	}
	heap[0] = heap[0] + 1;
	heap[heap[0]] = value;
	pushUp(heap[0]);
    }

    public void pushUp( int index ){
	if ( index != 1 && compare(index,index/2) ){
	    swap(index,index/2);
	    pushUp(index/2);
	}
    }

    public void swap(int index1, int index2){
	int current = heap[index1];
	heap[index1] = heap[index2];
	heap[index2] = current;
    }

    public boolean compare(int a , int b ){
	if ( isMax ){
	    return heap[a] > heap[b];
	}
	return heap[a] < heap[b];
    }

    public int peek(){
	return heap[1];
    }

    public int getSize(){
	return heap[0];
    }

    public String toString(){
	return Arrays.toString(heap);
    }

    public static void main ( String [] args ){
	MyHeap h = new MyHeap(true);
	h.add(10);
	h.add(60);
	h.add(600);
	h.add(1);
	h.add(-100);
	System.out.println(h);
        h.remove();
	System.out.println(h);
	h.remove();
	System.out.println(h);
    }
}