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
        return false;
    }
}
