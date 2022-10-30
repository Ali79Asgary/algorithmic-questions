package shining_star_question;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ShiningStarTest {

    @Test
    public void NewStarsCanShine() {
        double shineFactor = 1d;
        ShiningStar star = new ShiningStar(shineFactor);
        Assert.assertEquals(shineFactor, star.shine(), 0.0d);
    }

    @Test
    public void FadedOutStarsCannotShine() {
        double shineFactor = 1.5d;
        ShiningStar star = new ShiningStar(shineFactor);
        star.fadeOut();

        Assertions.assertThrows(IllegalStateException.class, () -> star.shine());
    }

    @Test
    public void StarsCanBeNamed() {
        double shineFactor = 0.8d;
        ShiningStar star = new ShiningStar(shineFactor);
        star.setName("Sun");
        Assert.assertEquals("Sun", star.getName());
    }
}
