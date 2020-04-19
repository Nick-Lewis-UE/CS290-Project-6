import java.util.ArrayList;

public abstract class AbstractPlayer {

    public AbstractPlayer(int playerNum, String name,
                          AbstractBoard board) {
        this.playerNum = playerNum;
        this.name = name;
        this.winMessage = "Congratulations, " + name + "! You won!";
        this.board = board;
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

    public AbstractBoard getBoard() {
        return board;
    }

    public void takeMove(int[] move) {
        moveStrat.takeMove(move);
    }

    public abstract boolean hasWin(int[] loc);
}
