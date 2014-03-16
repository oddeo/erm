package erm.model.svc.task;

import erm.model.domain.Author;
import erm.model.domain.Task;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author danieljones
 */
public class TaskServiceImpl implements ITaskService {

    @Override
    public Task getTask(long id) {

        return new Task("get task", new Author("danny", "jones", "djones"));

    }

    @Override
    public List<Task> getAllTasks() {

        Task t1 = new Task("task1", new Author("danny", "jones", "djones"));
        Task t2 = new Task("task2", new Author("danny", "jones", "djones"));
        List<Task> tList = new ArrayList<>();
        tList.add(t1);
        tList.add(t2);

        return tList;

    }

    @Override
    public boolean saveTask(Task task) {

        return true;

    }

    @Override
    public long createTask(Task task) {

        return 1L;

    }

    @Override
    public boolean deleteTask(long id) {

        return true;

    }

}
