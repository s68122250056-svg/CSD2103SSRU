วิธีที่ 1 Recursive Partition
1. แนวคิด

ใช้ตัวชี้ 2 ตำแหน่ง

left = ตำแหน่งแรก
right = ตำแหน่งสุดท้าย

ตรวจสอบดังนี้

ถ้า a[left] <= k ให้เลื่อน left
ถ้า a[right] > k ให้เลื่อน right
ถ้าด้านซ้ายมากกว่า k และด้านขวาน้อยกว่าหรือเท่ากับ k ให้สลับค่า
เรียกเมธอดซ้ำกับช่วงที่เหลือ
Base Case

เมื่อ

left >= right

หมายถึงแบ่งกลุ่มเสร็จแล้ว ให้หยุดทำงาน

Recursive Case

หลังจากตรวจสอบหรือสลับค่าแล้ว ให้เรียกเมธอดใหม่โดยลดช่วงการทำงานลง

2. Pseudocode
FUNCTION partitionRecursive(a, k, left, right)

    IF a is empty OR left >= right
        RETURN
    END IF

    IF a[left] <= k

        CALL partitionRecursive(
            a,
            k,
            left + 1,
            right
        )

    ELSE IF a[right] > k

        CALL partitionRecursive(
            a,
            k,
            left,
            right - 1
        )

    ELSE

        SWAP a[left] and a[right]

        CALL partitionRecursive(
            a,
            k,
            left + 1,
            right - 1
        )

    END IF

END FUNCTION
4. ตัวอย่างผลลัพธ์
Before: [12, 4, 7, 15, 3, 10, 8]
After: [8, 4, 7, 3, 15, 10, 12]

ผลลัพธ์อาจไม่เหมือนกันทุกครั้ง แต่สมาชิกที่ <= k ต้องอยู่ก่อนสมาชิกที่ > k

5. Time Complexity

ตัวชี้ left และ right เคลื่อนเข้าหากัน

สมาชิกแต่ละตัวถูกตรวจสอบไม่เกินจำนวนคงที่ครั้งหนึ่ง

ดังนั้น

O(n)
	​

6. Space Complexity

Recursive อาจเรียกตัวเองสูงสุดประมาณ n ครั้ง

จึงใช้ call stack

O(n)
	​

7. ข้อดีและข้อจำกัด

ข้อดี

ทำงานแบบ In-place
ไม่ต้องสร้างอาร์เรย์ใหม่
ใช้เวลา O(n)
แสดงหลักการ Recursive ชัดเจน

ข้อจำกัด

ใช้ call stack
อาร์เรย์ใหญ่มากอาจเกิด StackOverflowError
ไม่รักษาลำดับเดิมของสมาชิก
วิธีที่ 2 Iterative Partition
1. แนวคิด

ใช้หลักการเดียวกับ Recursive Partition แต่เปลี่ยนจากการเรียกเมธอดซ้ำเป็นลูป while

2. Pseudocode
FUNCTION partitionIterative(a, k)

    IF a is empty
        RETURN
    END IF

    left = 0
    right = length of a - 1

    WHILE left < right

        IF a[left] <= k

            left = left + 1

        ELSE IF a[right] > k

            right = right - 1

        ELSE

            SWAP a[left] and a[right]

            left = left + 1
            right = right - 1

        END IF

    END WHILE

END FUNCTION
. ตัวอย่างผลลัพธ์
Before: [12, 4, 7, 15, 3, 10, 8]
After: [8, 4, 7, 3, 15, 10, 12]
5. Time Complexity

ตัวชี้ทั้งสองเคลื่อนที่เข้าหากันจนตรวจสอบครบทุกสมาชิก

ดังนั้น

O(n)
	​

6. Space Complexity

ใช้ตัวแปรเพิ่มเพียง

left
right
temp

จึงเป็น

O(1)
	​

7. ข้อดีและข้อจำกัด

ข้อดี

ทำงานแบบ In-place
ใช้เวลา O(n)
ใช้พื้นที่ O(1)
ไม่มีความเสี่ยงจาก Stack Overflow

ข้อจำกัด

