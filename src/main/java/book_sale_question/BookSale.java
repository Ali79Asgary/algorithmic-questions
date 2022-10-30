package book_sale_question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class BookSale {
    public static int nthLowestSelling(int[] sales, int n) {
        HashMap<Integer, Integer> countsMap = new HashMap<Integer, Integer>();
        for (int x : sales) {
            Integer c = countsMap.get(x);
            if (c == null) {
                c = 0;
            }
            countsMap.put(x, ++c);
        }
        ArrayList<Map.Entry<Integer, Integer>> countsList = new ArrayList<Map.Entry<Integer, Integer>>(countsMap.entrySet());
        Collections.sort(countsList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return b.getValue().compareTo(a.getValue());
            }
        });
        return countsList.get(countsList.size() - n).getKey();
    }
}
