import java.util.ArrayList;

public class PawnPiece extends AbstractPiece {
    public PawnPiece(String p, ChessBoard chessBoard, int[] ints, AbstractPlayer p1) {
        super(p, chessBoard, ints, p1);
    }

    public ArrayList<int[]> generateMoves() {
        ArrayList<int[]> a = new ArrayList<>();

        if (player.getPlayerNum() == 1) {
            if (board.getGrid().get(location[1]+1).get(location[0]).isEmpty()) {
                a.add(new int[] {location[0], location[1], location[0], location[1]+1});

                if ((location[1] == 1 &&
                        board.getGrid().get(location[1]+2).get(location[0]).isEmpty())) {
                    a.add(new int[] {location[0], location[1], location[0], location[1]+2});
                }
            }

            if (board.getGrid().get(location[1]+1).get(location[0]+1).getPlayer().getPlayerNum() == 2) {
                a.add(new int[] {location[0], location[1], location[0]+1, location[0]+1});
            }

            if (board.getGrid().get(location[1]+1).get(location[0]-1).getPlayer().getPlayerNum() == 2) {
                a.add(new int[] {location[0], location[1], location[0]-1, location[0]+1});
            }
        } else if (player.getPlayerNum() == 2) {
            if (board.getGrid().get(location[1]-1).get(location[0]).isEmpty()) {
                a.add(new int[] {location[0], location[1], location[0], location[1]-1});

                if ((location[1] == 6 &&
                        board.getGrid().get(location[1]-2).get(location[0]).isEmpty())) {
                    a.add(new int[] {location[0], location[1], location[0], location[1]-2});
                }
            }

            if (board.getGrid().get(location[1]-1).get(location[0]+1).getPlayer().getPlayerNum() == 1) {
                a.add(new int[] {location[0], location[1], location[0]+1, location[0]-1});
            }

            if (board.getGrid().get(location[1]-1).get(location[0]-1).getPlayer().getPlayerNum() == 1) {
                a.add(new int[] {location[0], location[1], location[0]-1, location[0]-1});
            }
        }

        return a;
    }
}
