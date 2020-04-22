public abstract class AbstractGame {

    public AbstractGame() {
    }

    protected AbstractBoard board;
    protected AbstractPlayer p1;
    protected AbstractPlayer p2;
    protected AbstractPlayer turn;

    public void play() {
        String endMessage;
        this.turn = p1;

        while (true) {
            int[] move;

            System.out.println(turn.getName() + "'s turn!");

            move = scanForMove();
            turn.takeMove(move);
            System.out.println(this.board.toString());

            if (turn.hasWon(move)) {
                endMessage = turn.getWinMessage();
                break;
            }

            if (board.hasTie()) {
                endMessage = "It's a tie!";
                break;
            }

            if (turn.equals(p1)) {
                turn = p2;
            } else if (turn.equals(p2)) {
                turn = p1;
            }
        }

        System.out.println(endMessage);
    }

    public abstract int[] scanForMove();

    public AbstractBoard getBoard() {
        return board;
    }

    public void setBoard(AbstractBoard board) {
        this.board = board;
    }

    public AbstractPlayer getP1() {
        return p1;
    }

    public void setP1(AbstractPlayer p1) {
        this.p1 = p1;
    }

    public AbstractPlayer getP2() {
        return p2;
    }

    public void setP2(AbstractPlayer p2) {
        this.p2 = p2;
    }
}
