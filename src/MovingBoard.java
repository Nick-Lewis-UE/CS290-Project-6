import java.util.ArrayList;

public class MovingBoard extends AbstractBoard {

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
        return null;
    }

    @Override
    public boolean validMove(int[] move, AbstractPlayer p) {
        return false;
    }

    @Override
    public boolean hasTie() {
        return false;
    }
}
