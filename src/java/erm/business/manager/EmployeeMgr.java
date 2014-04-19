package erm.business.manager;

import erm.domain.Employee;
import java.util.List;

/**
 * @version 1.0
 * @author danieljones
 */
public interface EmployeeMgr {
    
    public Employee create(Employee emp);
    public Employee read(int id);
    public List<Employee> readAll();
    public Employee update(Employee emp);
    public void delete(Employee emp);
    
}
