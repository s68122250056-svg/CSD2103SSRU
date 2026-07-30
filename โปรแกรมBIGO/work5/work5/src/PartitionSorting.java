import java.util.Arrays;

public class PartitionSorting {

    static void partitionBySorting(int[] a, int k) {

        if (a == null || a.length == 0) {
            return;
        }

        Arrays.sort(a);

        int lastIndex = -1;

        for (int i = 0; i < a.length; i++) {

            if (a[i] <= k) {
                lastIndex = i;
            } else {
                break;
            }
        }

        System.out.println(
                "Last index with value <= k: "
                        + lastIndex);
    }

    public static void main(String[] args) {

        int[] numbers = {
                12, 4, 7, 15, 3, 10, 8
        };

        int k = 8;

        System.out.println(
                "Before: "
                        + Arrays.toString(numbers));

        partitionBySorting(numbers, k);

        System.out.println(
                "After: "
                        + Arrays.toString(numbers));
    }
}