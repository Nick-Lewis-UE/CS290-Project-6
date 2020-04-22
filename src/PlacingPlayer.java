import static java.lang.Math.min;

public class PlacingPlayer extends AbstractPlayer {
    public PlacingPlayer(int playerNum, String name,
                         AbstractBoard board) {
        super(playerNum, name, board);
    }

    protected AbstractPiece piece;
    protected int needToWin;

    public boolean hasWin(int[] loc) {
        // horizontal win
        for (int j = 1; j <= board.getNum_row(); j++) {
            if (checkHorizontalWin(j))
                return true;
        }
        // vertical win?
        if (checkVerticalWin(loc[0]))
            return true;

        // descending diagonal win
        for (int i = 1; i <= board.getNum_row(); i++) {
            if (checkDescDiagonalWin(loc[0], i))
                return true;
        }
        // ascending diagonal win
        for (int i = 1; i <= board.getNum_row(); i++) {
            if (checkAscDiagonalWin(loc[0], i))
                return true;
        }

        return false;
    }

    protected boolean checkHorizontalWin(int row) {
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

    protected boolean checkVerticalWin(int col) {
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

    protected boolean checkDescDiagonalWin(int col, int row) {
        int run = 0;
        int smaller = min(row, col);
        int r = row-smaller;
        int c = col-smaller;

        while (r < board.getNum_row() && c < board.getNum_col()) {
            if(board.getGrid().get(r).get(c).equals(piece))
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

    protected boolean checkAscDiagonalWin(int col, int row) {
        int run = 0;

        int r = row-1;
        int c = col-1;
        while (r < board.getNum_row()-1 && c > 0) {
            r++;
            c--;
        }

        while (r >= 0 && c < board.getNum_col()) {
            if(board.getGrid().get(r).get(c).equals(piece))
                run++;
            else
                run = 0;
            if (run >= needToWin)
                return true;

            r--;
            c++;
        }

        return false;
    }


}
