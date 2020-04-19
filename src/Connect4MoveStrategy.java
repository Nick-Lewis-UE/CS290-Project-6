public class Connect4MoveStrategy implements moveStrategy {
    public Connect4MoveStrategy(AbstractPlayer p) {
        this.p = p;
    }

    protected AbstractPlayer p;

    @Override
    public void takeMove(int[] move) {
        Piece placing;
        if (p.getPlayerNum() == 1) {
            placing = new Piece("x");
        } else {
            placing = new Piece("o");
        }

        for (int i = p.getBoard().getNum_row() - 1; i >= 0; i--) {
            if (p.getBoard().getGrid().get(i).get(move[0] - 1).isEmpty()) {
                p.getBoard().getGrid().get(i).set(move[0] - 1, placing);
                break;
            }
        }
    }
}