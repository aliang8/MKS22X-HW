import java.util.Arrays;
public class Queens{
    int[][]board;
    int queens;
    public Queens(int num) {
	board = new int[num][num];
	queens = num;
    }
    void addQueen(int row, int col) {
	board[row][col] = 1;
	for (int i = col+1; i < board[row].length; i++) {
	    board[row][i]--;
	}
	int curRow = row+1;
	for (int j = col+1; curRow < board.length && j < board[row].length; j++) {
	    board[curRow][j]--;
	    curRow++;
	}
	curRow = row-1;
	for (int k = col+1; curRow >= 0 && k < board[row].length; k++) {
	    board[curRow][k]--;
	    curRow--;
	}	
     }
     public boolean removeQueen(int row,int col){
	if(!(board[row][col]==1)){
	    return false;
	}
	for(int r = 0;r<board.length;r++){
	    for(int c = 0;c<board.length;c++){
		if((r==row)||(c==col)||(r-c==row-col)||(r+c==row+col)){
		    if(board[r][c]>0){
			board[r][c]-=1;
		    }else if(board[r][c]<0){
		    board[r][c]+=1;
		    }
		}
	    }
	}
	return true;
    }
    public String printBoard(){
	String result = "";
	for(int i = 0; i < board.length; i ++){
	    for(int j = 0; j <board[i].length; j++){
		result += Integer.toString(board[i][j])+ "    ";
	    }
	    result += "\n";
	}
	return result;
    }
    
    public static void main(String[]args){
	Queens eight = new Queens(8);
	eight.addQueen(3,5);
	System.out.println(eight.printBoard());
	eight.removeQueen(3,5);
	System.out.println(eight.printBoard());

    }
}
