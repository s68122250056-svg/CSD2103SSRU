import java.util.Scanner;

public class SearchStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] student = { "Somchai", "Somsri", "Anan", "Nida",
                "Prasit" };
        System.out.print("Enter name to search: ");
        String searchName = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < student.length; i++) {
            if (student[i].equals(searchName)) {
                found = true;
                break;
            }

        }
        if (found) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
        sc.close();
    }
}