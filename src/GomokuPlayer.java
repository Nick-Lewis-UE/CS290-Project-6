public class GomokuPlayer extends PlacingPlayer {
    public GomokuPlayer(int playerNum, String name,
                         AbstractBoard board) {
        super(playerNum, name, board);
        this.needToWin = 5;
        this.moveStrat = new GomokuMoveStrategy(this);
        if (playerNum == 1) {
            this.piece = new GomokuPiece("x", getBoard(), new int[0], this);
        } else {
            this.piece = new GomokuPiece("o", getBoard(), new int[0], this);
        }
    }
}
