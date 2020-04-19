public class NullPiece extends AbstractPiece {
    public NullPiece(AbstractBoard board, int[] location) {
        super(" ", board, location, null);
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
}
