/*  Alex Moore
    CPSC 2150 Program1
    Extended Tic-Tac-Toe
 */

package cpsc2150.homeworks.hw1;

public class BoardPosition {

    private static int row;
    private static int column;
    private static char character;

    /**
     * @param r the row position to put the marker
     * @param c the column position to put the marker
     * @param cha the player character
     * @ensures row = r and
     * column = c and
     * character = cha
     */
    BoardPosition (int r, int c, char cha) {
        BoardPosition.row = r;
        BoardPosition.column = c;
        BoardPosition.character = cha;
    }

    /**
     * @return the row position
     * @requires constructor has been called
     * @ensures getRow = row
     */
    public int getRow(){
        //returns the row
        return BoardPosition.row;
    }
    /**
     * @return the column position
     * @requires constructor has been called
     * @ensures getColumn = column
     */
    public int getColumn(){
        //returns the column
        return BoardPosition.column;
    }
    /**
     * @return the player character
     * @requires constructor has been called
     * @ensures getPLayer = the current player
     */
    public char getPlayer(){
        //returns X or O to signify the correct player
        /*if (BoardPosition.character == 'X') return 'X';
        return 'O';*/
        return BoardPosition.character;
    }

    /**
     * @param o an Object
     * @return whether 2 BoardPositions are equal
     * @requires the constructor has been called and
     * @ensures equals = (this == o)
     */
    @Override
    public boolean equals(Object o)
    {
        //check if 2 BoardPositions are equal
        if (o == null) return false;
        if (o == this) return true;
        if(!(o instanceof BoardPosition)) return false;
        return false;
    }

    /**
     * @return the custom string created
     * @requires the constructor has already been called and
     * row == the row position to put the marker
     * column == the column position to put the marker and
     * character == the player character
     * @ensures the correct string is returned
     */
    @Override
    public String toString()
    {
        String str = "";
        str += "Player " + character + " ";
        str += "at position " + row + "," + column + "\n";
        return str;
    }
}
