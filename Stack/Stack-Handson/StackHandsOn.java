import java.util.Stack;

public class StackHandsOn {
    public static void main(String[] args) {
        // Creating stack
        Stack<Integer> s = new Stack<>();
        
        // Pushing elements into the stack
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);

        // Get top element from the stack
        System.out.println("Top element: " + s.peek());

        // check whether stack is empty or not
        System.out.println("Stack empty: " + s.isEmpty());

        // Delete element from top
        if (!s.isEmpty()) {
            System.out.println("Deleted element: " + s.pop());
        }
        
        // Search an element in the stack(1-based indexing)
        System.out.println("Element 7 index: " + s.search(7));

        // Printing stack
        System.out.println(s);
    }  
}
