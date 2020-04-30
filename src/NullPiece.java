import java.util.ArrayList;

public class NullPiece extends AbstractPiece {
    public NullPiece(AbstractBoard board, int[] location) {
        super(" ", board, location, new NullPlayer(board));
    }

    protected NullPiece() {
        super(" ", null, new int[0], new NullPlayer(null));
    }
    public boolean equals(String s) {
        return false;
    }

    public boolean equals(AbstractPiece p) {
        return false;
    }

    public boolean isEmpty() {
        return true;
    }

    @Override
    public ArrayList<int[]> generateMoves() {
        return null;
    }
}
