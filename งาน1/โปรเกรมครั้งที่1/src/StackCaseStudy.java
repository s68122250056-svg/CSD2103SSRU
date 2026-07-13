import java.util.Stack;

public class StackCaseStudy {

    public static void main(String[] args) {

        Stack<String> undoStack = new Stack<>();

        undoStack.push("Type Data");
        undoStack.push("Type Structure");
        undoStack.push("Delete Structure");
        undoStack.push("Type Algorithm");
        undoStack.push("Type Java");

        System.out.println("=== Commands in Stack ===");
        System.out.println(undoStack);

        System.out.println("\nUndo 2 Commands");

        for (int i = 0; i < 2; i++) {

            if (!undoStack.isEmpty()) {
                String command = undoStack.pop();
                System.out.println("Undo : " + command);
            } else {
                System.out.println("Stack is empty.");
            }

        }

        System.out.println("\nStack after Undo");
        System.out.println(undoStack);

        System.out.println("\nExplanation:");
        System.out.println("Stack uses LIFO (Last In First Out).");
        System.out.println("The last command added is removed first.");

        System.out.println("\nTime Complexity");
        System.out.println("push() : O(1)");
        System.out.println("pop() : O(1)");
        System.out.println("peek() : O(1)");
    }
}