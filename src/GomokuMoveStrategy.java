public class GomokuMoveStrategy implements moveStrategy {

    public GomokuMoveStrategy(AbstractPlayer p) {
        this.p = p;
    }

    protected AbstractPlayer p;
    protected AbstractBoard b;

    @Override
    public void takeMove(int[] move) {
        AbstractPiece placing;
        if (p.getPlayerNum() == 1) {
            placing = new AbstractPiece("x");
        } else {
            placing = new AbstractPiece("o");
        }

        p.getBoard().getGrid().get(move[1]-1).set(move[0]-1, placing);
    }
}
