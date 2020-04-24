import java.util.ArrayList;

public class KingPiece extends AbstractPiece {
    public KingPiece(String k, ChessBoard chessBoard, int[] ints, AbstractPlayer p1) {
        super(k, chessBoard, ints, p1);
    }

    protected int[] rowAdds = new int[] {1,1,1,0,-1,-1,-1,0};
    protected int[] colAdds = new int[] {1,0,-1,-1,-1,0,1,1};

    public ArrayList<int[]> generateMoves() {
        ArrayList<int[]> moves = new ArrayList<>();

        try {
            for (int i = 0; i < rowAdds.length; i++) {
                if (board.getGrid().get(location[1] + rowAdds[i]).
                        get(location[0] + colAdds[i]).getPlayer().getPlayerNum() != player.getPlayerNum())
                    moves.add(new int[]{location[0],
                            location[1],
                            location[0] + colAdds[i],
                            location[1] + rowAdds[i]});
            }
        } catch(IndexOutOfBoundsException ignored) {}

        return moves;
    }

}
