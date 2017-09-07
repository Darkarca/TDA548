package samples;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

/*
 * This is an illustration of "smallest step" + functional decomposition
 * using the LCR game. See, https://en.wikipedia.org/wiki/LCR_(dice_game)
 *
 * Functional decomposition is a way to break down a big problem into smaller problems
 * Solve the smaller problems and combine the solutions to solve the big problem.
 * In combination with smallest step tactics this is very powerful!
 *
 * More explicit: If stuck, assume you have a method that solves the problem. Try to implement it. If stuck
 *                assume you have another (sub) method that helps ... until implementation of
 *                method is trivial. Compose simpler methods to get the first one you assumed solved the problem.
 *
 * Also: When we have smaller pieces (methods) we can test them before combining, greatly increases quality!
 *
 * Here are the steps:
 * Step 1.
 * So, this is what we would like to do (a pseudo code sketch):
 *
 *    // Create the data we need ... Player class, array of Players, actual Player
 *    result = roll()        // Fix method to roll, should give combinations of  L, C, R, . in random fashion
 *
 *    Func decomp: roll() uses rollDice(), rollDice is a normal dice, roll() will convert to LCR results
 *
 *    Now, implement and test methods: rollDice() and roll()
 *    Test are written in the test() method (called first in program(), comment/uncomment to use, see far below)
 *
 * Step 2
 * Now continue:
 *
 *   String[] result = roll(actual.chips)  // Tested, works!
 *   distributeChips() ...                 // Would like to have method
 *
 *   Func decomp: distributeChips() need playerLeft(), playerRight(), which both need index of actual
 *
 *   Now, implement and test methods: indexOf(), getPlayerLeft(), next() (= getPlayerRight()), distributeChips()
 *
 * Step 3
 * Continuing
 *
 *   String[] result = roll(actual.chips)  // Tested, works!
 *   distributeChips( result, players, actual ) // Tested, works!
 *   winner?                              // Would like to have
 *
 *   Now, implement and test method: gotWinner()
 *
 * Step 4
 * Finally:
 *
 *   // All above tested and works
 *   boolean b = gotWinner( players );  // Tested, works!
 *
 *   Now: Add a method to get the player choice, getCommand(), while loop and
 *   if statements (the command line). Fix output methods. Cleanup and finish. Done!
 *
 */
public class FuncDecompLCR {

    public static void main(String[] args) {
        new FuncDecompLCR().program();
    }

    final Scanner sc = new Scanner(in);
    final Random rand = new Random();
    final String EMPTY = "";   // This is a named value (easy to change if declared once)

    void program() {
        //test();        // < ********************** Uncomment to run tests ***************************

        final Player[] players = {getPlayer("olle", 3), getPlayer("fia", 3),
                getPlayer("pelle", 3)};
        Player actual = players[rand.nextInt(players.length)];
        boolean aborted = false;            // Game aborted?

        gameStartMsg(players);

        while (!gotWinner(players)) {
            String cmd = getCommand(actual); // cmd well known abbreviation for command
            if (cmd.equals("r")) {
                // ----Input
                String[] result = roll(actual.chips);  // No need to reset, will get new array

                // --- Process
                distributeChips(result, players, actual);
                actual = next(players, actual);

                // --- Output
                roundMsg(result);
                statusMsg(players);
            } else if (cmd.equals("q")) {
                aborted = true;
                break;
            } else {
                out.println("?");
            }
        } // End Game loop

        gameOverMsg(players, aborted);
    }

    // ---- Logical methods -----------------

    public String[] roll(int nChips) {
        String[] result = new String[]{EMPTY, EMPTY, EMPTY};
        if (nChips > 3) {
            nChips = 3;
        }
        for (int i = nChips - 1; i >= 0; i--) {  // Or count up
            int r = rollDice();
            if (r < 3) {
                result[i] = ".";
            } else if (r == 3) {
                result[i] = "L";
            } else if (r == 4) {
                result[i] = "C";
            } else {
                result[i] = "R";
            }
        }
        return result;
    }

