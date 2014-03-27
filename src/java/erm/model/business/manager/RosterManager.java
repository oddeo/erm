package erm.model.business.manager;

import erm.model.business.exception.ServiceLoadException;
import erm.model.domain.Employee;
import erm.model.svc.roster.IRosterService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Business Manager : facade handles the processing of question work flow for
 * presentation tier 1. Loads properties file using the PropertyManager 2.
 * Executes work flow of the application using services and domain value objects
 *
 * @author Daniel.Jones
 * @version 1.0
 */
public class RosterManager extends Manager implements IRosterService {

    private static RosterManager _managerInstance;
    private static final String FATAL_ERR_MSG = "Fatal Error : Roster Service failed to load";


    /**
     * Implements the singleton pattern
     *
     * @return InteractionManager : a single instance | new only if currently
     * null
     */
    public static synchronized RosterManager getInstance() {
        if (_managerInstance == null) {
            _managerInstance = new RosterManager();
        }
        return _managerInstance;
    }

    /**
     * Get employee by id
     * @param id
     * @return Employee
     */
    @Override
    public Employee getEmployee(long id) {
        
        Employee employee = new Employee();

        try {

            IRosterService rosterService = (IRosterService) getService(IRosterService.NAME);
            employee = rosterService != null ? rosterService.getEmployee(id) : null;

        } catch (ServiceLoadException sle) {

            Logger.getLogger(FATAL_ERR_MSG).
                    log(Level.SEVERE, null, sle);

            System.exit(1);

        }

        return employee;        
        
    }

    /**
     * get a leaders team roster by their leader id
     * @param leaderId
     * @return list of employees, i.e. team leader's roster
     */
    @Override
    public List<Employee> getMyRoster(long leaderId) {
        
        List<Employee> roster = new ArrayList<>();

        try {

            IRosterService rosterService = (IRosterService) getService(IRosterService.NAME);
            roster = rosterService != null ? rosterService.getMyRoster(1) : null;


        } catch (ServiceLoadException sle) {

            Logger.getLogger(FATAL_ERR_MSG).
                    log(Level.SEVERE, null, sle);

            System.exit(1);

        }

        return roster;        
        
    }

    /**
     * save updates to an existing employee
     * @param employee
     * @return result of save: true = success
     */
    @Override
    public boolean saveEmployee(Employee employee) {
        
        boolean result = false;

        try {

            IRosterService rosterService = (IRosterService) getService(IRosterService.NAME);
            result = rosterService != null ? rosterService.saveEmployee(employee) : null;


        } catch (ServiceLoadException sle) {

            Logger.getLogger(FATAL_ERR_MSG).
                    log(Level.SEVERE, null, sle);

            System.exit(1);

        }

        return result;         
        
    }

    /**
     * create a new employee
     * @param employee
     * @return new employee id
     */
    @Override
    public long createEmployee(Employee employee) {
        
        long newId = 0L;

        try {

            IRosterService rosterService = (IRosterService) getService(IRosterService.NAME);
            newId = rosterService != null ? rosterService.createEmployee(employee) : null;


        } catch (ServiceLoadException sle) {

            Logger.getLogger(FATAL_ERR_MSG).
                    log(Level.SEVERE, null, sle);

            System.exit(1);

        }

        return newId;         
        
    }

    /**
     * delete an existing employee by id
     * @param id
     * @return result of delete: true = success
     */
    @Override
    public boolean deleteEmployee(long id) {
        
        boolean result = false;

        try {

            IRosterService rosterService = (IRosterService) getService(IRosterService.NAME);
            result = rosterService != null ? rosterService.deleteEmployee(id) : null;


        } catch (ServiceLoadException sle) {

            Logger.getLogger(FATAL_ERR_MSG).
                    log(Level.SEVERE, null, sle);

            System.exit(1);

        }

        return result;           
        
        
    }

}
