package ceramic_store_question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CeramicStoreTest {
    @Test
    public void testRunAndWait_ExampleCaseTest_Successful() {
        final String[] result = {""};
        List<Runnable> runnables = Arrays.asList(() -> {
            try {
                Thread.sleep(800);
                result[0] = result[0] + "Slow";
            } catch (Exception e) {
            }
        }, () -> {
            try {
                Thread.sleep(100);
                result[0] = result[0] + "Fast";
            } catch (Exception e) {
            }
        });
        CeramicStore.runAndWait(runnables);
        Assertions.assertEquals(result[0], "FastSlow");
    }

    @Test
    public void testRunAndWait_TheMethodBlocksUntilAllRunnablesAreFinished_Successful() throws InterruptedException {
        List<Runnable> runnables = Arrays.asList(() -> {
            try {
                Thread.sleep(800);
            } catch (Exception e) {
            }
        }, () -> {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        });
        Thread thread = new Thread(()->{
            CeramicStore.runAndWait(runnables);
        });
        thread.start();
        Thread.sleep(1000);
        Assertions.assertEquals(Thread.State.TERMINATED, thread.getState());
    }

    @Test
    public void testRunAndWait_TheRunnablesAreRunInParallel_Successful() {
        final String[] result = {""};
        List<Runnable> runnables = Arrays.asList(() -> {
            try {
                Thread.sleep(100);
                result[0] = result[0] + "Thread";
            } catch (Exception e) {
            }
        }, () -> {
            try {
                Thread.sleep(100);
                result[0] = result[0] + "Thread";
            } catch (Exception e) {
            }
        });
        CeramicStore.runAndWait(runnables);
        Assertions.assertEquals(result[0], "Thread");
    }
}
