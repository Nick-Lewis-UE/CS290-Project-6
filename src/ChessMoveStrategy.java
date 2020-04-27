public class ChessMoveStrategy implements moveStrategy {
    public ChessMoveStrategy(AbstractPlayer p) {this.p = p; }

    protected AbstractPlayer p;

    @Override
    public void takeMove(int[] move) {
        AbstractPiece moved = p.getBoard().getGrid().get(move[1]).get(move[0]);

        p.getBoard().getGrid().get(move[3]).set(move[2], moved);
        p.getBoard().getGrid().get(move[1]).set(move[0],
                new NullPiece(p.getBoard(), new int[] {move[0], move[1]}));
        moved.setLocation(new int[] {move[2], move[3]});
    }
}
