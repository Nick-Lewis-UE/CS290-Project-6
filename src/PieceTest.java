import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class PieceTest {
    private void testPiece(AbstractPiece p, String symbol,
                           AbstractBoard board, int[] location,
                           AbstractPlayer player) {
        Assert.assertEquals(symbol, p.getSymbol());
        Assert.assertEquals(board.getClass(), p.getBoard().getClass());
        Assert.assertArrayEquals(location, p.getLocation());
        Assert.assertEquals(player.getClass(), p.getPlayer().getClass());
    }

    @Test
    public void testGomokuConstructors() {
        GomokuGame gg = new GomokuGame();
        GomokuBoard gb = new GomokuBoard();
        int[] location = new int[] {5,6};
        AbstractPlayer gp = gg.getP1();
        String s1 = "x";
        AbstractPiece p1 = new GomokuPiece(s1, gb, location, gp);
        testPiece(p1, s1, gb, location, gp);
    }

    @Test
    public void testConnect4Constructor() {
        Connect4Game cg = new Connect4Game();
        Connect4Board cb = new Connect4Board(cg);
        int[] location = new int[] {2,3};
        AbstractPlayer cp = cg.getP1();
        String s1 = "x";
        AbstractPiece p1 = new Connect4Piece(s1, cb, location, cp);
        testPiece(p1, s1, cb, location, cp);
    }

    @Test
    public void testCheckersConstructor() {
        CheckersGame cg = new CheckersGame();
        CheckersBoard cb = new CheckersBoard(cg);
        int[] location = new int[] {2,3};
        AbstractPlayer cp = cg.getP1();
        String s1 = "x";
        AbstractPiece p1 = new CheckersPiece(s1, cb, location, cp);
        testPiece(p1, s1, cb, location, cp);
    }

    @Test
    public void testSimpleMoves() {
        CheckersGame cg = new CheckersGame();
        CheckersPiece p1 = (CheckersPiece) cg.getBoard().getGrid().get(2).get(1);
        CheckersPiece p2 = (CheckersPiece) cg.getBoard().getGrid().get(0).get(7);

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

    @Test
    public void testFindJumps() {
        CheckersGame cg = new CheckersGame();

        cg.getP1().takeMove(new int[] {1,2,2,3});
        cg.getP2().takeMove(new int[] {4,5,3,4});
        int[] me = new int[] {2,3};
        CheckersPiece cp = (CheckersPiece) cg.getBoard().getGrid().get(3).get(2);

        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[] {2,3,4,5});

        Assert.assertArrayEquals(a.get(0), cp.findJumps(me).get(0));

        cg.getP2().takeMove(new int[] {0,5,1,4});
        a.add(new int[] {2,3,0,5});
        Assert.assertArrayEquals(a.get(0), cp.findJumps(me).get(0));
        Assert.assertArrayEquals(a.get(1), cp.findJumps(me).get(1));
    }

    @Test
    public void testFindLocalJumps_multipleJumps() {
        CheckersGame cg = new CheckersGame();
        CheckersPiece p1 = (CheckersPiece) cg.getBoard().getGrid().get(2).get(3);

        cg.getP1().takeMove(new int[] {1,2,2,3});
        cg.getP2().takeMove(new int[] {4,5,3,4});
        cg.getP1().takeMove(new int[] {2,3,4,5});
        cg.getP2().takeMove(new int[] {3,6,5,4});
        cg.getP2().takeMove(new int[] {5,6,4,5});
        cg.getP2().takeMove(new int[] {5,4,4,3});

        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[] {3,2,5,4,3,6});

        Assert.assertEquals(1, p1.findJumps(new int[] {3,2}).size());
        Assert.assertArrayEquals(a.get(0), p1.findJumps(new int[] {3,2}).get(0));
        Assert.assertTrue(cg.getBoard().validMove(a.get(0)));

    }

    @Test
    public void testKnightPieceGenerateMoves() {
        ChessGame cg = new ChessGame();
        ChessBoard cb = new ChessBoard(cg);

        ArrayList<int[]> moves = cb.getGrid().get(0).get(1).generateMoves();
        ArrayList<int[]> expected = new ArrayList<>();
        expected.add(new int[] {1,0,2,2});
        expected.add(new int[] {1,0,0,2});

        for (int i = 0; i < moves.size(); i++) {
            Assert.assertArrayEquals(expected.get(i), moves.get(i));
        }

        moves = cb.getGrid().get(7).get(1).generateMoves();
        expected = new ArrayList<>();
        expected.add(new int[] {1,7,0,5});
        expected.add(new int[] {1,7,2,5});

        for (int i = 0; i < moves.size(); i++) {
            Assert.assertArrayEquals(expected.get(i), moves.get(i));
        }
    }

    @Test
    public void testKingPieceGenerateMoves() {
        ChessGame cg = new ChessGame();

        ArrayList<int[]> moves = cg.getBoard().getGrid().get(0).get(4).generateMoves();

        Assert.assertTrue(moves.isEmpty());
        Assert.assertTrue(cg.getBoard().getGrid().get(7).get(4).generateMoves().isEmpty());
        cg.getP1().takeMove(new int[]{4, 0, 4, 3});

        Assert.assertEquals(8, cg.getBoard().getGrid().get(3).get(4).generateMoves().size());
        cg.getP2().takeMove(new int[]{4, 6, 1, 1});
        Assert.assertEquals(1, cg.getBoard().getGrid().get(7).get(4).generateMoves().size());

        cg.getP1().takeMove(new int[]{4, 3, 4, 5});
        cg.getP2().takeMove(new int[]{0, 6, 4, 6});
        Assert.assertEquals(8, cg.getBoard().getGrid().get(5).get(4).generateMoves().size());
    }

    @Test
    public void testKingCastlingGeneration() {
        ChessGame cg = new ChessGame();
        ArrayList<int[]> moves;
        cg.getP2().takeMove(new int[] {1,7,0,4});
        cg.getP2().takeMove(new int[] {2,7,0,4});
        cg.getP2().takeMove(new int[] {3,7,0,4});
        cg.getP2().takeMove(new int[] {5,7,0,4});
        cg.getP2().takeMove(new int[] {6,7,0,4});
        moves = cg.getBoard().getGrid().get(7).get(4).generateMoves();
        Assert.assertArrayEquals(moves.get(2), new int[]{4, 7, 2, 7});
        Assert.assertArrayEquals(moves.get(3), new int[]{4, 7, 6, 7});

        cg.getP1().takeMove(new int[] {7,7,6,7});
        moves = cg.getBoard().getGrid().get(7).get(4).generateMoves();
        Assert.assertEquals(3, moves.size());

        cg = new ChessGame();
        cg.getP2().takeMove(new int[] {1,0,0,4});
        cg.getP2().takeMove(new int[] {2,0,0,4});
        cg.getP2().takeMove(new int[] {3,0,0,4});
        cg.getP2().takeMove(new int[] {5,0,0,4});
        cg.getP2().takeMove(new int[] {6,0,0,4});
        moves = cg.getBoard().getGrid().get(0).get(4).generateMoves();
        Assert.assertArrayEquals(moves.get(2), new int[]{4, 0, 2, 0});
        Assert.assertArrayEquals(moves.get(3), new int[]{4, 0, 6, 0});

        cg.getP1().takeMove(new int[] {4,0,3,0});
        moves = cg.getBoard().getGrid().get(0).get(3).generateMoves();
        Assert.assertEquals(2, moves.size());

    }

    @Test
    public void testPawnPieceGenerateMoves(){
        ChessGame cg = new ChessGame();
        ChessBoard cb = new ChessBoard(cg);

        ArrayList<int[]> moves = cb.getGrid().get(1).get(3).generateMoves();

        ArrayList <int[]> a = new ArrayList<>();
        a.add(new int[] {3,1,3,2});
        a.add(new int[] {3,1,3,3});

        for (int i=0; i < moves.size(); i++) {
            Assert.assertArrayEquals(a.get(i), moves.get(i));
        }

        ArrayList<int[]> moves2 = cb.getGrid().get(6).get(2).generateMoves();
        ArrayList <int[]> a2 = new ArrayList<>();
        a2.add(new int[] {2,6,2,5});
        a2.add(new int[] {2,6,2,4});

        for (int i=0; i < moves.size(); i++) {
            Assert.assertArrayEquals(a2.get(i), moves2.get(i));
        }

        cg.getP2().getMoveStrat().takeMove(new int[] {1,6,1,2});
        ArrayList<int[]> moves3 = cb.getGrid().get(1).get(0).generateMoves();
        ArrayList<int[]> a3 = new ArrayList<>();
        a3.add(new int[] {0,1,0,2});
        a3.add(new int[] {0,1,0,3});
        a3.add(new int[] {0,1,1,2});

        for (int i=0; i < moves.size(); i++) {
            Assert.assertArrayEquals(a3.get(i), moves3.get(i));
        }

        cg.getP2().getMoveStrat().takeMove(new int[] {1,2,1,3});
        cg.getP1().getMoveStrat().takeMove(new int[] {0,1,0,2});
        ArrayList<int[]> moves4 = cg.getBoard().getGrid().get(2).get(0).generateMoves();
        ArrayList<int[]> a4 = new ArrayList<>();
        a4.add(new int[] {0,2,0,3});
        a4.add(new int[] {0,2,1,3});

        for (int i=0; i < moves.size(); i++) {
            Assert.assertArrayEquals(a4.get(i), moves4.get(i));
        }
    }

    @Test
    public void testRookPieceGenerateMoves() {
        ChessGame cg = new ChessGame();
        ChessBoard cb = (ChessBoard) cg.getBoard();

        ArrayList<int[]> moves = cb.getGrid().get(0).get(0).generateMoves();
        Assert.assertTrue(moves.isEmpty());

        cg.setTurn(cg.getP2());
        cg.getP2().takeMove(new int[] {7,6,0,6});
        ArrayList<int[]> actual = cg.getBoard().getGrid().get(7).get(7).generateMoves();
        ArrayList<int[]> expected = new ArrayList<>();
        for (int[] each : expected)
            System.out.println(Arrays.toString(each));
        Assert.assertEquals(6, actual.size());
    }

    @Test
    public void testQueenPieceGenerateMoves() {
        ChessGame cg = new ChessGame();

        ArrayList<int[]> moves = cg.getBoard().getGrid().
                get(0).get(3).generateMoves();

        Assert.assertTrue(moves.isEmpty());
        cg.getP1().takeMove(new int[] {3,1,0,4});
        ArrayList<int[]> a1 = cg.getBoard().getGrid().get(0).get(3).generateMoves();

        Assert.assertTrue(Arrays.equals(a1.get(0), new int[] {3,0,3,1}));
        Assert.assertTrue(Arrays.equals(a1.get(5), new int[] {3,0,3,6}));

        cg.getP2().takeMove(new int[] {3,6,0,4});
        ArrayList<int[]> a2 = cg.getBoard().getGrid().get(7).get(3).generateMoves();

        Assert.assertTrue(Arrays.equals(a2.get(0), new int[] {3,7,3,6}));
        Assert.assertArrayEquals(a2.get(5), new int[]{3, 7, 3, 1});
    }

    @Test
    public void testBishopPieceGenerateMoves() {
        ChessGame cg = new ChessGame();

        ArrayList<int[]> moves = cg.getBoard().getGrid().
                get(0).get(2).generateMoves();

        Assert.assertTrue(moves.isEmpty());
    }
}
