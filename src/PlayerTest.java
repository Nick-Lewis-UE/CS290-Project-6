import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PlayerTest {
//    private void testPlayer(AbstractPlayer p, String symbol) {
//        Assert.assertEquals(symbol, p.getPiece().getSymbol());
//    }
//
//    @Test
//    public void testConstructors() {
//        Player p1 = new Player("x");
//        testPlayer(p1, "x");
//
//        Player p2 = new Player("o");
//        testPlayer(p2, "o");
//    }

    @Test
    public void testHasWin() {
        GomokuBoard g1 = new GomokuBoard();
        GomokuPlayer player1 = new GomokuPlayer(1, "nick", g1);
        GomokuMoveStrategy gs1 = new GomokuMoveStrategy(player1);

        gs1.takeMove(BoardTest.makeLoc(1,1));
        gs1.takeMove(BoardTest.makeLoc(1,2));
        gs1.takeMove(BoardTest.makeLoc(1,3));
        gs1.takeMove(BoardTest.makeLoc(1,4));
        gs1.takeMove(BoardTest.makeLoc(1,5));

        Assert.assertEquals(true, player1.hasWin(BoardTest.makeLoc(1,1)));

        GomokuBoard g2 = new GomokuBoard();
        GomokuPlayer player2 = new GomokuPlayer(1, "not nick", g2);
        GomokuMoveStrategy gs2 = new GomokuMoveStrategy(player2);
        gs2.takeMove(BoardTest.makeLoc(5,2));
        gs2.takeMove(BoardTest.makeLoc(6,2));
        gs2.takeMove(BoardTest.makeLoc(7,2));
        gs2.takeMove(BoardTest.makeLoc(8,2));
        gs2.takeMove(BoardTest.makeLoc(9,2));

        Assert.assertEquals(true, player2.hasWin(BoardTest.makeLoc(7,2)));

    }
}
