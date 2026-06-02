// Benjamin Laughton
// CIS 2353
// Fall 2025
// Prof. Noah Clark

package triage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TriageMain {
    
    public static void main(String[] args) {
        TriageSimulator simulator = new TriageSimulator();
        
        // filereader
        String filename = "patients.txt";
        
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            
            System.out.println("===== READING PATIENTS FROM FILE =====\n");
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.trim().isEmpty()) {
                    simulator.add(line);
                }
            }
            
            scanner.close();
            
            System.out.println("\n===== PROCESSING PATIENTS IN TRIAGE ORDER =====\n");
            
            // patient processing
            int patientNumber = 1;
            while (!simulator.isEmpty()) {
                String nextPatient = simulator.remove();
                System.out.println("Patient #" + patientNumber + " to be seen: " + nextPatient);
                patientNumber++;
            }
            
            System.out.println("\n===== ALL PATIENTS PROCESSED =====");
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: File '" + filename + "' not found.");
            System.out.println("Please create a file with patient data in the format:");
            System.out.println("FirstName LastName TriageCode");
            System.out.println("\nExample file content:");
            System.out.println("Ilene Dover SF");
            System.out.println("Sum-Yung Gai BL");
            System.out.println("Jacques Strap IW");
            System.out.println("Wilma Fingaheel HN");
            System.out.println("Seymour Butts AL");
            System.out.println("Omai Chestowsh HA");
            System.out.println("Alotta Payne KS");
            System.out.println("Mike Rotchertz KS");
        }
    }
}