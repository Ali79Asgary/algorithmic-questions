package unique_numbers_question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class UniqueNumbersTest {
    @Test
    public void findUniqueNumbers_withSmallList_Successful() {
        Collection<Integer> numbers = Arrays.asList(1, 2, 2, 2, 3, 7, 6, 9, 9, 4, 5);
        Collection<Integer> result = Arrays.asList(1, 3, 4, 5, 6, 7);
        Collection<Integer> uniqueNumbers = UniqueNumbers.findUniqueNumbers(numbers);
        Assertions.assertArrayEquals(result.toArray(), uniqueNumbers.toArray());
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void findUniqueNumbers_withLargeList_Successful() {
        int[] array = createArray(100);
        Collection<Integer> numbers = new ArrayList<>();
        for (int number : array) {
            numbers.add(number);
        }
        Collection<Integer> uniqueNumbers = UniqueNumbers.findUniqueNumbers(numbers);
        Assertions.assertArrayEquals(numbers.toArray(), uniqueNumbers.toArray());
    }

    private int[] createArray(int arraySize) {
        return IntStream.rangeClosed(1, arraySize).toArray();
    }
}
