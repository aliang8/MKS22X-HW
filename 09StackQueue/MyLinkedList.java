import java.util.*;
public class MyLinkedList<T> implements Iterable<T>{
    private class LNode{
	private T value;
	private LNode next;
	private LNode prev;
	public LNode(T v){
	    value = v;
	}
	public T getValue(){
	    return value;
	}
	public LNode getNext(){
	    return next;
	}
	public LNode getPrev(){
	    return prev;
	}
	public T setValue(T v){
	    T old = value;
	    value = v;
	    return old;
	}
	public void setNext(LNode n){
	    next = n;
	}
	public void setPrev(LNode p){
	    prev = p;
	}
	public String toString(){
	    return value.toString();
	}
    }
    
    LNode head;
    LNode tail;
    int size;
    
    public Iterator<T> iterator(){
	//This uses an anonymous class! You don't need to know this.
	return new Iterator<T>()
	    {
		private LNode current = head;
		
		public boolean hasNext(){
		    return current != null;
		}
		public T next(){
		    if(!hasNext()){
			throw new NoSuchElementException();
		    }
		    T value = current.getValue();
		    current = current.getNext();
		    return value;
		}
		public void remove(){
		    throw new UnsupportedOperationException();
		}
	    };
    }
    public String toString(){
	String ans = "[";
	LNode p = head;
	while(p!=null){
	    ans += p.getValue();
	    if(p.getNext()!=null){
		ans += ", ";
	    }
	    p = p.getNext();
	}
	return ans+"]";
    }
    public String toString(boolean b){
	return toString()+" head: "+head +", tail: "+tail;
    }
    private LNode getNth(int index){
	//check bounds before calling this method!
	LNode temp = head;
	while(index > 0){
	    temp = temp.getNext();
	    index --;
	}
	return temp;
    }
    public boolean add(T value){
	if(head == null){
	    head = new LNode(value);
	    tail = head;
	}else{
	    tail.setNext(new LNode(value));
	    tail.getNext().setPrev(tail);
	    tail = tail.getNext();
	}
	size++;
	return true;
    }
    public T remove(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size());
	}
	LNode temp;
	if(index == 0){
	    temp = head;
	    head = head.getNext();
	    size--;
	    if(head == null){
		tail = null;
	    } else {
		head.setPrev(null);
	    }
	    return temp.getValue();
	}else{
	    LNode p = getNth(index-1);
	    temp = p.getNext();
	    if(tail == temp){
		tail = p;
	    }
	    p.setNext(p.getNext().getNext());
	    if (p.getNext() != null) {
		p.getNext().setPrev(p);
	    }
	    size --;
	    return temp.getValue();
	}
    }
    public boolean add(int index, T value){
	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	LNode temp = new LNode(value); 
	if(index == 0){
	    temp.setNext(head);
	    if (head != null) {
		head.setPrev(temp);
	    }
	    head = temp;
	    if(size==0){
		tail = head;
	    }
	}else{ 
	    LNode p = getNth(index-1);
	    temp.setNext(p.getNext());
	    if (temp.getNext() != null) {
		temp.getNext().setPrev(temp);
	    }
	    p.setNext(temp);
	    temp.setPrev(p);
	    if(tail.getNext() != null){
		tail=tail.getNext();
	    }
	}
	size++;
	return true;
    }
    
    public int size(){
	return size;
    }
    
    public T get(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	return getNth(index).getValue();
    }
    
    public T set(int index, T newValue){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	return getNth(index).setValue(newValue);
    }
    
    public int indexOf(T target){
	LNode temp = head;
	int index = 0;
	while(temp != null){
	    if(temp.getValue().equals(target)){
		return index;
	    }
	    index++;
	    temp = temp.getNext();
	}
	return -1;
    }

    public static void main(String [] args) {
	/*
	MyLinkedList<Integer> l = new MyLinkedList<Integer>();
	System.out.println(l);
	l.add(2);
	System.out.println(l);
        l.add(3);
	System.out.println(l);
	l.add(4);
	l.add(5);
	l.add(12);
	System.out.println(l);
	System.out.println(l.get(3));
	l.set(4,99);
	System.out.println(l);
	l.add(2,2);
	System.out.println(l);
	System.out.println(l.size());
	l.remove(1);
	System.out.println(l);
	System.out.println(l.indexOf(2));
	System.out.println(l);
	
	long head,end;
	head = System.currentTimeMillis();
	for (int i = 0; i < 100000; i++) {
	    l.addOld(i);
	}
	end = System.currentTimeMillis();
	System.out.println("Time for addOld(): " + (end-head)/1000.0 + "seconds.");

	head = System.currentTimeMillis();
	for (int i = 0; i < 100000; i++) {
	    l.add(i);
	}	
	end = System.currentTimeMillis();
	System.out.println("Time for add(): " + (end-head)/1000.0 + "seconds.");

	MyLinkedList<String> s = new MyLinkedList<String>();
	s.add(new String("boy"));
	s.add(new String("girl"));
	s.add(new String("pig"));
	System.out.println(s);
	*/
        MyLinkedList<String> m = new MyLinkedList<String>();
        ArrayList<String>    n = new ArrayList<String>();

        for(int i = 0; i < 10; i++){
            n.add(""+i);
            m.add(""+i);
        }

        try{
            m.add(-1,"oops");
            System.out.println("\n\nAdd -1 #####################################");
        }catch(IndexOutOfBoundsException e){

        }
        try{
            m.add(12,"oops");
            System.out.println("\n\n add 12 #####################################");
        }catch(IndexOutOfBoundsException e){

        }
        try{
            m.remove(12);
            System.out.println("\n\n remove 12 #####################################");
        }catch(IndexOutOfBoundsException e){

        }

        try{
            m.set(12,"Fwazzat?!?");
            System.out.println("\n\n set 12 #####################################");
        }catch(IndexOutOfBoundsException e){

        }





        //replace toString(true) with a debug to string that shows the head/tail
        System.out.println(m.toString(true));
        System.out.println(n);

        //test removing from head/tail/middle
        m.remove(0);
        n.remove(0);
        System.out.println(m.toString(true));

        m.remove(2);
        n.remove(2);
        System.out.println(m.toString(true));

        m.remove(m.size()-1);
        n.remove(n.size()-1);
        System.out.println(m.toString(true));
        System.out.println(n);

        //test adding to end/head
        m.add(0,"head");
        n.add(0,"head");
        m.add(m.size(),"PENULTIMATE");
        n.add(n.size(),"PENULTIMATE");
        System.out.println(m.toString(true));
        System.out.println(n);

        //test add
        m.add("Z-END!");
        n.add("Z-END!");
        System.out.println(m.toString(true));
        System.out.println(n);

	System.out.println("--------------------------------");
	
        //test remove random items:
        Random rand = new Random(0);
        for(int i = 0; i < 6000; i++){
            int op = rand.nextInt(4);

            if(op == 0 || n.size()==0){//ensure never empty
                n.add(""+i);
                m.add(""+i);
            }else if(op == 1 ){
                int x = rand.nextInt(n.size());
                n.add(x,""+i);
                m.add(x,""+i);
            }else{
                int x = rand.nextInt(n.size());
                if(!n.remove(x).equals(m.remove(x))){
                    System.out.println("Non matching elements removed\n");
                    System.exit(1);
                }
            }
        }
        System.out.println(m.toString(true));
        System.out.println(n);

        /*test speed of add in front and at end.
        long head,end;
        System.out.println("Add 100k to front");
        head = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++)
            n.add(0,""+i);
        end = System.currentTimeMillis();
        System.out.println( "ArrayList "+(end-head)/1000.0 );
        head = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++)
            m.add(0,""+i);
        end = System.currentTimeMillis();
        System.out.println( "LinkedList "+(end-head)/1000.0 );
        System.out.println("Add 1m to end");
        head = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++)
            n.add(""+i);
        end = System.currentTimeMillis();
        System.out.println( "ArrayList "+(end-head)/1000.0 );
        head = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++)
            m.add(""+i);
        end = System.currentTimeMillis();
        System.out.println( "LinkedList "+(end-head)/1000.0 );
        */
    }

}
