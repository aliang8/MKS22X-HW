public class BSTree<T extends Comparable<T>> {   
    
    private int greaterOf(int a, int b) {
	if (a > b) {
	    return a;
	}
	return b;
    }

    public BSTree() {
	root = new Node();
    }

    private class Node{
	T data;
	Node left;
	Node right;
	int height;
	// set/get: data/left/right
	
	public Node(){
	}

	public Node(T value){
	    data = value;
	}

	public Node(T value, Node left, Node right){
	    data = value;
	    this.left = left;
	    this.right = right;
	}

	public boolean hasChildren() {
	    if (left != null || right != null) {
		return true;
	    }
	    return false;
	}

	public void setValue(T value) {
	    data = value;
	}

	public T getValue() {
	    return data;
	}

	public Node getLeft(){
	    return left;
	}
	
	public Node getRight(){
	    return right;
	}
	

	//real methods here
	public int height(){ 
	    return height(0);
	}

	public int height(int n) {
	    if (left != null && right != null) {
		return greaterOf(left.height(n+1),right.height(n+1));
	    }
	    else if (right != null) {
		return right.height(n+1);
	    }
	    else if (left != null) {
		return left.height(n+1);
	    }
	    else {
		return n+1;
	    }
	}

	public void add(T value){
	    if (data == null) {
		data = value;
	    }
	    else if (value.compareTo(data) < 0) {
		if (left == null) {
		    left = new Node(value);
		}
		else {
		    left.add(value);
		}
	    }
	    else {
		if (right == null) {
		    right = new Node(value);
		}
		else {
		    right.add(value);
		}
	    }
	}


	public String toString(){
	    if (left == null && right == null){
		return data + " _ _";
	    }else if(left == null){
		return data + " _ " + right;
	    }else if(right==null){
		return data + " " + left + " _ ";
	    }else{
		return "" + data + " " + left + " " + right;
	    }
	}
	
	public boolean contains(T value, Node current){
	    if(current == null){
		return false;
	    }else if(current.getValue().compareTo(value) == 0){
		return true;
	    }else if(current.getValue().compareTo(value) < 0){
		return contains(value, current.getLeft());
	    }else{
		return contains(value, current.getRight());
	    }
	}
     
    }


    //remove easy for no or 1 children
    //remove when have 2 children replace node with largest of left or smallest of right (pick the taller child)
    //have the remove method for tree and node


    //IMPORTANT CHANGE TO PRIVATE
    private Node root;

    //OUTER methods here are wrapper methods for the root
    public int getHeight(){
	//call the root's methods
	//check for empty first!
	if (root.getValue() == null) {
	    return 0;
	}
	return root.height();
    }

    public void add(T value){
	//check for empty before you do things with root.
	if(root == null){
	    root = new Node(value);
	}else{
	    root.add(value);
	}
    }
    public String toString(){
	//check for empty before you do things with root.
	if (root.getValue() != null) {
	    return root.toString();
	}
	return root.toString();
    }
    public boolean contains(T value){
	//check for empty before you do things with root.
	if (root.getValue() == null) {
	    return false;
	}
	return false;
    }


    public static void main(String[]args) {
	BSTree<Integer> b = new BSTree<>();
	b.add(4);
	b.add(3);
	b.add(10);
	b.add(2);
	b.add(5);
	b.add(11);
	b.add(12);
	System.out.println(b);
	System.out.println(b.getHeight());
    }

}
