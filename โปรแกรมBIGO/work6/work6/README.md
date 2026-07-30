อัลกอริทึมที่ 1 Brute Force
1. แนวคิด

ตรวจสอบสมาชิกทุกคู่ที่เป็นไปได้ โดยใช้ลูปซ้อนกัน

ตัวอย่าง

A[0] + A[1]
A[0] + A[2]
A[0] + A[3]
...
A[1] + A[2]
A[1] + A[3]
...

ถ้าพบคู่ที่ผลรวมเท่ากับ k ให้แสดงค่าทั้งสองและคืนค่า true

ถ้าตรวจครบทุกคู่แล้วยังไม่พบ ให้คืนค่า false

2. Pseudocode
FUNCTION findPairBruteForce(a, k)

    IF a is null OR length of a < 2
        RETURN false
    END IF

    FOR i FROM 0 TO length of a - 2

        FOR j FROM i + 1 TO length of a - 1

            IF a[i] + a[j] == k

                DISPLAY "Pair found: " + a[i] + " and " + a[j]

                RETURN true

            END IF

        END FOR

    END FOR

    DISPLAY "Pair not found"

    RETURN false

END FUNCTION
3. โปรแกรมภาษา Java
public class PairBruteForce {

    static boolean findPairBruteForce(int[] a, int k) {

        // ตรวจสอบกรณีอาร์เรย์ว่างหรือมีสมาชิกไม่ถึง 2 ตัว
        if (a == null || a.length < 2) {
            System.out.println("Pair not found");
            return false;
        }

        // ตรวจสอบสมาชิกทุกคู่
        for (int i = 0; i < a.length - 1; i++) {

            for (int j = i + 1; j < a.length; j++) {

                if (a[i] + a[j] == k) {

                    System.out.println(
                            "Pair found: "
                                    + a[i]
                                    + " and "
                                    + a[j]
                    );

                    return true;
                }
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

        findPairBruteForce(numbers, k);
    }
}
4. ตัวอย่างผลลัพธ์
Pair found: 7 and 11

กรณีไม่พบคู่

A = [2, 4, 7, 11]
k = 30

ผลลัพธ์

Pair not found
5. Time Complexity

ในกรณีเลวร้ายที่สุด ต้องตรวจสอบทุกคู่

จำนวนคู่ทั้งหมดคือ

2
n(n−1)
	​


เมื่อตัดค่าคงที่และพจน์ที่โตช้ากว่าออก จะได้

O(n
2
)
	​

Best Case

ถ้าคู่แรกที่ตรวจสอบมีผลรวมเท่ากับ k

O(1)
	​

Worst Case

ถ้าไม่มีคู่ที่ต้องการ หรือคู่ที่ต้องการอยู่ช่วงท้าย

O(n
2
)
	​

6. Space Complexity

ใช้เพียงตัวแปร

i
j

จึงใช้พื้นที่เสริมคงที่

O(1)
	​

อัลกอริทึมที่ 2 Recursive Two-Pointer
1. แนวคิด

กำหนดตัวชี้ 2 ตำแหน่ง

left = 0
right = n - 1

คำนวณ

sum = a[left] + a[right]

แล้วพิจารณา

ถ้า sum == k พบคู่ที่ต้องการ
ถ้า sum < k ต้องเพิ่มผลรวม จึงเลื่อน left ไปทางขวา
ถ้า sum > k ต้องลดผลรวม จึงเลื่อน right ไปทางซ้าย
2. Base Case

กรณีที่ตัวชี้มาพบกันหรือผ่านกัน

left >= right

แสดงว่าไม่มีสมาชิกสองค่าที่แตกต่างกันเหลือให้ตรวจสอบ จึงคืนค่า false

3. Recursive Case

กรณีผลรวมน้อยกว่า k

findPairRecursive(a, k, left + 1, right)

กรณีผลรวมมากกว่า k

findPairRecursive(a, k, left, right - 1)
4. Pseudocode
FUNCTION findPairRecursive(a, k, left, right)

    IF a is null OR length of a < 2
        RETURN false
    END IF

    IF left >= right
        RETURN false
    END IF

    sum = a[left] + a[right]

    IF sum == k

        DISPLAY "Pair found: " + a[left] + " and " + a[right]

        RETURN true

    ELSE IF sum < k

        RETURN findPairRecursive(
            a,
            k,
            left + 1,
            right
        )

    ELSE

        RETURN findPairRecursive(
            a,
            k,
            left,
            right - 1
        )

    END IF

END FUNCTION
6. ตัวอย่างการทำงาน
A = [2, 4, 7, 11, 15, 20]
k = 18

รอบที่ 1

left = 0
right = 5

2 + 20 = 22
22 > 18

ลด right

รอบที่ 2

left = 0
right = 4

2 + 15 = 17
17 < 18

เพิ่ม left

รอบที่ 3

left = 1
right = 4

4 + 15 = 19
19 > 18

ลด right

รอบที่ 4

left = 1
right = 3

4 + 11 = 15
15 < 18

เพิ่ม left

รอบที่ 5

left = 2
right = 3

7 + 11 = 18

ผลลัพธ์

Pair found: 7 and 11
7. Time Complexity

ในแต่ละครั้ง ตัวชี้ left หรือ right จะเลื่อนอย่างน้อยหนึ่งตำแหน่ง

ระยะห่างระหว่างตัวชี้มีประมาณ n ตำแหน่ง จึงเรียกเมธอดไม่เกินประมาณ n ครั้ง

ดังนั้น

O(n)
	​

Best Case

ถ้าสมาชิกตัวแรกและตัวสุดท้ายรวมกันเท่ากับ k

O(1)
	​

Worst Case

หากไม่พบคู่ หรือพบในขั้นตอนสุดท้าย

O(n)
	​

8. Space Complexity

แม้จะใช้ตัวแปรไม่มาก แต่เป็น Recursive Algorithm

ในกรณีเลวร้ายที่สุดมี recursive call ประมาณ n ชั้น จึงใช้ call stack

O(n)
	​

อัลกอริทึมที่ 3 Binary Search
1. แนวคิด

เลือกสมาชิก a[i] ทีละตัว แล้วหาค่าที่ต้องการมาจับคู่

target = k - a[i]

จากนั้นใช้ Binary Search ค้นหา target ในตำแหน่งหลัง i

ตัวอย่าง

a[i] = 7
k = 18

target = 18 - 7
target = 11

จากนั้นค้นหา 11 ในอาร์เรย์

2. เหตุผลที่ค้นหาเฉพาะตำแหน่งหลัง i

ถ้าค้นหาทั้งอาร์เรย์ อาจพบสมาชิกตำแหน่งเดิม และอาจตรวจสอบคู่เดิมซ้ำ

จึงค้นหาในช่วง

i + 1 ถึง n - 1

เพื่อให้สมาชิกทั้งสองเป็นคนละตำแหน่งและไม่ตรวจสอบคู่ซ้ำ

3. Pseudocode ของ Binary Search
FUNCTION binarySearch(a, target, left, right)

    WHILE left <= right

        middle = left + (right - left) / 2

        IF a[middle] == target
            RETURN middle

        ELSE IF a[middle] < target
            left = middle + 1

        ELSE
            right = middle - 1

        END IF

    END WHILE

    RETURN -1

END FUNCTION
4. Pseudocode ของ findPairBinarySearch
FUNCTION findPairBinarySearch(a, k)

    IF a is null OR length of a < 2
        RETURN false
    END IF

    FOR i FROM 0 TO length of a - 2

        target = k - a[i]

        index = binarySearch(
            a,
            target,
            i + 1,
            length of a - 1
        )

        IF index is not -1

            DISPLAY "Pair found: " + a[i] + " and " + a[index]

            RETURN true

        END IF

    END FOR

    DISPLAY "Pair not found"

    RETURN false

END FUNCTION
6. โปรแกรมต้องไม่หยุดทำงานผิดปกติเมื่อรับข้อมูลว่าง

ในแต่ละเมธอดมีการตรวจสอบก่อนว่าอาร์เรย์เป็น null หรือมีสมาชิกน้อยกว่า 2 ตัวหรือไม่

if (numbers == null || numbers.length < 2) {
    return false;
}

จึงไม่เกิด Error เช่น

NullPointerException
ArrayIndexOutOfBoundsException

ตัวอย่างทดสอบกรณีอาร์เรย์ว่าง

int[] emptyData = {};

boolean result =
        findPairBruteForce(emptyData, 18);

if (!result) {
    System.out.println("Pair not found");
}

ผลลัพธ์

Pair not found

7. อธิบาย Base Case และ Recursive Case
Base Case
if (numbers == null || numbers.length < 2) {
    return false;
}

ถ้าอาร์เรย์ว่าง เป็น null หรือมีสมาชิกน้อยกว่า 2 ตัว จะไม่สามารถสร้างคู่จำนวนได้ จึงคืนค่า false

อีก Base Case คือ

if (left >= right) {
    return false;
}

เมื่อ left มาพบหรือผ่าน right แสดงว่าไม่มีสมาชิกสองตำแหน่งเหลือให้ตรวจสอบ จึงคืนค่า false

กรณีพบคู่ที่ต้องการก็ถือเป็น Base Case เช่นกัน

if (currentSum == targetSum) {
    System.out.println(
            "Pair found: "
                    + numbers[left]
                    + " and "
                    + numbers[right]
    );

    return true;
}

เมื่อผลรวมเท่ากับ k จะคืนค่า true และหยุดการเรียกเมธอดทันที

Recursive Case

ถ้าผลรวมน้อยกว่า k

return findPairRecursive(
        numbers,
        targetSum,
        left + 1,
        right
);

เลื่อน left ไปทางขวา เพราะอาร์เรย์เรียงจากน้อยไปมาก ค่าตำแหน่งถัดไปจะมากขึ้น ทำให้ผลรวมมีโอกาสเพิ่มขึ้น

ถ้าผลรวมมากกว่า k

return findPairRecursive(
        numbers,
        targetSum,
        left,
        right - 1
);

เลื่อน right ไปทางซ้าย เพราะค่าทางซ้ายมีค่าน้อยลง ทำให้ผลรวมมีโอกาสลดลง
ข้อ 8 วิเคราะห์ Big-O พร้อมเหตุผล
อัลกอริทึม	Time Complexity	Space Complexity
Brute Force	O(n²)	O(1)
Recursive Two-Pointer	O(n)	O(n)
Binary Search	O(n log n)	O(1)

Brute Force

ใช้ลูปซ้อนกันเพื่อตรวจสอบสมาชิกทุกคู่

จำนวนคู่ทั้งหมดประมาณ

2
n(n−1)
	​


เมื่อตัดค่าคงที่และพจน์ที่โตช้ากว่าออก จึงได้

O(n
2
)
	​


ใช้ตัวแปรเพิ่มเพียง i และ j ไม่ได้สร้างอาร์เรย์ใหม่ จึงมี Space Complexity

O(1)
	​

Recursive Two-Pointer

แต่ละครั้งจะเพิ่ม left หรือลด right อย่างน้อยหนึ่งตำแหน่ง

ตัวชี้สามารถเคลื่อนที่รวมกันได้ไม่เกินประมาณ n ครั้ง จึงมี Time Complexity

O(n)
	​


แต่ใช้การเรียกเมธอดแบบ Recursive สูงสุดประมาณ n ชั้น จึงใช้ Call Stack

O(n)
	​

Binary Search

ลูปเลือกสมาชิก a[i] ประมาณ n ตัว

แต่ละรอบใช้ Binary Search ค้นหาค่า

k - a[i]

Binary Search ใช้เวลา

O(logn)

ดังนั้นเวลารวมคือ

O(n)×O(logn)

จึงได้

O(nlogn)
	​


Binary Search ในโปรแกรมใช้ลูป ไม่ได้ใช้ Recursive และไม่ได้สร้างอาร์เรย์ใหม่ จึงใช้พื้นที่เพิ่มคงที่

O(1)
	​
