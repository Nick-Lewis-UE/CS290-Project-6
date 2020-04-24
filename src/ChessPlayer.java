public class ChessPlayer extends AbstractPlayer {
    public ChessPlayer(int playerNum, String name) {
        super(playerNum, name);
    }

    public ChessPlayer(int playerNum, String name,
                          AbstractBoard board) {
        super(playerNum, name, board);
        this.moveStrat = new CheckersMoveStrategy(this);
    }

    @Override
    public boolean hasWon(int[] loc) {
        return false;
    }
}
