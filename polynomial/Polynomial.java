// Benjamin Laughton
// CIS 2353
// Fall 2025
// Project 2


package proj2;

public class Polynomial {
    private Node head;
    
    // No-argument constructor
    public Polynomial() {
        this.head = null;
    }
    
    // String constructor
    public Polynomial(String poly) {
        this.head = null;
        parsePolynomial(poly);
    }
    
    // Copy constructor
    public Polynomial(Polynomial otherPoly) {
        if (otherPoly.head == null) {
            this.head = null;
            return;
        }
        
        // Deep copy
        this.head = new Node(otherPoly.head.getCoefficient(), 
                            otherPoly.head.getExponent());
        Node current = this.head;
        Node otherCurrent = otherPoly.head.getNextNode();
        
        while (otherCurrent != null) {
            Node newNode = new Node(otherCurrent.getCoefficient(), 
                                   otherCurrent.getExponent());
            current.setNextNode(newNode);
            current = newNode;
            otherCurrent = otherCurrent.getNextNode();
        }
    }
    
    // Parse polynomial string and create linked list
    private void parsePolynomial(String poly) {
        poly = poly.replaceAll("\\s+", ""); // Remove whitespace
        String[] terms = poly.split("(?=[+-])"); // Split on + or -
        
        for (String term : terms) {
            if (term.isEmpty()) continue;
            
            int coefficient = 0;
            int exponent = 0;
            
            if (term.contains("x")) {
                String[] parts = term.split("x");
                
                // Get coefficient
                if (parts[0].isEmpty() || parts[0].equals("+")) {
                    coefficient = 1;
                } else if (parts[0].equals("-")) {
                    coefficient = -1;
                } else {
                    coefficient = Integer.parseInt(parts[0]);
                }
                
                // Get exponent
                if (parts.length > 1 && parts[1].startsWith("^")) {
                    exponent = Integer.parseInt(parts[1].substring(1));
                } else {
                    exponent = 1; // Just x, so exponent is 1
                }
            } else {
                // Constant term
                coefficient = Integer.parseInt(term);
                exponent = 0;
            }
            
            addTerm(coefficient, exponent);
        }
    }
    
    // Add a term to the polynomial
    private void addTerm(int coefficient, int exponent) {
        Node newNode = new Node(coefficient, exponent);
        
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(newNode);
        }
    }
    
    // Print the polynomial
    public void print() {
        if (head == null) {
            System.out.print("0");
            return;
        }
        
        Node current = head;
        boolean first = true;
        
        while (current != null) {
            int coef = current.getCoefficient();
            int exp = current.getExponent();
            
            if (!first && coef > 0) {
                System.out.print("+");
            }
            
            if (exp == 0) {
                System.out.print(coef);
            } else if (exp == 1) {
                if (coef == 1) {
                    System.out.print("x");
                } else if (coef == -1) {
                    System.out.print("-x");
                } else {
                    System.out.print(coef + "x");
                }
            } else {
                if (coef == 1) {
                    System.out.print("x^" + exp);
                } else if (coef == -1) {
                    System.out.print("-x^" + exp);
                } else {
                    System.out.print(coef + "x^" + exp);
                }
            }
            
            current = current.getNextNode();
            first = false;
        }
    }
    
    // Static method to add two polynomials
    public static Polynomial add(Polynomial poly1, Polynomial poly2) {
        Polynomial result = new Polynomial();
        
        Node p1 = poly1.head;
        Node p2 = poly2.head;
        
        // Traverse both polynomials
        while (p1 != null || p2 != null) {
            if (p1 != null && (p2 == null || p1.getExponent() > p2.getExponent())) {
                result.addTerm(p1.getCoefficient(), p1.getExponent());
                p1 = p1.getNextNode();
            } else if (p2 != null && (p1 == null || p2.getExponent() > p1.getExponent())) {
                result.addTerm(p2.getCoefficient(), p2.getExponent());
                p2 = p2.getNextNode();
            } else {
                // Same exponent - combine
                int sumCoef = p1.getCoefficient() + p2.getCoefficient();
                if (sumCoef != 0) {
                    result.addTerm(sumCoef, p1.getExponent());
                }
                p1 = p1.getNextNode();
                p2 = p2.getNextNode();
            }
        }
        
        return result;
    }
}