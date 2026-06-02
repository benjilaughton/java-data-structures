// Benjamin Laughton
// CIS 2353
// Fall 2025
// Prof. Noah Clark

package triage;

/**
 * simulates a hospital triage system using three priority queues
 */
public class TriageSimulator {
    private Queue<String> priority1; // Most urgent
    private Queue<String> priority2; // Moderate
    private Queue<String> priority3; // Least urgent
    
    public TriageSimulator() {
        priority1 = new Queue<>();
        priority2 = new Queue<>();
        priority3 = new Queue<>();
    }
    
    /**
     * adds a patient to the appropriate queue
     * @param lineFromFile - format: "FName LName TriageCode"
     */
    public void add(String lineFromFile) {
        String[] parts = lineFromFile.trim().split("\\s+");
        
        if (parts.length < 3) {
            System.out.println("Invalid line format: " + lineFromFile);
            return;
        }
        
        String firstName = parts[0];
        String lastName = parts[1];
        String triageCode = parts[2].toUpperCase();
        String patientName = firstName + " " + lastName;
        
        // determine priority
        int priority = getPriority(triageCode);
        
        // add to appropriate queue
        switch (priority) {
            case 1:
                priority1.enqueue(patientName);
                System.out.println("Added " + patientName + " to Priority 1 (" + triageCode + ")");
                break;
            case 2:
                priority2.enqueue(patientName);
                System.out.println("Added " + patientName + " to Priority 2 (" + triageCode + ")");
                break;
            case 3:
                priority3.enqueue(patientName);
                System.out.println("Added " + patientName + " to Priority 3 (" + triageCode + ")");
                break;
            default:
                System.out.println("Unknown triage code: " + triageCode);
        }
    }
    
    /**
     * returns the priority level
     */
    private int getPriority(String code) {
        switch (code) {
            case "AL": // Amputated limb
            case "HA": // Heart attack
            case "ST": // Stroke
                return 1;
            case "BL": // Broken leg
            case "SF": // Serious Fall
            case "IW": // Infected wound
            case "KS": // Kidney stones
            case "OT": // Other/Unknown
                return 2;
            case "HN": // Hangnail
                return 3;
            default:
                return 2; // Default to priority 2 for unknown codes
        }
    }
    
    /**
     * removes and returns the next patient to be seen
     * checks priority 1 first, then 2, then 3
     */
    public String remove() {
        if (!priority1.isEmpty()) {
            return priority1.dequeue();
        } else if (!priority2.isEmpty()) {
            return priority2.dequeue();
        } else if (!priority3.isEmpty()) {
            return priority3.dequeue();
        }
        return null; // All queues are empty
    }
    
    /**
     * returns true if all three queues are empty
     */
    public boolean isEmpty() {
        return priority1.isEmpty() && priority2.isEmpty() && priority3.isEmpty();
    }
    
    /**
     * returns the total number of patients waiting
     */
    public int getTotalPatients() {
        return priority1.size() + priority2.size() + priority3.size();
    }
}