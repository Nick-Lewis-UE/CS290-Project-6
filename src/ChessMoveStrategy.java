import java.util.Scanner;

import static java.lang.Math.abs;

public class ChessMoveStrategy implements moveStrategy {
    public ChessMoveStrategy(AbstractPlayer p) {this.p = p; }

    protected AbstractPlayer p;

    @Override
    public void takeMove(int[] move) {
        AbstractPiece moved = p.getBoard().getGrid().get(move[1]).get(move[0]);

        p.getBoard().getGrid().get(move[3]).set(move[2], moved);
        p.getBoard().getGrid().get(move[1]).set(move[0],
                new NullPiece(p.getBoard(), new int[] {move[0], move[1]}));
        moved.setLocation(new int[] {move[2], move[3]});

        if (isCastlingMove(move)) {
            moveCastledRook(move);
        }

        if(promotable(move)) {
            promote(new int[] {move[2], move[3]});
        }
    }

    private void promote(int[] loc) {
        Scanner line = new Scanner(System.in);

        System.out.println("You can promote your pawn. What would you like to promote it to?");
        System.out.println("Q for Queen");
        System.out.println("B for Bishop");
        System.out.println("N for Knight");
        System.out.println("R for Rook");

        String choice = line.nextLine();
        System.out.println("Got Here");
        switch(choice) {
            case "Q":
                p.getBoard().getGrid().get(loc[1]).set(loc[0], new QueenPiece(p.getBoard(), loc, p));
                System.out.println("Queen");
                break;
            case "B":
                p.getBoard().getGrid().get(loc[1]).set(loc[0], new BishopPiece((ChessBoard) p.getBoard(), loc, p));
                break;
            case "N":
                p.getBoard().getGrid().get(loc[1]).set(loc[0], new KnightPiece((ChessBoard) p.getBoard(), loc, p));
                break;
            case "R":
                p.getBoard().getGrid().get(loc[1]).set(loc[0], new RookPiece((ChessBoard) p.getBoard(), loc, p));
                break;
            default: break;
        }
    }

    private boolean promotable(int[] move) {
        boolean isPawn = p.getBoard().getGrid().get(move[3]).get(move[2]).getSymbol().toLowerCase().equals("p");
        int finalRow;

        if (p.getPlayerNum() == 1) {
            finalRow = 7;
        } else {
            finalRow = 0;
        }

        return isPawn && move[3] == finalRow;
    }

    private void moveCastledRook(int[] move) {
        int oldRookCol;
        int newRookCol;

        if (move[2] < 4) {
            oldRookCol = 0;
            newRookCol = 3;
        } else {
            oldRookCol = 7;
            newRookCol = 5;
        }

//        System.out.println(oldRookCol + " to " + newRookCol);
        takeMove(new int[] {oldRookCol,move[1],newRookCol,move[3]});
    }

    public boolean isCastlingMove(int[] move) {
        boolean isKing = p.getBoard().getGrid().get(move[3]).get(move[2]).getSymbol().toLowerCase().equals("k");
        boolean notNormalMove =  abs(move[2] - move[0]) > 1;


        if (isKing && notNormalMove)
            return true;
        else
            return false;
    }
}
