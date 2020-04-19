import static java.lang.Math.abs;

public class CheckersStrategy implements moveStrategy {
    public CheckersStrategy(AbstractPlayer p, int[] move, AbstractBoard b) {
        this.p = p;
        this.move = move;
        this.b = b;
    }

    protected AbstractPlayer p;
    protected int[] move;
    protected AbstractBoard b;

    @Override
    public void takeMove() {
        Piece moved = b.getGrid().get(move[1]).get(move[0]);

        for (int i = 3; i < move.length; i = i + 2) {
            b.getGrid().get(move[i]).set(move[i - 1], moved);
            b.getGrid().get(move[i - 2]).set(move[i - 3], new NullPiece());

            if (isJumpMove(move)) {
                b.getGrid().get((move[i]+ move[i-2])/2).set((move[i-1]+move[i-3])/2,
                        new NullPiece());
            }
        }

        if (kingMe(move, moved)) {
            b.getGrid().get(move[move.length - 1]).set(move[move.length - 2],
                    new Piece(moved.getSymbol().toUpperCase()));
        }
    }

    public boolean isJumpMove(int[] loc) {
        return abs(loc[3]-loc[1]) == 2 && abs(loc[2]-loc[0]) == 2;
    }

    public boolean kingMe(int[] move, Piece p) {
        int kingRow;

        if (p.equals("x")) {
            kingRow = 7;
        } else if (p.equals("o")){
            kingRow = 0;
        } else return false;

        return move[move.length - 1] == kingRow;
    }
}
