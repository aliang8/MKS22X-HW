import java.util.*;
import java.util.Arrays;

public class Quick {
    public static int partitionOld(int[]data, int left, int right) {
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

    public static int quickselectOld(int[]data, int k)  {
	return quickselectOld(data, k, 0, data.length-1);
    }


    private static int quickselectOld(int[]data, int k, int left, int right) {
	int pos = partitionOld(data,left,right);
	if (pos == k) {
	    return data[pos];
	} else if (pos > k) {
	    return quickselectOld(data,k,left,pos - 1);
	}else {
	    return quickselectOld(data,k,pos + 1,right);
	}
    }



    public static void quickSortOld(int[]data) {
	quickSort(data, 0, data.length - 1);
    }

    public static void quickSortOld(int[]data, int left, int right) {
	if (right - left > 0) {
	    int pos = partitionOld(data, left, right);
	    quickSortOld(data, left, pos - 1);
	    quickSortOld(data, pos + 1, right);
	}
	
    }

     private static int[] partition(int[] data, int left, int right) {
	int pivot = (int) (Math.random() * (right - left + 1)) + left;
	int[] copy = new int[right - left + 1]; 

	int tempLeft = 0;
	int tempRight = right - left;

	for (int i = left; i <= right; i++) {
	    if (data[i] < data[pivot]) {
		copy[tempLeft] = data[i];
		tempLeft++;
	    } else if (data[i] > data[pivot]) {
		copy[tempRight] = data[i];
		tempRight--;
	    }
	}

	for (int i = tempLeft; i <= tempRight; i++) {
	    copy[i] = data[pivot];
	}

	int startIndex = left;

	for (int i = 0; i < copy.length; i++) {
	    data[startIndex] = copy[i];
	    startIndex++;
	}

	int[] pos = new int[2];
	pos[0] = tempLeft + left;
	pos[1] = tempRight + left;
	return pos;
    }

    public static int quickselect(int[] data,int k){
	return quickselect(data, k, 0, data.length-1);
    }
    
    public static int quickselect(int[] data,int k,int left,int right){
	int[] pos = partition(data,left,right);
	if(pos[0] == k){
	    return data[k];
	}else if(pos[0] > k){
	    return quickselect(data, k, left, pos[0] - 1);
	}else{
	    return quickselect(data, k, pos[0] + 1, right);
	}	    
    }

    public static void quickSort(int[] data){
	quickSort(data, 0, data.length - 1);
    }

    public static void quickSort(int[] data, int left, int right){
	if(right-left > 0){
	    int[] pos = partition(data,left,right);
	    quickSort(data, left, pos[0] - 1);
	    quickSort(data, pos[1] + 1, right);
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
	return "6, Liang, Anthony";  
    }

    public static void main(String[]args){
	int[] d = new int [4000000];
	int[] c = new int [d.length];

	for(int i = 0; i < d.length; i++){
	    d[i]= (int)(Math.random()*Integer.MAX_VALUE);
	    c[i]= d[i];
	}
	System.out.println("now sorting");
	Quick.quickSort(d); //or even your old quicksort!!!
	Arrays.sort(c);
	System.out.println("Done: Sorted="+Arrays.equals(d,c));
	
	int[]a1 = new int [4000000];//fill with random values from 0 to 3
	  for(int i=0; i<a1.length; i++){
	  a1[i]=(int)(Math.random()*3);
	  }
	  double startTimea1=System.currentTimeMillis();
	  Arrays.sort(a1);
	  System.out.println((System.currentTimeMillis()-startTimea1)/1000.);

	int[]a2 = new int [4000000];//fill with random values from 0 to 3
	  for(int i=0; i<a2.length; i++){
	  a2[i]=(int)(Math.random()*3);
	  }
	  double startTimea2=System.currentTimeMillis();
	  Quick.quickSortOld(a2);
	  System.out.println((System.currentTimeMillis()-startTimea2)/1000.);
    
	int[]a3 = new int [4000000];//fill with random values from 0 to 3
	  for(int i=0; i<a3.length; i++){
	  a3[i]=(int)(Math.random()*3);
	  }
	  double startTimea3=System.currentTimeMillis();
	  Quick.quickSort(a3);
	  System.out.println((System.currentTimeMillis()-startTimea3)/1000.);


    	
	int[]b1 = new int [4000000];
	for(int i=0; i<b1.length; i++){
	    b1[i]=(int)(Math.random()*Integer.MIN_VALUE);
	    b1[i]+=(int)(Math.random()*Integer.MAX_VALUE);
	}
	double startTimeb1=System.currentTimeMillis();
	Arrays.sort(b1);
	System.out.println((System.currentTimeMillis()-startTimeb1)/1000.);
        

	int[]b2 = new int [4000000];
	for(int i=0; i<b2.length; i++){
	    b2[i]=(int)(Math.random()*Integer.MIN_VALUE);
	    b2[i]+=(int)(Math.random()*Integer.MAX_VALUE);
	}
	double startTimeb2=System.currentTimeMillis();
	Quick.quickSortOld(b2);
	System.out.println((System.currentTimeMillis()-startTimeb2)/1000.);
        

	int[]b3 = new int [4000000];
	for(int i=0; i<b3.length; i++){
	    b3[i]=(int)(Math.random()*Integer.MIN_VALUE);
	    b3[i]+=(int)(Math.random()*Integer.MAX_VALUE);
	}
	double startTimeb3=System.currentTimeMillis();
	Quick.quickSort(b3);
	System.out.println((System.currentTimeMillis()-startTimeb3)/1000.);
        }
}
	
