import java.util.ArrayList;

public class ChessLineMovePiece extends AbstractPiece {
    public ChessLineMovePiece(String symbol, AbstractBoard board,
                              int[] location, AbstractPlayer p) {
        super(symbol, board, location, p);
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
