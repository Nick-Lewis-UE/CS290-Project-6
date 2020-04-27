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

    public AbstractBoard getBoard() {
        return board;
    }

    public ArrayList<int[]> generateMoves() {
        return null;
    }

    public ArrayList<int[]> generateChessMultiMove(int[] rowAdds, int[] colAdds) {
        ArrayList<int[]> moves = new ArrayList<>();

        try {
            for (int i = 0; i < rowAdds.length; i++) {
                int nextCol = location[0];
                int nextRow = location[1];
                boolean stop = false;

                while (!stop) {
                    nextCol = nextCol + colAdds[i];
                    nextRow = nextRow + rowAdds[i];

                    if (nextCol < board.getNum_col() && nextRow < board.getNum_row() &&
                    nextCol >= 0 && nextRow >= 0) {

                        int nextPiecePlayerNum = board.getGrid().get(nextRow).
                                get(nextCol).getPlayer().
                                getPlayerNum();


                        if (nextPiecePlayerNum != player.getPlayerNum()) {
                            moves.add(new int[]{location[0], location[1], nextCol, nextRow});

                            if (nextPiecePlayerNum != 0) {
                                stop = true;
                            }
                        } else {
                            stop = true;
                        }
                    } else {
                        stop = true;
                    }
                }
            }
        } catch (IndexOutOfBoundsException ignored) {}

        return moves;
    }
}
