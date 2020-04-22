public class NullPlayer extends AbstractPlayer {
    public NullPlayer(AbstractBoard board) {
        super(0, "null", board);
    }

    @Override
    public boolean hasWin(int[] loc) {
        return false;
    }
}
