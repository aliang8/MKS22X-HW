public class Recursion implements hw01{
    public String name() {
	return "Liang,Anthony";
    }

    public double sqrt(double n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	return findRoot(n,1);
    }


    public double findRoot(double n, double guess) {
	if (Math.pow(guess,2)/n < 0.01) {
	    return guess;
	}
	guess = (n/guess+guess)/2;
	return findRoot(n,guess);
    }


    public static void main(String[]args) {
	Recursion r = new Recursion();
	System.out.println(r.sqrt(64));
    }

}