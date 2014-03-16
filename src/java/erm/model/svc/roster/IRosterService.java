package erm.model.svc.roster;

import erm.model.domain.Employee;
import erm.model.svc.IService;
import java.util.List;

/**
 * @version 1.0
 * @author danieljones
 */
public interface IRosterService extends IService {
    
	/** NAME constant is looked up during call to getService from ServiceFactory */	
	public final String NAME = "IRosterService";
    
    public Employee getEmployee(long id);
    public List<Employee> getMyRoster(long leaderId);
    public boolean setManager(Employee employee);
    public long createEmployee(Employee employee);
    public boolean deleteEmployee(long id);
    
}
