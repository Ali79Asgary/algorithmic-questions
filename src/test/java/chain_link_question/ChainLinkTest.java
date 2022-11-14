package chain_link_question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChainLinkTest {
    @Test
    public void longerSide_exampleCase_returnLongerSide(){
        ChainLink left = new ChainLink();
        ChainLink middle = new ChainLink();
        ChainLink right = new ChainLink();
        left.append(middle);
        middle.append(right);
        Assertions.assertEquals(Side.RIGHT, left.longerSide());
    }

    @Test
    public void longerSide_regularChain_returnLongerSide(){
        ChainLink first = new ChainLink();
        ChainLink left = new ChainLink();
        ChainLink middle = new ChainLink();
        ChainLink right = new ChainLink();
        ChainLink last = new ChainLink();
        first.append(left);
        left.append(middle);
        middle.append(right);
        right.append(last);
        Assertions.assertEquals(Side.RIGHT, first.longerSide());
    }

    @Test
    public void longerSide_ClosedLoop_returnNone(){
        ChainLink first = new ChainLink();
        ChainLink left = new ChainLink();
        ChainLink middle = new ChainLink();
        ChainLink right = new ChainLink();
        ChainLink last = new ChainLink();
        first.append(left);
        left.append(middle);
        middle.append(right);
        right.append(last);
        last.append(first);
        Assertions.assertEquals(Side.NONE, first.longerSide());
    }
}
