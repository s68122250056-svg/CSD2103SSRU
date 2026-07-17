public class ReviewMethod {
    public static int findMax(int a, int b) {
        // เขยีนคําสง่ัทน
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        // เขยีนคําสง่ัทน

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int num1 = sc.nextInt();
        System.out.print("Enter number 2: ");
        int num2 = sc.nextInt();
        int max = findMax(num1, num2);
        System.out.println("Maximum number = " + max);
        sc.close();
    }
}