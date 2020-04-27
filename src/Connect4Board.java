public class Connect4Board extends PlacingBoard {

    public Connect4Board(AbstractGame game) {
        this.num_col = 7;
        this.num_row = 6;
        this.size = 42;
        this.needToWin = 4;
        this.grid = makeStartBoard(game);
    }

    public String toString() {
        StringBuilder board = new StringBuilder();
        board.append("|1|2|3|4|5|6|7|\n");
        for (int i = 0; i < num_row; i++) {
            board.append("|").append(grid.get(i).get(0).getSymbol()).
                    append("|").append(grid.get(i).get(1).getSymbol()).
                    append("|").append(grid.get(i).get(2).getSymbol()).
                    append("|").append(grid.get(i).get(3).getSymbol()).
                    append("|").append(grid.get(i).get(4).getSymbol()).
                    append("|").append(grid.get(i).get(5).getSymbol()).
                    append("|").append(grid.get(i).get(6).getSymbol()).
                    append("|").append("\n");
        }

        return board.toString();
    }

    public boolean validMove(int[] move) {
        return (move[0] <= 0 || move[0] > num_col ||
                !grid.get(0).get(move[0] - 1).isEmpty());
    }
}
