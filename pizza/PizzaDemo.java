package proj1;

import java.util.ArrayList;

/**
 * PizzaDemo class to test Pizza class functionality
 * tests equals() and compareTo() methods
 */
public class PizzaDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Pizza Class Testing Demo ===\n");
        
        // test 1: create pizzas using default constructor
        System.out.println("Test 1: Creating pizzas with default constructor");
        Pizza pizza1 = new Pizza();
        System.out.println("Pizza 1 (default):");
        System.out.println(pizza1);
        System.out.println();
        
        // test 2: create pizzas using parameterized constructor
        System.out.println("Test 2: Creating pizzas with parameterized constructor");
        ArrayList<String> toppings2 = new ArrayList<>();
        toppings2.add("cheese");
        toppings2.add("pepperoni");
        toppings2.add("ham");
        toppings2.add("onion");
        Pizza pizza2 = new Pizza(Pizza.CrustType.Butter, toppings2, Pizza.SizeType.Large);
        System.out.println("Pizza 2:");
        System.out.println(pizza2);
        System.out.println();
        
        // test 3: create another pizza and add toppings individually
        System.out.println("Test 3: Adding toppings individually");
        Pizza pizza3 = new Pizza();
        pizza3.setCrust(Pizza.CrustType.Garlic);
        pizza3.setSize(Pizza.SizeType.Medium);
        pizza3.addTopping("cheese");
        pizza3.addTopping("Italian sausage");
        pizza3.addTopping("green pepper");
        System.out.println("Pizza 3:");
        System.out.println(pizza3);
        System.out.println();
        
        // test 4: create pizza with same characteristics as pizza3 for equals test
        System.out.println("Test 4: Testing equals() method");
        Pizza pizza4 = new Pizza();
        pizza4.setCrust(Pizza.CrustType.Garlic);
        pizza4.setSize(Pizza.SizeType.XLarge); // Different size, shouldn't matter
        pizza4.addTopping("pineapple");
        pizza4.addTopping("ham");
        pizza4.addTopping("cheese");
        System.out.println("Pizza 4:");
        System.out.println(pizza4);
        System.out.println();
        
        // test equals method
        System.out.println("=== Testing equals() method ===");
        System.out.println("Pizza 3 equals Pizza 4? " + pizza3.equals(pizza4) + 
                         " (same crust: Garlic, same # toppings: 3)");
        System.out.println("Pizza 2 equals Pizza 3? " + pizza2.equals(pizza3) + 
                         " (different crust, different # toppings)");
        System.out.println();
        
        // test 5: create more pizzas for compareTo testing
        System.out.println("Test 5: Creating pizzas for compareTo() testing");
        
        // pizza with fewer toppings
        Pizza pizza5 = new Pizza();
        pizza5.setCrust(Pizza.CrustType.Cheese);
        pizza5.addTopping("cheese");
        System.out.println("Pizza 5 (Cheese crust, 1 topping):");
        System.out.println(pizza5);
        System.out.println();
        
        // pizza with more toppings
        ArrayList<String> toppings6 = new ArrayList<>();
        toppings6.add("cheese");
        toppings6.add("pepperoni");
        toppings6.add("onion");
        toppings6.add("green pepper");
        toppings6.add("anchovies");
        Pizza pizza6 = new Pizza(Pizza.CrustType.Plain, toppings6, Pizza.SizeType.Party);
        System.out.println("Pizza 6 (Plain crust, 5 toppings):");
        System.out.println(pizza6);
        System.out.println();
        
        // pizza with same toppings but different crust for crust comparison
        Pizza pizza7 = new Pizza();
        pizza7.setCrust(Pizza.CrustType.GarlicButter);
        pizza7.addTopping("cheese");
        pizza7.addTopping("pepperoni");
        pizza7.addTopping("mushroom");
        System.out.println("Pizza 7 (GarlicButter crust, 3 toppings):");
        System.out.println(pizza7);
        System.out.println();
        
        // test compareTo method
        System.out.println("=== Testing compareTo() method ===");
        System.out.println("Comparison results: -1 = less than, 0 = equal, 1 = greater than\n");
        
        System.out.println("Pizza 5 (1 topping) compareTo Pizza 6 (5 toppings): " + 
                         pizza5.compareTo(pizza6) + " (expected: -1)");
        System.out.println("Pizza 6 (5 toppings) compareTo Pizza 5 (1 topping): " + 
                         pizza6.compareTo(pizza5) + " (expected: 1)");
        System.out.println("Pizza 3 (Garlic, 3) compareTo Pizza 4 (Garlic, 3): " + 
                         pizza3.compareTo(pizza4) + " (expected: 0)");
        System.out.println("Pizza 3 (Garlic, 3) compareTo Pizza 7 (GarlicButter, 3): " + 
                         pizza3.compareTo(pizza7) + " (expected: -1, GarlicButter > Garlic)");
        System.out.println("Pizza 7 (GarlicButter, 3) compareTo Pizza 3 (Garlic, 3): " + 
                         pizza7.compareTo(pizza3) + " (expected: 1, GarlicButter > Garlic)");
        
        // test crust hierarchy with same number of toppings
        System.out.println("\n=== Testing Crust Hierarchy (same # of toppings) ===");
        System.out.println("Hierarchy: Cheese > GarlicButter > Garlic > Butter > Plain\n");
        
        Pizza plainPizza = new Pizza();
        plainPizza.setCrust(Pizza.CrustType.Plain);
        plainPizza.addTopping("cheese");
        
        Pizza butterPizza = new Pizza();
        butterPizza.setCrust(Pizza.CrustType.Butter);
        butterPizza.addTopping("cheese");
        
        Pizza cheesePizza = new Pizza();
        cheesePizza.setCrust(Pizza.CrustType.Cheese);
        cheesePizza.addTopping("cheese");
        
        System.out.println("Plain (1) compareTo Butter (1): " + plainPizza.compareTo(butterPizza) + 
                         " (expected: -1)");
        System.out.println("Butter (1) compareTo Plain (1): " + butterPizza.compareTo(plainPizza) + 
                         " (expected: 1)");
        System.out.println("Plain (1) compareTo Cheese (1): " + plainPizza.compareTo(cheesePizza) + 
                         " (expected: -1)");
        System.out.println("Cheese (1) compareTo Plain (1): " + cheesePizza.compareTo(plainPizza) + 
                         " (expected: 1)");
        
        System.out.println("\n=== Demo Complete ===");
    }
}