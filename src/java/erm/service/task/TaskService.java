package erm.service.task;

import erm.model.domain.Task;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * @version 1.0
 * @author danieljones
 */
@WebService
@SOAPBinding(style=Style.DOCUMENT)
public interface TaskService {
    
    @WebMethod public Task getTask(long id);
    @WebMethod public List<Task> getAllTasks();
    @WebMethod public boolean saveTask(Task task);
    @WebMethod public long createTask(Task task);
    @WebMethod public boolean deleteTask(long id);
    
}
