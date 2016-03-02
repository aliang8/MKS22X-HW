import java.util.*;
import java.io.*;

public class Silver {

    int field[][];
    int T;
    int r1;
    int c1;
    int r2;
    int c2;
    
    public Silver() {
	try {
	    Scanner s = new Scanner(new File("ctravel.in"));
	    int N = s.nextInt();
	    int M = s.nextInt();
	    T = s.nextInt();
	    int total = 0;
	    field = new int[N][M];
	    for (int i = 0; i < N; i++) {
	        String next = s.next();
		for (int j = 0; j < next.length(); j++) {
		    if (next.charAt(j) == '*') {
			field[i][j] = -1;
		    }
		    else {
			field[i][j] = 0;
		    }
		}
	    }
	    r1 = s.nextInt()-1;
	    c1 = s.nextInt()-1;
	    r2 = s.nextInt()-1;
	    c2 = s.nextInt()-1;
	    field[r1][c1] = 1;
	}
	catch (FileNotFoundException e) {

	}
    }


    public int solve() {
	for (int i = 0; i < T; i++) {
	    for (int j = 0; j < field.length; j++) {
		for (int k = 0; k < field[j].length; k++) {
		    if (field[j][k] > 0) {
			setNeighbors(j,k);
		    }
		}
	    }
	    ridNegatives();
	}
	return field[r2][c2];
    }

    
    public void setNeighbors(int row, int col) {
	if (col > 0 && (field[row][col-1] >= 0 || field[row][col-1] <= -2)) {
	    field[row][col-1] += -2*field[row][col];
	}
	if (row > 0 && (field[row-1][col] >= 0 || field[row-1][col] <= -2)) {
	    field[row-1][col] += -2*field[row][col];
	}

	if (col < field[0].length-1 && (field[row][col+1] >= 0 || field[row][col+1] <= -2)) {
	    field[row][col+1] += -2*field[row][col];
	}
	if (row < field.length-1 && (field[row+1][col] >= 0 || field[row+1][col] <= -2)) {
	    field[row+1][col] += -2*field[row][col];
	}
	field[row][col] = 0;
    }


    public String toString() {
	String str = "";
	for (int i = 0; i < field.length; i++) {
	    for (int j = 0; j < field[i].length; j++) {
		str += (field[i][j] + " ");
	    }
	    str += "\n";
	}
	return str;
    }

    public void ridNegatives() {
	for (int i = 0; i < field.length; i++) {
	    for (int j = 0; j < field[i].length; j++) {
		if (field[i][j] < -1) {
		    field[i][j] = -1*(field[i][j]/2);
		}
	    }
	}
    }

    public static void main(String[]args) {
	Silver s = new Silver();
	System.out.print(s.solve());
	System.out.println(" Liang, Anthony, 6");
    }
}
