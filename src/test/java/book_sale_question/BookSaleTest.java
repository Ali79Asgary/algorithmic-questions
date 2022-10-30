package book_sale_question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class BookSaleTest {
    @Test
    public void nthLowestSelling_withSmallList_Successful() {
        int[] sales = new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5};
        int result = BookSale.nthLowestSelling(sales, 2);
        Assertions.assertEquals(2, result);
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void nthLowestSelling_withLargeList_Successful() {
        int[] sales = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 6, 5, 4, 3, 2, 1, 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5};
        int result = BookSale.nthLowestSelling(sales, 2);
        Assertions.assertEquals(9, result);
    }
}
