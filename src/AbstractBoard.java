import java.util.ArrayList;

public abstract class AbstractBoard {
    // outer list is rows, inner list is columns
    protected ArrayList<ArrayList<AbstractPiece>> grid;
    protected int size;
    protected int num_col;
    protected int num_row;
    protected AbstractGame game;

    public AbstractBoard() {}

    public int getSize() {
        return size;
    }

    public int getNum_row() {
        return num_row;
    }

    public int getNum_col() {
        return num_col;
    }

    public ArrayList<ArrayList<AbstractPiece>> getGrid() {
        return grid;
    }

    public abstract String toString();

    protected abstract ArrayList<ArrayList<AbstractPiece>> makeStartBoard(AbstractGame game);

    public abstract boolean validMove(int[] move, AbstractPlayer p);

    public abstract boolean hasTie();
}
