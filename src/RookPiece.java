import java.util.ArrayList;

public class RookPiece extends AbstractPiece {
    public RookPiece(String r, ChessBoard chessBoard, int[] ints, AbstractPlayer p1) {
        super(r, chessBoard, ints, p1);
    }

    protected int[] rowAdds = new int[] {1,0,-1,0};
    protected int[] colAdds = new int[] {0,-1,0,1};

    public ArrayList<int[]> generateMoves() {
        ArrayList<int[]> moves = new ArrayList<>();

        try {
            for (int i=0; i < rowAdds.length; i++) {
                int nextCol = location[0];
                int nextRow = location[1];
                boolean stop = false;

                while (!stop) {
                    nextCol = nextCol+colAdds[i];
                    nextRow = nextRow+rowAdds[i];
                    int nextPiecePlayerNum = board.getGrid().get(nextRow).
                            get(nextCol).getPlayer().
                            getPlayerNum();

                    if (nextCol == board.getNum_col() || nextRow == board.getNum_row())
                        break;

                    if (nextPiecePlayerNum != player.getPlayerNum()) {
                        moves.add(new int[] {location[0], location[1], nextCol, nextRow});

                        if (nextPiecePlayerNum != 0) {
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
