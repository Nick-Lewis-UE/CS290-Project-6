import java.util.ArrayList;

public class BishopPiece extends AbstractPiece {
    public BishopPiece(String b, ChessBoard chessBoard, int[] ints, AbstractPlayer p1) {
        super(b, chessBoard, ints, p1);
    }

    protected int[] rowAdds = new int[] {1,1,-1,-1};
    protected int[] colAdds = new int[] {1,-1,-1,1};

    public ArrayList<int[]> generateMoves() {
        return generateChessMultiMove(rowAdds, colAdds);
    }
}
