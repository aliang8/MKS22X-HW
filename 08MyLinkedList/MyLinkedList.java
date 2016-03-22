public class MyLinkedList<T> {

    private class LNode {
	T value;
	LNode next;	

	public LNode(T v){
	    value = v;
	}

	public LNode getNext(){
	    return next;
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
    }

    LNode head;
    LNode end;
    int size;
     
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
	}
	size++;
	return true;
    }

    public String toString(){
	String ans = "[";
	LNode p = head;
	while (p != null){
	    ans += p.getValue() + " ";
	    if (p.getNext() != null){
		ans += ", ";
	    }
	    p = p.getNext();
	}
	return ans + "]";
    }

    public int size(){
	return size;
    }

    public T get(int index){
	if (index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	for (int i = 0; i < size; i++){
	    if (i == index){
		return current.getValue();
	    }else {
		current = current.getNext();
	    }
	}
	return null;
    }

    public T set(int index, T newValue) {
	if (index >= size) {
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

    public boolean add(int index, T value){
	if (index >= size){
	    add(value);
	}else {
	    LNode current = head;
	    for (int i = 0; i < index; i++){
		current = current.getNext();
	    }   
	    add(get(size - 1));
            for (int i = size - 1; i > index; i--) {
		set(i, get(i-1));
	    }
	    current.setValue(value);
	    size++;
	}
	return true;
    }
	   
    public boolean remove(int pos){
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
    
    public int indexOf(T value) {
	LNode current = head;
	for (int i = 0; i < size; i++) {
	    if (current.getValue() == value) {
		return i;
	    }
	    current = current.getNext();
	}
	return -1;
    }
    

    public static void main(String [] args) {
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
	
	long start,end;
	start = System.currentTimeMillis();
	for (int i = 0; i < 100000; i++) {
	    l.addOld(i);
	}
	end = System.currentTimeMillis();
	System.out.println("Time for addOld(): " + (end-start)/1000.0 + "seconds.");

	start = System.currentTimeMillis();
	for (int i = 0; i < 100000; i++) {
	    l.add(i);
	}	
	end = System.currentTimeMillis();
	System.out.println("Time for add(): " + (end-start)/1000.0 + "seconds.");

	MyLinkedList<String> s = new MyLinkedList<String>();
	s.add(new String("boy"));
	s.add(new String("girl"));
	s.add(new String("pig"));
	System.out.println(s);
    }

}
