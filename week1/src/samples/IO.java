package samples;

import java.util.Scanner;    // Need this from Java

import static java.lang.System.*; // Need this from Java

/*
    IO = Input/output, input data to program (often from keyboard) and
    output data from program (to a terminal on screen)

    IO is handled by "streams" in Java (a channel to send/receive bytes)

    NOTE: See import above, must be there
 */
public class IO {

    public static void main(String[] args) {
        new IO().program();
    }

    // A Scanner is an utility to create values out of sequences of character codes from keyboard
    // Codes (bytes) are transmitted via the input stream "in"
    final Scanner sc = new Scanner(in);  // Create Scanner, connect scanner and input stream to use in program
                                         // Other end of input stream is connected to keyboard (default)
    void program() {

        // Use the out stream (by default connected to screen)
        // All below are statements so put ";" last
        out.print(1);           // Print literal 1 to screen  (NO new line)
        out.println("abc");     // Print String literal and then new line
        out.println(" c d e "); // Print String literal, spaces preserved
        out.println("My lucky number is " + 23 ); // Use + to concatenate string and value
        out.println();              // Just print new line
        out.println("Empty line above");

        // Must have some place to store input value(s), we use variable(s)
        int n;  // Initialized later
        out.println("Input an integer > ");  // Prompt user

        // Use sc (the scanner) to read form keyboard.
        // When running: Input some digits in window below (program will wait until Enter)
        n = sc.nextInt();      // sc will read keys and convert to int
        out.println("Value was " + n);  // Text and content of variable written out!

        // If NOT possible to convert to variable type, exception and program aborted
        // Run again: Try to input some characters and then enter

        // Needed only if reading a number *and then* a string (because reading digits
        // leaves enter key last in input)
        sc.nextLine(); // Read away the enter key (try comment out and run)

        out.println("Input a text > ");
        String s = sc.nextLine();   // Read a String
        out.println("Value was " + s);


        // Also possible
        double d = sc.nextDouble();
        boolean b = sc.nextBoolean();

        //char ch = sc.next....;    *NOT* Possible

    }
}
