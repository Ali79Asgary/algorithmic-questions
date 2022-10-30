package moving_total_question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MovingTotalTest {

    @Test
    public void testAppend_with100Elements_Successful() {
        int[] array = createArray(100);
        MovingTotal movingTotal = new MovingTotal();
        movingTotal.append(array);
        boolean result = movingTotal.contains(12);
        Assertions.assertTrue(result);
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void testAppend_withLargeNumberOfElements_PerformanceIsOK() {
        int[] array = createArray(1000000);
        MovingTotal movingTotal = new MovingTotal();
        movingTotal.append(array);
        boolean result = movingTotal.contains(12);
        Assertions.assertTrue(result);
    }

    private int[] createArray(int arraySize) {
        return IntStream.rangeClosed(1, arraySize).toArray();
    }
}
