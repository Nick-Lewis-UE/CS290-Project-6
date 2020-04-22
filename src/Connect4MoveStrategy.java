public class Connect4MoveStrategy implements moveStrategy {
    public Connect4MoveStrategy(AbstractPlayer p) {
        this.p = p;
    }

    protected AbstractPlayer p;

    @Override
    public void takeMove(int[] move) {
        int row = 0;
        for (int i = p.getBoard().getNum_row() - 1; i >= 0; i--) {
            if (p.getBoard().getGrid().get(i).get(move[0] - 1).isEmpty()) {
                row = i;
                break;
            }
        }

        AbstractPiece placing;
        if (p.getPlayerNum() == 1) {
            placing = new Connect4Piece("x", p.getBoard(), new int[]{move[0] - 1, row}, p);
        } else {
            placing = new Connect4Piece("o", p.getBoard(), new int[]{move[0] - 1, row}, p);
        }

        p.getBoard().getGrid().get(row).set(move[0] - 1, placing);
    }
}
