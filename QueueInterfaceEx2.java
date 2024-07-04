import java.util.Deque;
import java.util.ArrayDeque;

class Tester {
    
    public static Deque<Integer> changeSmallest(Deque<Integer> inputStack) {
        if (inputStack.isEmpty()) {
            return inputStack;
        }
        
        // Find the smallest element and count occurrences
        int min = Integer.MAX_VALUE;
        int minCount = 0;
        Deque<Integer> tempStack = new ArrayDeque<>();
        
        while (!inputStack.isEmpty()) {
            int current = inputStack.pop();
            if (current < min) {
                min = current;
                minCount = 1;
            } else if (current == min) {
                minCount++;
            }
            tempStack.push(current);
        }
        
        // Remove all occurrences of the smallest element from tempStack
        Deque<Integer> smallestElements = new ArrayDeque<>();
        while (!tempStack.isEmpty()) {
            int current = tempStack.pop();
            if (current != min) {
                inputStack.push(current);
            } else {
                smallestElements.push(current);
            }
        }
        
        // Push smallest elements back to inputStack in reverse order
        while (!smallestElements.isEmpty()) {
            inputStack.push(smallestElements.pop());
        }
        
        return inputStack;
    }

    public static void main(String[] args) {
        Deque<Integer> inputStack = new ArrayDeque<>();
        inputStack.push(10);
        inputStack.push(8);
        inputStack.push(5);
        inputStack.push(12);
        inputStack.push(5);
    
        Deque<Integer> updatedStack = changeSmallest(inputStack);
        
        System.out.println("Stack After Modification:");
        for (Integer value : updatedStack)
            System.out.println(value);
    }
}
