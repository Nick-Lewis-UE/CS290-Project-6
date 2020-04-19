import org.junit.Assert;
import org.junit.Test;

public class PieceTest {
    private void testPiece(AbstractPiece p, String symbol) {
        Assert.assertEquals(symbol, p.getSymbol());
    }

    @Test
    public void testConstructors() {
        String s1 = "x";
        AbstractPiece p1 = new AbstractPiece(s1);
        testPiece(p1, s1);
    }
}
