import java.util.ArrayList;

public class BishopPiece extends ChessLineMovePiece {
    public BishopPiece(ChessBoard chessBoard, int[] ints, AbstractPlayer p1) {
        super("b", chessBoard, ints, p1);
        if (p1.playerNum == 1)
            symbol = "B";
    }

    protected int[] rowAdds = new int[] {1,1,-1,-1};
    protected int[] colAdds = new int[] {1,-1,-1,1};

    public ArrayList<int[]> generateMoves() {
        return generateChessMultiMove(rowAdds, colAdds);
    }
}
