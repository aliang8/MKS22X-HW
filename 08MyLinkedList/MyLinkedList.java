public class MyLinkedList {

    private class LNode {
	int value;
	LNode next;	

	public LNode(int v){
	    value = v;
	}

	public LNode getNext(){
	    return next;
	}
	public int getValue(){
	    return value;
	}
	public void setValue(int v){
	    value = v;
	}
	public void setNext(LNode n){
	    next = n;
	}
    }

    LNode head;
    int size;

    public boolean add(int value){
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

    public int get(int index){
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
	return -1;
    }

    public int set(int index, int newValue){
	if (index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	for (int i = 0; i < index; i++){
	    current = current.getNext();
	}
	current.setValue(newValue);
	return -1;
    }

    public boolean add(int index, int value){
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
	   
    public int remove(int index){
	if(index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	int i = 0;
	if(index == 0){
	    head = head.getNext();
	}
	while(head != null){
	    if(i == index-1){
		i = head.getNext().getValue();
		head.setNext(head.getNext().getNext());
		return i;
	    }
	    head = head.getNext();s
	    i++;
	}
	return 0;
    }
    
    public int indexOf(int value) {
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
	MyLinkedList l = new MyLinkedList();
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
    }

}
