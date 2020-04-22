import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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

//    @Test
//    public void testHasTie() {
//        CheckersBoard c = new CheckersBoard();
//        CheckersPlayer p1 = new CheckersPlayer(1, "who", c);
//        CheckersPlayer p2 = new CheckersPlayer(2, "where", c);
//
//        Assert.assertFalse(c.hasTie());
//
//       p1.takeMove(new int[] {1,2,0,3});
//       p1.takeMove(new int[] {3,2,2,3});
//       p1.takeMove(new int[] {5,2,4,3});
//       p1.takeMove(new int[] {7,2,6,3});
//       p1.takeMove(new int[] {0,1,1,2});
//       p1.takeMove(new int[] {2,1,3,2});
//       p1.takeMove(new int[] {4,1,5,2});
//       p1.takeMove(new int[] {6,1,7,2});
//       p1.takeMove(new int[] {1,0,0,1});
//       p1.takeMove(new int[] {3,0,2,1});
//       p1.takeMove(new int[] {5,0,4,1});
//       p1.takeMove(new int[] {7,0,6,1});
//
//       p2.takeMove(new int[] {0,5,1,4});
//       p2.takeMove(new int[] {2,5,3,4});
//       p2.takeMove(new int[] {4,5,5,4});
//       p2.takeMove(new int[] {6,5,7,4});
//       p2.takeMove(new int[] {1,6,0,5});
//       p2.takeMove(new int[] {3,6,2,5});
//       p2.takeMove(new int[] {5,6,4,5});
//       p2.takeMove(new int[] {7,6,6,5});
//       p2.takeMove(new int[] {0,7,1,6});
//       p2.takeMove(new int[] {2,7,3,6});
//       p2.takeMove(new int[] {4,7,5,6});
//       p2.takeMove(new int[] {6,7,7,6});
//
//        Assert.assertTrue(c.hasTie());
//    }
//
//    @Test
//    public void testKingMe() {
//        CheckersBoard c = new CheckersBoard();
//        CheckersPiece xPiece = new CheckersPiece("x");
//        CheckersPiece oPiece = new CheckersPiece("o");
//
//        Assert.assertTrue(c.kingMe(new int[] {1,0,7,7}, xPiece));
//        Assert.assertTrue(c.kingMe(new int[] {6,7,4,0}, oPiece));
//    }
//
//    @Test
//    public void testIsJumpMove() {
//        CheckersBoard c1 = new CheckersBoard();
//        int[] j = new int[4];
//        j[0] = 2;
//        j[1] = 3;
//        j[2] = 4;
//        j[3] = 5;
//
//        Assert.assertTrue(c1.isJumpMove(j));
//        Assert.assertTrue(c1.isJumpMove(new int[] {3,6,5,4}));
//    }
//
//    @Test
//    public void testGetJumpedPosition() {
//        CheckersBoard c1 = new CheckersBoard();
//        int[] j = new int[4];
//        j[0] = 2;
//        j[1] = 3;
//        j[2] = 4;
//        j[3] = 5;
//
//        int[] jumped = new int[2];
//        jumped[0] = 3;
//        jumped[1] = 4;
//
//        Assert.assertArrayEquals(jumped, c1.getJumpedPosition(j));
//    }
//
//    @Test
//    public void testFindLegalMoves() {
//        CheckersBoard c1 = new CheckersBoard();
//        AbstractPiece p1 = new AbstractPiece("x");
//        ArrayList<int[]> a1 = c1.findLegalMoves(p1);
//        ArrayList<int[]> a2 = c1.findAllSimpleMoves(p1);
//
//        for (int i = 0; i < a2.size(); i++) {
//            Assert.assertArrayEquals(a2.get(i), a1.get(i));
//        }
//
//        c1.takeMove(new AbstractPiece("x"), new int[] {1,2,2,3});
//        c1.takeMove(new AbstractPiece("o"), new int[] {4,5,3,4});
//        c1.takeMove(new AbstractPiece("o"), new int[] {0,5,1,4});
//        c1.takeMove(new AbstractPiece("x"), new int[] {7,2,6,3});
//        c1.takeMove(new AbstractPiece("o"), new int[] {6,5,5,4});
//
//        ArrayList<int[]> a3 = c1.findLegalMoves(p1);
//        ArrayList<int[]> a4 = c1.findAllJumps(p1);
//
//
//        for (int i = 0; i < a4.size(); i++) {
//            Assert.assertArrayEquals(a4.get(i), a3.get(i));
//        }
//
//    }
//
//    @Test
//    public void testFindAllSimpleMoves() {
//        CheckersBoard c1 = new CheckersBoard();
//        AbstractPiece p1 = new AbstractPiece("x");
//
//        ArrayList<int[]> a1 = new ArrayList<>();
//        a1.add(new int[] {1,2,2,3});
//        a1.add(new int[] {1,2,0,3});
//        a1.add(new int[] {3,2,4,3});
//        a1.add(new int[] {3,2,2,3});
//        a1.add(new int[] {5,2,6,3});
//        a1.add(new int[] {5,2,4,3});
//        a1.add(new int[] {7,2,6,3});
//
//        ArrayList<int[]> a2 = c1.findAllSimpleMoves(p1);
//
//        Assert.assertFalse(a2.isEmpty());
//
//        for (int i = 0; i < a2.size(); i++) {
//            Assert.assertArrayEquals(a1.get(i), a2.get(i));
//        }
//    }
//
//    @Test
//    public void testFindLocalSimpleMoves() {
//        CheckersBoard c1 = new CheckersBoard();
//        AbstractPiece p1 = new AbstractPiece("x");
//
//        Assert.assertFalse(c1.findLocalSimpleMoves(new int[] {1,2}, p1).isEmpty());
//
//        Assert.assertArrayEquals(new int[] {1,2,2,3},
//                c1.findLocalSimpleMoves(new int[] {1,2}, p1).get(0));
//        Assert.assertArrayEquals(new int[] {1,2,0,3},
//                c1.findLocalSimpleMoves(new int[] {1,2}, p1).get(1));
//        Assert.assertTrue(c1.findLocalSimpleMoves(new int[] {7,0}, p1).isEmpty());
//
//        c1.takeMove(new AbstractPiece("o"), new int[] {4,5,3,4});
//        c1.takeMove(new AbstractPiece("o"), new int[] {3,4,2,3});
//
//        Assert.assertArrayEquals(new int[] {1,2,0,3},
//                c1.findLocalSimpleMoves(new int[] {1,2}, p1).get(0));
//    }
//
//    @Test
//    public void testFindAllJumps() {
//        CheckersBoard b1 = new CheckersBoard();
//        AbstractPiece p1 = new AbstractPiece("x");
//
//        Assert.assertTrue(b1.findAllJumps(p1).isEmpty());
//
//        b1.takeMove(new AbstractPiece("x"), new int[] {1,2,2,3});
//        b1.takeMove(new AbstractPiece("o"), new int[] {4,5,3,4});
//        b1.takeMove(new AbstractPiece("o"), new int[] {0,5,1,4});
//        b1.takeMove(new AbstractPiece("x"), new int[] {7,2,6,3});
//        b1.takeMove(new AbstractPiece("o"), new int[] {6,5,5,4});
//
//        ArrayList<int[]> a = new ArrayList<>();
//        a.add(new int[] {2,3,4,5});
//        a.add(new int[] {2,3,0,5});
//        a.add(new int[] {6,3,4,5});
//        Assert.assertArrayEquals(a.get(0), b1.findAllJumps(p1).get(0));
//        Assert.assertArrayEquals(a.get(1), b1.findAllJumps(p1).get(1));
//        Assert.assertArrayEquals(a.get(2), b1.findAllJumps(p1).get(2));
//    }
//
//    @Test
//    public void testFindLocalJumps() {
//        CheckersBoard c1 = new CheckersBoard();
//        AbstractPiece p1 = new AbstractPiece("x");
//
//        c1.takeMove(new AbstractPiece("x"), new int[] {1,2,2,3});
//        c1.takeMove(new AbstractPiece("o"), new int[] {4,5,3,4});
//        int[] me = new int[] {2,3};
//
//        ArrayList<int[]> a = new ArrayList<>();
//        a.add(new int[] {2,3,4,5});
//
//        Assert.assertArrayEquals(a.get(0), c1.findLocalJumps(me, p1).get(0));
//
//        c1.takeMove(new AbstractPiece("o"), new int[] {0,5,1,4});
//        a.add(new int[] {2,3,0,5});
//        Assert.assertArrayEquals(a.get(0), c1.findLocalJumps(me, p1).get(0));
//        Assert.assertArrayEquals(a.get(1), c1.findLocalJumps(me, p1).get(1));
//    }
//
//    @Test
//    public void testFindLocalJumps_multipleJumps() {
//        CheckersBoard c1 = new CheckersBoard();
//        AbstractPiece p1 = new AbstractPiece("x");
//        CheckersPlayer p = new CheckersPlayer(1, "Nick", c1);
//        AbstractPiece oPiece = new AbstractPiece("o");
//
//        c1.takeMove(p1, new int[] {1,2,2,3});
//        c1.takeMove(oPiece, new int[] {4,5,3,4});
//        c1.takeMove(p1, new int[] {2,3,4,5});
//        c1.takeMove(oPiece, new int[] {3,6,5,4});
//        c1.takeMove(oPiece, new int[] {5,6,4,5});
//        c1.takeMove(oPiece, new int[] {5,4,4,3});
//
//        ArrayList<int[]> a = new ArrayList<>();
//        a.add(new int[] {3,2,5,4,3,6});
//
//        Assert.assertEquals(1, c1.findLocalJumps(new int[] {3,2},
//                p1).size());
//        Assert.assertArrayEquals(a.get(0), c1.findLocalJumps(new int[] {3,2},
//                p1).get(0));
//        Assert.assertTrue(c1.validMove(a.get(0),p));
//
//    }
//
//    @Test
//    public void testAppendMoveArray() {
//        CheckersBoard b1 = new CheckersBoard();
//
//        int[] a1 = new int[] {1,2,3,4};
//        int[] a2 = new int[] {5,6};
//
//        Assert.assertArrayEquals(new int[] {1,2,3,4,5,6}, b1.appendMoveArray(a1, a2));
//    }
}
