วิธีที่ 1 Recursive Two-Pointer
1. แนวคิด

ใช้ตัวชี้ 2 ตำแหน่ง

left = ตำแหน่งแรก
right = ตำแหน่งสุดท้าย

ตรวจสอบดังนี้

ถ้า a[left] เป็นจำนวนคู่ ให้เลื่อน left
ถ้า a[right] เป็นจำนวนคี่ ให้เลื่อน right
ถ้าด้านซ้ายเป็นจำนวนคี่และด้านขวาเป็นจำนวนคู่ ให้สลับค่า
เรียกเมธอดซ้ำกับช่วงที่เหลือ
Base Case

เมื่อ

left >= right

หมายถึงจัดกลุ่มครบแล้ว ให้หยุดทำงาน

Recursive Case

หลังจากตรวจสอบหรือสลับค่าแล้ว ให้เรียกเมธอดใหม่โดยลดช่วงการทำงานลง

2. Pseudocode
FUNCTION rearrangeRecursive(a, left, right)

    IF a is empty OR left >= right
        RETURN
    END IF

    IF a[left] is even
        CALL rearrangeRecursive(
            a,
            left + 1,
            right
        )

    ELSE IF a[right] is odd
        CALL rearrangeRecursive(
            a,
            left,
            right - 1
        )

    ELSE
        SWAP a[left] and a[right]

        CALL rearrangeRecursive(
            a,
            left + 1,
            right - 1
        )
    END IF

END FUNCTION
4. ตัวอย่างผลลัพธ์
Before: [7, 2, 9, 4, 1, 6, 3, 8]
After: [8, 2, 6, 4, 1, 9, 3, 7]

ผลลัพธ์อาจแตกต่างจากตัวอย่างได้ แต่จำนวนคู่ต้องอยู่ก่อนจำนวนคี่ทั้งหมด

5. Time Complexity

ในแต่ละครั้ง ตัวชี้อย่างน้อยหนึ่งตำแหน่งจะถูกเลื่อนเข้าใกล้กัน

สมาชิกแต่ละตัวถูกตรวจสอบไม่เกินจำนวนคงที่ครั้งหนึ่ง จึงใช้เวลา

O(n)
	​

6. Space Complexity

เมธอด Recursive อาจเรียกตัวเองสูงสุดประมาณ n ครั้ง

จึงใช้พื้นที่ใน call stack

O(n)
	​

7. จำนวนครั้งของการสลับ

สลับเฉพาะกรณีที่

ด้านซ้ายเป็นคี่
ด้านขวาเป็นคู่

จำนวนครั้งสูงสุดประมาณ

2
n
	​


ดังนั้นจำนวนการสลับเป็น

O(n)
8. ข้อดีและข้อจำกัด

ข้อดี

ทำงานแบบ In-place
ไม่ต้องสร้างอาร์เรย์ใหม่
ใช้เวลา O(n)
แสดงแนวคิด Recursive ชัดเจน

ข้อจำกัด

ใช้ call stack O(n)
อาร์เรย์ขนาดใหญ่อาจเกิด StackOverflowError
ไม่รักษาลำดับเดิมของสมาชิก

วิธีที่ 2 Iterative Two-Pointer
1. แนวคิด

ใช้ตัวชี้ left และ right เหมือนวิธี Recursive แต่ใช้ลูป while แทนการเรียกเมธอดซ้ำ

2. Pseudocode
FUNCTION rearrangeTwoPointer(a)

    IF a is empty
        RETURN
    END IF

    left = 0
    right = length of a - 1

    WHILE left < right

        IF a[left] is even
            left = left + 1

        ELSE IF a[right] is odd
            right = right - 1

        ELSE
            SWAP a[left] and a[right]

            left = left + 1
            right = right - 1
        END IF

    END WHILE

END FUNCTION

4. ตัวอย่างผลลัพธ์
Before: [7, 2, 9, 4, 1, 6, 3, 8]
After: [8, 2, 6, 4, 1, 9, 3, 7]
5. Time Complexity

ตัวชี้ left และ right เคลื่อนที่เข้าหากันจนตรวจสอบสมาชิกครบทุกตัว

ดังนั้น

