import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class GameTest {
    private void testGame(AbstractGame g, AbstractBoard b, AbstractPlayer p1, AbstractPlayer p2) {
        ArrayList<ArrayList<AbstractPiece>> grid = b.makeStartBoard(g);
        Assert.assertEquals(grid.size()*grid.get(0).size(), b.getSize());
        for (int i = 0; i < b.getNum_row(); i++) {
            for (int j = 0; j < b.getNum_col(); j++)
                Assert.assertEquals(grid.get(i).get(j).getSymbol(),
                        b.getGrid().get(i).get(j).getSymbol());
        }
        Assert.assertEquals(p1.getPlayerNum(), g.getP1().getPlayerNum());
        Assert.assertEquals(p2.getPlayerNum(), g.getP2().getPlayerNum());
    }

    @Test
    public void testConstructors() {

        // Gomoku
        GomokuGame g1 = new GomokuGame();
        AbstractBoard b1 = new GomokuBoard();
        AbstractPlayer p1 = new GomokuPlayer(1, "Player 1", b1);
        AbstractPlayer p2 = new GomokuPlayer(2, "Player 2", b1);

        testGame(g1, b1, p1, p2);

        // Connect4
        Connect4Game g2 = new Connect4Game();
        Connect4Board b2 = new Connect4Board(g2);
        AbstractPlayer p11 = new Connect4Player(1, "Player 1", b1);
        AbstractPlayer p21 = new Connect4Player(2, "Player 2", b1);

        testGame(g2, b2, p11, p21);
    }

    @Test
    public void testScanForPiece() {
    }
}
