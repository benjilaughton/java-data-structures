package pizza;

import java.util.ArrayList;

/**
 * Pizza class that implements Comparable interface
 * represents a pizza with crust type, toppings, and size
 */
public class Pizza implements Comparable<Pizza> {
    
    // enumerated type for crust types
    public enum CrustType {
        Plain,
        Butter,
        Garlic,
        GarlicButter,
        Cheese
    }
    
    // enumerated type for size types
    public enum SizeType {
        Small,
        Medium,
        Large,
        XLarge,
        XXLarge,
        Party
    }
    
    // fields
    private CrustType crust;
    private ArrayList<String> toppings;
    private SizeType size;
    
    /**
     * default constructor - initializes fields to default values
     */
    public Pizza() {
        this.crust = CrustType.Plain;
        this.toppings = new ArrayList<>();
        this.size = SizeType.Small;
    }
    
    /**
     * parameterized constructor
     * @param crust The crust type for the pizza
     * @param toppings ArrayList of toppings
     * @param size The size of the pizza
     */
    public Pizza(CrustType crust, ArrayList<String> toppings, SizeType size) {
        this.crust = crust;
        this.toppings = new ArrayList<>(toppings); // Create a copy to avoid external modification
        this.size = size;
    }
    
    // getter and setter methods
    public CrustType getCrust() {
        return crust;
    }
    
    public void setCrust(CrustType crust) {
        this.crust = crust;
    }
    
    public ArrayList<String> getToppings() {
        return toppings;
    }
    
    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }
    
    public SizeType getSize() {
        return size;
    }
    
    public void setSize(SizeType size) {
        this.size = size;
    }
    
    /**
     * adds an individual topping to the pizza
     * @param topping the topping to add
     */
    public void addTopping(String topping) {
        toppings.add(topping);
    }
    
    /**
     * returns a string representation of the pizza
     * @return string containing crust type and all toppings
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("This pizza has a ").append(crust).append(" crust and the following toppings:\n");
        
        if (toppings.isEmpty()) {
            sb.append("none");
        } else {
            for (String topping : toppings) {
                sb.append(topping).append("\n");
            }
            // remove the last newline character
            sb.setLength(sb.length() - 1);
        }
        
        return sb.toString();
    }
    
    /**
     * checks if two pizzas are equal
     * pizzas are equal if they have the same crust and same number of toppings
     * @param obj the object to compare with
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Pizza otherPizza = (Pizza) obj;
        return this.crust == otherPizza.crust && 
               this.toppings.size() == otherPizza.toppings.size();
    }
    
    /**
     * compares this pizza with another pizza
     * first compares by number of toppings, then by crust type
     * crust hierarchy: Cheese > GarlicButter > Garlic > Butter > Plain
     * @param otherPizza the pizza to compare with
     * @return -1 if this pizza is less than, 0 if equal, 1 if greater than
     */
    @Override
    public int compareTo(Pizza otherPizza) {
        // first check if they're equal
        if (this.equals(otherPizza)) {
            return 0;
        }
        
        // compare by number of toppings first
        if (this.toppings.size() < otherPizza.toppings.size()) {
            return -1;
        } else if (this.toppings.size() > otherPizza.toppings.size()) {
            return 1;
        }
        
        // same number of toppings, compare by crust
        // assign values based on hierarchy: Cheese > GarlicButter > Garlic > Butter > Plain
        int thisCrustValue = getCrustValue(this.crust);
        int otherCrustValue = getCrustValue(otherPizza.crust);
        
        if (thisCrustValue < otherCrustValue) {
            return -1;
        } else if (thisCrustValue > otherCrustValue) {
            return 1;
        }
        
        return 0;
    }
    
    /**
     * helper method to assign numeric values to crust types for comparison
     * higher value means superior crust
     * @param crust the crust type
     * @return numeric value for comparison
     */
    private int getCrustValue(CrustType crust) {
        switch (crust) {
            case Plain:
                return 1;
            case Butter:
                return 2;
            case Garlic:
                return 3;
            case GarlicButter:
                return 4;
            case Cheese:
                return 5;
            default:
                return 0;
        }
    }
}