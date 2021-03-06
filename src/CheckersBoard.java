import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.abs;

public class CheckersBoard extends MovingBoard {

    public CheckersBoard(CheckersGame game) {
        super(game);
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
    public boolean validMove(int[] move) {
        ArrayList<int[]> moves = findLegalMoves(game.getTurn());

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

    protected int[] appendMoveArray (int[] soFar, int[] upNext) {
        int[] combined = new int[soFar.length + upNext.length];

        System.arraycopy(soFar, 0, combined, 0, soFar.length);
        System.arraycopy(upNext, 0, combined, soFar.length, upNext.length);

        return combined;
    }

}
