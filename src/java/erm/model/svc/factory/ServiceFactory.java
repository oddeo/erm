package erm.model.svc.factory;

import erm.model.business.exception.ServiceLoadException;
import erm.model.svc.IService;

/**
 * ServiceFactory design as singleton using the Service Locator pattern, which
 * looks up the service name, and instantiates it using reflection
 *
 * @author Daniel.Jones
 *
 */
public class ServiceFactory implements IService {

    /**
     * Implement as Singleton
     */
    private ServiceFactory() {
    }
    private static final ServiceFactory serviceFactory = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return serviceFactory;
    }

    /**
     * @param serviceName: name of the service to pull back
     * @return IService : new instance of IService using reflection to lookup
     * class name
     * @throws erm.model.business.exception.ServiceLoadException
     */
    public IService getService(String serviceName) throws ServiceLoadException {

        try {
            Class<?> c = Class.forName(getImplName(serviceName));
            return (IService) c.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServiceLoadException(serviceName + " not loaded");
        }

    }

    /**
     * TODO: PropertyManager is not returning values from the file. Hardcoding
     * factory here is temp
     *
     * @return String : name of service pulled from properties file in config
     * folder
     */
    private String getImplName(String serviceName) {

    //PropertyManager.loadProperties();
        //return PropertyManager.getPropertyValue(serviceName);
        String impl;

        switch (serviceName) {

            case "ICommentService":
                impl = "erm.model.svc.comment.CommentServiceImpl";
                break;
            case "ITaskService":
                impl = "erm.model.svc.task.TaskServiceImpl";
                break;
            case "IRosterService":
                impl = "erm.model.svc.roster.RosterServiceImpl";
                break;
            default:
                impl = null;
                break;
        }

        return impl;
    }
}
