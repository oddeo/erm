package erm.model.business.manager;

import erm.model.business.exception.ServiceLoadException;
import erm.model.svc.IService;
import erm.model.svc.factory.ServiceFactory;

/**
 * Manager Super Type - Base class for all Business Tier Managers
 *
 * @author Daniel.Jones
 * @version 1.0
 */
public abstract class Manager {

    private ServiceFactory _factory = ServiceFactory.getInstance();

    /**
     * TODO: PropertyManager is not pulling from the correct file Static block
     * loads properties file first
     */
    /* static { Manager.loadProperties(); } */
    /**
     * Only intended to be used by children in the inheritance model
     *
     * @param serviceName : name of the service key for impl lookup
     * @return IService : generic version of the service matching the
     * serviceName key
     * @throws ServiceLoadException : if unable to find a service matching the
     * serviceName key
     */
    protected IService getService(String serviceName) throws ServiceLoadException {

        return _factory.getService(serviceName);

    }

    /**
     * TODO: PropertyManager is not pulling from the correct file Pass in the
     * property file location to the Property Manager and load the file
     */
    /* public static void loadProperties() {
     try {
        
     PropertyManager.loadProperties();
      
     } catch (PropertyFileNotFoundException e) {
        
     System.out.println("Application Exiting : Unable to locate the properties file");
     System.out.println(e.getMessage());
     System.exit(1);
      
     }
     } */
}
