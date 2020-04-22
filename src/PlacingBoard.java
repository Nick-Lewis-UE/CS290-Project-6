import java.util.ArrayList;

import static java.lang.Math.min;

public abstract class PlacingBoard extends AbstractBoard {
    protected int needToWin;

    public ArrayList<ArrayList<AbstractPiece>> makeStartBoard(AbstractGame game) {
        ArrayList<ArrayList<AbstractPiece>> a= new ArrayList<>();
        for (int i = 0; i < num_row; i++) {
            a.add(i, new ArrayList<>());
            for (int j = 0; j < num_col; j++) {
                a.get(i).add(j, new NullPiece(this, new int[] {j}));
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
