import static java.lang.Math.abs;

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

        if (isCastlingMove(move)) {
            moveCastledRook(move);
        }
    }

    private void moveCastledRook(int[] move) {
        int oldRookCol;
        int newRookCol;

        if (move[2] < 4) {
            oldRookCol = 0;
            newRookCol = 3;
        } else {
            oldRookCol = 7;
            newRookCol = 5;
        }

//        System.out.println(oldRookCol + " to " + newRookCol);
        takeMove(new int[] {oldRookCol,move[1],newRookCol,move[3]});
    }

    public boolean isCastlingMove(int[] move) {
        boolean isKing = p.getBoard().getGrid().get(move[3]).get(move[2]).getSymbol().toLowerCase().equals("k");
        boolean notNormalMove =  abs(move[2] - move[0]) > 1;


        if (isKing && notNormalMove)
            return true;
        else
            return false;
    }
}
