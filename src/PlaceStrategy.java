public class PlaceStrategy implements moveStrategy {

    public PlaceStrategy(AbstractPlayer p, int[] move, AbstractBoard b) {
        this.p = p;
        this.move = move;
        this.b = b;
    }

    protected AbstractPlayer p;
    protected int[] move;
    protected AbstractBoard b;

    @Override
    public void takeMove() {
        Piece placing;
        if (p.getPlayerNum() == 1) {
            placing = new Piece("x");
        } else {
            placing = new Piece("o");
        }

        b.getGrid().get(move[1]-1).set(move[0]-1, placing);
    }
}
