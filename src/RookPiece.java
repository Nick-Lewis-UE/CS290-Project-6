import java.util.ArrayList;

public class RookPiece extends AbstractPiece {
    public RookPiece(String r, ChessBoard chessBoard, int[] ints, AbstractPlayer p1) {
        super(r, chessBoard, ints, p1);
    }

    protected int[] rowAdds = new int[] {1,0,-1,0};
    protected int[] colAdds = new int[] {0,-1,0,1};

    public ArrayList<int[]> generateMoves() {
        return generateChessMultiMove(rowAdds, colAdds);
    }
}
