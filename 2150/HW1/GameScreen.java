/*  Alex Moore
    CPSC 2150 Program1
    Extended Tic-Tac-Toe
 */

package cpsc2150.homeworks.hw1;

import java.util.Scanner;

/**
 * @invariants whichPlayer >= 0
 */
public class GameScreen {

    private static GameBoard gb = new GameBoard();  //create a new GameBoard
    private static BoardPosition bp;    //create a BoardPosition
    private static int whichPlayer = 0; //int to help determine which players turn
    private static Scanner scanner = new Scanner( System.in );  //scanner to read in info from the user

    /**
     * @param args the number of arguments passed in
     * @requires GameBoard has been created and
     * BoardPosition has been created
     * @ensures the board is printed out and the game is played and
     * the correct winner is displayed and
     * the board is displayed
     */
    public static void main (String [] args) {
        boolean playAgain = true;
        while (playAgain) {
            boolean end = false;
            while (!end) {
                readPosition(getPlayer());
                //check if the last play won the game
                if (GameBoard.checkForWinner(bp)) {
                    System.out.println("Player " + bp.getPlayer() + " wins!");
                    System.out.println(gb.toString());
                    end = true;
                }
                //check if last play resulted in a draw
                else if (GameBoard.checkForDraw()) {
                    System.out.println("Game is a draw!");
                    end = true;
                }
            }
            System.out.println("Would you like to play again?");
            String again;
            again = scanner.next();
            playAgain = (again.equals("Y") || again.equals("y"));
            if (playAgain) {
                gb = new GameBoard();   //create new Gameboard to play
                whichPlayer = 0;    //reset whichPlayer
            }
        }
    }


    /**
     * @param player the "X" or the "O" declaring which player
     * @requires player = "X" || "O"
     * @ensures the user enters correct row and column data and
     * a new board position is set and
     * the correct player marker is placed in the appropriate position
     */
    private static void readPosition(char player) {
        int x;
        int y;
        final int MAXSIZE = 8;

        boolean available = false;
        while (!available) {
            available = true;
            System.out.println(gb.toString());  //print out the gameboard
            //ask player for the position
            System.out.println("Player " + player + " Please enter your ROW");
            x = scanner.nextInt();
            System.out.println("Player " + player + " Please enter your COLUMN");
            y = scanner.nextInt();
            //assign marker to the new position
            bp = new BoardPosition(x, y, player);
            if (x >= MAXSIZE || y >= MAXSIZE ||x<0||y<0|| !GameBoard.checkSpace(bp)) {
                System.out.println("That space is unavailable, please pick again");
                available = false;
            }
            else {
                GameBoard.placeMarker(bp);
            }
        }
    }

    /**
     * @return the correct players turn
     * @requires whichPlayer is created and initialized to 0
     * @ensures either "X" or "O" is returned for the player
     */
    private static char getPlayer() {
        GameScreen.whichPlayer+=1;
        if (GameScreen.whichPlayer % 2 == 0) {
            return 'O';
        }
        return 'X';
    }

}