    void distributeChips(String[] result, Player[] players, Player actual) {
        for (int i = 0; i < result.length; i++) {   // Changed to for
            if (result[i] != "." && result[i] != EMPTY && actual.chips > 0) {
                actual.chips--;
            }
            if (result[i] == "L") {
                Player left = getPlayerLeft(players, actual);
                left.chips++;
            } else if (result[i] == "R") {
                Player right = next(players, actual);
                right.chips++;
            } else {
                // Nothing
            }
        }
    }

    boolean gotWinner(Player[] players) {
        int count = 0;
        for (Player p : players) {
            if (p.chips > 0) {
                count++;
            }
        }
        return count == 1;
    }

    Player getPlayerLeft(Player[] players, Player actual) {
        int i = indexOf(players, actual);
        return players[(i + players.length - 1) % players.length];
    }

    Player next(Player[] players, Player actual) {
        int i = indexOf(players, actual);
        return players[(i + 1) % players.length];
    }

    int indexOf(Player[] players, Player player) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == player) {
                return i;
            }
        }
        return -1;
    }

    int rollDice() {
        return rand.nextInt(6) + 1;
    }

    // --- IO Methods -----------------------------------------

    void gameStartMsg(Player[] players) {
        out.println("LCR Game started");
        out.println("r = roll, q = quit");
        statusMsg(players);
    }

    Player getPlayer(String name, int chips){
        Player p = new Player();
        p.name = name;
        p.chips = chips;
        return p;
    }

    void gameOverMsg(Player[] players, boolean aborted) {
        if (aborted) {
            out.println("Aborted");
        } else {
            int i = 0;
            while (players[i].chips == 0) {
                i++;
            }
            out.println("Game over! Winner is " + players[i].name);
        }
    }

    void roundMsg(String[] result) {
        out.println(Arrays.toString(result));
    }

    void statusMsg(Player[] players) {
        for (Player p : players) {
            out.print(p.name + ": " + p.chips + " ");
        }
        out.println();
    }

    String getCommand(Player actual) {
        out.print("Player is " + actual.name + " > ");
        return sc.nextLine();
    }

    // ------- Class to hold player data -----------

    class Player {
        String name;
        int chips;
    }

    // ********************** Testing *************************************''

    // To test we write out something that should be true!
    // Tests should always be kept! Even if program finished. It's part of documentation
    void test() {
        // Step 1
        int d = rollDice();
        out.println(1 <= d && d <= 6);   // Should print "true"
        d = rollDice();
        out.println(1 <= d && d <= 6);

        String[] r = roll(2);  // Only 2 dices so one of three should be empty
        out.println(r[0].equals(EMPTY) || r[1].equals(EMPTY) || r[2].equals(EMPTY));

        r = roll(3);  // Three dices non should be empty
        out.println(!r[0].equals(EMPTY) && !r[1].equals(EMPTY) && !r[2].equals(EMPTY));
        out.println(r[0].equals("L") || r[0].equals("R") || r[0].equals("C") || r[0].equals("."));

        // Step 2
        // Need some hard coded test data
        Player[] players = {getPlayer("0lle", 3), getPlayer("Pelle", 3),
                getPlayer("Fia", 3)};
        Player actual = players[2];
        out.println(indexOf(players, actual) == 2);

        out.println(getPlayerLeft(players, players[0]) == players[2]);
        out.println(next(players, players[2]) == players[0]);

        String[] res = {"L", "C", "R"};
        actual = players[1];
        distributeChips(res, players, actual);
        out.println(players[0].chips == 4 && players[1].chips == 0 && players[2].chips == 4);

        // Step 3
        players[1].chips = 0;
        players[2].chips = 0;
        out.println(gotWinner(players));  // Player 0 wins

        exit(0);  // Will terminate program, *NEVER* use except here!
    }
}
