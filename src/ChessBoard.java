import java.util.ArrayList;

public class ChessBoard extends MovingBoard {
    public ChessBoard(ChessGame chessGame) {
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    protected ArrayList<ArrayList<AbstractPiece>> makeStartBoard(AbstractGame game) {
        return null;
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
