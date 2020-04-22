public abstract class AbstractPlayer {

    public AbstractPlayer(int playerNum, String name,
                          AbstractBoard board) {
        this.playerNum = playerNum;
        this.name = name;
        this.winMessage = "Congratulations, " + name + "! You won!";
        this.board = board;
    }

    public AbstractPlayer(int playerNum, String name) {
        this.playerNum = playerNum;
        this.name = name;
        this.winMessage = "Congratulations, " + name + "! You won!";
    }

    protected int playerNum;
    protected String name;
    protected String winMessage;
    protected moveStrategy moveStrat;
    protected AbstractBoard board;

    public String getName() {
        return name;
    }

    public String getWinMessage() {
        return winMessage;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public moveStrategy getMoveStrat() {
        return moveStrat;
    }

    public AbstractBoard getBoard() {
        return board;
    }

    public void setBoard(AbstractBoard board) {
        this.board = board;
    }

    public void takeMove(int[] move) {
        moveStrat.takeMove(move);
    }

    public abstract boolean hasWon(int[] loc);
}
