public class PairRecursiveTwoPointer {

    static boolean findPairRecursive(
            int[] a,
            int k,
            int left,
            int right
    ) {

        // ตรวจสอบกรณีอาร์เรย์ว่าง
        if (a == null || a.length < 2) {
            return false;
        }

        // Base Case: ตัวชี้มาพบกันหรือผ่านกัน
        if (left >= right) {
            return false;
        }

        int sum = a[left] + a[right];

        // พบคู่ที่ต้องการ
        if (sum == k) {

            System.out.println(
                    "Pair found: "
                            + a[left]
                            + " and "
                            + a[right]
            );

            return true;

        // ผลรวมน้อยเกินไป ต้องเพิ่ม left
        } else if (sum < k) {

            return findPairRecursive(
                    a,
                    k,
                    left + 1,
                    right
            );

        // ผลรวมมากเกินไป ต้องลด right
        } else {

            return findPairRecursive(
                    a,
                    k,
                    left,
                    right - 1
            );
        }
    }

    public static void main(String[] args) {

        int[] numbers = {
                2, 4, 7, 11, 15, 20
        };

        int k = 18;

        boolean found = findPairRecursive(
                numbers,
                k,
                0,
                numbers.length - 1
        );

        if (!found) {
            System.out.println("Pair not found");
        }
    }
}