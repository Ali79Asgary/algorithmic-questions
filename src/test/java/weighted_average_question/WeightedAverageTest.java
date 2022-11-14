package weighted_average_question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class WeightedAverageTest {

    @Test
    public void mean_argumentsAreNull_throwIllegalArgumentException() {
        List<Integer> numbers = null;
        List<Integer> weights = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            WeightedAverage.mean(numbers, weights);
        });
    }

    @Test
    public void mean_arraysDontHaveSameLength_throwIllegalArgumentException() {
        List<Integer> numbers = Arrays.asList(1, 2);
        List<Integer> weights = Arrays.asList(1, 2, 3);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            WeightedAverage.mean(numbers, weights);
        });
    }
}
