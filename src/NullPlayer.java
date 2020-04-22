public class NullPlayer extends AbstractPlayer {
    public NullPlayer(AbstractBoard board) {
        super(0, "null", board);
    }

    @Override
    public boolean hasWon(int[] loc) {
        return false;
    }
}
