package secondeval;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter String 1: ");
        String one = input.next();
        one = one.toLowerCase();
        System.out.println("Enter String 2: ");
        String two = input.next();
        two = two.toLowerCase();
        boolean isAnagram = true;
        if(one.length() != two.length()) {
            System.out.println("not an anagram");
            isAnagram = false;
        } else {
            for(int i = 0 ; i < one.length(); i++) {
                if(!(two.contains(Character.toString(one.charAt(i))))) {
                    System.out.println("not an anagram");
                    isAnagram = false;
                    break;
                }
            }
        }
        if(isAnagram) System.out.println("both are anagrams of each other");
    }
}
