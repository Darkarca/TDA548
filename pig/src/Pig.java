import java.util.*;

import static java.lang.System.*;

/*
 * The Pig game
 * See http://en.wikipedia.org/wiki/Pig_%28dice_game%29
 */
public class Pig {

    public static void main(String[] args) {
        new Pig().program();
    }

    // The only allowed instance variables (i.e. declared outside any method)
    // Accessible from any method
    final Scanner sc = new Scanner(in);
    final Random rand = new Random();

    void program() {
        //test();                 // <-------------- Uncomment run to tests!
        int diceRoll;
        int winPts = 100;          // Points to win
        int round = 0;
        int currentPlayer;
        Player[] players;         // The players (array of Player objects)
        boolean aborted = false;  // Game aborted by player
        boolean gameWon = false;

        welcomeMsg(winPts);

        players = getPlayers();
        statusMsg(players);



        while (!aborted && !gameWon) {
            currentPlayer = round % players.length;
            printPlayer(players[currentPlayer].name);
            String input;
            if (players[currentPlayer].name.contains("CPU")) {
                input = computerIO(players, currentPlayer);
            } else {
                input = playerInput();
            }

            if (input.equals("r")) {                                                                                    // Checks if current player decides to roll the die
                diceRoll = rollDice();                                                                                  // Calls the method "rollDice" to randomize the die "output"
                if (diceRoll == 1) {                                                                                        // Checks if diceRoll is 1 which then ends the round
                    out.println("Got 1 lost it all!");
                    statusMsg(players);
                    round++;                                                                                            // Break current loop in order to let the next player have their turn
                    players[currentPlayer].roundPts = 0;                                                                // Resets the points for this round to 0

                } else {                                                                                                // For any other number, (2-6), add the number rolled to the roundpts variable
                    players[currentPlayer].roundPts += diceRoll;
                    if (players[currentPlayer].roundPts + players[currentPlayer].totalPts >= winPts) {                  // Check if wincondition is met
                        players[currentPlayer].totalPts += players[currentPlayer].roundPts;                             // Calculate the points for the winning player and display win message
                        out.print("Game over! Winner is player " +
                                players[currentPlayer].name + " with " + players[currentPlayer].totalPts);
                        gameWon = true;                                                                                 // Ends application after game ends
                    } else {                                                                                            // If wincondition is not yet met, display roundpts and re-initiate the loop
                        out.println("Got " + diceRoll + " running total is " + players[currentPlayer].roundPts);
                    }
                }
            } else if (input.equals("n")) {                                                                             // Checks if current player decides to end their turn and save their points
                players[currentPlayer].totalPts += players[currentPlayer].roundPts;                                                     // Add roundpts to totalpts
                statusMsg(players);                                                                                     // Display points for all players
                round++;                                                                                                // Break current loop in order to let the next player have their turn
                players[currentPlayer].roundPts = 0;                                                                    // Resets the points for this round to 0

            } else if (input.equals("q")) {                                                                             // Checks if current player decides to abort the game entirely
                out.print("Game aborted!");
                aborted = true;                                                                                         // Ends application
            }

        }
        // TODO Write game here!


        // gameOverMsg
    }

    // ---- Game logic methods --------------

    // TODO Add methods

    int getPlayerMaxScore(Player[] players){

        int maxScore = players[0].totalPts;

        for (int i = 0; i < players.length - 1; i++) {                                                                  // Compares scores of all players, selects the one with the highest score
            if (players[i].totalPts > maxScore) {
                maxScore = players[i].totalPts;
            }
        }
        return maxScore;
    }

    int computerLogic(Player[] players, int currentPlayer) {

        final int PROCEED = 1;
        final int ABORT = 0;

        int maxScore = getPlayerMaxScore(players);

        int optimal = 21 + Math.round((maxScore - players[currentPlayer].totalPts) / 8);                                // Calculates optimal round score to aim for


        if (maxScore >= 71 || players[currentPlayer].totalPts >= 71) {                                                  // If any player has a score over 71 the computer will roll continuously
            return PROCEED;
        } else if (players[currentPlayer].roundPts > optimal) {                                                         // If the computers running score is over the previously calculated optimal score, the computer will pass
            return ABORT;
        } else {
            return PROCEED;
        }

    }

    int rollDice() {                                                                                                    // Rolls a die
        return rand.nextInt(6) + 1;                                                                              // Returns a random number between 1 and 6
    }


    // ---- IO methods ------------------

    void printPlayer(String playerName){
        out.print("Player is " + playerName + " > ");
    }

    void welcomeMsg(int winPoints) {
        out.println("Welcome to PIG!");
        out.println("First player to get " + winPoints + " points will win!");
        out.println("Commands are: r = roll , n = next, q = quit");
        out.println();
    }

    void statusMsg(Player[] players) {
        out.print("Points: ");
        for (Player p : players) {
            out.print(p.name + " = " + p.totalPts + " ");
        }
        out.println();
    }

    String playerInput(){
        return sc.nextLine();
    }

    Player[] getPlayers() {
        out.print("How many players? > ");
        int nPlayers = sc.nextInt();
        sc.nextLine();  // Read away \n
        Player[] players = new Player[nPlayers + 1];
        for (int i = 0; i < nPlayers; i++) {                                                                            // Initiates for-loop
            players[i] = new Player();                                                                                  // Initiates instance of players
            out.print("Name for player " + (i + 1) + " > ");                                                          // Asks for player name
            players[i].name = sc.nextLine();                                                                            // Initializes class variable 'name' for each player 'i'
        }
        // DONE
        players[nPlayers] = new Player();                                                                               // Adds computer player to game
        players[nPlayers].name = "DefaultCPU";


        return players;
    }

    String computerIO(Player[] players, int currentPlayer){
        int choice = computerLogic(players, currentPlayer);

        if (choice == 1) {
            out.println("Computer chose: r");
            return "r";
        } else {
            out.println("Computer chose: n");
            return "n";
        }

    }

    // ---------- Class -------------
    // A class makes it possible to keep all data for a Player in one place
    // Use the class to create (instantiate) Player objects
    class Player {
        String name;
        int totalPts;    // Total points for all rounds, default 0
        int roundPts;    // Points for a single round, default 0
    }

    // ----- Testing -----------------
    void test() {
        int roll = rollDice();
        if (1 <= roll && roll <= 6){
            out.println("Dice roll test successful");
        } else {
            out.println("Dice roll test unsuccessful");
        }

        Player[] players = new Player[3];
        players[0] = new Player();
        players[1] = new Player();
        players[2] = new Player();
        players[0].name = "Olle";
        players[1].name = "Fia";
        players[2].name = "CPU";

        printPlayer(players[0].name);
        out.println();

        int computerReturn;

        players[0].totalPts = 23;

        computerReturn = computerLogic(players, 2);

        if (computerReturn == 1){
            out.println("Computer test1 successful");
        } else {
            out.println("Computer test1 unsuccessful");
        }

        players[2].roundPts = 40;

        computerReturn = computerLogic(players, 2);

        if (computerReturn == 0){
            out.println("Computer test2 successful");
        } else {
            out.println("Computer test2 unsuccessful");
        }

        players[1].totalPts = 72;

        computerReturn = computerLogic(players, 2);

        if (computerReturn == 1){
            out.println("Computer test3 successful");
        } else {
            out.println("Computer test3 unsuccessful");
        }

        players[0].totalPts = 99;

        int maxScore = getPlayerMaxScore(players);

        if (maxScore == players[0].totalPts) {
            out.println("Max score test successful");
        } else {
            out.println("Max score test unsuccessful");
        }
        exit(0);   // End program
    }
}



