// Benjamin Laughton
// CIS 2353
// Fall 2025
// Project 2


package polynomial;

public class Node {
    private int coefficient;
    private int exponent;
    private Node nextNode;
    
    public Node(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.nextNode = null;
    }
    
    public int getCoefficient() {
        return coefficient;
    }
    
    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }
    
    public int getExponent() {
        return exponent;
    }
    
    public void setExponent(int exponent) {
        this.exponent = exponent;
    }
    
    public Node getNextNode() {
        return nextNode;
    }
    
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}