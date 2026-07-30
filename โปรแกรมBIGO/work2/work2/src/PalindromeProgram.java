import java.util.Scanner;

public class PalindromeProgram {

    static String cleanText(String s) {

        if (s == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = Character.toLowerCase(s.charAt(i));

            if (ch >= 'a' && ch <= 'z') {
                result.append(ch);
            }
        }

        return result.toString();
    }

    static boolean isPalindromeByReverse(String s) {

        String clean = cleanText(s);

        StringBuilder reversed = new StringBuilder();

        for (int i = clean.length() - 1; i >= 0; i--) {
            reversed.append(clean.charAt(i));
        }

        return clean.equals(reversed.toString());
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Input: ");
        String text = input.nextLine();

        boolean result = isPalindromeByReverse(text);

        System.out.println("Result: " + result);
    }
}