public class Piece {
    public Piece(String symbol) {
        this.symbol = symbol;
    }

    protected String symbol;

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
}
