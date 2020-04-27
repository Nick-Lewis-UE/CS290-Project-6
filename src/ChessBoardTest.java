import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ChessBoardTest {
    int num_col = 8;
    int num_row = 8;
    int size = 64;

    @Test
    public void testConstructors() {
        ChessGame cg = new ChessGame();
        ChessBoard c = new ChessBoard(cg);
        ArrayList<ArrayList<AbstractPiece>> b = c.makeStartBoard(cg);

        BoardTest.testBoard(c, num_col, num_row, size, b);
    }

    @Test
    public void testMakeStartBoard() {
        ChessGame cg = new ChessGame();
        ChessBoard c1 = new ChessBoard(cg);
        ChessPlayer cp1 = new ChessPlayer(1,
                "Player 1", c1);
        ChessPlayer cp2 = new ChessPlayer(2,
                "Player 2", c1);

        ArrayList<ArrayList<AbstractPiece>> a = new ArrayList<>();

        a.add(0, new ArrayList<>());
        a.add(1, new ArrayList<>());
        a.add(2, new ArrayList<>());
        a.add(3, new ArrayList<>());
        a.add(4, new ArrayList<>());
        a.add(5, new ArrayList<>());
        a.add(6, new ArrayList<>());
        a.add(7, new ArrayList<>());

        a.get(0).add(0, new RookPiece("R", c1,
                new int[] {0,0}, cp1));
        a.get(0).add(1, new KnightPiece("N", c1,
                new int[] {1,0}, cp1));
        a.get(0).add(2, new BishopPiece("B", c1,
                new int[] {2,0}, cp1));
        a.get(0).add(3, new QueenPiece("Q", c1,
                new int[] {3,0}, cp1));
        a.get(0).add(4, new KingPiece("K", c1,
                new int[] {4,0}, cp1));
        a.get(0).add(5, new BishopPiece("B", c1,
                new int[] {5,0}, cp1));
        a.get(0).add(6, new KnightPiece("N", c1,
                new int[] {6,0}, cp1));
        a.get(0).add(7, new RookPiece("R", c1,
                new int[] {7,0}, cp1));

        a.get(1).add(0, new PawnPiece("P", c1,
                new int[] {0,1}, cp1));
        a.get(1).add(1, new PawnPiece("P", c1,
                new int[] {1,1}, cp1));
        a.get(1).add(2, new PawnPiece("P", c1,
                new int[] {2,1}, cp1));
        a.get(1).add(3, new PawnPiece("P", c1,
                new int[] {3,1}, cp1));
        a.get(1).add(4, new PawnPiece("P", c1,
                new int[] {4,1}, cp1));
        a.get(1).add(5, new PawnPiece("P", c1,
                new int[] {5,1}, cp1));
        a.get(1).add(6, new PawnPiece("P", c1,
                new int[] {6,1}, cp1));
        a.get(1).add(7, new PawnPiece("P", c1,
                new int[] {7,1}, cp1));

        a.get(2).add(0, new NullPiece());
        a.get(2).add(1, new NullPiece());
        a.get(2).add(2, new NullPiece());
        a.get(2).add(3, new NullPiece());
        a.get(2).add(4, new NullPiece());
        a.get(2).add(5, new NullPiece());
        a.get(2).add(6, new NullPiece());
        a.get(2).add(7, new NullPiece());

        a.get(3).add(0, new NullPiece());
        a.get(3).add(1, new NullPiece());
        a.get(3).add(2, new NullPiece());
        a.get(3).add(3, new NullPiece());
        a.get(3).add(4, new NullPiece());
        a.get(3).add(5, new NullPiece());
        a.get(3).add(6, new NullPiece());
        a.get(3).add(7, new NullPiece());

        a.get(4).add(0, new NullPiece());
        a.get(4).add(1, new NullPiece());
        a.get(4).add(2, new NullPiece());
        a.get(4).add(3, new NullPiece());
        a.get(4).add(4, new NullPiece());
        a.get(4).add(5, new NullPiece());
        a.get(4).add(6, new NullPiece());
        a.get(4).add(7, new NullPiece());

        a.get(5).add(0, new NullPiece());
        a.get(5).add(1, new NullPiece());
        a.get(5).add(2, new NullPiece());
        a.get(5).add(3, new NullPiece());
        a.get(5).add(4, new NullPiece());
        a.get(5).add(5, new NullPiece());
        a.get(5).add(6, new NullPiece());
        a.get(5).add(7, new NullPiece());

        a.get(6).add(0, new PawnPiece("p", c1,
                new int[] {0,6}, cp2));
        a.get(6).add(1, new PawnPiece("p", c1,
                new int[] {1,6}, cp2));
        a.get(6).add(2, new PawnPiece("p", c1,
                new int[] {2,6}, cp2));
        a.get(6).add(3, new PawnPiece("p", c1,
                new int[] {3,6}, cp2));
        a.get(6).add(4, new PawnPiece("p", c1,
                new int[] {4,6}, cp2));
        a.get(6).add(5, new PawnPiece("p", c1,
                new int[] {5,6}, cp2));
        a.get(6).add(6, new PawnPiece("p", c1,
                new int[] {6,6}, cp2));
        a.get(6).add(7, new PawnPiece("p", c1,
                new int[] {7,6}, cp2));

        a.get(7).add(0, new RookPiece("r", c1,
                new int[] {0,7}, cp1));
        a.get(7).add(1, new KnightPiece("n", c1,
                new int[] {1,7}, cp1));
        a.get(7).add(2, new BishopPiece("b", c1,
                new int[] {2,7}, cp1));
        a.get(7).add(3, new QueenPiece("q", c1,
                new int[] {3,7}, cp1));
        a.get(7).add(4, new KingPiece("k", c1,
                new int[] {4,7}, cp1));
        a.get(7).add(5, new BishopPiece("b", c1,
                new int[] {5,7}, cp1));
        a.get(7).add(6, new KnightPiece("n", c1,
                new int[] {6,7}, cp1));
        a.get(7).add(7, new RookPiece("r", c1,
                new int[] {7,7}, cp1));

        BoardTest.testBoard(c1, a);
    }

    @Test
    public void testValidMove() {
        ChessGame cg = new ChessGame();
        ChessBoard cb = (ChessBoard) cg.getBoard();

        Assert.assertTrue(cb.validMove(new int[] {3,1,3,2}, cg.getP1()));
        Assert.assertTrue(cb.validMove(new int[] {0,1,0,2}, cg.getP1()));
        Assert.assertTrue(cb.validMove(new int[] {7,1,7,2}, cg.getP1()));
        Assert.assertTrue(cb.validMove(new int[] {0,6,0,5}, cg.getP2()));
        Assert.assertTrue(cb.validMove(new int[] {3,6,3,5}, cg.getP2()));
        Assert.assertTrue(cb.validMove(new int[] {7,6,7,5}, cg.getP2()));

        cg.getP1().getMoveStrat().takeMove(new int[] {0,1,0,2});
        Assert.assertTrue(cb.validMove(new int[] {0,0,0,1}, cg.getP1()));
        Assert.assertTrue(cb.validMove(new int[] {0,2,0,3}, cg.getP1()));

        cg.getP2().getMoveStrat().takeMove(new int[] {1,6,1,3});
        Assert.assertTrue(cb.validMove(new int[] {0,2,1,3}, cg.getP1()));
        Assert.assertTrue(cb.validMove(new int[] {1,3,0,2}, cg.getP2()));

        Assert.assertTrue(cb.validMove(new int[] {6,7,7,5}, cg.getP2()));

    }
}
