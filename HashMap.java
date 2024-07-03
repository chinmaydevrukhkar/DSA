import java.util.HashMap;
import java.util.Map;

class Tester {

    public static void main(String args[]) {
        Map<String, Double> studentMarks = new HashMap<>();
        studentMarks.put("Lily", 90.0);
        studentMarks.put("Robin", 68.0);
        studentMarks.put("Marshall", 76.5);
        studentMarks.put("Neil", 67.0);
        studentMarks.put("Ted", 92.0);
        
        Map<String, Double> maxMinScorers = Student.findMaxMinScorers(studentMarks);
        
        if (maxMinScorers != null) {
            System.out.println("Details of Top Scorers & Low Scorers\n====================================");
            for (Map.Entry<String, Double> entry : maxMinScorers.entrySet()) {
                System.out.println(entry.getKey() + " -- " + entry.getValue());
            }
        } else {
            System.out.println("No student records found.");
        }
    }
}

class Student {
    
    public static Map<String, Double> findMaxMinScorers(Map<String, Double> studentMarks) {
        if (studentMarks == null || studentMarks.isEmpty()) {
            return null; // or return an empty map based on requirements
        }
        
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        String topScorer = null;
        String lowScorer = null;
        
        for (Map.Entry<String, Double> entry : studentMarks.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                topScorer = entry.getKey();
            }
            if (entry.getValue() < min) {
                min = entry.getValue();
                lowScorer = entry.getKey();
            }
        }
        
        // Create a map to store the results
        Map<String, Double> maxMinScorers = new HashMap<>();
        maxMinScorers.put("Top Scorer", max);
        maxMinScorers.put("Low Scorer", min);
        
        return maxMinScorers;
    }
}
