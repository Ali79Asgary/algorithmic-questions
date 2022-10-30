package shelf_question;

import org.junit.Assert;
import org.junit.Test;

public class ShelfTest {

    @Test
    public void shelfCanAcceptAndReturnItem() {
        Shelf shelf = new Shelf();
        shelf.put("Orange");
        Assert.assertTrue(shelf.take("Orange"));
    }

    @Test
    public void shelfCannotAcceptNullOrEmptyItem() {
        Shelf shelf = new Shelf();

        shelf.put(null);
        Assert.assertFalse(shelf.take(null));

        shelf.put("");
        Assert.assertFalse(shelf.take(""));
    }

    @Test
    public void shelfCannotGiveOneItemMultipleTimes() {
        Shelf shelf = new Shelf();

        shelf.put("Avocado");

        Assert.assertTrue(shelf.take("Avocado"));
        Assert.assertFalse(shelf.take("Avocado"));
    }

    @Test
    public void shelfCanAcceptAndGiveMultipleSameItems() {
        Shelf shelf = new Shelf();

        shelf.put("Avocado");
        shelf.put("Avocado");
        Assert.assertTrue(shelf.take("Avocado"));
        Assert.assertTrue(shelf.take("Avocado"));
    }
}
