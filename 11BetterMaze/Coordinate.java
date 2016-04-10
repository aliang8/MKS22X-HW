import java.util.*;

public class Coordinate{
    private int x;
    private int y;
    private ArrayList<int[]> prevLocation;

    public Coordinate(int x, int y){
	this.x = x;
	this.y = y;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public ArrayList<int[]> previousLocation(){
	return prevLocation;
    }

    public void addLocation (int x, int y){
	prevLocation.add({x, y});
    }
}