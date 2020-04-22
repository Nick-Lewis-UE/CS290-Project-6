public class CheckersGame extends MovingGame {

    public CheckersGame() {
        this.setP1(new CheckersPlayer(1, "Player 1"));
        this.setP2(new CheckersPlayer(2, "Player 2"));
        this.setBoard(new CheckersBoard(this));
        this.turn = this.p1;
        p1.setBoard(this.board);
        p2.setBoard(this.board);
    }


}
