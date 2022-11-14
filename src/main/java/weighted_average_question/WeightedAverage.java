package weighted_average_question;

import java.util.List;

public class WeightedAverage {
    public static double mean(List<Integer> numbers, List<Integer> weights) {
        if (numbers == null || weights == null || numbers.size() != weights.size()) {
            throw new IllegalArgumentException();
        }
        double total = 0;
        double totalWeights = 0;
        for (int i = 0; i < numbers.size(); i++) {
            total += (double) numbers.get(i) * weights.get(i);
            totalWeights += weights.get(i);
        }
        return total / totalWeights;
    }
}
