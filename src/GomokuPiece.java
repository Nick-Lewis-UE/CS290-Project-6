import java.util.ArrayList;

public class GomokuPiece extends AbstractPiece {

    public GomokuPiece(String symbol, AbstractBoard board, int[] location) {
        this.symbol = symbol;
        this.board = board;
        this.location = location;
    }
}
