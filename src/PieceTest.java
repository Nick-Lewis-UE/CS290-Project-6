import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class PieceTest {
    private void testPiece(AbstractPiece p, String symbol) {
        Assert.assertEquals(symbol, p.getSymbol());
    }

//    @Test
//    public void testConstructors() {
//        String s1 = "x";
//        AbstractPiece p1 = new AbstractPiece(s1);
//        testPiece(p1, s1);
//    }
    @Test
    public void testSimpleMoves() {
        CheckersGame cg = new CheckersGame();
        CheckersBoard c1 = new CheckersBoard(cg);
        CheckersPiece p1 = (CheckersPiece) cg.getBoard().getGrid().get(2).get(1);
        CheckersPiece p2 = (CheckersPiece) cg.getBoard().getGrid().get(0).get(7);
        CheckersMoveStrategy cs = new CheckersMoveStrategy(cg.getP2());

        Assert.assertFalse(p1.findSimpleMoves().isEmpty());

        Assert.assertArrayEquals(new int[] {1,2,2,3},
                p1.findSimpleMoves().get(0));
        Assert.assertArrayEquals(new int[] {1,2,0,3},
                p1.findSimpleMoves().get(1));
        Assert.assertTrue(p2.findSimpleMoves().isEmpty());

        cg.getP2().takeMove(new int[] {4,5,3,4});
        cg.getP2().takeMove(new int[] {3,4,2,3});
        CheckersPiece p3 = (CheckersPiece) cg.getBoard().getGrid().get(2).get(1);

        Assert.assertArrayEquals(new int[] {1,2,0,3},
                p3.findSimpleMoves().get(0));
    }
}
