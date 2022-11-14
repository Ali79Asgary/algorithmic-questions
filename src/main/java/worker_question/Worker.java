package worker_question;

import java.util.*;
import java.util.HashMap;

public class Worker {
    private HashMap<Integer, TaskResource> taskResources = new HashMap<Integer, TaskResource>();

    public Iterable<TaskResource> getTaskResources() {
        return this.taskResources.values();
    }

    public TaskResource acquireTaskResource(int id) {
        TaskResource w = this.taskResources.getOrDefault(id, null);
        if (w == null) {
            w = new TaskResource(id);
            this.taskResources.put(id, w);
        }

        return w;
    }

    public void releaseTaskResource(int id) {
        TaskResource w = this.taskResources.getOrDefault(id, null);
        if (w == null)
            throw new IllegalArgumentException();

        w.close();
        this.taskResources.remove(id);
    }

    public class TaskResource implements AutoCloseable {
        private List<String> taskList = new ArrayList<String>();

        private int id;

        public int getId() {
            return this.id;
        }

        public List<String> getTasks() {
            return this.taskList;
        }

        public TaskResource(int id) {
            this.id = id;
        }

        public void doTask(String task) {
            if (this.taskList == null)
                throw new IllegalStateException(this.getClass().getName());

            this.taskList.add(task);
        }

        @Override
        public void close() {
            this.taskList = null;
        }
    }
}
