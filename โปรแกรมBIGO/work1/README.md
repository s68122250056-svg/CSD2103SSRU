1. แนวคิด
reverse("abc")
= "c" + reverse("ab")
= "c" + "b" + reverse("a")
= "cba"
2. Pseudocode
FUNCTION reverseRecursive(s)

    IF s is empty OR length of s is 1
        RETURN s
    END IF

    lastCharacter = s[length of s - 1]
    remainingString = s from index 0 to length of s - 2

    RETURN lastCharacter + reverseRecursive(remainingString)

END FUNCTION
4. ตัวอย่าง Input และ Output
Input: pots&pans
Output: snap&stop
อีกตัวอย่าง
Input: algorithm
Output: mhtirogla
กรณีสตริงว่าง
Input:
Output:
5. Time Complexity
เมธอดเรียกตัวเองประมาณ n ครั้ง
แต่ในแต่ละครั้งมีการใช้
substring()
และการต่อสตริงด้วยเครื่องหมาย
+
จำนวนงานโดยรวมจึงประมาณ

n+(n−1)+(n−2)+⋯+1
=
2
n(n+1)​
ดังนั้น
O(n**2)
6. Space Complexity

มี recursive call ประมาณ n ครั้ง จึงใช้ call stack

O(n)

และมีการสร้าง substring ใหม่หลายครั้ง ซึ่งอาจใช้พื้นที่รวม

O(n**2)

ดังนั้น Space Complexity ในกรณีนี้คือ

O(n**2)	​
7. ข้อดีและข้อจำกัด
ข้อดีคือโค้ดสั้นและแสดงหลักการเวียนเกิดได้ชัดเจน
ข้อจำกัดคือใช้หน่วยความจำมาก และเมื่อสตริงยาวมากอาจเกิด
StackOverflowError

วิธีที่ 2 Iterative Algorithm
1. แนวคิด
Input: abc

อ่าน c
อ่าน b
อ่าน a

Output: cba

2. Pseudocode
FUNCTION reverseIterative(s)

    CREATE result as StringBuilder

    FOR i FROM length of s - 1 DOWN TO 0
        APPEND s[i] TO result
    END FOR

    RETURN result as String

END FUNCTION

3. โปรแกรมภาษา Java
import java.util.Scanner;

public class ReverseStringIterative {

    static String reverseIterative(String s) {

        if (s == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Input: ");
        String text = input.nextLine();

        String result = reverseIterative(text);

        System.out.println("Output: " + result);
    }
}
4. ตัวอย่าง Input และ Output
Input: pots&pans
Output: snap&stop

อีกตัวอย่าง

Input: java
Output: avaj
5. Time Complexity

ลูปอ่านข้อความทุกตัวเพียง 1 ครั้ง

ถ้ามีตัวอักษรทั้งหมด n ตัว ลูปจะทำงาน n รอบ

ดังนั้น

O(n)
	​

6. Space Complexity

StringBuilder เก็บผลลัพธ์จำนวน n ตัวอักษร

ดังนั้น

O(n)
	​


ถ้าไม่นับพื้นที่ของผลลัพธ์ จะใช้พื้นที่เสริมเพียง O(1)

7
หัวข้อ	                          Recursive	             Iterative
จำนวนครั้งที่ประมวลผล	            ประมาณ n ครั้ง	         n ครั้ง
Time Complexity	                 O(n²)	               O(n)
Space Complexity	             O(n²)	               O(n)
ใช้ Call Stack	                  ใช่	                 ไม่ใช้
เสี่ยง StackOverflowError	        มี	                  ไม่มี
เหมาะกับข้อมูลขนาดใหญ่	             ไม่เหมาะ	            เหมาะ
ความเข้าใจง่าย	              แสดงrecursionชัดเจน	ทำงานตรงไปตรงมา


8สรุป

Recursive Algorithm เหมาะสำหรับศึกษาหลักการเวียนเกิดและใช้กับสตริงขนาดเล็ก

Iterative Algorithm เหมาะสำหรับการใช้งานจริง โดยเฉพาะสตริงขนาดใหญ่ เพราะใช้เวลา
















































