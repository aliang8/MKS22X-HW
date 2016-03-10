import java.util.*;
import java.util.Arrays;

public class Quick {
    public static int partition(int[]data, int left, int right) {

        if (left == right) {
	    return right;
	}
        int randIndex = (int)(Math.random()*(right-left + 1)) + left;
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
	    swap(data, right + 1, temp);
	    return right + 1;
	}
	else {
	    swap(data, left, temp);
	    return left;
	}

    }

    private static void swap(int[]data,int a, int b) {
	int temp = data[a];
	data[a] = data[b];
	data[b] = temp;
    }
        
    public static int quickselect(int[]data, int k)  {
	return quickselect(data, k, 0, data.length-1);
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

    
    public static void quickSort(int[]data) {
	quickSort(data, 0, data.length - 1);
    }

    public static void quickSort(int[]data, int left, int right) {
	if (right - left > 0) {
	    int pos = partition(data, left, right);
	    quickSort(data, left, pos - 1);
	    quickSort(data, pos + 1, right);
	}
	
    }

    public static void  printArray(int[]data) {
	String array = "[";
	for (int i = 0; i < data.length; i++) {
	    if (i == data.length - 1) {
		array += data[i];
	    }
	    else {
		array += data[i] + ", ";
	    }
	}
	array += "]";
	System.out.println(array);
    }

    public static String name(){
	return "6,Liang,Anthony";
    }

    public static void main(String[]args) {
	int[] data1 = {3,10,6,27,16,33};
	//System.out.println(quickselect(data1,3));
	System.out.println("Original Array: ");
	printArray(data1);
	quickSort(data1);
	System.out.println("New Array: ");
	printArray(data1);

	int[] data2 = {1,2,5,4};
	System.out.println("Original Array: ");
	printArray(data2);
	quickSort(data2);
	System.out.println("New Array: ");
	printArray(data2);

	int[] data3 = {123,23,333,33221,33};
	System.out.println("Original Array: ");
	printArray(data3);
	quickSort(data3);
	System.out.println("New Array: ");
	printArray(data3);

    }
     
}


