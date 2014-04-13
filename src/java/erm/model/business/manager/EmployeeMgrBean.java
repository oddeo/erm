package erm.model.business.manager;

import erm.model.domain.Employee;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;

/**
 * @version 1.0
 * @author danieljones
 */
@ManagedBean
public class EmployeeMgrBean implements EmployeeMgr {
    
    @PersistenceUnit(unitName="ERMPU")
    EntityManagerFactory emf;
    
    @PersistenceContext(unitName="ERMPU")
    EntityManager em;
    
    @Resource
    UserTransaction utx;

    @Override
    public Employee create(Employee emp) {
        
        em = emf.createEntityManager();
        
        try {
            
            utx.begin();
            em.persist(emp);
            utx.commit();
            
        } catch (Exception e) {
            
            Logger.getLogger(
                    EmployeeMgrBean.class.getName())
                    .log(Level.SEVERE, null, e);
            
            try {
                
                utx.rollback();
                
            } catch (IllegalStateException | SecurityException | SystemException ex) {
                
                Logger.getLogger(
                        EmployeeMgrBean.class.getName())
                        .log(Level.SEVERE, null, e);
                
            }
            
        }
        
        return emp;
        
    }

    @Override
    public Employee read(int id) {
        
        em = emf.createEntityManager();
        Employee employee = em.find(Employee.class, id);
        
        return employee;
        
    }
    
    @Override
    public List<Employee> readAll() {
        
        em = emf.createEntityManager();
        TypedQuery<Employee> query =
              em.createQuery("SELECT e FROM Employee e", Employee.class);
          List<Employee> results = query.getResultList();
        return results;
        
    }

    @Override
    public Employee update(Employee emp) {
        
        em = emf.createEntityManager();
        Employee returnEmp = new Employee();
        
        try {
            
            utx.begin();
            returnEmp = em.merge(emp);
            utx.commit();
            
        } catch (Exception e) {
            
            Logger.getLogger(
                    EmployeeMgrBean.class.getName())
                    .log(Level.SEVERE, null, e);
            
            try {
                
                utx.rollback();
                
            } catch (IllegalStateException | SecurityException | SystemException ex) {
                
                Logger.getLogger(
                        EmployeeMgrBean.class.getName())
                        .log(Level.SEVERE, null, e);
                
            }
            
        }
        
        return returnEmp;
        
    }

    @Override
    public void delete(Employee emp) {
        
        em = emf.createEntityManager();
        
        try {
            
            utx.begin();
            em.remove(em.merge(emp));
            utx.commit();
            
        } catch (Exception e) {
            
            Logger.getLogger(
                    EmployeeMgrBean.class.getName())
                    .log(Level.SEVERE, null, e);
            
            try {
                
                utx.rollback();
                
            } catch (IllegalStateException | SecurityException | SystemException ex) {
                
                Logger.getLogger(
                        EmployeeMgrBean.class.getName())
                        .log(Level.SEVERE, null, e);
                
            }
            
        }
        
    }
    
}
