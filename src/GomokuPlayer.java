public class GomokuPlayer extends PlacingPlayer {
    public GomokuPlayer(int playerNum, String name, moveStrategy moveStrat,
                         AbstractBoard board) {
        super(playerNum, name, moveStrat, board);
        this.needToWin = 5;
    }
}
