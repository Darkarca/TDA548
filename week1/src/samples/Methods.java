package samples;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  Methods, are smaller parts of a program (a subprogram) returning a calculated value or
 *  performing a specific task
 *  - Similar to mathematical function but not all return a value.
 *
 *  Any method *MUST* be declared before use. Method declaration is like:
 *
 *  type name ( parameter list ) {        (<- method head)
 *          ..method body (a block) ...
 *  }
 *
 *  - Name is name of method, to be used when calling the method
 *  - Type before name is type of value returned (if any) the "return type"
 *  - Parameter list is the in data sent to the method. Parameter list declared as variables
 *    (parameters) i.e. type and name separated by ",".
 *  - Body is the statements that the method should execute.
 *
 *  To do a method call (i.e. run the method):
 *  - Write method name in code, supply arguments in parenthesis, possibly assign
 *    return value to some variable
 *  - If assigning result, return type must be compatible with variable type
 *  - Declaration and call must match: Name, numbers of params, type of params
 *
 * NOTE: To inspect the execution of this try the debugger (learn how to use a debugger)
 */
public class Methods {

    public static void main(String[] args) {
        new Methods().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        // Primitive parameters and return values
        out.println(add(1, 3) == 4);    // Method calls to add, arguments 1 and 3
        out.println(abs(-12) == 12);
        out.println(pow(2, 8) == 256);

        // Boolean return value
        out.println(isEven(6) == true);  // Method calls to isEven(), argument 6

        // Array parameter, int as return
        int[] arr = {1, 4, 7, 3, 9, 2};
        out.println(max(arr) == 9);  // Method calls to max(), argument is arr

        // No parameter
        String name = getName();
        // No return value
        welcome(name);
    }

    // ----- Methods declarations written after (outside) program ------------
    // Method declaration inside other method declaration *NOT* allowed (nested not allowed)

    // Very simple method
    int add(int a, int b) {
        return a + b;
    }

    double f2c(double fahrenheit){
        return (fahrenheit - 32) * 5 / 9;
    }  // No called

    // Declare method: return type int, name abs, one int parameter named n
    // Note must have more return statement (checked by compiler)
    int abs(int n) {
        if (n < 0) {
            return -n;
        }
        return n;   // Return value of n
    }

    // Declare method named pow, with return type int and two int parameters
    int pow(int b, int e) {
        int p = 1;
        for (int i = 0; i < e; i++) {
            p = p * b;
        }
        return p;    // Must have
    }


    boolean isEven(int n) {
        return n % 2 == 0;
    }

    // Declare method max, return type int and int-array as parameter
    int max(int[] arr) {
        int m = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > m) {
                m = arr[i];
            }
        }
        return m;   // Must have
    }

    // String as return type
    String getName() {
        out.print("Please enter your name > ");
        return sc.nextLine();   // Return input immediately
    }

    // No return value needed, write void instead of return type
    // No return statement in body
    void welcome(String name) {
        out.println("Welcome " + name);
    }


    // See also , ClassBasics for more method samples

}
