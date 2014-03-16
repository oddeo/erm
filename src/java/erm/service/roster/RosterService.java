package erm.service.roster;

import erm.model.domain.Employee;
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
public interface RosterService {
    
    @WebMethod public Employee getEmployee(long id);
    @WebMethod public List<Employee> getMyRoster(long leaderId);
    @WebMethod public boolean setManager(Employee employee);
    @WebMethod public long createEmployee(Employee employee);
    @WebMethod public boolean deleteEmployee(long id);
    
}
