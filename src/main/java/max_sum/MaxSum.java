package max_sum;

import java.util.List;

public class MaxSum {
    public static int findMaxSum(List<Integer> list) {
        int max1 = 0;
        int max2 = 0;
        for (int number : list) {
            if (number > max1) {
                max2 = max1;
                max1 = number;
            } else if (number > max2) {
                max2 = number;
            }
        }
        return max1 + max2;
    }
}
