import java.util.Scanner;

public class GomokuGame extends AbstractGame {

    public GomokuGame() {
        this.setBoard(new GomokuBoard());
        this.setP1(new GomokuPlayer(1, "Player 1", this.board));
        this.setP2(new GomokuPlayer(2, "Player 2", this.board));
    }

    @Override
    public int[] scanForMove() {
        System.out.println("Enter the coordinate to place your piece at!");

        Scanner scan = new Scanner(System.in);
        String letter = scan.findInLine(".").toUpperCase();
        int col = (int)letter.charAt(0)-64;
        int row = scan.nextInt();

        int[] move = new int[] {col, row};

        if (board.validMove(move)) {
            System.out.println("Invalid row/column. Please try again.");
            return scanForMove();
        }

        return move;

    }
}
