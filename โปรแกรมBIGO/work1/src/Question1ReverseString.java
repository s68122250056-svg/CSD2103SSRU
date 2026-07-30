import java.util.Scanner;

public class Question1ReverseString {

    static String reverseRecursive(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        return s.charAt(s.length() - 1)
                + reverseRecursive(s.substring(0, s.length() - 1));
    }

    static String reverseIterative(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input: ");
        String text = input.nextLine();

        System.out.println("Recursive: " + reverseRecursive(text));
        System.out.println("Iterative: " + reverseIterative(text));
    }
}