package samples;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *
 * Program to convert Fahrenheit to Celsius
 *
 * This show the program structure we should try to adhere to
 *
 *         Input --> Process --> Output
 */
public class F2C {

    // Don't care about this, must be there, start coding at program
    public static void main(String[] args) {
        new F2C().program();
    }

    // This connects our program to the keyboard
    final Scanner sc = new Scanner(in);

    void program() {        // Program starts
        double fahrenheit;  // Variable declarations
        double celsius;

        // ---- Input ----
        out.print("Enter Fahrenheit > "); // Print to screen to notify user
        fahrenheit = sc.nextDouble();     // When running, write input in window below + Enter

        // ---- Process ----
        celsius = (fahrenheit - 32) * 5 / 9;    // Some calculations (NO output here!)

        // --- Output ----
        out.println(fahrenheit + " F = " + celsius + " C");  // Output result to screen

    }
}
