package ceramic_store_question;

import java.util.*;

public class CeramicStore {
    public static void runAndWait(List<Runnable> runnables) {
        List<Thread> threads = new ArrayList<>();
        for (Runnable runnable : runnables) {
            Thread thread = new Thread(runnable);
            thread.start();

            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (Exception e) {
            }
        }
    }
}
