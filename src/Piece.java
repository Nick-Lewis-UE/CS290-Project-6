public class Piece {
    public Piece(String symbol) {
        this.symbol = symbol;
    }

    protected String symbol;
    protected int[] location;
    protected AbstractBoard board;

    public Piece() {
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean equals(String s) {
        return this.symbol.equals(s);
    }

    public boolean equals(Piece p) {
        return this.symbol.equals(p.getSymbol());
    }

    public boolean isEmpty() {
        return false;
    }

    protected int[] getLocation() {
        return location;
    }
}
