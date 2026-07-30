วิธีที่ 1 Reverse and Compare
1. แนวคิด

ขั้นแรกทำความสะอาดข้อความก่อน โดย

เปลี่ยนเป็นตัวพิมพ์เล็ก
เก็บเฉพาะตัวอักษรภาษาอังกฤษ
ไม่นับช่องว่าง
ไม่นับเครื่องหมายวรรคตอน
ข้อความเดิม:
A man, a plan, a canal: Panama

ข้อความหลังทำความสะอาด:
amanaplanacanalpanama

ข้อความย้อนกลับ:
amanaplanacanalpanama
จึงได้ผลลัพธ์เป็น true

2. Pseudocode
FUNCTION cleanText(s)

    CREATE result as StringBuilder

    FOR each character ch in s
        CONVERT ch to lowercase

        IF ch is English letter
            APPEND ch to result
        END IF
    END FOR

    RETURN result as String

END FUNCTION
FUNCTION isPalindromeByReverse(s)

    clean = cleanText(s)
    CREATE reversed as StringBuilder

    FOR i FROM length(clean) - 1 DOWN TO 0
        APPEND clean[i] to reversed
    END FOR

    IF clean equals reversed
        RETURN true
    ELSE
        RETURN false
    END IF

END FUNCTION

4. ตัวอย่าง Input และ Output

ตัวอย่างที่ 1

Input: racecar
Result: true

ตัวอย่างที่ 2

Input: algorithm
Result: false

ตัวอย่างที่ 3

Input: A man, a plan, a canal: Panama
Result: true

ตัวอย่างที่ 4

Input:
Result: true

สตริงว่างถือว่าเป็น Palindrome เพราะไม่มีตัวอักษรคู่ใดที่ไม่ตรงกัน


5. Time Complexity

ให้ n คือจำนวนตัวอักษรในข้อความเดิม

การทำความสะอาดข้อความใช้เวลา

O(n)

การสร้างข้อความย้อนกลับใช้เวลา

O(n)

การเปรียบเทียบข้อความใช้เวลาสูงสุด

O(n)

ดังนั้นเวลารวมคือ

O(n)+O(n)+O(n)

ตัดค่าคงที่ออก จะได้

O(n)
	​

ทั้งกรณีดีที่สุดและกรณีเลวร้ายที่สุดยังเป็น O(n) เพราะต้องสร้างข้อความย้อนกลับทั้งหมดก่อนเสมอ

6. Space Complexity

ต้องสร้าง

ข้อความหลังทำความสะอาด ขนาดประมาณ n
ข้อความย้อนกลับ ขนาดประมาณ n

ดังนั้น

O(n)
	​

7. ข้อดีและข้อจำกัด

ข้อดี

เข้าใจง่าย
เขียนโปรแกรมง่าย
ไม่มีความเสี่ยงจากการเรียกเมธอดซ้ำ
ใช้กับข้อความขนาดใหญ่ได้ดีกว่า Recursive

ข้อจำกัด

ต้องสร้างข้อความย้อนกลับใหม่
ใช้พื้นที่เพิ่ม O(n)
ไม่สามารถหยุดทันทีเมื่อพบตัวอักษรคู่แรกไม่ตรงกัน เพราะต้องสร้างข้อความย้อนกลับก่อน


วิธีที่ 2 Recursive Two-Pointer
1. แนวคิด

ใช้ตัวชี้ 2 ตำแหน่ง ได้แก่

left = ตำแหน่งแรก
right = ตำแหน่งสุดท้าย

เปรียบเทียบตัวอักษรที่ left และ right

ถ้าไม่เหมือนกัน คืนค่า false
ถ้าเหมือนกัน ให้เลื่อน left ไปทางขวา
ลด right ไปทางซ้าย
เรียกเมธอดซ้ำกับช่วงที่เหลือ

ตัวอย่าง

racecar
r == r
 a == a
  c == c
   e

เมื่อ left >= right แสดงว่าตรวจครบแล้ว จึงคืนค่า true

2. Base Case และ Recursive Case
Base Case
left >= right

หมายถึงตรวจสอบมาถึงตรงกลางหรือผ่านตรงกลางแล้ว จึงคืนค่า true

Recursive Case

ถ้าตัวอักษรที่ตำแหน่ง left และ right เหมือนกัน ให้เรียกเมธอดใหม่ด้วย

