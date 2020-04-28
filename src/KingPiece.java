import java.util.ArrayList;
import java.util.Arrays;

public class KingPiece extends AbstractPiece {
    public KingPiece(String k, ChessBoard chessBoard, int[] ints, AbstractPlayer p1) {
        super(k, chessBoard, ints, p1);
    }

    protected int[] rowAdds = new int[] {1,1,1,0,-1,-1,-1,0};
    protected int[] colAdds = new int[] {1,0,-1,-1,-1,0,1,1};

    public ArrayList<int[]> generateMoves() {
        ArrayList<int[]> moves = new ArrayList<>();

        for (int i = 0; i < rowAdds.length; i++) {
            if (inBounds(location[0] + colAdds[i], location[1] + rowAdds[i])) {
                if (board.getGrid().get(location[1] + rowAdds[i]).
                        get(location[0] + colAdds[i]).getPlayer().getPlayerNum() != player.getPlayerNum())
                    moves.add(new int[]{location[0],
                            location[1],
                            location[0] + colAdds[i],
                            location[1] + rowAdds[i]});
            }
        }

        int kingRow;
        if (player.getPlayerNum() == 1)
            kingRow = 0;
        else
            kingRow = 7;

        if (Arrays.equals(location, new int[] {4,kingRow})) {
            if (board.getGrid().get(kingRow).get(0).getSymbol().toLowerCase().equals("r") &&
            board.getGrid().get(kingRow).get(2).isEmpty() &&
            board.getGrid().get(kingRow).get(3).isEmpty()) {
                moves.add(new int[] {4,kingRow,2,kingRow});
            }

            if (board.getGrid().get(kingRow).get(7).getSymbol().toLowerCase().equals("r") &&
                    board.getGrid().get(kingRow).get(5).isEmpty() &&
                board.getGrid().get(kingRow).get(6).isEmpty()) {
                moves.add(new int[] {4,kingRow,6,kingRow});
            }
        }

        return moves;
    }
}
