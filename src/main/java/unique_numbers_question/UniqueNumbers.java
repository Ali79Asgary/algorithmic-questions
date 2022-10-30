package unique_numbers_question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class UniqueNumbers {
    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
        HashMap<Integer, Integer> countNumbers = new HashMap<>();

        for (int number : numbers) {
            int count = countNumbers.containsKey(number) ? countNumbers.get(number) : 0;
            countNumbers.put(number, count + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (HashMap.Entry<Integer, Integer> numberCount : countNumbers.entrySet())
            if (numberCount.getValue() == 1)
                result.add(numberCount.getKey());

        return result;
    }
}