O(n)
	​

6. Space Complexity

ใช้ตัวแปรเพิ่มเพียง

left
right
temp

จึงใช้พื้นที่เสริมคงที่

O(1)
	​

7. จำนวนครั้งของการสลับ

สลับเฉพาะเมื่อด้านซ้ายเป็นคี่และด้านขวาเป็นคู่

จำนวนการสลับสูงสุดประมาณ

2
n
	​


จึงเป็น

O(n)
8. ข้อดีและข้อจำกัด

ข้อดี

ใช้เวลา O(n)
ใช้พื้นที่เพียง O(1)
ทำงานแบบ In-place
ไม่มีความเสี่ยงจาก StackOverflowError

ข้อจำกัด

ไม่รักษาลำดับเดิมของสมาชิก
ผลลัพธ์อาจมีลำดับต่างจากอาร์เรย์เดิม

วิธีที่ 3 Extra Array
1. แนวคิด

สร้างอาร์เรย์ใหม่ที่มีขนาดเท่ากับอาร์เรย์เดิม

ดำเนินการ 2 รอบ

รอบแรก นำจำนวนคู่ใส่ในอาร์เรย์ใหม่
รอบที่สอง นำจำนวนคี่ใส่ต่อจากจำนวนคู่

วิธีนี้รักษาลำดับเดิมของจำนวนคู่และจำนวนคี่ได้

2. Pseudocode
FUNCTION rearrangeExtraArray(a)

    IF a is null
        RETURN empty array
    END IF

    CREATE result with same length as a
    index = 0

    FOR each value in a
        IF value is even
            result[index] = value
            index = index + 1
        END IF
    END FOR

    FOR each value in a
        IF value is odd
            result[index] = value
            index = index + 1
        END IF
    END FOR

    RETURN result

END FUNCTION

4. ตัวอย่างผลลัพธ์
Original: [5, 2, 7, 4, 9, 6]
Result: [2, 4, 6, 5, 7, 9]

สังเกตว่า

จำนวนคู่ยังเรียงตามลำดับเดิม คือ 2, 4, 6
จำนวนคี่ยังเรียงตามลำดับเดิม คือ 5, 7, 9

ดังนั้นวิธีนี้เป็น Stable Algorithm

5. Time Complexity

รอบแรกตรวจสอบสมาชิกทั้งหมด n ตัว

รอบที่สองตรวจสอบสมาชิกทั้งหมดอีก n ตัว

O(n)+O(n)=O(2n)

เมื่อตัดค่าคงที่ จะได้

O(n)
	​

6. Space Complexity

ต้องสร้างอาร์เรย์ใหม่ขนาด n

ดังนั้น

O(n)
	​

7. จำนวนครั้งของการสลับ

วิธีนี้ไม่มีการสลับสมาชิก

Number of swaps = 0

แต่มีการคัดลอกสมาชิกจากอาร์เรย์เดิมไปยังอาร์เรย์ใหม่จำนวน n ครั้ง

8. ข้อดีและข้อจำกัด

ข้อดี

รักษาลำดับเดิมของสมาชิก
เป็น Stable Algorithm
ไม่มีการสลับข้อมูล
ไม่มีความเสี่ยงจาก Stack Overflow
เข้าใจง่าย

ข้อจำกัด

ต้องสร้างอาร์เรย์ใหม่
ใช้พื้นที่เพิ่ม O(n)
ไม่ใช่ In-place Algorithm

สรุป

หากต้องการใช้หน่วยความจำน้อยและไม่จำเป็นต้องรักษาลำดับเดิม ควรเลือก

Iterative Two-Pointer

เพราะใช้เวลา

O(n)

และใช้พื้นที่

O(1)

หากต้องการรักษาลำดับเดิมของจำนวนคู่และจำนวนคี่ ควรเลือก

Extra Array

เพราะเป็น Stable Algorithm แต่ต้องใช้พื้นที่เพิ่ม

O(n)

ส่วน Recursive Two-Pointer เหมาะสำหรับศึกษาหลักการเวียนเกิด แต่ไม่เหมาะกับอาร์เรย์ขนาดใหญ่มาก เนื่องจากอาจเกิด StackOverflowError