import java.util.ArrayList;

public class ChessPlayer extends AbstractPlayer {
    public ChessPlayer(int playerNum, String name) {
        super(playerNum, name);
        this.moveStrat = new ChessMoveStrategy(this);
    }

    public ChessPlayer(int playerNum, String name,
                          AbstractBoard board) {
        super(playerNum, name, board);
        this.moveStrat = new ChessMoveStrategy(this);
    }

    @Override
    public boolean hasWon(int[] loc) {
        boolean isChecked = ((ChessBoard) board).check();

        if (!isChecked)
            return false;

        for (int[] each : findMyKing().generateMoves()) {
            if (board.validMove(each))
                return false;
        }

        return true;
    }

    private AbstractPiece findMyKing() {
        AbstractPiece myKing = null;

        for (int r = 0; r <(board.getGrid()).size(); r++) {
            for (int c = 0; c < (board.getGrid()).get(r).size(); c++) {
                if (board.getGrid().get(r).get(c).getPlayer().getPlayerNum() == playerNum &&
                        board.getGrid().get(r).get(c).getSymbol().toLowerCase().equals("k")) {
                    myKing = board.getGrid().get(r).get(c);
                }
            }
        }
        return myKing;
    }
}
