import java.util.LinkedList;
import java.util.Queue;

public class QueueCaseStudy {

    public static void main(String[] args) {

        Queue<String> patientQueue = new LinkedList<>();

        patientQueue.add("P001");
        patientQueue.add("P002");
        patientQueue.add("P003");
        patientQueue.add("P004");
        patientQueue.add("P005");

        System.out.println("Initial Queue");
        System.out.println(patientQueue);

        System.out.println("\nPatients Served");

        for (int i = 0; i < 2; i++) {

            if (!patientQueue.isEmpty()) {
                System.out.println(patientQueue.remove());
            } else {
                System.out.println("Queue is empty.");
            }

        }

        patientQueue.add("P006");
        patientQueue.add("P007");

        System.out.println("\nNext Patient");
        System.out.println(patientQueue.peek());

        System.out.println("\nPatients Waiting");
        System.out.println(patientQueue.size());

        System.out.println("\nQueue Status");
        System.out.println(patientQueue);

        System.out.println("\nExplanation:");
        System.out.println("Queue uses FIFO (First In First Out).");
        System.out.println("The first patient arriving is served first.");

        System.out.println("\nTime Complexity");
        System.out.println("add() : O(1)");
        System.out.println("remove() : O(1)");
        System.out.println("peek() : O(1)");
    }
}