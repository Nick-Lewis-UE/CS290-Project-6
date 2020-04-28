import java.util.ArrayList;

public class RookPiece extends ChessLineMovePiece {
    public RookPiece(ChessBoard chessBoard, int[] ints, AbstractPlayer p1) {
        super("r", chessBoard, ints, p1);
        if (p1.playerNum == 1)
            symbol = "R";
    }

    protected int[] rowAdds = new int[] {1,0,-1,0};
    protected int[] colAdds = new int[] {0,-1,0,1};

    public ArrayList<int[]> generateMoves() {
        return generateChessMultiMove(rowAdds, colAdds);
    }
}
