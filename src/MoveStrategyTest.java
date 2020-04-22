import com.sun.tools.javac.comp.Check;
import org.junit.Test;

import java.util.ArrayList;

public class MoveStrategyTest {
    @Test
    public void testGomoku() {
        // Gomoku
        GomokuBoard g1 = new GomokuBoard();
        GomokuPlayer gp1 = new GomokuPlayer(1, "p1", g1);
        int[] loc1 = new int[2];
        loc1[0] = loc1[1] = 5;
        AbstractPiece p1 = new GomokuPiece("x", g1, loc1, gp1);
        new GomokuMoveStrategy(gp1);
        gp1.takeMove(loc1);

        ArrayList<ArrayList<AbstractPiece>> a1 = BoardTest.makeEmptyBoard(19, 19);
        a1.get(4).set(4, p1);
        BoardTest.testBoard(g1, a1);
    }

    @Test
    public void testConnect4() {
        //Connect4
        Connect4Game cg1 = new Connect4Game();
        Connect4Board c1 = (Connect4Board) cg1.getBoard();
        int[] loc2 = new int[1];
        int[] loc3 = new int[1];
        loc2[0] = 3;
        loc3[0] = 5;
        AbstractPiece p2 = new Connect4Piece("o", c1, loc2, cg1.getP2());
        AbstractPiece p3 = new Connect4Piece("x", c1, loc3, cg1.getP1());
        Connect4MoveStrategy cs1 = new Connect4MoveStrategy(cg1.getP2());
        Connect4MoveStrategy cs2 = new Connect4MoveStrategy(cg1.getP1());
        cs1.takeMove(loc2);
        cs2.takeMove(loc3);
        ArrayList<ArrayList<AbstractPiece>> a2 = BoardTest.makeEmptyBoard(6,7);
        a2.get(5).set(2, p2);
        a2.get(5).set(4, p3);
        BoardTest.testBoard(c1, a2);

        int[] loc4 = new int[1];
        loc4[0] = 5;
        cs2.takeMove(loc4);
        a2.get(4).set(4, p3);
        BoardTest.testBoard(c1, a2);
    }

    @Test
    public void testCheckers() {
        CheckersGame cg1 = new CheckersGame();
        CheckersBoard c = new CheckersBoard(cg1);
        CheckersPlayer p1 = new CheckersPlayer(1, "who", c);
        CheckersPlayer p2 = new CheckersPlayer(2, "where", c);
        CheckersMoveStrategy cs1 = new CheckersMoveStrategy(p1);
        CheckersMoveStrategy cs2 = new CheckersMoveStrategy(p2);
        cs1.takeMove(new int[] {1,2,2,3});
        cs2.takeMove(new int[] {4,5,3,4});
        cs2.takeMove(new int[] {6,5,7,4});
        cs2.takeMove(new int[] {7,6,6,5});
        cs2.takeMove(new int[] {6,7,7,6});
        cs1.takeMove(new int[] {2,3,4,5,6,7});

        ArrayList<ArrayList<AbstractPiece>> g = c.makeStartBoard(cg1);
        g.get(2).set(1, new NullPiece());
        g.get(5).set(4, new NullPiece());
        g.get(6).set(5, new NullPiece());
        g.get(4).set(7, new CheckersPiece("o", c, new int[] {7,4}, p1));
        g.get(7).set(6, new CheckersPiece("X", c, new int[] {6,7}, p2));

        BoardTest.testBoard(c, g);
    }
}
