package erm.service.endpoint;

import erm.model.domain.Interaction;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * Service Implementation Bean
 * @version 1.0
 * @author danieljones
 */
@WebService
@SOAPBinding(style=Style.DOCUMENT)
public interface InteractionService {
    
    @WebMethod public Interaction getInteraction(long id);
    @WebMethod public List<Interaction> getAllInteractions();
    @WebMethod public boolean saveInteraction(Interaction interaction);
    @WebMethod public long createInteraction(Interaction interaction);
    @WebMethod public boolean deleteInteraction(long id);
    
}
