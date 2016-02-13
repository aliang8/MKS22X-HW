public class KnightTour {

	int[][] solution;
	int path = 0;

	public KnightTour(int row, int col) {
		solution = new int[row][col];
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution[0].length; j++) {
				solution[i][j] = 0;
			}
		}
	}

	public void solve() {
		if (solveH(0, 0, 0, (solution.length * solution[0].length) - 1)) {
			printSolution();
		} else {
			System.out.println("NO PATH FOUND");
		}
	}

	public boolean solveH(int row, int column, int index, int N) {
		// check if current cell has been stepped on
		if (solution[row][column] != 0) {
			return false;
		}
		// number the cell path
		solution[row][column] = path++;
		if (index == N) {
			return true;
		}

		// go down and right
		if (canMove(row + 2, column + 1)
				&& solveH(row + 2, column + 1, index + 1, N)) {
			return true;
		}
		// go right and down
		if (canMove(row + 1, column + 2)
				&& solveH(row + 1, column + 2, index + 1, N)) {
			return true;
		}
		// go right and up
		if (canMove(row - 1, column + 2)
				&& solveH(row - 1, column + 2, index + 1, N)) {
			return true;
		}
		// go up and right
		if (canMove(row - 2, column + 1)
				&& solveH(row - 2, column + 1, index + 1, N)) {
			return true;
		}
		// go up and left
		if (canMove(row - 2, column - 1)
				&& solveH(row - 2, column - 1, index + 1, N)) {
			return true;
		}
		// go left and up
		if (canMove(row - 1, column - 2)
				&& solveH(row - 1, column - 2, index + 1, N)) {
			return true;
		}
		// go left and down
		if (canMove(row + 1, column - 2)
				&& solveH(row + 1, column - 2, index + 1, N)) {
			return true;
		}
		// go down and left
		if (canMove(row + 2, column - 1)
				&& solveH(row + 2, column - 1, index + 1, N)) {
			return true;
		}
		// backtrack and do recursion again
		solution[row][column] = 0;
		path--;
		return false;

	}

	public boolean canMove(int row, int col) {
		//check if knight can move to specific cell
		if (row >= 0 && col >= 0 && row < solution.length && col < solution[0].length) {
			return true;
		}
		return false;
	}

	public void printSolution() {
	  for (int i = 0; i < solution.length; i++) {
	      for (int j = 0; j < solution[0].length; j++) {
		      System.out.print(solution[i][j] + "   ");
	      }
	      System.out.println("\n");
	  }
        }


	public static void main(String[] args) {
		KnightTour knightTour = new KnightTour(7,7);
		knightTour.solve();
	}

}

