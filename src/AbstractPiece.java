import java.util.ArrayList;

public abstract class AbstractPiece {
    public AbstractPiece(String symbol, AbstractBoard board,
                         int[] location, AbstractPlayer player) {
        this.symbol = symbol;
        this.board = board;
        this.location = location;
        this.player = player;
    }

    protected String symbol;
    protected int[] location;
    protected AbstractBoard board;
    protected AbstractPlayer player;

    public AbstractPiece() {
    }

    public String getSymbol() {
        return symbol;
    }

    public AbstractPlayer getPlayer() {
        return player;
    }

    public boolean equals(String s) {
        return this.symbol.equals(s);
    }

    public boolean equals(AbstractPiece p) {
        return this.symbol.equals(p.getSymbol());
    }

    public boolean isEmpty() {
        return false;
    }

    protected int[] getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    public ArrayList<int[]> generateMoves() {
        return null;
    }
}
