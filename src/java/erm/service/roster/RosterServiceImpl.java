package erm.service.roster;

import erm.model.domain.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 * @version 1.0
 * @author danieljones
 */
@WebService(endpointInterface="erm.service.roster.RosterService")
public class RosterServiceImpl implements RosterService {

    @Override
    public Employee getEmployee(long id) {
        
        return new Employee("first","last","manager");
        
    }

    @Override
    public List<Employee> getMyRoster(long leaderId) {
        
        Employee e1 = new Employee("danny", "jones", "manager1");
        Employee e2 = new Employee("davy", "jones", "manager2");
        List<Employee> eList = new ArrayList<>();
        eList.add(e1);
        eList.add(e2);
        
        return eList;
        
    }

    @Override
    public boolean setManager(Employee employee) {
       
        return true;
        
    }

    @Override
    public long createEmployee(Employee employee) {
        
        return 1L;  
        
    }

    @Override
    public boolean deleteEmployee(long id) {
        
        return true;
        
    }
    
}
