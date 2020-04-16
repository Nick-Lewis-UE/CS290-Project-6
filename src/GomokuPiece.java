import java.util.ArrayList;

public class GomokuPiece extends Piece {

    public GomokuPiece(String symbol, AbstractBoard board, int[] location) {
        this.symbol = symbol;
        this.board = board;
        this.location = location;
    }

    public ArrayList<int[]> generateMoves() {
        ArrayList<int[]> moves = new ArrayList<>();
        for (ArrayList<Piece> eachRow : board.getGrid()) {
            for (Piece eachPiece : eachRow) {
                if (eachPiece.isEmpty()) {
                    moves.add(eachPiece.getLocation());
                }
            }
        }

        return moves;
    }
}
