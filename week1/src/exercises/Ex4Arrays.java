package exercises;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Program to exercise arrays
 * <p>
 * See:
 * - Loops (for-loop only)
 * - ArrayBasics
 */
public class Ex4Arrays {

    public static void main(String[] args) {
        new Ex4Arrays().program();
    }

    final Scanner sc = new Scanner(in);

    private void program() {
        int[] aarray;
        int i = 0;


        aarray = new int[5];
        while (i < 5) {
            System.out.println("Which integer would you want at index " + i);
            aarray[i] = sc.nextInt();
            i++;
        }
        System.out.println("Which index would you like to see the value of?");
        int y = sc.nextInt();
        System.out.println("The number: " + aarray[y] + " at index: " + y);
        try {

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Too high of an index");
        }
    }
}