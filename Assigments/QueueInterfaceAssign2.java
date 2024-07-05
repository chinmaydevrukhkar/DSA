import java.util.ArrayDeque;
import java.util.Deque;

class Tester {

    public static Deque<Character> updateStack(Deque<Character> inputStack) {
        // Step 1: Create a temporary stack to hold the bottom three elements
        Deque<Character> tempStack = new ArrayDeque<>();
        
        // Step 2: Remove the bottom three elements from inputStack and push them to tempStack
        for (int i = 0; i < 3; i++) {
            tempStack.push(inputStack.removeLast());
        }
        
        // Step 3: Push the elements from tempStack back into inputStack (in their original order)
        while (!tempStack.isEmpty()) {
            inputStack.push(tempStack.pop());
        }
        
        // Step 4: Return the updated inputStack
        return inputStack;
    }
    
    public static void main(String[] args) {
        Deque<Character> inputStack = new ArrayDeque<>();
        inputStack.push('E');
        inputStack.push('D');
        inputStack.push('C');
        inputStack.push('B');
        inputStack.push('A');
        
        Deque<Character> resultStack = updateStack(inputStack);
        
        System.out.println("The alphabets in updated stack are:");
        for(Character alphabet: resultStack)
            System.out.println(alphabet);
    }
}
