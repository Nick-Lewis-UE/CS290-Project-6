public class ChessPlayer extends AbstractPlayer {
    public ChessPlayer(int playerNum, String name) {
        super(playerNum, name);
        this.moveStrat = new ChessMoveStrategy(this);
    }

    public ChessPlayer(int playerNum, String name,
                          AbstractBoard board) {
        super(playerNum, name, board);
        this.moveStrat = new ChessMoveStrategy(this);
    }

    @Override
    public boolean hasWon(int[] loc) {
        boolean isCheck = ((ChessBoard) board).check();
        int[] myKing = new int[0];

        if (!isCheck)
            return false;

        for (int r = 0; r <(board.getGrid()).size(); r++) {
            for (int c = 0; c < (board.getGrid()).get(r).size(); c++) {
                if (board.getGrid().get(r).get(c).getPlayer().getPlayerNum() == board.getGame().getTurn().getPlayerNum() &&
                        board.getGrid().get(r).get(c).getSymbol().toLowerCase().equals("k")) {
                    myKing = new int[]{c, r};
                }
            }
        }

        for (int[] each : board.getGrid().get(myKing[1]).get(myKing[0]).generateMoves()) {
            if (board.validMove(each))
                return false;
        }

        return true;
    }
}
