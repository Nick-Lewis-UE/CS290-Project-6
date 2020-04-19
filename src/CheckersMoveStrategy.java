import static java.lang.Math.abs;

public class CheckersMoveStrategy implements moveStrategy {
    public CheckersMoveStrategy(AbstractPlayer p) {
        this.p = p;
    }

    protected AbstractPlayer p;

    @Override
    public void takeMove(int[] move) {
        AbstractPiece moved = p.getBoard().getGrid().get(move[1]).get(move[0]);

        for (int i = 3; i < move.length; i = i + 2) {
            p.getBoard().getGrid().get(move[i]).set(move[i - 1], moved);
            p.getBoard().getGrid().get(move[i - 2]).set(move[i - 3],
                    new NullPiece(p.getBoard(), new int[] {move[i - 3], move[i - 2]}));

            if (isJumpMove(move)) {
                p.getBoard().getGrid().get((move[i]+ move[i-2])/2).set((move[i-1]+move[i-3])/2,
                        new NullPiece(p.getBoard(),
                                new int[] {(move[i-1]+move[i-3])/2, (move[i]+ move[i-2])/2}));
            }
        }

        if (kingMe(move, moved)) {
            p.getBoard().getGrid().get(move[move.length - 1]).set(move[move.length - 2],
                    new CheckersKingPiece(moved.getSymbol().toUpperCase(), p.getBoard(),
                            new int[] {move[move.length - 2], move[move.length - 1]}, p));
        }
    }

    public boolean isJumpMove(int[] loc) {
        return abs(loc[3]-loc[1]) == 2 && abs(loc[2]-loc[0]) == 2;
    }

    public boolean kingMe(int[] move, AbstractPiece p) {
        int kingRow;

        if (p.equals("x")) {
            kingRow = 7;
        } else if (p.equals("o")){
            kingRow = 0;
        } else return false;

        return move[move.length - 1] == kingRow;
    }
}
