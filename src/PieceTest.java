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
        Assert.assertTrue(cg.getBoard().validMove(a.get(0),cg.getP1()));

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
    }

    @Test
    public void testKingPieceGenerateMoves() {
        ChessGame cg = new ChessGame();
        ChessBoard cb = new ChessBoard(cg);

        ArrayList<int[]> moves = cb.getGrid().get(0).get(4).generateMoves();

        Assert.assertTrue(moves.isEmpty());
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
//            System.out.println(Arrays.toString(moves.get(i)));
            Assert.assertArrayEquals(a.get(i), moves.get(i));
        }

        ArrayList<int[]> moves2 = cb.getGrid().get(6).get(2).generateMoves();
        ArrayList <int[]> a2 = new ArrayList<>();
        a2.add(new int[] {2,6,2,5});
        a2.add(new int[] {2,6,2,4});

        for (int i=0; i < moves.size(); i++) {
//            System.out.println(Arrays.toString(moves2.get(i)));
            Assert.assertArrayEquals(a2.get(i), moves2.get(i));
        }
    }

    @Test
    public void testRookPieceGenerateMoves() {
        ChessGame cg = new ChessGame();
        ChessBoard cb = (ChessBoard) cg.getBoard();

        ArrayList<int[]> moves = cb.getGrid().get(0).get(0).generateMoves();
        Assert.assertTrue(moves.isEmpty());
    }
}
