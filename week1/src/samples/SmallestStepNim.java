package samples;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *
 *  Below is an attempt to illustrate the "smallest step" tactic by implementing the Nim-game in versions.
 *  For Nim , see See https://en.wikipedia.org/wiki/Nim.
 *  Each "step" is written in a method to make it possible to trace. No other methods used for now
 *
 *  Smallest step means:
 *  - When starting out, just implement the smallest possible part that
 *    help us move in the direction of the solution.
 *  - Wait with loops, checks, special cases etc.
 *  - When smallest possible works: Implement "next smallest" step, run to test, etc.
 *  - Any program should always be possible to run
 *
 */
public class SmallestStepNim {

    public static void main(String[] args) {
        new SmallestStepNim().program();
    }

    final Random rand = new Random();    // rand is a random generator, possible to get random numbers.
    final Scanner sc = new Scanner(in);

    void program() {
        nim1();     // This is just to see the versions
        //nim2();
        //nim3();
        //nim4();
        //nim5();
    }

    // ------- Version 1 --------------------------
    // Minimal, get player input, remove from pile
    void nim1() {
        int pile = 13;                 // This is how many coins in pile
        int nCoins;                    // Number of coins taken

        out.print("Pick coins > ");    // Player choose
        nCoins = sc.nextInt();
        pile = pile - nCoins;          // Remove from pile

        out.println(pile);             // Basic step accomplished!

    }

    // ------ Version 2 -------------------------------
    // Add computer choice
    void nim2() {
        int pile = 13;
        int nCoins;

        out.print("Pick coins > ");
        nCoins = sc.nextInt();
        pile = pile - nCoins;

        nCoins = rand.nextInt(3) + 1;  // Computer choose, using the random generator
        out.println("Comp " + nCoins);  // Just for now
        pile = pile - nCoins;

        out.println(pile);   // Computer step accomplished!

    }

    // ------ Version 3 -------------------------------
    // Add turns.
    void nim3() {
        int pile = 13;
        int nCoins;
        boolean humanIsPlayer = true;  // Player and computer take turns

        while( pile > 1) {
            if (humanIsPlayer) {               // Player choose
                out.print("Pick coins > ");
                nCoins = sc.nextInt();
                pile = pile - nCoins;
            } else {
                nCoins = rand.nextInt(3) + 1;  // Computer choose
                out.println("Comp " + nCoins);
                pile = pile - nCoins;   // Bad redundant code (same line as above)!
            }
            out.println("Pile " + pile); // Just for now
            humanIsPlayer = !humanIsPlayer;   // Toggle player
        }
        // Run until working!
    }

    // ------ Version 4 -------------------------------
    // Player check, remove redundancy
    void nim4(){
        int pile = 13;
        int nCoins;
        boolean humanIsPlayer = true;

        while( pile > 1) {
            if (humanIsPlayer) {
                 while (true) {        // Add check for player input
                    out.print("Pick coins > ");
                    nCoins = sc.nextInt();
                    if (1 <= nCoins && nCoins <= 3 && nCoins <= pile) {
                        out.println("Player took " + nCoins);
                        break;
                    }
                }
            } else {
                nCoins = rand.nextInt(3) + 1;
                out.println("Comp " + nCoins);
            }
            pile = pile - nCoins;         // Eliminated redundant code
            out.println("Pile " + pile);
            humanIsPlayer = !humanIsPlayer;
        }
    }

    // ---------- Version 5 (final) ------------------------------
    // Computer AI. Fancier IO.
    void nim5() {
        int pile = 13;
        int nCoins;
        boolean humanIsPlayer = true;

        out.println("Welcome to till NIM");
        out.println("There's " + pile + " coins in the pile");

        while (pile > 1) {

            // ----- Input for human OR computer -----------
            if (humanIsPlayer) {
                while (true) {
                    out.print("Pick coins > ");
                    nCoins = sc.nextInt();
                    if (1 <= nCoins && nCoins <= 3 && nCoins <= pile) {
                        out.println("Player took " + nCoins);
                        break;
                    }
                }
            } else {
                if (pile == 4) {    // VERY simple AI for computer ...
                    nCoins = 3;
                } else if (pile == 3) {
                    nCoins = 2;
                } else if (pile == 2) {
                    nCoins = 1;
                } else {
                    nCoins = rand.nextInt(3) + 1;
                }
                out.println("Computer took " + nCoins);
            }


            // ------- Process -------------
            pile = pile - nCoins;
            humanIsPlayer = !humanIsPlayer;

            // Output ------------
            out.println("There's " + pile + " coins in the pile");

        } // End loop

        // Finished
        out.print("Game over. Winner is: ");
        if (!humanIsPlayer) {
            out.println("Human");
        } else {
            out.println("Computer");
        }
    }


}
