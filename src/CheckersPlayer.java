import java.util.ArrayList;

public class CheckersPlayer extends AbstractPlayer {
    public CheckersPlayer(int playerNum, String name,
                        AbstractBoard board) {
        super(playerNum, name, board);
        this.moveStrat = new CheckersMoveStrategy(this);
        if (playerNum == 1) {
            this.piece = new CheckersPiece("x", getBoard(), new int[0], this);
        } else {
            this.piece = new CheckersPiece("o", getBoard(), new int[0], this);
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
