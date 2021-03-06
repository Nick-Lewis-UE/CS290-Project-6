import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PlayerTest {
    private void testPlayer(AbstractPlayer p, int playerNum,
                            String name, AbstractBoard board,
                            moveStrategy moveStrat) {
        Assert.assertEquals(playerNum, p.getPlayerNum());
        Assert.assertEquals(name, p.getName());
        Assert.assertEquals(board, p.getBoard());
        Assert.assertEquals(moveStrat.getClass(), p.getMoveStrat().getClass());
    }

    @Test
    public void testGomokuConstructor() {
        GomokuBoard gb = new GomokuBoard();
        GomokuPlayer p = new GomokuPlayer(1, "name", gb);
        moveStrategy gs = new GomokuMoveStrategy(p);
        testPlayer(p, 1, "name", gb, gs);
    }

    @Test
    public void testConnect4Constructor() {
        Connect4Game cg = new Connect4Game();
        Connect4Board cb = new Connect4Board(cg);
        Connect4Player cp = new Connect4Player(2, "nickname", cb);
        Connect4MoveStrategy cs = new Connect4MoveStrategy(cp);

        testPlayer(cp, 2, "nickname", cb, cs);
    }

    @Test
    public void testCheckersConstructor() {
        CheckersGame cg = new CheckersGame();
        CheckersBoard cb = new CheckersBoard(cg);
        CheckersPlayer cp = new CheckersPlayer(2, "who?", cb);
        CheckersMoveStrategy cs = new CheckersMoveStrategy(cp);

        testPlayer(cp, 2, "who?", cb, cs);
    }

    @Test
    public void testGomokuHasWin() {
        GomokuBoard g1 = new GomokuBoard();
        GomokuPlayer player1 = new GomokuPlayer(1, "nick", g1);
        GomokuMoveStrategy gs1 = new GomokuMoveStrategy(player1);

        gs1.takeMove(BoardTest.makeLoc(1, 1));
        gs1.takeMove(BoardTest.makeLoc(1, 2));
        gs1.takeMove(BoardTest.makeLoc(1, 3));
        gs1.takeMove(BoardTest.makeLoc(1, 4));
        gs1.takeMove(BoardTest.makeLoc(1, 5));

        Assert.assertEquals(true, player1.hasWon(BoardTest.makeLoc(1, 1)));
    }

    @Test
    public void testConnect4HasWin() {
        GomokuBoard g2 = new GomokuBoard();
        GomokuPlayer player2 = new GomokuPlayer(1, "not nick", g2);
        GomokuMoveStrategy gs2 = new GomokuMoveStrategy(player2);
        gs2.takeMove(BoardTest.makeLoc(5,2));
        gs2.takeMove(BoardTest.makeLoc(6,2));
        gs2.takeMove(BoardTest.makeLoc(7,2));
        gs2.takeMove(BoardTest.makeLoc(8,2));
        gs2.takeMove(BoardTest.makeLoc(9,2));

        Assert.assertEquals(true, player2.hasWon(BoardTest.makeLoc(7,2)));
    }

    @Test
    public void testCheckersHasWin() {
        CheckersGame cg = new CheckersGame();
        CheckersBoard c1 = new CheckersBoard(cg);
        CheckersPlayer p1 = new CheckersPlayer(1, "Nick", c1);
        CheckersPlayer p2 = new CheckersPlayer(2, "Not Nick", c1);

        for (int i = 0; i < c1.getGrid().size(); i++) {
            for (int j = 0; j < c1.getGrid().get(0).size(); j++) {
                if (c1.getGrid().get(i).get(j).getSymbol().equals("x")) {
                    c1.getGrid().get(i).set(j, new NullPiece());
                }
            }
        }

        Assert.assertFalse(p1.hasWon(new int[0]));
        Assert.assertTrue(p2.hasWon(new int[0]));
    }

    @Test
    public void testChessHasWon() {
        ChessGame cg = new ChessGame();
        cg.getP1().takeMove(new int[] {3,0,4,6});
        Assert.assertFalse(cg.getP1().hasWon(new int[] {4,6}));

        cg.getP1().takeMove(new int[] {4,6,4,5});
        System.out.println(cg.getBoard().toString());
        cg.setTurn(cg.getP2());
        Assert.assertTrue(cg.getP1().hasWon(new int[] {4,5}));
    }
}
