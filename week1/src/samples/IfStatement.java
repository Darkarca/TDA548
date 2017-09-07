package samples;

import static java.lang.System.*;

/**
 * The if statement (selection)
 */
public class IfStatement {

    public static void main(String[] args) {
        new IfStatement().program();
    }

    void program() {
        int i = 2;
        int j = 5;
        int k = 20;

        // If statement (NOTE: "{" on same line!)
        if (i == 2) {                       // if i == 2 true ...
            out.println("i is 2");          // .. do this. Continue after }
        }                                   // <--- NO ";" here

        // If-else statement
        if (j > 3) {                 // if j > 3 true ...
            out.println("j > 3");    //... do this...
        } else {                     // ... else ...
            out.println("j <= 3");   // ... do this. Continue after }
        }

        // If-else if-statement (else if-ladder).
        // NOTE: Only one of alternatives is executed! If one true found
        // no other tested
        if (j == 3) {
            out.println("j is 3");
        } else if (k <= 20) {
            out.println("k <= 20");
        } else {
            out.println("j != 3 and k > 20");
        }
    }
}
