// Benjamin Laughton
// CIS 2353
// Fall 2025
// Project 2


package polynomial;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Polynomial> polynomials = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        // Read polynomials from file
        try {
            File file = new File("polynomials.txt");
            Scanner fileScanner = new Scanner(file);
            
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (!line.isEmpty()) {
                    Polynomial poly = new Polynomial(line);
                    polynomials.add(poly);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: polynomials.txt");
            return;
        }
        
        // Main loop
        while (true) {
            System.out.println("\nList of Polynomials:");
            for (int i = 0; i < polynomials.size(); i++) {
                System.out.print(i + ": ");
                polynomials.get(i).print();
                System.out.println();
            }
            
            System.out.println("\nWhich do you wish to add? Press -1 to Exit.");
            String input = scanner.nextLine();
            
            if (input.contains(" ")) {
                String[] indices = input.split("\\s+");
                try {
                    int idx1 = Integer.parseInt(indices[0]);
                    int idx2 = Integer.parseInt(indices[1]);
                    
                    if (idx1 < 0 || idx2 < 0) {
                        break;
                    }
                    
                    if (idx1 >= polynomials.size() || idx2 >= polynomials.size()) {
                        System.out.println("Invalid input. Index out of range.");
                        continue;
                    }
                    
                    Polynomial result = Polynomial.add(polynomials.get(idx1), 
                                                      polynomials.get(idx2));
                    polynomials.add(result);
                    
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                }
            } else {
                try {
                    int num = Integer.parseInt(input);
                    if (num < 0) {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                }
            }
        }
        
        scanner.close();
        System.out.println("Goodbye!");
    }
}