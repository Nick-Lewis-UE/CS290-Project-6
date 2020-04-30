import java.util.ArrayList;

public class GomokuPiece extends AbstractPiece {

    public GomokuPiece(String symbol, AbstractBoard board,
                       int[] location, AbstractPlayer player) {
        super(symbol, board, location, player);
    }

    @Override
    public ArrayList<int[]> generateMoves() {
        return null;
    }
}
