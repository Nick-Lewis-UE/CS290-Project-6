import java.util.ArrayList;
import java.util.Arrays;

public class ChessBoard extends MovingBoard {
    public ChessBoard(ChessGame game) {
        super(game);
    }

    @Override
    protected ArrayList<ArrayList<AbstractPiece>> makeStartBoard(AbstractGame game) {
        ArrayList<ArrayList<AbstractPiece>> a = new ArrayList<>();

        for (int i = 0; i < num_row; i++) {
            a.add(i, new ArrayList<>());
        }

        a.get(0).add(0, new RookPiece("R", this, new int[] {0,0}, game.getP1()));
        a.get(0).add(1, new KnightPiece("N", this, new int[] {1,0}, game.getP1()));
        a.get(0).add(2, new BishopPiece("B", this, new int[] {2,0}, game.getP1()));
        a.get(0).add(3, new QueenPiece("Q", this, new int[] {3,0}, game.getP1()));
        a.get(0).add(4, new KingPiece("K", this, new int[] {4,0}, game.getP1()));
        a.get(0).add(5, new BishopPiece("B", this, new int[] {5,0}, game.getP1()));
        a.get(0).add(6, new KnightPiece("N", this, new int[] {6,0}, game.getP1()));
        a.get(0).add(7, new RookPiece("R", this, new int[] {7,0}, game.getP1()));

        for (int i = 0; i < num_col; i++) {
            a.get(1).add(i, new PawnPiece("P", this, new int[] {i,1}, game.getP1()));
        }

        for(int i = 2; i < 6; i++) {
            for (int j = 0; j < num_col; j++) {
                a.get(i).add(j, new NullPiece());
            }
        }

        for (int i = 0; i < num_col; i++) {
            a.get(6).add(i, new PawnPiece("p", this, new int[] {i,6}, game.getP2()));
        }

        a.get(7).add(0, new RookPiece("r", this, new int[] {0,7}, game.getP2()));
        a.get(7).add(1, new KnightPiece("n", this, new int[] {1,7}, game.getP2()));
        a.get(7).add(2, new BishopPiece("b", this, new int[] {2,7}, game.getP2()));
        a.get(7).add(3, new QueenPiece("q", this, new int[] {3,7}, game.getP2()));
        a.get(7).add(4, new KingPiece("k", this, new int[] {4,7}, game.getP2()));
        a.get(7).add(5, new BishopPiece("b", this, new int[] {5,7}, game.getP2()));
        a.get(7).add(6, new KnightPiece("n", this, new int[] {6,7}, game.getP2()));
        a.get(7).add(7, new RookPiece("r", this, new int[] {7,7}, game.getP2()));

        return a;
    }

    @Override
    public boolean validMove(int[] move) {
        ArrayList<int[]> legalMoves;

        if (check()) {
            legalMoves = findKingMoves();
        } else {
            legalMoves = findAllMoves();
        }

        for (int[] each : legalMoves) {
            if (Arrays.equals(each, move))
                return true;
        }

        return false;
    }

    @Override
    public boolean hasTie() {
        if (check())
            return false;

        for (ArrayList<AbstractPiece> eachRow : grid) {
            for (AbstractPiece eachPiece : eachRow) {
                if (eachPiece.getPlayer().getPlayerNum() == game.getTurn().getPlayerNum()) {
                    if (!eachPiece.generateMoves().isEmpty())
                        return false;
                }
            }
        }
        return true;
    }

    private ArrayList<int[]> findAllMoves() {
        ArrayList<int[]> legalMoves = new ArrayList<>();
        for (int r = 0; r < (getGrid()).size(); r++) {
            for (int c = 0; c < (getGrid()).get(r).size(); c++) {
                if (getGrid().get(r).get(c).getPlayer().getPlayerNum() == game.getTurn().getPlayerNum()) {
                    legalMoves.addAll(getGrid().get(r).get(c).generateMoves());
                }
            }
        }

        for (int i=0; i < legalMoves.size(); i++) {
            if (moveToCheck(legalMoves.get(i))) {
                legalMoves.remove(i);
            }
        }

        return legalMoves;
    }

    private ArrayList<int[]> findKingMoves() {
        ArrayList<int[]> legalMoves = new ArrayList<>();
        for (int r = 0; r <(getGrid()).size(); r++) {
            for (int c = 0; c <(getGrid()).get(r).size(); c++) {
                if (getGrid().get(r).get(c).getPlayer().getPlayerNum() == game.getTurn().getPlayerNum() &&
                    getGrid().get(r).get(c).getSymbol().toLowerCase().equals("k")) {
                    legalMoves.addAll(getGrid().get(r).get(c).generateMoves());

                    for (int i=0; i < legalMoves.size(); i++) {
                        if (moveToCheck(legalMoves.get(i))) {
                            legalMoves.remove(i);
                        }
                    }
                }
            }
        }

        return legalMoves;
    }

    public boolean check() {
        ArrayList<int[]> legalMoves = new ArrayList<>();
        AbstractPlayer otherPlayer;
        int[] turnsKing = new int[0];

        if (game.getTurn() == game.getP1())
            otherPlayer = game.getP2();
        else
            otherPlayer = game.getP1();

        for (int r = 0; r <(getGrid()).size(); r++) {
            for (int c = 0; c <(getGrid()).get(r).size(); c++) {
                if (getGrid().get(r).get(c).getPlayer().getPlayerNum() == otherPlayer.getPlayerNum()) {
                    try {
                        legalMoves.addAll(getGrid().get(r).get(c).generateMoves());
                    } catch (IndexOutOfBoundsException ignored) {}
                }
                if (getGrid().get(r).get(c).getPlayer().getPlayerNum() == game.getTurn().getPlayerNum() &&
                        getGrid().get(r).get(c).getSymbol().toLowerCase().equals("k")) {
                    turnsKing = new int[]{c, r};
                }

            }
        }

        for (int[] each : legalMoves) {
            if (each[2] == turnsKing[0] && each[3] == turnsKing[1]) {
                return true;
            }
        }

        return false;
    }

    private boolean moveToCheck(int[] move) {
        ArrayList<int[]> legalMoves = new ArrayList<>();
        AbstractPlayer otherPlayer;
        int col = move[2];
        int row = move[3];

        if (!grid.get(move[1]).get(move[0]).getSymbol().toLowerCase().equals("k"))
            return false;

        if (game.getTurn() == game.getP1())
            otherPlayer = game.getP2();
        else
            otherPlayer = game.getP1();

        for (int r = 0; r <(getGrid()).size(); r++) {
            for (int c = 0; c <(getGrid()).get(r).size(); c++) {
                if (getGrid().get(r).get(c).getPlayer().getPlayerNum() == otherPlayer.getPlayerNum()) {
                    try {
                        legalMoves.addAll(getGrid().get(r).get(c).generateMoves());
                    } catch (IndexOutOfBoundsException ignored) {}
                }
            }
        }


        for (int[] each : legalMoves) {
            if (each[2] == col && each[3] == row)
                return true;
        }

        return false;
    }
}
