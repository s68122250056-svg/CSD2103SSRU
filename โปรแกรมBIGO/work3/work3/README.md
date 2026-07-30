วิธีที่ 1 Recursive Counting
1. แนวคิด

ตรวจสอบตัวอักษรทีละตัวด้วยการเรียกเมธอดแบบเวียนเกิด (Recursive)

ทุกครั้งที่ตรวจสอบตัวอักษร

ถ้าเป็นสระ เพิ่มตัวนับสระ
ถ้าเป็นพยัญชนะ เพิ่มตัวนับพยัญชนะ
ถ้าเป็นตัวเลข ช่องว่าง หรือเครื่องหมายพิเศษ จะข้ามไป

เมื่อถึงตัวสุดท้ายให้เปรียบเทียบว่า

จำนวนสระ > จำนวนพยัญชนะ ?
Base Case
index == s.length()

คืนค่า

vowels > consonants
Recursive Case

ตรวจสอบตัวอักษรตำแหน่งปัจจุบัน แล้วเรียกเมธอดที่ตำแหน่งถัดไป

index + 1
2. Pseudocode
FUNCTION countRecursive(s,index,vowels,consonants)

    IF index == length of s
        RETURN vowels > consonants
    END IF

    ch = lowercase(s[index])

    IF ch is letter

        IF ch is vowel
            vowels++
        ELSE
            consonants++
        END IF

    END IF

    RETURN countRecursive(
        s,
        index+1,
        vowels,
        consonants
    )

END FUNCTION
4. ตัวอย่าง Input / Output
Input : education

Vowels : 5
Consonants : 4

true

อีกตัวอย่าง

Input : Hello World

Vowels : 3
Consonants : 7

false
5. Time Complexity

ตรวจสอบตัวอักษรทุกตัวหนึ่งครั้ง

จึงเป็น

O(n)
	​

6. Space Complexity

Recursive Call

ประมาณ

n ครั้ง

จึงเป็น

O(n)
	​

7. ข้อดี
เข้าใจหลักการ Recursive
โค้ดสั้น
ข้อเสีย
ใช้ Call Stack
สตริงยาวมากอาจเกิด
StackOverflowError
วิธีที่ 2 Iterative Counting
1. แนวคิด

ใช้ลูปอ่านตัวอักษรทีละตัว

ถ้าเป็นสระ เพิ่มตัวนับสระ
ถ้าเป็นพยัญชนะ เพิ่มตัวนับพยัญชนะ

เมื่อจบลูป

เปรียบเทียบ

vowels > consonants
2. Pseudocode
FUNCTION hasMoreVowelsIterative(s)

    vowels=0
    consonants=0

    FOR each character

        IF character is letter

            IF vowel

                vowels++

            ELSE

                consonants++

            END IF

        END IF

    END FOR

    RETURN vowels>consonants

END FUNCTION
4. ตัวอย่าง Input / Output
Input : education

Vowels : 5
Consonants : 4

true
5. Time Complexity

อ่านตัวอักษรทุกตัวเพียงครั้งเดียว

O(n)
	​

6. Space Complexity

ใช้เพียงตัวแปร

vowels
consonants
i

จึงเป็น

O(1)
	​
7. การเปรียบเทียบ
หัวข้อ	                           Recursive	Iterative
Time Complexity	                   O(n)	      O(n)
Space Complexity	               O(n)	      O(1)
Recursive Calls	                  n ครั้ง	    ไม่มี
StackOverflowError	               มีโอกาส	   ไม่มี
เหมาะกับข้อมูลขนาดใหญ่	            ไม่ค่อยเหมาะ	เหมาะ

8.
สรุป

ทั้งสองวิธีมี Time Complexity เท่ากัน คือ O(n) เพราะต้องตรวจสอบตัวอักษรทุกตัว แต่ Iterative Counting เหมาะกับการใช้งานจริงมากกว่า เนื่องจากใช้หน่วยความจำเพียง O(1) และไม่เสี่ยงเกิด StackOverflowError เมื่อประมวลผลสตริงขนาดใหญ่ ส่วน Recursive Counting เหมาะสำหรับการเรียนรู้แนวคิดของอัลกอริทึมแบบเวียนเกิดมากกว่า