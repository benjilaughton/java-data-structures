// Benjamin Laughton
// Project 3
// CIS 2353

package proj3;

/**
 * test class to demonstrate the functionality of ChangeStack
 */
public class TestChangeStack {
    
    public static void main(String[] args) {
        System.out.println("=== ChangeStack Testing ===\n");
        
        // Test 1: basic push and pop operations
        System.out.println("Test 1: Basic Push and Pop");
        ChangeStack stack1 = new ChangeStack();
        stack1.push(5);
        stack1.push(10);
        stack1.push(15);
        System.out.println(stack1);
        System.out.println("Popped: " + stack1.pop());
        System.out.println(stack1);
        System.out.println();
        
        // Test 2: peek operation
        System.out.println("Test 2: Peek Top");
        System.out.println("Top element (peek): " + stack1.peekTop());
        System.out.println("Stack after peek: " + stack1);
        System.out.println();
        
        // Test 3: increase values
        System.out.println("Test 3: Increase Values");
        ChangeStack stack2 = new ChangeStack();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);
        System.out.println("Original: " + stack2);
        stack2.increaseValues(3, 10);
        System.out.println("After increasing bottom 3 by 10: " + stack2);
        System.out.println();
        
        // Test 4: decrease values
        System.out.println("Test 4: Decrease Values");
        System.out.println("Before decrease: " + stack2);
        stack2.decreaseValues(2, 5);
        System.out.println("After decreasing bottom 2 by 5: " + stack2);
        System.out.println();
        
        // Test 5: increase more elements than exist
        System.out.println("Test 5: Increase More Than Stack Size");
        ChangeStack stack3 = new ChangeStack();
        stack3.push(1);
        stack3.push(2);
        stack3.push(3);
        System.out.println("Original (3 elements): " + stack3);
        stack3.increaseValues(10, 5);
        System.out.println("After increasing bottom 10 by 5: " + stack3);
        System.out.println();
        
        // Test 6: operations on empty stack
        System.out.println("Test 6: Empty Stack Operations");
        ChangeStack stack4 = new ChangeStack();
        System.out.println("Empty stack: " + stack4);
        stack4.increaseValues(5, 10);
        System.out.println("After increase on empty stack: " + stack4);
        
        // test exception handling
        System.out.println("\nTest 7: Exception Handling");
        try {
            stack4.pop();
        } catch (StackEmptyException e) {
            System.out.println("Caught exception on pop: " + e.getMessage());
        }
        
        try {
            stack4.peekTop();
        } catch (StackEmptyException e) {
            System.out.println("Caught exception on peek: " + e.getMessage());
        }
        System.out.println();
        
        // Test 8: complex scenario
        System.out.println("Test 8: Complex Scenario");
        ChangeStack stack5 = new ChangeStack();
        for (int i = 1; i <= 6; i++) {
            stack5.push(i * 10);
        }
        System.out.println("Initial stack: " + stack5);
        stack5.increaseValues(4, 5);
        System.out.println("After increasing bottom 4 by 5: " + stack5);
        stack5.decreaseValues(3, 10);
        System.out.println("After decreasing bottom 3 by 10: " + stack5);
        System.out.println("Popped: " + stack5.pop());
        System.out.println("Final stack: " + stack5);
        System.out.println();
        
        System.out.println("=== All Tests Complete ===");
    }
}