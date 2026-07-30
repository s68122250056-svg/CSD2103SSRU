import java.util.Arrays;

public class PartitionIterativex {

    static void partitionIterative(int[] a, int k) {

        if (a == null || a.length == 0) {
            return;
        }

        int left = 0;
        int right = a.length - 1;

        while (left < right) {

            // ด้านซ้ายอยู่ถูกกลุ่มแล้ว
            if (a[left] <= k) {

                left++;

            // ด้านขวาอยู่ถูกกลุ่มแล้ว
            } else if (a[right] > k) {

                right--;

            // ซ้าย > k และขวา <= k
            } else {

                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;

                left++;
                right--;
            }
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

        partitionIterative(numbers, k);

        System.out.println(
                "After: "
                        + Arrays.toString(numbers)
        );
    }
}