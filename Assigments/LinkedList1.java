import java.util.LinkedList;
import java.util.*;

class Tester {

	public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> set = new LinkedHashSet<Integer>(list); 
        List<Integer> updatedList = new LinkedList<>(set);
        //Implement your logic here and change the return statement accordingly
        return updatedList;
	}
	
	public static void main(String args[]) {
		List<Integer> list = new LinkedList<Integer>();
		list.add(10);
		list.add(15);
		list.add(15);
		list.add(15);
		list.add(10);
		
		List<Integer> updatedList = removeDuplicates(list);
		
		System.out.println("Linked list without duplicates");
		for (Integer value : updatedList) {
			System.out.print(value+" ");
		}
	}
	
}
