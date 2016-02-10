import java.util.Arrays;
public class Queens{
    int[][]board;
    int queens;
    public Queen(int num) {
	board = new int[num][num];
	queens = num;
    }
    public void addQueen(int x, int y) {
	board[x][y] = 1;
	int r = x + 1;
	for(int c = y + 1; c < board.length; c++){
	    if(r < board.length){
		board[r][c] -= 1;
		r+= 1;
	    }
	}
	r = x - 1;
	for(int c = col+1; c < board.length; c++){
	    if(r > 0) {
		board[r][c] -= 1;
		r -= 1;
	    }
	}
	for(int c = x + 1; c < board.length; c++){
	    board[x][c] -= 1;
	}
    }
    public void removeQueen(int x, int y){
	board[x][y] = 0;
	int counter = 1;
	int counter2 = 1;
	for(int a = y + 1; a < board.length; a ++){
	    board[x][a]=board[x][a] + 1;
	}
	for(int b = x - 1 ; b >=0;b --){
	    board[b][y + counter] = board[b][y + counter]+1;
	    counter ++;
	}
	for(int c = x; c <board.length - 1; c ++){
	    board[x+counter2][y+counter2]= board[x+counter2][y+counter2] + 1;
	    counter2 ++;
	}
    }
    public String printBoard(){
	String result = "";
	for(int i = 0; i < board.length; i ++){
	    for(int j = 0; j <board[i].length; j++){
		result += Integer.toString(board[i][j])+ " ";
	    }
	    result += "\n";
	}
	return result;
    }
    
    public static void main(String[]args){
	Queens eight = new Queens(8);
	hq.addQueen(3,5);
	System.out.println(eight.printBoard());
	hq.removeQueen(3,5);
	System.out.println(eight.printBoard());

    }
}
