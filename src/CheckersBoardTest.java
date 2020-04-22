import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CheckersBoardTest extends BoardTest {

    int num_col = 8;
    int num_row = 8;
    int size = 64;

    @Test
    public void testConstructors() {
        CheckersGame cg = new CheckersGame();
        CheckersBoard c = new CheckersBoard(cg);
        ArrayList<ArrayList<AbstractPiece>> b = c.makeStartBoard(cg);

        testBoard(c, num_col, num_row, size, b);
    }

    @Test
    public void testToString() {
        CheckersGame cg = new CheckersGame();
        CheckersBoard c1 = new CheckersBoard(cg);

        String s = "|A|B|C|D|E|F|G|H|\n" +
                "| |x| |x| |x| |x| 8\n" +
                "|x| |x| |x| |x| | 7\n" +
                "| |x| |x| |x| |x| 6\n" +
                "| | | | | | | | | 5\n" +
                "| | | | | | | | | 4\n" +
                "|o| |o| |o| |o| | 3\n" +
                "| |o| |o| |o| |o| 2\n" +
                "|o| |o| |o| |o| | 1\n";

        Assert.assertEquals(s, c1.toString());
    }

    @Test
    public void testMakeStartBoard() {
        CheckersGame cg = new CheckersGame();
        CheckersBoard c1 = new CheckersBoard(cg);
        CheckersPlayer cp1 = new CheckersPlayer(1,
                "Player 1", c1);
        CheckersPlayer cp2 = new CheckersPlayer(2,
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

        a.get(0).add(0, new NullPiece());
        a.get(0).add(1, new CheckersPiece("x", c1,
                new int[] {1,0}, cp1));
        a.get(0).add(2, new NullPiece());
        a.get(0).add(3, new CheckersPiece("x", c1,
                new int[] {1,0}, cp1));
        a.get(0).add(4, new NullPiece());
        a.get(0).add(5, new CheckersPiece("x", c1,
                new int[] {1,0}, cp1));
        a.get(0).add(6, new NullPiece());
        a.get(0).add(7, new CheckersPiece("x", c1,
                new int[] {1,0}, cp1));

        a.get(1).add(0, new CheckersPiece("x", c1,
                new int[] {1,0}, cp1));
        a.get(1).add(1, new NullPiece());
        a.get(1).add(2, new CheckersPiece("x", c1,
                new int[] {1,0}, cp1));
        a.get(1).add(3, new NullPiece());
        a.get(1).add(4, new CheckersPiece("x", c1,
                new int[] {1,0}, cp1));
        a.get(1).add(5, new NullPiece());
        a.get(1).add(6, new CheckersPiece("x", c1,
                new int[] {1,0}, cp1));
        a.get(1).add(7, new NullPiece());

        a.get(2).add(0, new NullPiece());
        a.get(2).add(1, new CheckersPiece("x", c1,
                new int[] {1,0}, cp1));
        a.get(2).add(2, new NullPiece());
        a.get(2).add(3, new CheckersPiece("x", c1,
                new int[] {1,0}, cp1));
        a.get(2).add(4, new NullPiece());
        a.get(2).add(5, new CheckersPiece("x", c1,
                new int[] {1,0}, cp1));
        a.get(2).add(6, new NullPiece());
        a.get(2).add(7, new CheckersPiece("x", c1,
                new int[] {1,0}, cp1));

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

        a.get(5).add(0, new CheckersPiece("o", c1,
                new int[] {0,5}, cp2));
        a.get(5).add(1, new NullPiece());
        a.get(5).add(2, new CheckersPiece("o", c1,
                new int[] {0,5}, cp2));
        a.get(5).add(3, new NullPiece());
        a.get(5).add(4, new CheckersPiece("o", c1,
                new int[] {0,5}, cp2));
        a.get(5).add(5, new NullPiece());
        a.get(5).add(6, new CheckersPiece("o", c1,
                new int[] {0,5}, cp2));
        a.get(5).add(7, new NullPiece());

        a.get(6).add(0, new NullPiece());
        a.get(6).add(1, new CheckersPiece("o", c1,
                new int[] {0,5}, cp2));
        a.get(6).add(2, new NullPiece());
        a.get(6).add(3, new CheckersPiece("o", c1,
                new int[] {0,5}, cp2));
        a.get(6).add(4, new NullPiece());
        a.get(6).add(5, new CheckersPiece("o", c1,
                new int[] {0,5}, cp2));
        a.get(6).add(6, new NullPiece());
        a.get(6).add(7, new CheckersPiece("o", c1,
                new int[] {0,5}, cp2));

        a.get(7).add(0, new CheckersPiece("o", c1,
                new int[] {0,5}, cp2));
        a.get(7).add(1, new NullPiece());
        a.get(7).add(2, new CheckersPiece("o", c1,
                new int[] {0,5}, cp2));
        a.get(7).add(3, new NullPiece());
        a.get(7).add(4, new CheckersPiece("o", c1,
                new int[] {0,5}, cp2));
        a.get(7).add(5, new NullPiece());
        a.get(7).add(6, new CheckersPiece("o", c1,
                new int[] {0,5}, cp2));
        a.get(7).add(7, new NullPiece());

        testBoard(c1, a);
    }

    @Test
    public void testValidMove() {
        CheckersBoard c1 = new CheckersBoard(new CheckersGame());
        CheckersPlayer p1 = new CheckersPlayer(1, "player", c1);
        CheckersPlayer p2 = new CheckersPlayer(2, "player", c1);
        // valid move
        int[] move1 = new int[] {1,2,2,3};
        Assert.assertTrue(c1.validMove(move1, p1));

        // invalid starting point
        int[] move2 = new int[] {1,1,2,2};
        Assert.assertFalse(c1.validMove(move2, p1));

        // invalid ending point
        int[] move3 = new int[] {0,1,1,2};
        Assert.assertFalse(c1.validMove(move3, p1));

        // no piece to be jumped
        int[] move4 = new int[] {1,2,3,4};
        Assert.assertFalse(c1.validMove(move4, p1));

        // not diagonal move
        int[] move5 = new int[] {1,2,1,3};
        Assert.assertFalse(c1.validMove(move5, p1));

        // can't move backwards
        p1.takeMove(new int[] {7,2,6,3});
        int[] move6 = new int[] {6,3,7,2};
        Assert.assertFalse(c1.validMove(move6, p1));

        // must take forced jump
        p2.takeMove(new int[] {4,5,5,4});
        int[] move7 = new int[] {3,2,2,3};
        Assert.assertFalse(c1.validMove(move7, p1));
    }

    @Test
    public void testHasTie() {
        CheckersBoard c = new CheckersBoard(new CheckersGame());
        CheckersPlayer p1 = new CheckersPlayer(1, "who", c);
        CheckersPlayer p2 = new CheckersPlayer(2, "where", c);

        Assert.assertFalse(c.hasTie());

       p1.takeMove(new int[] {1,2,0,3});
       p1.takeMove(new int[] {3,2,2,3});
       p1.takeMove(new int[] {5,2,4,3});
       p1.takeMove(new int[] {7,2,6,3});
       p1.takeMove(new int[] {0,1,1,2});
       p1.takeMove(new int[] {2,1,3,2});
       p1.takeMove(new int[] {4,1,5,2});
       p1.takeMove(new int[] {6,1,7,2});
       p1.takeMove(new int[] {1,0,0,1});
       p1.takeMove(new int[] {3,0,2,1});
       p1.takeMove(new int[] {5,0,4,1});
       p1.takeMove(new int[] {7,0,6,1});

       p2.takeMove(new int[] {0,5,1,4});
       p2.takeMove(new int[] {2,5,3,4});
       p2.takeMove(new int[] {4,5,5,4});
       p2.takeMove(new int[] {6,5,7,4});
       p2.takeMove(new int[] {1,6,0,5});
       p2.takeMove(new int[] {3,6,2,5});
       p2.takeMove(new int[] {5,6,4,5});
       p2.takeMove(new int[] {7,6,6,5});
       p2.takeMove(new int[] {0,7,1,6});
       p2.takeMove(new int[] {2,7,3,6});
       p2.takeMove(new int[] {4,7,5,6});
       p2.takeMove(new int[] {6,7,7,6});

        Assert.assertTrue(c.hasTie());
    }

    @Test
    public void testKingMe() {
        CheckersGame cg =new CheckersGame();
        CheckersBoard c = new CheckersBoard(cg);
        CheckersPiece xPiece = new CheckersPiece("x", c,
                new int[0], cg.getP1());
        CheckersPiece oPiece = new CheckersPiece("o", c,
                new int[0], cg.getP2());

        Assert.assertTrue(c.kingMe(new int[] {1,0,7,7}, xPiece));
        Assert.assertTrue(c.kingMe(new int[] {6,7,4,0}, oPiece));
    }

    @Test
    public void testIsJumpMove() {
        CheckersBoard c1 = new CheckersBoard(new CheckersGame());
        int[] j = new int[4];
        j[0] = 2;
        j[1] = 3;
        j[2] = 4;
        j[3] = 5;

        Assert.assertTrue(c1.isJumpMove(j));
        Assert.assertTrue(c1.isJumpMove(new int[] {3,6,5,4}));
    }

    @Test
    public void testFindLegalMoves() {
        CheckersGame cg = new CheckersGame();
        CheckersBoard c1 = new CheckersBoard(cg);
        AbstractPlayer p1 = cg.getP1();
        AbstractPlayer p2 = cg.getP2();
        ArrayList<int[]> a1 = c1.findLegalMoves(p1);

        ArrayList<int[]> legalMoves = new ArrayList<>();
        ArrayList<ArrayList<AbstractPiece>> b = c1.makeStartBoard(cg);
        for (int r = 0; r <(b).size(); r++) {
            for (int c = 0; c <(b).get(r).size(); c++) {
                if (b.get(r).get(c).getPlayer().getPlayerNum() == p1.getPlayerNum()) {
                    legalMoves.addAll(b.get(r).get(c).generateMoves());
                }
            }
        }

        for (int i = 0; i < legalMoves.size(); i++) {
            Assert.assertArrayEquals(legalMoves.get(i), a1.get(i));
        }

        cg.getP1().takeMove(new int[] {1,2,2,3});
        cg.getP2().takeMove(new int[] {4,5,3,4});
        cg.getP2().takeMove(new int[] {0,5,1,4});
        cg.getP1().takeMove(new int[] {7,2,6,3});
        cg.getP2().takeMove(new int[] {6,5,5,4});

        b.get(2).set(1, new NullPiece(c1, new int[] {1,2}));
        b.get(3).set(2, new CheckersPiece("x", c1,
                new int[] {2,3}, p1));
        b.get(5).set(4, new NullPiece(c1, new int[] {4,5}));
        b.get(4).set(3, new CheckersPiece("o", c1,
                new int[] {3,4}, p2));
        b.get(5).set(0, new NullPiece(c1, new int[] {0,5}));
        b.get(4).set(1, new CheckersPiece("o", c1,
                new int[] {1,4}, p2));
        b.get(2).set(7, new NullPiece(c1, new int[] {7,6}));
        b.get(3).set(6, new CheckersPiece("x", c1,
                new int[] {6,3}, p1));
        b.get(5).set(6, new NullPiece(c1, new int[] {6,5}));
        b.get(4).set(5, new CheckersPiece("o", c1,
                new int[] {5,4}, p2));

        CheckersBoard c100 = (CheckersBoard) cg.getBoard();
        ArrayList<int[]> a3 = c100.findLegalMoves(p1);

        ArrayList<int[]> legalMoves2 = new ArrayList<>();
        legalMoves2.add(new int[] {2,3,4,5});
        legalMoves2.add(new int[] {2,3,0,5});
        legalMoves2.add(new int[] {6,3,4,5});

        for (int i = 0; i < legalMoves2.size(); i++) {
            Assert.assertArrayEquals(legalMoves2.get(i), ((CheckersBoard) cg.getBoard()).findLegalMoves(cg.getP1()).get(i));
        }

    }

    @Test
    public void testAppendMoveArray() {
        CheckersBoard b1 = new CheckersBoard(new CheckersGame());

        int[] a1 = new int[] {1,2,3,4};
        int[] a2 = new int[] {5,6};

        Assert.assertArrayEquals(new int[] {1,2,3,4,5,6}, b1.appendMoveArray(a1, a2));
    }
}
