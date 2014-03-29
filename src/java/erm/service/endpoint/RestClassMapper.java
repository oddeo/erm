package erm.service.endpoint;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Map classes for rest service
 * @version 1.0
 * @author danieljones
 */
@ApplicationPath("/rest")
public class RestClassMapper extends Application {
    
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(EmployeeResource.class);
        classes.add(InteractionResource.class);
        return classes;
    }
    
}