left + 1
right - 1

หากไม่เหมือนกัน ให้คืนค่า false ทันที

3. Pseudocode
FUNCTION isPalindromeRecursive(s, left, right)

    IF left >= right
        RETURN true
    END IF

    IF s[left] is not equal to s[right]
        RETURN false
    END IF

    RETURN isPalindromeRecursive(
        s,
        left + 1,
        right - 1
    )

END FUNCTION
5. ตัวอย่าง Input และ Output

ตัวอย่างที่ 1

Input: level
Clean text: level
Result: true

ตัวอย่างที่ 2

Input: algorithm
Clean text: algorithm
Result: false

ตัวอย่างที่ 3

Input: A man, a plan, a canal: Panama
Clean text: amanaplanacanalpanama
Result: true

ตัวอย่างที่ 4

Input: Go hang a salami, I'm a lasagna hog
Clean text: gohangasalamiimalasagnahog
Result: true

6. Time Complexity
กรณีที่ตัวอักษรคู่แรกไม่ตรงกัน
ตัวอย่าง
algorithm
ตัวแรกคือ a และตัวสุดท้ายคือ m ไม่เหมือนกัน จึงหยุดทันที
เฉพาะขั้นตอน Recursive ใช้เวลา
O(1)​
แต่หากรวมขั้นตอนทำความสะอาดข้อความด้วย ยังต้องอ่านข้อความเดิมทั้งหมด จึงเป็น
O(n)​
กรณีที่เป็น Palindrome
ต้องเปรียบเทียบประมาณครึ่งหนึ่งของจำนวนตัวอักษร
2
n​
ใน Big-O ตัดค่าคงที่ออก จึงเป็น
O(n)	​
Worst Case
เกิดเมื่อข้อความเป็น Palindrome หรือคู่ที่ไม่ตรงกันอยู่ใกล้ตรงกลาง
O(n)​
Best Case
หากพิจารณาเฉพาะเมธอด Recursive และคู่แรกไม่ตรงกัน
O(1)​
หากรวมการทำความสะอาดข้อความ
O(n)

7. Space Complexity
เมธอด Recursive เรียกตัวเองประมาณ
n/2	​
ครั้ง
แต่ Big-O ตัดค่าคงที่ออก จึงใช้ call stack
O(n)	​
นอกจากนี้ข้อความหลังทำความสะอาดใช้พื้นที่อีก O(n)
ดังนั้นพื้นที่รวมยังเป็น
O(n)
	
การเปรียบเทียบทั้ง 2 วิธี

หัวข้อ	          Reverse and Compare	        Recursive Two-Pointer
แนวคิด           กลับข้อความแล้วเปรียบเทียบ         เปรียบเทียบซ้ายและขวา
Best-case Time  O(n)                           O(1) เฉพาะการตรวจสอบ
Worst-case Time	O(n)	                       O(n)
Space Complexity	O(n)	                   O(n)
สร้างข้อความย้อนกลับ	สร้าง	                    ไม่สร้าง
หยุดก่อนครบทุกตัวได้	ไม่ได้	                     ได้
ใช้ Call Stack	  ไม่ใช้	                       ใช้
เสี่ยง StackOverflowError	ไม่มี	                มีเมื่อข้อความยาวมาก
เหมาะกับข้อมูลขนาดใหญ่	เหมาะกว่า	                อาจไม่เหมาะ

8สรุป

วิธี Reverse and Compare เหมาะเมื่อ

ต้องการโค้ดที่เข้าใจง่าย
ข้อมูลมีขนาดใหญ่
ไม่ต้องการเสี่ยง StackOverflowError

วิธี Recursive Two-Pointer เหมาะเมื่อ

ต้องการฝึกหลักการ Recursive
ต้องการหยุดทันทีเมื่อพบตัวอักษรไม่ตรงกัน
ข้อมูลมีขนาดไม่ใหญ่มาก

โดยทั่วไปสำหรับการใช้งานจริง วิธี Two-Pointer แบบลูปจะเหมาะที่สุด เพราะหยุดก่อนเวลาได้ และใช้พื้นที่เพียง O(1) แต่ตามโจทย์นี้กำหนดให้ใช้ Recursive Two-Pointer จึงใช้พื้นที่ O(n) จาก call stack





















































