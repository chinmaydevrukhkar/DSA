class Tester {
    
    // Static variable to count iterations
    public static int iterations = 0;
	
    // Method to perform binary search and count iterations
	public static int searchElement(int elements[], int low, int high, int elementToBeSearched) {
	    while (low <= high) {
	        iterations++; // Increment iteration count for each comparison
	        
	        int mid = low + (high - low) / 2;
	        
	        // Check if elementToBeSearched is present at mid
	        if (elements[mid] == elementToBeSearched)
	            return mid;
	        
	        // If elementToBeSearched is greater, ignore left half
	        if (elements[mid] < elementToBeSearched)
	            low = mid + 1;
	        // If elementToBeSearched is smaller, ignore right half
	        else
	            high = mid - 1;
	    }
	    
	    // Element is not present in array
	    return -1;
	}
	
	public static void main(String[] args) {
	    int[] elements = { 1, 23, 43, 46, 78, 90 };
		int elementToBeSearched = 43;
		
		// Reset iterations count before performing search
		iterations = 0;
		
		int indexPosition = searchElement(elements, 0, elements.length - 1, elementToBeSearched);
		
		if (indexPosition == -1)
			System.out.println("Element not found!");
		else
			System.out.println("Element found at index position " + indexPosition + "!");
		
		System.out.println("Number of iterations: " + iterations);
	}
}
