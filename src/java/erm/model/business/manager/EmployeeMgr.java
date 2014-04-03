package erm.model.business.manager;

import erm.model.domain.Employee;

/**
 * @version 1.0
 * @author danieljones
 */
public interface EmployeeMgr {
    
    public Employee create(Employee emp);
    public Employee read(int id);
    public Employee update(Employee emp);
    public void delete(Employee emp);
    
}
