package max_sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MaxSumTest {

    @Test
    public void findMaxSum_withSmallList_Successful() {
        List<Integer> list = createList(10);
        int result = MaxSum.findMaxSum(list);
        Assertions.assertEquals(19, result);
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void findMaxSum_withMediumList_PerformanceIsOK() {
        List<Integer> list = createList(200);
        int result = MaxSum.findMaxSum(list);
        Assertions.assertEquals(399, result);
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void findMaxSum_withLargeList_PerformanceIsOK() {
        List<Integer> list = createList(10000);
        int result = MaxSum.findMaxSum(list);
        Assertions.assertEquals(19999, result);
    }

    private List<Integer> createList(int arraySize) {
        List<Integer> list = new ArrayList<>();
        int[] array = IntStream.rangeClosed(1, arraySize).toArray();
        for (int i = 0; i < arraySize; i++) {
            list.add(array[i]);
        }
        return list;
    }
}
