import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.lang.Math.abs;

public class CheckersBoard extends AbstractBoard {

    public CheckersBoard(AbstractGame game) {
        this.num_col = 8;
        this.num_row = 8;
        this.size = 64;
        this.grid = makeStartBoard(game);
        this.game = game;
    }

    @Override
    public void takeMove(AbstractPiece p, int[] move) {
        AbstractPiece moved = grid.get(move[1]).get(move[0]);

        for (int i = 3; i < move.length; i = i + 2) {
            grid.get(move[i]).set(move[i - 1], moved);
            grid.get(move[i - 2]).set(move[i - 3],
                    new NullPiece(this, new int[] {move[i - 3], move[i - 2]}));

            if (isJumpMove(move)) {
                grid.get((move[i]+ move[i-2])/2).set((move[i-1]+move[i-3])/2,
                        new NullPiece(this,
                                new int[] {(move[i-1]+move[i-3])/2, (move[i]+ move[i-2])/2}));
            }
        }

        if (kingMe(move, p)) {
            grid.get(move[move.length - 1]).set(move[move.length - 2],
                    new CheckersKingPiece(moved.getSymbol().toUpperCase(), this,
                            new int[] {move[move.length - 2], move[move.length - 1]}, p.getPlayer()));
        }
    }

    @Override
    public String toString() {
        int row_num = 8;
        StringBuilder board = new StringBuilder("|A|B|C|D|E|F|G|H|\n");
        for (int i = 0; i < num_row; i++) {
            board.append("|").
                    append(grid.get(i).get(0).getSymbol()).append("|").
                    append(grid.get(i).get(1).getSymbol()).append("|").
                    append(grid.get(i).get(2).getSymbol()).append("|").
                    append(grid.get(i).get(3).getSymbol()).append("|").
                    append(grid.get(i).get(4).getSymbol()).append("|").
                    append(grid.get(i).get(5).getSymbol()).append("|").
                    append(grid.get(i).get(6).getSymbol()).append("|").
                    append(grid.get(i).get(7).getSymbol()).append("|").
                    append(" ").append(row_num--).append("\n");
        }

        return board.toString();
    }

    @Override
    protected ArrayList<ArrayList<AbstractPiece>> makeStartBoard(AbstractGame game) {
        ArrayList<ArrayList<AbstractPiece>> a = new ArrayList<>();

        for(int i = 0; i < num_row; i++) {
            a.add(i, new ArrayList<>());
            for (int j = 0; j < num_col; j++) {
                if (((i == 0 || i == 2) && j % 2 != 0) ||
                        (i == 1 && j % 2 == 0))
                    a.get(i).add(j, new CheckersPiece("x", this,
                            new int[] {j,i}, game.getP1()));
                else if (((i == 5 || i == 7) && j % 2 == 0) ||
                        (i == 6 && j % 2 != 0))
                    a.get(i).add(j, new CheckersPiece("o", this,
                            new int[] {j,i}, game.getP2()));
                else
                    a.get(i).add(j, new NullPiece(this, new int[] {i,j}));
            }
        }

        return a;
    }

    @Override
    public boolean validMove(int[] move, AbstractPlayer p) {
        ArrayList<int[]> moves = findLegalMoves(p);

        for (int[] each : moves) {
            if (Arrays.equals(each, move))
                return true;
        }

        return false;
    }

    @Override
    public boolean hasTie() {
        return findLegalMoves(game.getP1()).isEmpty() &&
                findLegalMoves(game.getP2()).isEmpty();
    }

    protected boolean kingMe(int[] move, AbstractPiece p) {
        int kingRow;

        if (p.equals("x")) {
            kingRow = 7;
        } else if (p.equals("o")){
            kingRow = 0;
        } else return false;

        return move[move.length - 1] == kingRow;
    }

    protected boolean isJumpMove(int[] loc) {
        return abs(loc[3]-loc[1]) == 2 && abs(loc[2]-loc[0]) == 2;
    }

    protected int[] getJumpedPosition(int[] loc) {
        int[] jumped = new int[2];
        jumped[0] = (loc[2]+loc[0])/2;
        jumped[1] = (loc[3]+loc[1])/2;

        return jumped;
    }

