package secondeval;

import java.util.ArrayList;
import java.util.Scanner;

public class Pairs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the array size");
        int size = input.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the array elements: ");
        for(int i = 0 ; i < size; i++) {
            array[i] = input.nextInt();
        }
        System.out.println("enter k: ");
        int k = input.nextInt();
        int pairCount = 0;
        for(int i = 0; i < size-1;i++) {
            for(int j = i+1; j < size; j++) {
                if(((array[i] + array[j]) % k) == 0) {
                    System.out.println("pair " + (pairCount+1) + ": " + array[i] + ", " + array[j]);
                    pairCount++;
                }
            }
        }
        System.out.println("total number of pairs: " + pairCount);
    }
}
