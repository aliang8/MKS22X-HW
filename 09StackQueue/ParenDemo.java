import java.util.*;
public class ParenDemo {
    
    public static boolean isMatching(String s) {
        MyStack <Character> p = new MyStack<Character>();
	for (int i = 0; i < s.length(); i++) {
	    if (s.charAt(i)=='('|| s.charAt(i)=='['|| s.charAt(i)=='{'|| s.charAt(i)=='<') {
		p.push(s.charAt(i));
	    }else if (s.charAt(i)==')'|| s.charAt(i)==']'|| s.charAt(i)=='}'|| s.charAt(i)=='>') {
		try {
		    if(p.pop() != getMatch(s.charAt(i)))  {
			return false;
		    }
		}
		catch (NoSuchElementException e) {
		    return false;
		}
	    }
	}
	return p.isEmpty();
    }
    
    public static char getMatch(char s) {
	if (s == '>') {
	    return '<';
	} else if (s == ']') {
	    return '[';
	} else if (s == ')') {
	    return '(';
	} else {
	    return '{';
	}
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
