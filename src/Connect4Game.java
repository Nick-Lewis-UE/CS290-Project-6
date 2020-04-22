import java.util.Scanner;

public class Connect4Game extends AbstractGame{

    public Connect4Game() {
        this.setBoard(new Connect4Board(this));
        this.setP1(new Connect4Player(1, "Player 1", this.board));
        this.setP2(new Connect4Player(2, "Player 2", this.board));
    }

    public int[] scanForMove() {
        System.out.println("Enter a column to drop into!");
        Scanner scan = new Scanner(System.in);

        int[] move = new int[1];
        move[0] = scan.nextInt();


        if (board.validMove(move, turn)) {
            System.out.println("Invalid column. Please try again.");
            return scanForMove();
        }

        return move;
    }
}
