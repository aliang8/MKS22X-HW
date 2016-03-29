public class ParenDemo {
    
    public static boolean isMatching(String s) {
        MyStack <String> p = new MyStack<String>();
	for (int i = 0; i < s.length(); i++) {
	    if (s.charAt(i)=='('|| s.charAt(i)=='['|| s.charAt(i)=='{'|| s.charAt(i)=='<') {
		p.push("" + s.charAt(i));
	    }
	    if (s.charAt(i)==')'|| s.charAt(i)==']'|| s.charAt(i)=='}'|| s.charAt(i)=='>') {
	       if (("" + s.charAt(i)).equals(matchingBracket(p.peek()))) {
		    p.pop();
		}
	       else {
		return false;}
	    }
	}
	return true;
    }

    public static String matchingBracket(String s) {
	if (s.equals("<")) {
	    return ">";
	}
	if (s.equals("[")) {
	    return "]";
	}
	if (s.equals("(")) {
	    return ")";
	}
	if (s.equals("{")) {
	    return "}";
	}
	return "";
    }


    public static void main(String[]args){
	String input = "()()(([[]]))";
	if(args.length > 0){
	    input = args[0];
	    System.out.println(isMatching(input)); 
	}else{
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}
    }
}