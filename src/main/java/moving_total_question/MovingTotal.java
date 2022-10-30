package moving_total_question;

import java.util.HashSet;

public class MovingTotal {
    private int n = 0;
    private int a = 0;
    private int b = 0;
    private int c = 0;

    private HashSet<Integer> totals = new HashSet<Integer>();

    public void append(int[] list) {
        for (int x : list) {
            a = b;
            b = c;
            c = x;

            if (++n >= 3) {
                totals.add(a + b + c);
            }
        }
    }

    public boolean contains(int total) {
        return totals.contains(total);
    }
}
