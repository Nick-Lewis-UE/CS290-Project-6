public class ChessPlayer extends AbstractPlayer {
    public ChessPlayer(int playerNum, String name) {
        super(playerNum, name);
    }

    @Override
    public boolean hasWon(int[] loc) {
        return false;
    }
}
