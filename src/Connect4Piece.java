import java.util.ArrayList;

public class Connect4Piece extends AbstractPiece {
    public Connect4Piece(String symbol, AbstractBoard board,
                         int[] location, AbstractPlayer player) {
        super(symbol, board, location, player);
    }

    @Override
    public ArrayList<int[]> generateMoves() {
        return null;
    }
}
