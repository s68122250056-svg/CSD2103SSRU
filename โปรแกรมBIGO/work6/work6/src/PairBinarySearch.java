public class PairBinarySearch {

    static int binarySearch(
            int[] a,
            int target,
            int left,
            int right
    ) {

        while (left <= right) {

            int middle = left + (right - left) / 2;

            if (a[middle] == target) {

                return middle;

            } else if (a[middle] < target) {

                left = middle + 1;

            } else {

                right = middle - 1;
            }
        }

        return -1;
    }

    static boolean findPairBinarySearch(int[] a, int k) {

        if (a == null || a.length < 2) {
            System.out.println("Pair not found");
            return false;
        }

        for (int i = 0; i < a.length - 1; i++) {

            int target = k - a[i];

            int index = binarySearch(
                    a,
                    target,
                    i + 1,
                    a.length - 1
            );

            if (index != -1) {

                System.out.println(
                        "Pair found: "
                                + a[i]
                                + " and "
                                + a[index]
                );

                return true;
            }
        }

        System.out.println("Pair not found");
        return false;
    }

    public static void main(String[] args) {

        int[] numbers = {
                2, 4, 7, 11, 15, 20
        };

        int k = 18;

        findPairBinarySearch(numbers, k);
    }
}