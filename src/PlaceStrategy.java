public class PlaceStrategy implements moveStrategy {

    public PlaceStrategy(AbstractPlayer p) {
        this.p = p;
    }

    protected AbstractPlayer p;
    protected AbstractBoard b;

    @Override
    public void takeMove(int[] move) {
        Piece placing;
        if (p.getPlayerNum() == 1) {
            placing = new Piece("x");
        } else {
            placing = new Piece("o");
        }

        p.getBoard().getGrid().get(move[1]-1).set(move[0]-1, placing);
    }
}
