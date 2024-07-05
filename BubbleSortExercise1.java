class Tester {
	static int noOfSwaps = 0;
	static int noOfPasses = 0;

	public static void swap(int[] elements, int firstIndex, int secondIndex) {
	      int temp;
	      temp = elements[firstIndex];
	      elements[firstIndex]=elements[secondIndex];
	      elements[secondIndex]=temp;
	}

	public static int bubbleSort(int[] elements) {
	    int count=0;
	    for(int i=0;i<elements.length;i++){
	        for(int j=0;j<elements.length-1;j++){
	            if(elements[j+1]<elements[j]){
	                count++;
	                swap(elements,j,j+1);
	            }
	        }
	    }
		return count-1;
	}

	public static void displayArray(int[] elements) {
		for (int element : elements)
			System.out.print(element + " ");
		System.out.println();
	}

	public static void main(String[] args) {

		int[] elements = { 23, 67, 45, 76, 34, 68, 90 };

		System.out.println("Given array:");
		displayArray(elements);

		int noOfPasses = bubbleSort(elements);

		System.out.println("==========================");
		System.out.println("Total number of passes needed to sort the array: " + noOfPasses);
		System.out.println("==========================");

		System.out.println("Array after sorting:");
		displayArray(elements);

	}
}
