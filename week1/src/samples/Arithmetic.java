package samples;

import java.util.Scanner;

import static java.lang.System.*;

/**
 * Arithmetic with Java, mostly as you are used to in math.
 */
public class Arithmetic {

    public static void main(String[] args) {
        new Arithmetic().program();
    }

    final Scanner scan = new Scanner(in);

    void program() {
        int op1;    // Declarations
        int op2;

        out.print("Input 2 integers (enter after each) > ");  // Prompt user
        op1 = scan.nextInt();
        op2 = scan.nextInt();

        // All below are statements so put ";" last
        // The right side is an expression, i.e a value.
        int result = op1 + op2;                // Addition.
        out.println("Result + " + result);

        result = op1 - op2;                    // Subtraction
        out.println("Result - " + result);

        result = op1 * op2;                    // Multiplication
        out.println("Result * " + result);

        result = op1 / op2;                    // Division. Oh, oh, ..
        out.println("Result / " + result);     // ... this is integer division! (Both operands integer)

        double dResult = (double) op1 / op2;      // (double) will cast (change type of) value in op1
        out.println("Result real / " + dResult);  // Now we get real division

        result = op1 % op2;                       // Remainder operator (modulo)
        out.println("Result % (modulo) " + result);

        out.println("Left to right " + 4/2/2);    // Associativity (Left to right normally)
        out.println("Using parentheses " + 4/(2/2));

        // NO exp/power operator like ^  !

        // out.println("Div with zero " + 1/0);   // Arithmetic Exception
        out.println("Div with zero " + 1.0/0);    // Infinity
    }
}
