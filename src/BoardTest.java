import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BoardTest {
    public static void testBoard(AbstractBoard b, ArrayList<ArrayList<AbstractPiece>> grid) {
//        System.out.println("Grid Size: " + grid.size());
        for (int i = 0; i < b.getNum_row(); i++) {
//            System.out.println(b.getGrid().get(i).getSymbol());
//            System.out.println(grid.get(i).getSymbol());
            for (int j = 0; j < b.getNum_col(); j++)
                Assert.assertEquals(grid.get(i).get(j).getSymbol(),
                        b.getGrid().get(i).get(j).getSymbol());
        }
    }

    public void testBoard(AbstractBoard b, int num_col, int num_row, int size,
                             ArrayList<ArrayList<AbstractPiece>> grid) {
//        System.out.println("Grid Size: " + grid.size());
        for (int i = 0; i < b.getNum_row(); i++) {
//            System.out.println(b.getGrid().get(i).getSymbol());
//            System.out.println(grid.get(i).getSymbol());
            for (int j = 0; j < b.getNum_col(); j++)
                Assert.assertEquals(grid.get(i).get(j).getSymbol(),
                        b.getGrid().get(i).get(j).getSymbol());

            Assert.assertEquals(num_col, b.getNum_col());
            Assert.assertEquals(num_row, b.getNum_row());
            Assert.assertEquals(size, b.getSize());
        }
    }


    public static ArrayList<ArrayList<AbstractPiece>> makeEmptyBoard(int rows, int cols) {
        ArrayList<ArrayList<AbstractPiece>> a= new ArrayList();
        for (int i = 0; i < rows; i++) {
            a.add(i, new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                a.get(i).add(j, new NullPiece());
            }
        }
        return a;
    }

    public static int[] makeLoc(int col, int row) {
        int[] loc = new int[2];
        loc[0] = col;
        loc[1] = row;
        return loc;
    }

    @Test
    public void testConstructors() {
        // Gomoku

        // testing empty constructor
        GomokuBoard g1 = new GomokuBoard();
        testBoard(g1, makeEmptyBoard(19, 19));


        // Connect4
        Connect4Game cg1 = new Connect4Game();
        Connect4Board b2 = new Connect4Board(cg1);
        testBoard(b2, makeEmptyBoard(6, 7));
    }

    @Test
    public void testGomokuToString() {
        GomokuBoard b1 = new GomokuBoard();

        String s = "|A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|\n" +
                "| | | | | | | | | | | | | | | | | | | |1\n" +
                "| | | | | | | | | | | | | | | | | | | |2\n" +
                "| | | | | | | | | | | | | | | | | | | |3\n" +
                "| | | | | | | | | | | | | | | | | | | |4\n" +
                "| | | | | | | | | | | | | | | | | | | |5\n" +
                "| | | | | | | | | | | | | | | | | | | |6\n" +
                "| | | | | | | | | | | | | | | | | | | |7\n" +
                "| | | | | | | | | | | | | | | | | | | |8\n" +
                "| | | | | | | | | | | | | | | | | | | |9\n" +
                "| | | | | | | | | | | | | | | | | | | |10\n" +
                "| | | | | | | | | | | | | | | | | | | |11\n" +
                "| | | | | | | | | | | | | | | | | | | |12\n" +
                "| | | | | | | | | | | | | | | | | | | |13\n" +
                "| | | | | | | | | | | | | | | | | | | |14\n" +
                "| | | | | | | | | | | | | | | | | | | |15\n" +
                "| | | | | | | | | | | | | | | | | | | |16\n" +
                "| | | | | | | | | | | | | | | | | | | |17\n" +
                "| | | | | | | | | | | | | | | | | | | |18\n" +
                "| | | | | | | | | | | | | | | | | | | |19\n";

        Assert.assertEquals(s, b1.toString());
    }

    @Test
    public void testConnect4ToString() {
        System.out.println("Empty Gomoku Board.");
        GomokuBoard g1 = new GomokuBoard();
        g1.toString();
    }
}
