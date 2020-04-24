import java.util.ArrayList;

public class ChessBoard extends MovingBoard {
    public ChessBoard(ChessGame game) {
        super(game);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    protected ArrayList<ArrayList<AbstractPiece>> makeStartBoard(AbstractGame game) {
        ArrayList<ArrayList<AbstractPiece>> a = new ArrayList<>();

        for (int i = 0; i < num_row; i++) {
            a.add(i, new ArrayList<>());
        }

        a.get(0).set(0, new RookPiece("R", this, new int[] {0,0}, game.getP1()));
        a.get(0).set(1, new KnightPiece("N", this, new int[] {1,0}, game.getP1()));
        a.get(0).set(2, new BishopPiece("B", this, new int[] {2,0}, game.getP1()));
        a.get(0).set(3, new QueenPiece("Q", this, new int[] {3,0}, game.getP1()));
        a.get(0).set(4, new KingPiece("K", this, new int[] {4,0}, game.getP1()));
        a.get(0).set(5, new BishopPiece("B", this, new int[] {5,0}, game.getP1()));
        a.get(0).set(6, new KnightPiece("N", this, new int[] {6,0}, game.getP1()));
        a.get(0).set(7, new RookPiece("R", this, new int[] {7,0}, game.getP1()));

        for (int i = 0; i < num_col; i++) {
            a.get(1).set(i, new PawnPiece("P", this, new int[] {i,1}, game.getP1()));
        }

        for(int i = 2; i < 6; i++) {
            for (int j = 0; j < num_col; j++) {
                a.get(i).set(j, new NullPiece());
            }
        }

        for (int i = 0; i < num_col; i++) {
            a.get(1).set(i, new PawnPiece("p", this, new int[] {i,6}, game.getP2()));
        }

        a.get(7).set(0, new RookPiece("r", this, new int[] {0,7}, game.getP2()));
        a.get(7).set(1, new KnightPiece("n", this, new int[] {1,7}, game.getP2()));
        a.get(7).set(2, new BishopPiece("b", this, new int[] {2,7}, game.getP2()));
        a.get(7).set(3, new QueenPiece("q", this, new int[] {3,7}, game.getP2()));
        a.get(7).set(4, new KingPiece("k", this, new int[] {4,7}, game.getP2()));
        a.get(7).set(5, new BishopPiece("b", this, new int[] {5,7}, game.getP2()));
        a.get(7).set(6, new KnightPiece("n", this, new int[] {6,7}, game.getP2()));
        a.get(7).set(7, new RookPiece("r", this, new int[] {7,7}, game.getP2()));

        return a;
    }

    @Override
    public boolean validMove(int[] move, AbstractPlayer p) {
        return false;
    }

    @Override
    public boolean hasTie() {
        return false;
    }
}
