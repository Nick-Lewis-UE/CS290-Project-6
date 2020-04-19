public class Connect4Player extends PlacingPlayer{
    public Connect4Player(int playerNum, String name,
                        AbstractBoard board) {
        super(playerNum, name, board);
        this.needToWin = 4;
    }
}
