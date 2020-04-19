import java.util.ArrayList;

public class MovingPlayer extends AbstractPlayer {
    public MovingPlayer(int playerNum, String name,
                         AbstractBoard board) {
        super(playerNum, name, board);
        if (playerNum == 1) {
            this.piece = new AbstractPiece("x");
        } else {
            this.piece = new AbstractPiece("o");
        }
    }

    protected AbstractPiece piece;

    public boolean hasWin(int[] loc) {
        for (ArrayList<AbstractPiece> eachRow : board.getGrid()) {
            for (AbstractPiece eachPiece : eachRow) {
                if (!eachPiece.equals(piece) &&
                        !eachPiece.isEmpty())
                    return false;
            }
        }

        return true;
    }
}
