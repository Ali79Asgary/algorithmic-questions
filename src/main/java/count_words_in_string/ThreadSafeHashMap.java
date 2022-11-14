package count_words_in_string;

import java.util.Collections;
import java.util.HashMap;

public class ThreadSafeHashMap {
    static HashMap<Integer, String> hashMap = null;

    public static void main(String[] args) {
        // This is a thread_safe hashmap.
        hashMap = (HashMap<Integer, String>) Collections.synchronizedMap(new HashMap<Integer, String>());
    }
}
