import java.util.*;

public class Quick {
    public static int partition(int[]data, int left, int right) {

        if (left == right) {
	    return right;
	}
        int randIndex = (int)(Math.random()*(right-left)) + left;
	int val = data[randIndex];
 	int temp = right;
	swap(data,randIndex,right);
	right--;

	while (left < right) {
 	    if (data[left] <= val) {
		left++;
	    }
 	    else {
 		swap(data,left,right);
		right--;
	    }
 	}
	int temp2 = temp;
        if (data[left] < val) {
	    swap(data,right+1,temp);
	    return right+1;
	}
	else {
	    swap(data,left,temp);
	    return left;
	}

    }

    private static void swap(int[]data,int a, int b) {
	int temp = data[a];
	data[a] = data[b];
	data[b] = temp;
    }
        
    public static int quickselect(int[]data, int k)  {
	return quickselect(data,k,0,data.length-1);
    }


    private static int quickselect(int[]data, int k, int left, int right) {
	int pos = partition(data,left,right);
	if (pos == k) {
	    return data[pos];
	} else if (pos > k) {
	    return quickselect(data,k,left,pos - 1);
	}else {
	    return quickselect(data,k,pos + 1,right);
	}
    }

    public static String name(){
	return "6,Liang,Anthony";
    }

    public static void main(String[]args) {
	int[] data1 = {3,10,6,27,16,33};
	System.out.println(quickselect(data1,3));
	int[] data2 = {3,3};
	System.out.println(quickselect(data2,1));
	int[] data3 = {3,10,6};
	System.out.println(quickselect(data3,2));	   
    }
    
    
}