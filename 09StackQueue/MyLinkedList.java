import java.util.*;

public class MyLinkedList<T> implements Iterable<T> {

    private class LNode {
	T value;
	LNode next;	
	LNode prev;
	
	public LNode(T v){
	    value = v;
	}

	public LNode getNext(){
	    return next;
	}
	public LNode getPrev() {
	    return prev;
	}
	public T getValue(){
	    return value;
	}
	public void setValue(T v){
	    value = v;
	}
	public void setNext(LNode n){
	    next = n;
	}
	public void setPrev(LNode p) {
	    prev = p;
	}
    }

    LNode head;
    int size;
    LNode end;

    public MyLinkedList() {
	size = 0;
    }

    public boolean addOld(T value){
	if(head == null){
	    head = new LNode(value);
	}else {
	    LNode p = head;
	    while(p.getNext() !=null){
		p = p.getNext();
	    }
	    p.setNext(new LNode(value));
	}
	size++;
	return true;
    }

    public boolean add(T value) {

	if (size == 0) {
	    head = new LNode(value);
	    end = head;
	}
	else {
	    end.setNext(new LNode(value));
	    end = end.getNext();
	    end.setPrev(end);
	}
	size++;
	return true;
    }

    public boolean add(int index, T value) {
	
	if (index > size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}else if (index == 0) {
	    LNode current = head;
	    head = new LNode(value);
	    head.setNext(current);
	    current.setPrev(head);
	    size++;
	}else if (index == size) {
	    add(value);
	}else {
	    LNode current = head;
	    for (int i = 0; i < index-1; i++) {
		current = current.getNext();
	    }
	    LNode node = current.getNext();
	    current.setNext(new LNode(value));
	    node.setPrev(current.getNext());
	    current.getNext().setPrev(current);
	    current.getNext().setNext(node);
	    size++;
	}
	return true;
    }
    
    public T get(int index){
	if(index >= size){
		throw new IndexOutOfBoundsException();	
	}
	LNode current= head;
	for (int i = 0; i < index; i++){
	    current = current.getNext();
	}
	return current.getValue();
    }


    public int size() {
	return size;
    }


    public T set(int index, T newValue) {
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	for (int i = 0; i < index; i++) {
	    current = current.getNext();
	}
	T oldValue = current.getValue();
	current.setValue(newValue);
	return oldValue;
    }

    public boolean removeOld(int pos){
	if(pos > size){
	    return false;
	}else if (pos == 0){
	    head = head.getNext();
	    return true;
	}else{
	    LNode current = head;
	    for (int i = 0; i < pos - 1; i++){
		current = current.getNext();
	    }
	    current.setNext(current.getNext().getNext());
	    size--;
	    return true;
	}
    }
    
    public T remove(int index) {
	if (index >= size || index < 0 ) {
	    throw new IndexOutOfBoundsException();
	}else if (index == 0) {
	    T removed = head.getValue();
	    head = head.getNext();
	    size--;
	    return removed;
	}else {
	    LNode current = head;
	    for (int i = 0; i < index-1; i++) {
		current = current.getNext();
	    }
	    if (index == size-1) {
		end = current;
	    }
	    T removed = current.getNext().getValue();
	    current.setNext(current.getNext().getNext());
	    size--;
	    return removed;
	}
    }

    public int indexOf(T value){
	int pos = 0;
	LNode current=head;
	while(current.getNext()!=null){
	    if (current.getValue().equals(value)){
		return pos;
	    }
	    current=current.getNext();
	}
	return -1;
    }
    
    public String toString(boolean debug){
	String ans = "[";
	LNode p = head;
	while (p != null){
	    ans += p.getValue() + " ";
	    if (p.getNext() != null){
		ans += ", ";
	    }
	    p = p.getNext();
	}
        ans += "]";
	if(debug){
	    return ans + " HEAD: " + head.getValue() + "\tTAIL: " + end.getValue();
	}else {
	    return ans;
	}
    }

    public Iterator<T> iterator(){
	return null;
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