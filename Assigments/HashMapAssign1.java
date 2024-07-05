import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Tester {
    
    public static List<String> sortSales(Map<String, Integer> sales) {
        // Step 1: Convert map entries to list
        List<Entry<String, Integer>> list = new ArrayList<>(sales.entrySet());
        
        // Step 2: Sort the list based on sales in descending order
        Collections.sort(list, (entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        
        // Step 3: Extract names in sorted order
        List<String> sortedEmployees = new ArrayList<>();
        for (Entry<String, Integer> entry : list) {
            sortedEmployees.add(entry.getKey());
        }
        
        // Step 4: Return the sorted list of employee names
        return sortedEmployees;
    }

    public static void main(String args[]) {
        Map<String, Integer> sales = new HashMap<>();
        sales.put("Mathew", 50);
        sales.put("Lisa", 76);
        sales.put("Courtney", 45);
        sales.put("David", 49);
        sales.put("Paul", 49);
        
        List<String> employees = sortSales(sales);
        
        System.out.println("Employees in the decreasing order of their sales\n=====================================");
        for (String employeeName : employees) {
            System.out.println(employeeName);
        }
    }

}
