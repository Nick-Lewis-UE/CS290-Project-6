import java.util.ArrayList;

public class QueenPiece extends ChessLineMovePiece {
    public QueenPiece(AbstractBoard chessBoard, int[] ints, AbstractPlayer p1) {
        super("q", chessBoard, ints, p1);
        if (p1.playerNum == 1)
            symbol = "Q";
    }

    protected int[] rowAdds = new int[] {1,1,1,0,-1,-1,-1,0};
    protected int[] colAdds = new int[] {1,0,-1,-1,-1,0,1,1};

    public ArrayList<int[]> generateMoves() {
        return generateChessMultiMove(rowAdds, colAdds);
    }
}

