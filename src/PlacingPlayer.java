import java.util.ArrayList;

import static java.lang.Math.min;

public class PlacingPlayer extends AbstractPlayer {
    public PlacingPlayer(int playerNum, String name, moveStrategy moveStrat,
                         AbstractBoard board) {
        super(playerNum, name, moveStrat, board);
        if (playerNum == 1) {
            this.piece = new Piece("x");
        } else {
            this.piece = new Piece("o");
        }
    }

    protected Piece piece;
    protected int needToWin;

    public boolean hasWin(int[] loc) {
        return (checkHorizontalWin(loc[1]) || checkVerticalWin(p, loc[0]) ||
                checkDescDiagonalWin(p, loc[0], loc[1]) || checkAscDiagonalWin(p, loc[0], loc[1]));
    }

    public boolean checkHorizontalWin(int row) {
        int run = 0;
        for (int i = 0; i < board.getNum_col(); i++) {
            if (board.getGrid().get(row-1).get(i).equals(piece))
                run++;
            else
                run = 0;
            if (run >= needToWin)
                return true;
        }

        return false;
    }

    public boolean checkVerticalWin(int col) {
        int run = 0;
        for (int i = 0; i < board.getNum_row(); i++) {
            if(board.getGrid().get(i).get(col-1).equals(piece))
                run++;
            else
                run = 0;
            if (run >= needToWin)
                return true;
        }

        return false;
    }

    public boolean checkDescDiagonalWin(AbstractPlayer p, int col, int row) {
        int run = 0;
        int smaller = min(row, col);
        int r = row-smaller;
        int c = col-smaller;

        while (r < num_row && c< num_col) {
            if(grid.get(r).get(c).equals(p.getPiece()))
                run++;
            else
                run = 0;
            if (run >= needToWin)
                return true;

            r++;
            c++;
        }

        return false;
    }

}