    protected ArrayList<int[]> findLegalMoves(AbstractPlayer player) {
        ArrayList<int[]> legalMoves = new ArrayList<>();

        for (int r = 0; r <(getGrid()).size(); r++) {
            for (int c = 0; c <(getGrid()).get(r).size(); c++) {
                if (getGrid().get(r).get(c).getPlayer().getPlayerNum() == player.getPlayerNum()) {
                    legalMoves.addAll(getGrid().get(r).get(c).generateMoves());
                }
            }
        }

        ArrayList<int[]> allMoves = new ArrayList<>();
        if (legalMoves.stream().anyMatch(this::isJumpMove)) {
            legalMoves.stream().filter(this::isJumpMove).forEach(allMoves::add);
        } else {
            legalMoves.stream().filter(each -> !isJumpMove(each)).forEach(allMoves::add);
        }
        return allMoves;
    }

    protected ArrayList<int[]> findAllSimpleMoves(AbstractPiece p) {
        ArrayList<int[]> a = new ArrayList<>();

        for (int r = 0; r <(getGrid()).size(); r++) {
            for (int c = 0; c <(getGrid()).get(r).size(); c++) {
                if (getGrid().get(r).get(c).equals(p)) {
                    a.addAll(findLocalSimpleMoves(new int[]{c, r},
                            getGrid().get(r).get(c)));
                }
            }
        }

        return a;
    }

    protected ArrayList<int[]> findLocalSimpleMoves(int[] me, AbstractPiece p) {
        int[] rowAdds;
        int[] colAdds = new int[] {1,-1};
        ArrayList<int[]> allMoves = new ArrayList<>();

        if (p.getSymbol().equals("x")) {
            rowAdds = new int[] {1,1};
        } else if (p.getSymbol().equals("o")){
            rowAdds = new int[] {-1,-1};
        } else {
            rowAdds = new int[] {-1,-1,1,1};
            colAdds = new int[] {1,-1,1,-1};
        }

        for (int i = 0; i < 2; i++) {
            try {
                AbstractPiece nextPiece = getGrid().get(me[1] + rowAdds[i]).get(me[0] + colAdds[i]);

                if (nextPiece.isEmpty()) {
                    int[] newMe = appendMoveArray(me,
                            new int[] {me[me.length-2]+colAdds[i],
                                    me[me.length-1]+rowAdds[i]});
                    allMoves.add(newMe);
                }
            } catch (IndexOutOfBoundsException ignored) {}
        }

        return allMoves;
    }

    protected ArrayList<int[]> findAllJumps(AbstractPiece p) {
        ArrayList<int[]> a = new ArrayList<>();

        for (int r = 0; r <(getGrid()).size(); r++) {
            for (int c = 0; c <(getGrid()).get(r).size(); c++) {
                if (getGrid().get(r).get(c).equals(p.getSymbol())) {
                    a.addAll(findLocalJumps(new int[]{c, r},
                            getGrid().get(r).get(c)));
                }
            }
        }

        return a;
    }

    protected ArrayList<int[]> findLocalJumps (int[] me, AbstractPiece p) {
        int[] rowAdds;
        int[] colAdds = new int[] {1,-1};
        boolean moreJumps = false;
        ArrayList<int[]> allMoves = new ArrayList<>();

        if (p.getSymbol().equals("x")) {
            rowAdds = new int[] {1,1};
        } else if (p.getSymbol().equals("o")){
            rowAdds = new int[] {-1,-1};
        } else {
            rowAdds = new int[] {-1,-1,1,1};
            colAdds = new int[] {1,-1,1,-1};
        }

        for (int i = 0; i < 2; i++) {
            try {
                AbstractPiece nextPiece = getGrid().get(me[me.length-1] + rowAdds[i]).
                        get(me[me.length-2] + colAdds[i]);

                if (!nextPiece.isEmpty() &&
                        !nextPiece.equals(p) &&
                        getGrid().get(me[me.length - 1] + 2 * rowAdds[i]).
                                get(me[me.length - 2] + 2 * colAdds[i]).isEmpty()) {
                    int[] newMe = appendMoveArray(me,
                            new int[]{me[me.length - 2] + 2 * colAdds[i],
                                    me[me.length - 1] + 2 * rowAdds[i]});
                    allMoves.addAll(findLocalJumps(newMe, p));
                    moreJumps = true;
                }
            } catch(IndexOutOfBoundsException ignored) {}
        }

        if (!moreJumps && me.length != 2) {
            allMoves.add(me);
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
