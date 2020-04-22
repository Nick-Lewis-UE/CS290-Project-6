import java.util.ArrayList;
import java.util.Arrays;

public class CheckersPiece extends AbstractPiece {
    public CheckersPiece(String symbol, AbstractBoard board,
                         int[] location, AbstractPlayer player)  {
        super(symbol, board, location, player);
        if (symbol.equals("x")) {
            rowAdds = new int[] {1,1};
        } else if (symbol.equals("o")) {
            rowAdds = new int[]{-1, -1};
        }
        colAdds = new int[] {1,-1};
    }

    protected int[] rowAdds;
    protected int[] colAdds;

    public ArrayList<int[]> generateMoves() {
        ArrayList<int[]> legalMoves;

        legalMoves = findJumps(location);

        if (legalMoves.isEmpty()) {
            legalMoves = findSimpleMoves();
        }
        return legalMoves;
    }

    protected ArrayList<int[]> findJumps (int[] me) {
        boolean moreJumps = false;
        ArrayList<int[]> allMoves = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            try {
                AbstractPiece nextPiece = board.getGrid().get(me[me.length-1] + rowAdds[i]).
                        get(me[me.length-2] + colAdds[i]);

                if (!nextPiece.isEmpty() &&
                        !nextPiece.equals(symbol) &&
                        board.getGrid().get(me[me.length - 1] + 2 * rowAdds[i]).
                                get(me[me.length - 2] + 2 * colAdds[i]).isEmpty()) {
                    int[] newMe = appendMoveArray(me,
                            new int[]{me[me.length - 2] + 2 * colAdds[i],
                                    me[me.length - 1] + 2 * rowAdds[i]});
                    allMoves.addAll(findJumps(newMe));
                    moreJumps = true;
                }
            } catch(IndexOutOfBoundsException ignored) {}
        }

        if (!moreJumps && me.length != 2) {
            allMoves.add(me);
        }

        return allMoves;
    }

    protected ArrayList<int[]> findSimpleMoves() {
        ArrayList<int[]> allMoves = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            try {
                AbstractPiece nextPiece = board.getGrid().get(location[1] + rowAdds[i]).get(location[0] + colAdds[i]);

                if (nextPiece.isEmpty()) {
                    int[] newMe = appendMoveArray(location,
                            new int[] {location[location.length-2]+colAdds[i],
                                    location[location.length-1]+rowAdds[i]});
                    allMoves.add(newMe);
                }
            } catch (IndexOutOfBoundsException ignored) {}
        }

        return allMoves;
    }

    protected int[] appendMoveArray (int[] soFar, int[] upNext) {
        int[] combined = new int[soFar.length + upNext.length];

        System.arraycopy(soFar, 0, combined, 0, soFar.length);
        System.arraycopy(upNext, 0, combined, soFar.length, upNext.length);

        return combined;
    }
}
