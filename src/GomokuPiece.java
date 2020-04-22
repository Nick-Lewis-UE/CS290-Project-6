public class GomokuPiece extends AbstractPiece {

    public GomokuPiece(String symbol, AbstractBoard board, int[] location, AbstractPlayer Player) {
        this.symbol = symbol;
        this.board = board;
        this.location = location;
        this.player = player;
    }
}
