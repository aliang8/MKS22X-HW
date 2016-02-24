import java.util.*;
import java.io.*;

public class Bronze {

    public static String makeLake() {
	int[][]field;
	try {
	    Scanner s = new Scanner(new File("makelake.in"));
	    int rows = s.nextInt();
	    int cols = s.nextInt();
	    field = new int[rows][cols];
	    int waterLevel = s.nextInt();
	    int stomps = s.nextInt();
	    s.nextLine();
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
		    field[i][j] = s.nextInt();
		}
	    }

  	    for (int i = 0; i < stomps; i++) {
	        int r = s.nextInt()-1;
		int c = s.nextInt()-1;
		int d = s.nextInt();
	        field[r][c] -= d;
		for (int j = r; j <  r+3; j++) {
		    for (int k = c; k < c+3; k++) {
			if (field[j][k] > field[r][c]) {
			    field[j][k] = field[r][c];
			}
		    }
		}
	    }


	    for (int i = 0; i < rows; i++) {
		for (int j = 0; j < cols; j++) {
		    if (field[i][j] < waterLevel) {
			field[i][j] = waterLevel - field[i][j];
		    }
		    else {
			field[i][j] = 0;
		    }
		}
	    }

	    int sum = arraySum(field);
	    return sum*72*72 +",6,Liang,Anthony";
	}
	catch (FileNotFoundException e) {
	    System.out.println(e);
	}
	
	return "6,Anthony,Liang";
    }


    public static int arraySum(int[][]array) {
	int sum = 0;
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		sum += array[i][j];
	    }
	}
	return sum;
    }

    public static void main(String[]args) {
	System.out.println(makeLake());
    }
    
}
