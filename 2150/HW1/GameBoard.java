/*  Alex Moore
    CPSC 2150 Program1
    Extended Tic-Tac-Toe
 */

package cpsc2150.homeworks.hw1;


/**
 * @invariants row = the max row size and
 * column = the max column size and
 * win = the number needed to win a game
 */
public class GameBoard {

    final private static int ROW = 8;  //max row size
    final private static int COLUMN = 8;   //max column size
    final private static int WIN = 5;  //number needed consecutive to win

    //Create the game board
    private static char[][] matrix = new char[GameBoard.ROW][GameBoard.COLUMN];

    /**
     * @ensures function initialize is called
     */
    GameBoard () {
        initialize();
    }

    /**
     *  @requires ROW = max row size and
     *  COLUMN = max column size and
     *  a GameBoard has been created of size ROW x COLUMN
     *  @ensures all places in the GameBoard are set to " "
     */
    private void initialize() {
        //initialize the matrix
        for(int i = 0; i < GameBoard.ROW; i++) {
            for(int j = 0; j < GameBoard.COLUMN; j++) {
                matrix[i][j] = ' ';
            }
        }
    }

    /**
     * @param pos the current position on the board and the player
     * @return whether or not the space is " "
     * @requires pos has a row and a column and
     * a GameBoard has been created
     * @ensures function returns true if location is equal to " " and
     * returns false otherwise
     */
    public static boolean checkSpace(BoardPosition pos){
        //returns true if the position specified in pos is available, false otherwise
        if (matrix[pos.getRow()][pos.getColumn()] == ' ') return true;
        else return false;
    }

    /**
     * @param marker the current position on the board and the current player
     * @requires marker has the correct row, column, and player and
     * a GameBoard has been created
     * @ensures the current players marker is placed in the correct board position
     */
    public static void placeMarker(BoardPosition marker){
        //places the character in marker on the position specified by marker
        matrix[marker.getRow()][marker.getColumn()] = marker.getPlayer();
    }

    /**
     * @param lastPos the most recent position on the board and the last player
     * @return whether the last player has won
     * @requires lastPos has the correct row, column, and player
     * @ensures checkHorizontal is called and
     * checkDiagonal is called and
     * checkVertical is called and
     * the correct boolean value is returned for winner
     */
    public static boolean checkForWinner(BoardPosition lastPos){
        //this function will check to see if the lastPos placed resulted in a winner.
        //If so it will return true, otherwise false.
        //Passing in the last position will help limit the possible places to check
        //for a win condition, since you can assume that any win condition that did
        // not include the most recent play made would have been caught earlier.
        return (checkHorizontalWin(lastPos) || checkDiagonalWin(lastPos) || checkVerticalWin(lastPos));
    }

    /**
     * @return whether or not the game ended in a draw
     * @requires row == 8 and
     * column == 8 and
     * a GameBoard has been created and
     * checkForWinner == false
     * @ensures every board position is checked and the correct boolean for a draw is returned
     */
    public static boolean checkForDraw(){
        //this function will check to see if the game has resulted in a tie. A game
        //is tied if there are no free board positions remaining. It will return
        //true if the game is tied, and false otherwise.
        for(int i = 0; i < GameBoard.ROW; i++) {
            for(int j = 0; j < GameBoard.COLUMN; j++) {
                if (matrix[i][j] == ' ') return false;
            }
        }
        return true;
    }

    //The following private functions must be available. They will help with your public functions.

    /**
     * @param lastPos the most recent position on the board and the last player
     * @return whether or not the player got win number of consecutive marks in a row
     * @requires lastPos has the correct row, column, and player and
     * win = 5 and
     * column = 8 and
     * row = 8 and
     * a GameBoard has been created
     * @ensures the current player character positions are counted which are connected horizontally and
     * the correct boolean is returned for a horizontal win
     */
    private static boolean checkHorizontalWin(BoardPosition lastPos){
        //checks to see if the last marker placed resulted in 5 in a row horizontally.
        //Returns true if it does, otherwise false
        //check if there is possible to go further in and find marker
        int count = 1;  //set initial marker count to 1
        int rowPos = lastPos.getRow();  //set rowPos
        int colPos = lastPos.getColumn();   //set colPos

        boolean resume = true;
        while (resume) {
            colPos = colPos - 1; //check next column to the left, same row
            if((count < GameBoard.WIN) && (colPos >= 0) && (matrix[rowPos][colPos] == lastPos.getPlayer())) {
                count= count + 1;
            }
            else {
                resume = false;
            }
        }
        colPos = lastPos.getColumn();   //reset colPos
        resume = true;
        while (resume) {
            colPos = colPos + 1;    //check next column to the right, same row
            if((count < GameBoard.WIN) && (colPos < GameBoard.COLUMN) && (matrix[rowPos][colPos] == lastPos.getPlayer())) {
                count = count + 1;
            }
            else {
                resume = false;
            }
        }
        //if count is bigger or equal to the amount needed to win
        if (count >= GameBoard.WIN ) {
            return true;
        }
        return false;
    }

