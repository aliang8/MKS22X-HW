import java.util.Arrays;
public class Driver{
    public static void main(String[] args){
	BetterMaze m = new BetterMaze("data1.dat");
	m.setAnimate(true);
	if(args.length < 1){
	    m.clearTerminal();
	    m.solveBFS();
	    m.clearTerminal();
	    System.out.println(m);
	}
	else{
	    m.clearTerminal();
	    m.solveDFS();
	    m.clearTerminal();
	    System.out.println(m);
	}
    }
}


//THANK U MATTHEW FOR DRIVER
