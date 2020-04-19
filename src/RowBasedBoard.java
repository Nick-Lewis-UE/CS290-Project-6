import java.util.ArrayList;

import static java.lang.Math.min;

public abstract class RowBasedBoard extends AbstractBoard {
    protected int needToWin;

//    public boolean checkHorizontalWin(AbstractPlayer p, int row) {
//        int run = 0;
//        for (int i = 0; i < num_col; i++) {
//            if (grid.get(row-1).get(i).equals(p.getPiece()))
//                run++;
//            else
//                run = 0;
//            if (run >= needToWin)
//                return true;
//        }
//
//        return false;
//    }
//
//    public boolean checkVerticalWin(AbstractPlayer p, int col) {
//        int run = 0;
//        for (int i = 0; i < num_row; i++) {
//            if(grid.get(i).get(col-1).equals(p.getPiece()))
//                run++;
//            else
//                run = 0;
//            if (run >= needToWin)
//                return true;
//        }
//
//        return false;
//    }
//
//    public boolean checkDescDiagonalWin(AbstractPlayer p, int col, int row) {
//        int run = 0;
//        int smaller = min(row, col);
//        int r = row-smaller;
//        int c = col-smaller;
//
//        while (r < num_row && c< num_col) {
//            if(grid.get(r).get(c).equals(p.getPiece()))
//                run++;
//            else
//                run = 0;
//            if (run >= needToWin)
//                return true;
//
//            r++;
//            c++;
//        }
//
//        return false;
//    }
//
//    public boolean checkAscDiagonalWin(AbstractPlayer p, int col, int row) {
//        int run = 0;
//
//        int r = row-1;
//        int c = col-1;
//        while (r < num_row-1 && c > 0) {
//            r++;
//            c--;
//        }
//
//        while (r >= 0 && c < num_col) {
//            if(grid.get(r).get(c).equals(p.getPiece()))
//                run++;
//            else
//                run = 0;
//            if (run >= needToWin)
//                return true;
//
//            r--;
//            c++;
//        }
//
//        return false;
//    }

    public ArrayList<ArrayList<Piece>> makeStartBoard() {
        ArrayList<ArrayList<Piece>> a= new ArrayList<>();
        for (int i = 0; i < num_row; i++) {
            a.add(i, new ArrayList<>());
            for (int j = 0; j < num_col; j++) {
                a.get(i).add(j, new NullPiece());
            }
        }
        return a;
    }

    public boolean hasTie() {
        for (int i = 0; i < num_row; i++)
            for (int j = 0; j < num_col; j++)
                if (grid.get(i).get(j).isEmpty()) {
                    return false;
                }
        return true;
    }
}
