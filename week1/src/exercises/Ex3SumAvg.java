package exercises;

import java.util.Scanner;

import static java.lang.System.*;;

/*
 * Program to calculate sum and average for non-negative integers
 *
 * See:
 * - Loops (while only)
 * - LoopAndAHalf
 *
 */
public class Ex3SumAvg {

    public static void main(String[] args) {
        new Ex3SumAvg().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        // Write your code here
        int sum = 0;
        int num = 0;
        final Scanner sc = new Scanner(in);
        while (true) {    // Infinite loop
            out.print("Input positive int > ");    // Try negatives when running!
            int i = sc.nextInt();
             sum = sum+i;
             num = num+1;
            if (i < 0) {
                break;    // Break in middle (half) of loop. Jump directly out of enclosing loop
            }
        }
        double avg = sum/num;
        System.out.print(sum);

        System.out.print(num);

        System.out.print("Your average is: "+avg);

        // -- Process---


        // -- Output ----

    }

}
