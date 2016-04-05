public class Driver<T>{
    //generic array
    T[] data;

    //suppress this ONE function from
    //having warnings.
    @SuppressWarnings("unchecked")	    
    public Driver(){
	//typecast object array to generic array
	data = (T[]) new Object[10];
    }
    
    public void add(T n){
	data[0]=n;
    }

    public T get(){
	
	return data[0];
    }
    
    public static void main(String[]args){
	Driver<String> x = new Driver<String>();
	x.add("fish");
 	x.addFirst("hey");  
	x.addFirst("bye");  
	System.out.println(x.getFirst());
	x.addLast("yo");   
	System.out.println(x.getLast());
	x.addLast("compsci");
	System.out.println(x.getLast());
	x.addFirst("is");  
	x.addLast("so");  
	x.addLast("fun");  
	x.addLast("yay");  
	x.addLast("wow"); 
	x.addLast("cool");  
	x.addFirst("man");  
	x.removeLast();  
	x.removeFirst(); 
	System.out.println(x.get());
    }
}