    /**
     * @param lastPos the most recent position on the board and the last player
     * @return whether or not the player got win number of consecutive marks in a column
     * @requires lastPos has the correct row, column, and player and
     * win = 5 and
     * column = 8 and
     * row = 8 and
     * a matrix has been created
     * @ensures the current player character positions are counted which are connected vertically and
     * the correct boolean is returned for a vertical win
     */
    private static boolean checkVerticalWin(BoardPosition lastPos){
        //checks to see if the last marker placed resulted in 5 in a row vertically.
        //Returns true if it does, otherwise false
        int count = 1; //set initial marker count to 1
        int rowPos = lastPos.getRow();  //set rowPos
        int colPos = lastPos.getColumn();   //set colPos

        boolean resume = true;
        while (resume) {
            rowPos = rowPos - 1; //check next row up, same column
            if((count < GameBoard.WIN) && (rowPos >= 0) && (matrix[rowPos][colPos] == lastPos.getPlayer())) {
                count= count + 1;
            }
            else {
                resume = false;
            }
        }
        rowPos = lastPos.getRow();  //reset rowPos
        resume = true;
        while (resume) {
            rowPos = rowPos + 1; //check next row down, same column
            if((count < GameBoard.WIN) && (rowPos < GameBoard.ROW) && (matrix[rowPos][colPos] == lastPos.getPlayer())) {
                count = count + 1;
            }
            else {
                resume = false;
            }
        }
        //if count is bigger or equal to the amount needed to win
        if (count >= GameBoard.WIN ) {
            return true;
        }
        return false;
    }

    /**
     * @param lastPos the most recent position on the board and the last player
     * @return whether or not the player got win number of consecutive marks in a diagonal
     * @requires lastPos has the correct row, column, and player and
     * win = 5 and
     * column = 8 and
     * row = 8 and
     * a matrix has been created
     * @ensures the current player character positions are counted which are connected diagonally and
     * the correct boolean is returned for a diagonal win
     */
    private static boolean checkDiagonalWin(BoardPosition lastPos){
        //checks to see if the last marker placed resulted in 5 in a row diagonally.
        //Returns true if it does, otherwise false
        //Note: there are two diagonals to check
        int count = 1; //set initial marker count to 1
        int rowPos = lastPos.getRow(); //set rowPos
        int colPos = lastPos.getColumn(); //set colPos

        boolean resume = true;
        while (resume) {
            //check the up left diagonal
            colPos = colPos - 1;
            rowPos = rowPos -1;
            if((count < GameBoard.WIN) && (colPos >= 0) && (rowPos >= 0) && (matrix[rowPos][colPos] == lastPos.getPlayer())) {
                count= count + 1;
            }
            else {
                resume = false;
            }
        }
        colPos = lastPos.getColumn();   //reset colPos
        rowPos = lastPos.getRow();  //reset rowPos
        resume = true;
        while (resume) {
            //check the down right diagonal
            colPos = colPos + 1;
            rowPos = rowPos + 1;
            if((count < GameBoard.WIN) && (colPos < GameBoard.COLUMN) && (rowPos < GameBoard.ROW) &&
                    (matrix[rowPos][colPos] == lastPos.getPlayer())) {
                count = count + 1;
            }
            else {
                resume = false;
            }
        }
        //if count is bigger or equal to the amount needed to win
        if (count >= GameBoard.WIN ) {
            return true;
        }
        count = 1;
        colPos = lastPos.getColumn();   //reset colPos
        rowPos = lastPos.getRow();  //reset rowPos
        resume = true;
        while (resume) {
            //check the down left diagonal
            colPos = colPos - 1;
            rowPos = rowPos + 1;
            if((count < GameBoard.WIN) && (colPos >= 0) && (rowPos < GameBoard.ROW) &&
                    (matrix[rowPos][colPos] == lastPos.getPlayer())) {
                count = count + 1;
            }
            else {
                resume = false;
            }
        }
        colPos = lastPos.getColumn();   //reset colPos
        rowPos = lastPos.getRow();  //reset rowPos
        resume = true;
        while (resume) {
            //check the up right diagonal
            colPos = colPos + 1;
            rowPos = rowPos - 1;
            if((count < GameBoard.WIN) && (colPos < GameBoard.COLUMN) && (rowPos >= 0) &&
                    (matrix[rowPos][colPos] == lastPos.getPlayer())) {
                count = count + 1;
            }
            else {
                resume = false;
            }
        }
        //if count is bigger or equal to the amount needed to win
        if (count >= GameBoard.WIN) {
            return true;
        }
        return false;
    }

    /**
     * @param o an Object
     * @return whether 2 GameBoards are equal
     * @requires the constructor has been called and
     * @ensures equals = (this == o)
     */
    @Override
    public boolean equals(Object o) {
        //check if 2 gameboards are equal
        if (o == this) return true;
        if (o == null) {
            return false;
        }
        if (!(o instanceof GameBoard)) return false;
        return false;
    }
    /**
     * @return the custom string created
     * @requires the constructor has already been called and
     * a matrix has been created and
     * row == 8 and
     * column == 8
     * @ensures the correct string is returned
     */
    @Override
    public String toString()
    {
        //create the formatting and return a string of the gameboard
        String str = "";
        str += " ";
        for (int i = 0; i < ROW; i++) {
            str += " " + i;
        }
        str += " " + "\n";
        for (int i = 0; i < ROW; i++) {
            str += i;
            for (int j = 0; j < COLUMN; j++) {
                str += "|" + matrix[i][j];
            }
            str += "|" + "\n";
        }
        return str;
    }
}
