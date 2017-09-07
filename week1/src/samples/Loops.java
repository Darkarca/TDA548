package samples;

import static java.lang.System.*;

/*
 * The while and for statements (iteration)
 * Collectively known as "loops"
 */
public class Loops {

    public static void main(String[] args) {
        new Loops().program();
    }

    void program() {

        // ----- while loop ------------

        // Going up
        int i = 0;    // Set start value for counter
        while (i < 10) {  // Is i < 10 is true? ...
            out.println("i is : " + i);  // ... yes, do the block
            i++;     // Increment counter (last)
        }            // Jump up to while and start over
        out.println("i after loop is : " + i);

        // Going down
        i = 10;
        while (i > 0) {
            out.println("i is : " + i);
            i--;   // Decrement counter
        }
        out.println("i after loop is : " + i);


        // Step
        i = 0;
        while (i < 20) {
            out.println("i is : " + i);
            i = i + 2;  // Step by 2
        }
        out.println("i after loop is : " + i);


        // Non terminating (program will hang, program run but nothing seems to happen )
        // Uncomment and run to try
        /*value = 0;
        while (value >= 0) {    // True forever
            out.println("i is : " + value);
            value++;
        }*/

        // --- for loop -------------------

        // Going up (NOTE: int j = 0 only executed once, at loop entry)
        for( int j = 0 ; j < 10 ; j++){   // If j < 10 is true ...
           out.println("j is : " + j);    // ... do this
           // <------ j++ is in fact done here (lastly), but written on first line
        }  // Jump up to j < 10, and start over

        // out.println(j);     // Can't use j here, not in scope. Scope is in loop only

        // Going down
         for( int j = 10 ; j >= 0 ; j--){
           out.println("j is : " + j);
        }

        // Step
         for( int j = 0 ; j < 20  ; j = j + 2){
           out.println("j is : " + j);
        }

    }
}
