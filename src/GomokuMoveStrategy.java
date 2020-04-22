public class GomokuMoveStrategy implements moveStrategy {

    public GomokuMoveStrategy(AbstractPlayer p) {
        this.p = p;
    }

    protected AbstractPlayer p;

    @Override
    public void takeMove(int[] move) {
        AbstractPiece placing;
        if (p.getPlayerNum() == 1) {
            placing = new GomokuPiece("x", p.getBoard(), move, p);
        } else {
            placing = new GomokuPiece("o", p.getBoard(), move, p);
        }

        p.getBoard().getGrid().get(move[1]-1).set(move[0]-1, placing);
    }
}
