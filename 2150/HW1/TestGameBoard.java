package cpsc2150.homeworks.hw1;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestGameBoard {

    @Test
    public void testcheckSpace_empty()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'X');
        assertEquals(true, GameBoard.checkSpace(place));
    }

    @Test
    public void testcheckSpace_has_value_X()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'X');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkSpace(place));
    }

    @Test
    public void testcheckSpace_has_value_O()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'O');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkSpace(place));
    }

    @Test
    public void testcheckSpace_place_other()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'X');
        GameBoard.placeMarker(place);
        BoardPosition test = new BoardPosition(2,2,'X');
        assertEquals(true, GameBoard.checkSpace(test));
    }

    @Test
    public void testcheckSpace_topleftcorner_X()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(0,0,'X');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkSpace(place));
    }

    @Test
    public void testcheckSpace_bottom_right_corner_X()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(7,7,'X');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkSpace(place));
    }

    @Test
    public void testcheckSpace_top_right_corner_O()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(0,7,'O');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkSpace(place));
    }

    @Test
    public void testcheckSpace_bottom_left_corner_O()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(7,0,'O');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkSpace(place));
    }

    @Test
    public void testplaceMarker_3_3_X()
    {
        GameBoard testB = new GameBoard();
        char[][] test = new char[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                test[i][j] = ' ';
            }
        }
        test[3][3] = 'X';
        String str = "";
        str += " ";
        for (int i = 0; i < 8; i++) {
            str += " " + i;
        }
        str += " " + "\n";
        for (int i = 0; i < 8; i++) {
            str += i;
            for (int j = 0; j < 8; j++) {
                str += "|" + test[i][j];
            }
            str += "|" + "\n";
        }

        BoardPosition place = new BoardPosition(3,3,'X');
        GameBoard.placeMarker(place);
        assertEquals(str, testB.toString());
    }

    @Test
    public void testplaceMarker_2_5_O()
    {
        GameBoard testB = new GameBoard();
        char[][] test = new char[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                test[i][j] = ' ';
            }
        }
        test[2][5] = 'O';
        String str = "";
        str += " ";
        for (int i = 0; i < 8; i++) {
            str += " " + i;
        }
        str += " " + "\n";
        for (int i = 0; i < 8; i++) {
            str += i;
            for (int j = 0; j < 8; j++) {
                str += "|" + test[i][j];
            }
            str += "|" + "\n";
        }

        BoardPosition place = new BoardPosition(2,5,'O');
        GameBoard.placeMarker(place);
        assertEquals(str, testB.toString());
    }

    @Test
    public void testplaceMarker_0_0_X()
    {
        GameBoard testB = new GameBoard();
        char[][] test = new char[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                test[i][j] = ' ';
            }
        }
        test[0][0] = 'X';
        String str = "";
        str += " ";
        for (int i = 0; i < 8; i++) {
            str += " " + i;
        }
        str += " " + "\n";
        for (int i = 0; i < 8; i++) {
            str += i;
            for (int j = 0; j < 8; j++) {
                str += "|" + test[i][j];
            }
            str += "|" + "\n";
        }

        BoardPosition place = new BoardPosition(0,0,'X');
        GameBoard.placeMarker(place);
        assertEquals(str, testB.toString());
    }

    @Test
    public void testplaceMarker_0_7_X()
    {
        GameBoard testB = new GameBoard();
        char[][] test = new char[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                test[i][j] = ' ';
            }
        }
        test[0][7] = 'X';
        String str = "";
        str += " ";
        for (int i = 0; i < 8; i++) {
            str += " " + i;
        }
        str += " " + "\n";
        for (int i = 0; i < 8; i++) {
            str += i;
            for (int j = 0; j < 8; j++) {
                str += "|" + test[i][j];
            }
            str += "|" + "\n";
        }

        BoardPosition place = new BoardPosition(0,7,'X');
        GameBoard.placeMarker(place);
        assertEquals(str, testB.toString());
    }

    @Test
    public void testplaceMarker_7_0_X()
    {
        GameBoard testB = new GameBoard();
        char[][] test = new char[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                test[i][j] = ' ';
            }
        }
        test[7][0] = 'X';
        String str = "";
        str += " ";
        for (int i = 0; i < 8; i++) {
            str += " " + i;
        }
        str += " " + "\n";
        for (int i = 0; i < 8; i++) {
            str += i;
            for (int j = 0; j < 8; j++) {
                str += "|" + test[i][j];
            }
            str += "|" + "\n";
        }

        BoardPosition place = new BoardPosition(7,0,'X');
        GameBoard.placeMarker(place);
        assertEquals(str, testB.toString());
    }

    @Test
    public void testplaceMarker_7_7_X()
    {
        GameBoard testB = new GameBoard();
        char[][] test = new char[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                test[i][j] = ' ';
            }
        }
        test[7][7] = 'X';
        String str = "";
        str += " ";
        for (int i = 0; i < 8; i++) {
            str += " " + i;
        }
        str += " " + "\n";
        for (int i = 0; i < 8; i++) {
            str += i;
            for (int j = 0; j < 8; j++) {
                str += "|" + test[i][j];
            }
            str += "|" + "\n";
        }

        BoardPosition place = new BoardPosition(7,7,'X');
        GameBoard.placeMarker(place);
        assertEquals(str, testB.toString());
    }

    @Test
    public void testcheckForWinner_empty()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'X');
        assertEquals(false, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_one_place_1_1()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'X');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_one_place_4_6()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(4,6,'X');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_two_places_horizontal()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,2, 'X');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_three_places_horizontal()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,2, 'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,3,'X');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_four_places_horizontal()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,2, 'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,3,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,4,'X');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_five_places_horizontal_notconnected()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,2, 'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,3,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,4,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,6,'X');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_six_places_horizontal_connected()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,2, 'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,3,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,4,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,6,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,5,'X');
        GameBoard.placeMarker(place);
        assertEquals(true, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_five_places_horizontal_connected()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,2, 'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,3,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,4,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,0,'X');
        GameBoard.placeMarker(place);
        assertEquals(true, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_five_places_horizontal_connected_topedge()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(0,0,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(0,1, 'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(0,2,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(0,4,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(0,3,'X');
        GameBoard.placeMarker(place);
        assertEquals(true, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_five_places_horizontal_connected_bottomedgeleft()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(7,0,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(7,1, 'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(7,2,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(7,4,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(7,3,'X');
        GameBoard.placeMarker(place);
        assertEquals(true, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_five_places_horizontal_connected_bottomedgeright()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(7,3,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(7,5, 'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(7,6,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(7,7,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(7,4,'X');
        GameBoard.placeMarker(place);
        assertEquals(true, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_two_places_vert()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,1, 'X');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_three_places_vert()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,1, 'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(3,1,'X');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_four_places_vert()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,1, 'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(3,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,1,'X');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_five_places_vert_notconnected()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,1, 'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(3,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(6,1,'X');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_six_places_vert_connected()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,1, 'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(3,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(6,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(5,1,'X');
        GameBoard.placeMarker(place);
        assertEquals(true, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_five_places_vert_connected()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,1, 'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(3,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(0,1,'X');
        GameBoard.placeMarker(place);
        assertEquals(true, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_five_places_vert_connected_leftedge()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(0,0,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,0, 'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(3,0,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,0,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,0,'X');
        GameBoard.placeMarker(place);
        assertEquals(true, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_five_places_vert_connected_rightedge()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(3,7,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(5,7, 'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(6,7,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(7,7,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,7,'X');
        GameBoard.placeMarker(place);
        assertEquals(true, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_two_places_negDiagonal()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,2, 'O');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_three_places_negDiagonal()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,2, 'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(3,3,'O');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_four_places_negDiagonal()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,2, 'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(3,3,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,4,'O');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_five_places_negDiagonal_notconnected()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,2, 'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(3,3,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,4,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(6,6,'O');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_six_places_negDiagonal_connected()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,2, 'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(3,3,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,4,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(6,6,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(5,5,'O');
        GameBoard.placeMarker(place);
        assertEquals(true, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_five_places_negDiagonal_connected()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,2, 'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(3,3,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,4,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(0,0,'O');
        assertEquals(true, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_five_places_negDiagonal_connected_bottomcorner()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(3,3,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(5,5, 'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(6,6,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(7,7,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,4,'O');
        assertEquals(true, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_five_places_negDiagonal_connected_bottommiddle()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(3,0,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(5,2, 'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(6,3,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(7,4,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,1,'O');
        assertEquals(true, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_five_places_negDiagonal_connected_rightmiddle()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(0,3,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,5, 'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(3,6,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,7,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(1,4,'O');
        assertEquals(true, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_two_places_posDiagonal()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,6,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,5, 'O');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_three_places_posDiagonal()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,6,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,5, 'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(3,4,'O');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_four_places_posDiagonal()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,6,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,5, 'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(3,4,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,3,'O');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_five_places_posDiagonal_notconnected()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,6,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,5, 'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(3,4,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,3,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(6,1,'O');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_six_places_posDiagonal_connected()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,6,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,5, 'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(3,4,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,3,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(6,1,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(5,2,'O');
        GameBoard.placeMarker(place);
        assertEquals(true, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_five_places_posDiagonal_connected()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,6,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,5, 'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(3,4,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,3,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(0,7,'O');
        assertEquals(true, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_five_places_posDiagonal_connected_bottomcorner()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(3,4,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(5,2, 'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(6,1,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(7,0,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,3,'O');
        assertEquals(true, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_five_places_posDiagonal_connected_topmiddle()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,3,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,2, 'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(3,1,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,0,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(0,4,'O');
        assertEquals(true, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForWinner_five_places_posDiagonal_connected_rightmiddle()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(7,3,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(5,5, 'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(3,7,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(4,6,'O');
        GameBoard.placeMarker(place);
        place = new BoardPosition(6,4,'O');
        assertEquals(true, GameBoard.checkForWinner(place));
    }

    @Test
    public void testcheckForDraw_empty()
    {
        GameBoard testB = new GameBoard();
        assertEquals(false, GameBoard.checkForDraw());
    }

    @Test
    public void testcheckForDraw_oneplace()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'X');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForDraw());
    }

    @Test
    public void testcheckForDraw_threeplaces()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place = new BoardPosition(1,1,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(5,3,'X');
        GameBoard.placeMarker(place);
        place = new BoardPosition(2,7,'X');
        GameBoard.placeMarker(place);
        assertEquals(false, GameBoard.checkForDraw());
    }

    @Test
    public void testcheckForDraw_notatie_middle()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place;
        char ch = '1';
        for (int i = 0; i<8; i++) {
            for (int j = 0; j<8; j++) {
                if (i==3 && j==3) {
                    place = new BoardPosition(3,3, ' ');
                }
                else{
                    place = new BoardPosition(i, j, ch);
                    GameBoard.placeMarker(place);
                    assertEquals(false, GameBoard.checkForWinner(place));
                    ch++;
                }
            }
        }
        assertEquals(false, GameBoard.checkForDraw());
    }

    @Test
    public void testcheckForDraw_notatie_last()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place;
        char ch = '1';
        for (int i = 0; i<8; i++) {
            for (int j = 0; j<8; j++) {
                if (i==7 && j==7) {
                    place = new BoardPosition(7,7, ' ');
                }
                else{
                    place = new BoardPosition(i, j, ch);
                    GameBoard.placeMarker(place);
                    assertEquals(false, GameBoard.checkForWinner(place));
                    ch++;
                }
            }
        }
        assertEquals(false, GameBoard.checkForDraw());
    }

    @Test
    public void testcheckForDraw()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place;
        char ch = '1';
        for (int i = 0; i<8; i++) {
            for (int j = 0; j<8; j++) {
                place = new BoardPosition(i, j, ch);
                GameBoard.placeMarker(place);
                assertEquals(false, GameBoard.checkForWinner(place));
                ch++;
            }
        }
        assertEquals(true, GameBoard.checkForDraw());
    }

    @Test
    public void testcheckForDraw_space_ascii_char()
    {
        GameBoard testB = new GameBoard();
        BoardPosition place;
        char ch = '9';
        for (int i = 0; i<8; i++) {
            for (int j = 0; j<8; j++) {
                place = new BoardPosition(i, j, ch);
                GameBoard.placeMarker(place);
                if(i==3&&j==1) {
                    assertEquals(true, GameBoard.checkForWinner(place));
                }
                else{
                    assertEquals(false, GameBoard.checkForWinner(place));
                }
                ch--;
            }
        }
        assertEquals(false, GameBoard.checkForDraw());
    }

    @Test
    public void testinitialize()
    {
        GameBoard testB = new GameBoard();
        char[][] test = new char[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                test[i][j] = ' ';
            }
        }
        String str = "";
        str += " ";
        for (int i = 0; i < 8; i++) {
            str += " " + i;
        }
        str += " " + "\n";
        for (int i = 0; i < 8; i++) {
            str += i;
            for (int j = 0; j < 8; j++) {
                str += "|" + test[i][j];
            }
            str += "|" + "\n";
        }

        assertEquals(str, testB.toString());
    }

}
