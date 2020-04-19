public class GomokuPlayer extends PlacingPlayer {
    public GomokuPlayer(int playerNum, String name,
                         AbstractBoard board) {
        super(playerNum, name, board);
        this.needToWin = 5;
    }
}
