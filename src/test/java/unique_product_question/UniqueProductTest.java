package unique_product_question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class UniqueProductTest {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void testFirstUniqueProduct_whenLargeNumberOfProducts_performanceIsOK() {
        String[] products = createRandomArray(100);
        String result = UniqueProduct.firstUniqueProduct(products);
        Assertions.assertEquals("1", result);
    }

    @Test
    public void testFirstUniqueProduct_whenHasSomeUniqueProducts_returnFirstUniqueProduct() {
        String[] products = createArrayWithSomeUniqueProducts();
        String result = UniqueProduct.firstUniqueProduct(products);
        Assertions.assertEquals("reza", result);
    }

    @Test
    public void testFirstUniqueProduct_whenNoUniqueProducts_returnNull() {
        String[] products = createArrayWithNoUniqueProducts();
        String result = UniqueProduct.firstUniqueProduct(products);
        Assertions.assertNull(result);
    }

    private String[] createRandomArray(int arraySize) {
        int[] arrayOfInt = IntStream.rangeClosed(1, arraySize).toArray();
        String[] arrayOfString = new String[arrayOfInt.length];
        for (int i = 0; i < arrayOfInt.length; i++) {
            arrayOfString[i] = String.valueOf(arrayOfInt[i]);
        }
        return arrayOfString;
    }

    private String[] createArrayWithSomeUniqueProducts() {
        return new String[]{"ali", "reza", "ali", "mohsen", "ali", "mohammad"};
    }

    private String[] createArrayWithNoUniqueProducts() {
        return new String[]{"ali", "reza", "ali", "ali", "reza", "ali"};
    }
}
