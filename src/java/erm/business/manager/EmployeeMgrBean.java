package erm.business.manager;

import erm.domain.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 * @version 1.0
 * @author danieljones
 */
@Stateless
public class EmployeeMgrBean implements EmployeeMgr {
    
    @PersistenceContext(unitName="ERMPU")
    EntityManager em;
    
    public EmployeeMgrBean(){}
    
    public EmployeeMgrBean(EntityManager em) {
        
        this.em = em;
        
    }

    @Override
    public Employee create(Employee emp) {

        em.persist(emp);
        
        return emp;
        
    }

    @Override
    public Employee read(int id) {

        Employee employee = em.find(Employee.class, id);
        
        return employee;
        
    }
    
    @Override
    public List<Employee> readAll() {

        TypedQuery<Employee> query =
              em.createQuery("SELECT e FROM Employee e", Employee.class);
          List<Employee> results = query.getResultList();
        return results;
        
    }

    @Override
    public Employee update(Employee emp) {
        
        return em.merge(emp);
        
    }

    @Override
    public void delete(Employee emp) {

        em.remove(em.merge(emp));
        
    }
    
}
