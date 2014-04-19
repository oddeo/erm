package erm.business.exception;

import javax.persistence.RollbackException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * @version 1.0
 * @author danieljones
 */
public class RollbackMapper
    implements ExceptionMapper<RollbackException> {

    @Override
    public Response toResponse(RollbackException exception) {
        
        return Response.status(Response.Status.CONFLICT).build();
        
    }
    
}
