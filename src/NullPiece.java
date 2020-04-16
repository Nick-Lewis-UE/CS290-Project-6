public class NullPiece extends Piece {
    public NullPiece() {
        super(" ");
    }

    public boolean equals(String s) {
        return false;
    }

    public boolean equals(Piece p) {
        return false;
    }

    public boolean isEmpty() {
        return true;
    }
}