ไม่รักษาลำดับเดิมของสมาชิก
ผลลัพธ์ภายในแต่ละกลุ่มอาจเปลี่ยนลำดับ
วิธีที่ 3 Sorting-Based Algorithm
1. แนวคิด

เรียงอาร์เรย์จากน้อยไปมากก่อน

เมื่อเรียงแล้ว สมาชิกที่น้อยกว่าหรือเท่ากับ k จะอยู่ด้านหน้า และสมาชิกที่มากกว่า k จะอยู่ด้านหลังโดยอัตโนมัติ

จากนั้นค้นหาตำแหน่งสุดท้ายที่มีค่า <= k

2. Pseudocode
FUNCTION partitionBySorting(a, k)

    IF a is empty
        RETURN
    END IF

    SORT a in ascending order

    lastIndex = -1

    FOR i FROM 0 TO length of a - 1

        IF a[i] <= k
            lastIndex = i
        ELSE
            BREAK
        END IF

    END FOR

    DISPLAY lastIndex

END FUNCTION
4. ตัวอย่างผลลัพธ์
Before: [12, 4, 7, 15, 3, 10, 8]
Last index with value <= k: 3
After: [3, 4, 7, 8, 10, 12, 15]
5. Time Complexity

การเรียงอาร์เรย์ใช้เวลาโดยทั่วไป

O(nlogn)

การค้นหาตำแหน่งสุดท้ายใช้เวลา

O(n)

รวมเป็น

O(nlogn)+O(n)

พจน์ที่โตเร็วที่สุดคือ n log n

ดังนั้น

O(nlogn)
	​

6. Space Complexity

Arrays.sort() สำหรับ int[] ใช้พื้นที่เสริมค่อนข้างน้อยและทำงานกับอาร์เรย์เดิม

โดยทั่วไปสามารถวิเคราะห์พื้นที่เสริมได้เป็น

O(logn)
	​


ทั้งนี้ขึ้นอยู่กับอัลกอริทึมเรียงลำดับที่ Java ใช้

7. เหตุผลที่การเรียงลำดับช้ากว่าที่จำเป็น

โจทย์ต้องการเพียงแบ่งข้อมูลออกเป็น 2 กลุ่ม คือ

<= k
> k

ไม่ได้ต้องการเรียงสมาชิกทั้งหมด

Recursive และ Iterative Partition ตรวจสอบสมาชิกแต่ละตัวเพียงครั้งเดียว จึงใช้เวลา O(n)

แต่ Sorting-Based ต้องเรียงลำดับสมาชิกทั้งหมด จึงใช้เวลา O(n log n) ซึ่งมากกว่าที่จำเป็น

การเปรียบเทียบทั้ง 3 วิธี
หัวข้อ	Recursive Partition	Iterative Partition	Sorting-Based
Time Complexity	O(n)	O(n)	O(n log n)
Space Complexity	O(n)	O(1)	O(log n) โดยประมาณ
In-place	ใช่	ใช่	ใช่
เปลี่ยนอาร์เรย์เดิม	เปลี่ยน	เปลี่ยน	เปลี่ยน
ใช้ Recursive Call	ใช้	ไม่ใช้	ขึ้นกับวิธี sort
รักษาลำดับเดิม	ไม่รักษา	ไม่รักษา	เรียงลำดับใหม่ทั้งหมด
เสี่ยง StackOverflowError	มี	ไม่มี	โดยทั่วไปไม่มีจากโค้ดผู้

สรุป

หากต้องการประสิทธิภาพดีที่สุด ควรเลือก

Iterative Partition

เพราะใช้เวลา

O(n)

ใช้พื้นที่เสริม

O(1)

และทำงานแบบ In-place

Recursive Partition เหมาะสำหรับศึกษาหลักการเวียนเกิด แต่มีข้อจำกัดเรื่อง call stack

Sorting-Based Algorithm เหมาะเมื่อผู้ใช้ต้องการให้อาร์เรย์เรียงลำดับด้วย แต่หากต้องการเพียงแบ่งข้อมูลตามค่า k การเรียงลำดับถือว่าช้ากว่าที่จำเป็น
