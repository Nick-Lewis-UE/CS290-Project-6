public class Connect4Player extends PlacingPlayer{
    public Connect4Player(int playerNum, String name,
                        AbstractBoard board) {
        super(playerNum, name, board);
        this.needToWin = 4;
        this.moveStrat = new Connect4MoveStrategy(this);
        if (playerNum == 1) {
            this.piece = new Connect4Piece("x", getBoard(), new int[0], this);
        } else {
            this.piece = new CheckersPiece("o", getBoard(), new int[0], this);
        }
    }
}
