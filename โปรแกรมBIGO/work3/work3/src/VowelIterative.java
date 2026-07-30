import java.util.Scanner;

public class VowelIterative {

    static boolean hasMoreVowelsIterative(String s){

        int vowels=0;
        int consonants=0;

        for(int i=0;i<s.length();i++){

            char ch=
                    Character.toLowerCase(
                            s.charAt(i));

            if(ch>='a'&&ch<='z'){

                if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                    vowels++;
                }else{
                    consonants++;
                }

            }

        }

        System.out.println(
                "Vowels : "+vowels);

        System.out.println(
                "Consonants : "+consonants);

        return vowels>consonants;

    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        System.out.print("Input : ");

        String s=sc.nextLine();

        System.out.println(
                hasMoreVowelsIterative(s));

    }

}