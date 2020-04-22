public class ChessGame extends MovingGame {
    public ChessGame() {
        this.setP1(new ChessPlayer(1, "Player 1"));
        this.setP2(new ChessPlayer(2, "Player 2"));
        this.setBoard(new ChessBoard(this));
        this.turn = this.p1;
        p1.setBoard(this.board);
        p2.setBoard(this.board);
    }
}
