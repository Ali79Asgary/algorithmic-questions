package worker_question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WorkerTest {
    @Test
    public void testAcquireTaskResource_withOneTaskResource_Successful() {
        Worker worker = new Worker();
        Worker.TaskResource taskResource = worker.acquireTaskResource(0);
        Iterable<Worker.TaskResource> taskResourceIterable = worker.getTaskResources();
        Assertions.assertEquals(taskResource, taskResourceIterable.iterator().next());
    }

    @Test
    public void testAcquireTaskResource_withSeveralTaskResource_Successful() {
        Worker worker = new Worker();
        int[] array = createArray(10);
        List<Worker.TaskResource> taskResourceList = new ArrayList<>();
        for (Integer id : array) {
            Worker.TaskResource taskResource = worker.acquireTaskResource(id);
            taskResourceList.add(taskResource);
        }
        Iterable<Worker.TaskResource> taskResourceIterable = worker.getTaskResources();
        Assertions.assertEquals(taskResourceList.get(0), taskResourceIterable.iterator().next());
    }

    @Test
    public void testReleaseTaskResource_withoutTaskResource_throwIllegalArgumentException() {
        Worker worker = new Worker();
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            worker.releaseTaskResource(0);
        });
    }

    @Test
    public void testReleaseTaskResource_withOneTaskResource_throwIllegalArgumentException() {
        Worker worker = new Worker();
        Worker.TaskResource taskResource = worker.acquireTaskResource(0);
        worker.releaseTaskResource(0);
        Iterable<Worker.TaskResource> taskResourceIterable = worker.getTaskResources();
        Assertions.assertFalse(taskResourceIterable.iterator().hasNext());
    }

    @Test
    public void testReleaseTaskResource_withSeveralTaskResource_Successful() {
        Worker worker = new Worker();
        int[] array = createArray(10);
        List<Worker.TaskResource> taskResourceList = new ArrayList<>();
        for (Integer id : array) {
            Worker.TaskResource taskResource = worker.acquireTaskResource(id);
            taskResourceList.add(taskResource);
        }
        for (Integer id : array) {
            worker.releaseTaskResource(id);
        }
        Iterable<Worker.TaskResource> taskResourceIterable = worker.getTaskResources();
        Assertions.assertFalse(taskResourceIterable.iterator().hasNext());
    }

    private int[] createArray(int arraySize) {
        return IntStream.rangeClosed(1, arraySize).toArray();
    }
}
