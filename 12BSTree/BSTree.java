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

	public int getHeight(Node current){
	    if (current==null){
		return 0;
	    }else{
		return 1+Math.max(getHeight(current.getLeft()),getHeight(current.getRight()));
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

	public Node leftLargest(){
	    Node start = left;
	    while (start.right != null) {
		start = start.right;
	    }
	    return start;
	}

        private void shift(Node a, Node b) {
	    a = b;
	}
	public T remove(T value) {
	    if (value.compareTo(data) == 0) {
		if (left != null && right != null) {
		    data = remove(leftLargest().getValue());
		}
		else if (left != null) {
		    shift(this,this.left);
		}
		else if (right != null) {
		    shift(this,this.right);
		}
		else {
		    data = null;
		}
		return value;
	    }
	    else if (value.compareTo(data) < 0) {
		T ret = left.remove(value);
		if (left.getValue() == null) {
		    left = null;
		}
		return ret;
	    }
	    else {
		T ret = right.remove(value);
		if (right.getValue() == null) {
		    right = null;
		}
		return ret;
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
	return root.getHeight(root);
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

    public T remove(T value) {
	if (root.getValue() == null) {
	    return null;
	}	
	return root.remove(value);
    }

    public static void main(String[]args) {
	BSTree<Integer> bs=new BSTree<Integer>();
	bs.add(3);
	System.out.println(bs.toString());
	bs.add(2);
	System.out.println(bs.toString());
	System.out.println(bs.getHeight());  
	bs.add(4);
	System.out.println(bs.toString());
	bs.remove(2);
	System.out.println(bs.toString());
	bs.remove(3);
	System.out.println(bs.toString());
  }

}
