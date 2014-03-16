package erm.model.svc.task;

import erm.model.domain.Task;
import erm.model.svc.IService;
import java.util.List;

/**
 * @version 1.0
 * @author danieljones
 */
public interface ITaskService extends IService {
    
	/** NAME constant is looked up during call to getService from ServiceFactory */	
	public final String NAME = "ITaskService";
    
    public Task getTask(long id);
    public List<Task> getAllTasks();
    public boolean saveTask(Task task);
    public long createTask(Task task);
    public boolean deleteTask(long id);
    
}
