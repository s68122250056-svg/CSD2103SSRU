import java.util.Scanner;

public class VowelRecursive {

    static boolean hasMoreVowelsRecursive(String s){

        return countRecursive(s,0,0,0);

    }

    static boolean countRecursive(
            String s,
            int index,
            int vowels,
            int consonants){

        if(index==s.length()){

            System.out.println("Vowels : "+vowels);
            System.out.println("Consonants : "+consonants);

            return vowels>consonants;

        }

        char ch=Character.toLowerCase(s.charAt(index));

        if(ch>='a'&&ch<='z'){

            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                vowels++;
            }else{
                consonants++;
            }

        }

        return countRecursive(
                s,
                index+1,
                vowels,
                consonants);

    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        System.out.print("Input : ");

        String s=sc.nextLine();

        System.out.println(
                hasMoreVowelsRecursive(s));

    }

}