import java.util.*;

public class Sorts{

//-------------------INSERTION SORT--------------------------*
     public static void insertionSort(int[] data){
	int value = 0;
	int index = 0;
	for(int i = 1; i < data.length; i++){
      	    value = data[i];
	    index = i;
	    while(index >= 1 && value <= data[index-1]){
		data[index] = data[index-1];
		index-=1;
	    }
	    data[index]= value;
	}
    }

//-------------------SELECTION SORT--------------------------*
    public static void selectionSort(int[] data) {
	int start = 0;
	int index = 0;
	while (start < data.length-1) {
	    int smallest = data[start];
	    for (int i = start; i < data.length; i++) {
		if (data[i] < smallest) {
		    smallest = data[i];
		    index = i;
		}
	    }
	    data[index] = data[start];
	    data[start] = smallest;
	    start++;
	}
    }

//-------------------BUBBLE SORT--------------------------*
    public static void bubbleSort(int[]data) {
	int counter = data.length;
	int temp;
	while (counter != 0) {
	    for (int i = 1; i < counter; i++) {
		if (data[i-1] > data[i]) {
		    temp = data[i-1];
		    data[i-1] = data[i];
		    data[i] = temp;
		}
	    }
	    counter--; 
	}
    }


    public static void  printArray(int[] data) {
	System.out.println(Arrays.toString(data));	
    }

    public static void fillRandom(int[] data){
	for (int i = 0; i< data.length; i++){
	    data[i] = (int)(Math.random() * 1000);
	}
    }

    public static void swap(int[] data, int index, int index2){
	int temp = data[index];
        data[index] = data[index2];
	data[index2] = temp;
    }
    

//-------------------EASYMERGE SORT--------------------------*
    public static int[] easymerge(int[]aryA, int[]aryB){
	int[] copy = new int[aryA.length+aryB.length];
	int aIndex=0;
	int bIndex=0;
	int sortIndex=0;
	while(aIndex<aryA.length && bIndex<aryB.length){
	    if(aryA[aIndex]<=aryB[bIndex]){
		copy[sortIndex]=aryA[aIndex];
		aIndex++;
		sortIndex++;
	    }else{
		copy[sortIndex]=aryB[bIndex];
		bIndex++;
		sortIndex++;
	    }
	}
	for(int a=aIndex; a<aryA.length; a++){
	    copy[sortIndex]=aryA[a];
	    sortIndex++;
	}
	for(int b=bIndex; b<aryB.length; b++){
	    copy[sortIndex]=aryB[b];
	    sortIndex++;
	}
	return copy;
    }


//-------------------BETTER MERGESORT SORT--------------------------*
    public static void merge(int[]data, int startA, int endA, int startB, int endB){
	int[] copy = new int[(endA-startA)+1+(endB-startB)+1];

	int aIndex=startA;
	int bIndex=startB;
	int sortIndex=0;

	while(aIndex<=endA && bIndex<=endB){
	    if(data[aIndex]<=data[bIndex]){
		copy[sortIndex]=data[aIndex];
		aIndex++;
		sortIndex++;
	    }else{
		copy[sortIndex]=data[bIndex];
		bIndex++;
		sortIndex++;
	    }
	}
	
	for(int a=aIndex; a<=endA; a++){
	    copy[sortIndex]=data[a];
	    sortIndex++;
	}
	for(int b=bIndex; b<=endB; b++){
	    copy[sortIndex]=data[b];
	    sortIndex++;
	}
	for(int c=startA; c<copy.length; c++){
	    data[c]=copy[c-startA];
	}

	printArray(copy);
    }

    public static void main(String[]args){
	// insertion test
        int[] test1 = {10,8,5,6,7,12};
	System.out.println("Insertion Sort Test");
	insertionSort(test1);
	printArray(test1);
	
	//selection test
	int[] test2 = {1,24,5,654,52};
	System.out.println("Selection Sort Test");	
	selectionSort(test2);
	printArray(test2); 

	//bubble test
	int[] test3 = {1,2,9,5,0,3};
	System.out.println("Bubble Sort Test");
	bubbleSort(test3);
	printArray(test3);

	//easymergetest
	int[] a = {1,4,7,10,21,33,55};
	int[] b = {5,6,11,22,33,44,55,66};
	System.out.println("Easy Merge Sort Test");
	printArray(easymerge(a,b));

	//bettermerge test
	int[] c = new int[] {1,3,5,7,8,9,10,16,32,78};
	System.out.println("Better Merge Sort Test");
	merge(c,0,3,4,7);
    }
}
