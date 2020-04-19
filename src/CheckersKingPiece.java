public class CheckersKingPiece extends CheckersPiece {
    public CheckersKingPiece(String symbol, AbstractBoard board,
                             int[] location, AbstractPlayer player)  {
        super(symbol, board, location, player);
        rowAdds = new int[] {-1,-1,1,1};
        colAdds = new int[] {1,-1,1,-1};
    }
}
