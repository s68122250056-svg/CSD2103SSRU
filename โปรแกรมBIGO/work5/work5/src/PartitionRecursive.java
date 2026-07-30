import java.util.Arrays;

public class PartitionRecursive {

    static void partitionRecursive(
            int[] a,
            int k,
            int left,
            int right
    ) {

        // Base Case
        if (a == null || a.length == 0 || left >= right) {
            return;
        }

        // ค่าด้านซ้ายอยู่ถูกกลุ่มแล้ว
        if (a[left] <= k) {

            partitionRecursive(
                    a,
                    k,
                    left + 1,
                    right
            );

        // ค่าด้านขวาอยู่ถูกกลุ่มแล้ว
        } else if (a[right] > k) {

            partitionRecursive(
                    a,
                    k,
                    left,
                    right - 1
            );

        // ซ้าย > k และขวา <= k ให้สลับกัน
        } else {

            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;

            partitionRecursive(
                    a,
                    k,
                    left + 1,
                    right - 1
            );
        }
    }

    public static void main(String[] args) {

        int[] numbers = {
                12, 4, 7, 15, 3, 10, 8
        };

        int k = 8;

        System.out.println(
                "Before: "
                        + Arrays.toString(numbers)
        );

        partitionRecursive(
                numbers,
                k,
                0,
                numbers.length - 1
        );

        System.out.println(
                "After: "
                        + Arrays.toString(numbers)
        );
    }
}