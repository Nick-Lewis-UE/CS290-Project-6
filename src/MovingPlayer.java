import java.util.ArrayList;

public class MovingPlayer extends AbstractPlayer {
    public MovingPlayer(int playerNum, String name,
                         AbstractBoard board) {
        super(playerNum, name, board);
        if (playerNum == 1) {
            this.piece = new Piece("x");
        } else {
            this.piece = new Piece("o");
        }
    }

    protected Piece piece;

    public boolean hasWin(int[] loc) {
        for (ArrayList<Piece> eachRow : board.getGrid()) {
            for (Piece eachPiece : eachRow) {
                if (!eachPiece.equals(piece) &&
                        !eachPiece.isEmpty())
                    return false;
            }
        }

        return true;
    }
}