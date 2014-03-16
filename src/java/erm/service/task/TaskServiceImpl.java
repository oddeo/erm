package erm.service.task;

import erm.model.domain.Task;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 * @version 1.0
 * @author danieljones
 */
@WebService(endpointInterface="erm.service.task.TaskService")
public class TaskServiceImpl implements TaskService {

    @Override
    public Task getTask(long id) {
        
        return new Task("get task", "danny jones");
        
    }

    @Override
    public List<Task> getAllTasks() {
        
        Task t1 = new Task("task1", "danny");
        Task t2 = new Task("task2", "jones");
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
