public class KnightTour {

	int[][] solution;

	public KnightTour(int row, int col) {
		solution = new int[row][col];
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution[0].length; j++) {
				solution[i][j] = 0;
			}
		}
	}

	public void solve() {
		if (solveH(0, 0)) {
			printSolution();
		} else {
			System.out.println("NO PATH FOUND");
		}
	}

	public boolean solveH(int row, int column) {
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
	}

}