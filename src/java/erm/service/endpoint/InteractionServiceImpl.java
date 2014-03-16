package erm.service.endpoint;

import erm.model.business.manager.InteractionManager;
import erm.model.domain.Interaction;
import java.util.List;
import javax.jws.WebService;


/**
 * Service Endpoint Implementation
 * @version 1.0
 * @author danieljones
 */
@WebService(endpointInterface="erm.service.endpoint.InteractionService")
public class InteractionServiceImpl implements InteractionService {
    
    //Static InteractionManager
    InteractionManager iMgr = InteractionManager.getInstance();

    @Override
    public Interaction getInteraction(long id) {
        
        return iMgr.getInteraction(id);
        
    }

    @Override
    public List<Interaction> getAllInteractions() {
        
        return iMgr.getAllInteractions();
        
    }

    @Override
    public boolean saveInteraction(Interaction interaction) {
        
        return iMgr.saveInteraction(interaction);
        
    }

    @Override
    public long createInteraction(Interaction interaction) { 
        
        return iMgr.createInteraction(interaction);
        
    }

    @Override
    public boolean deleteInteraction(long id) {
        
        return iMgr.deleteInteraction(id);
        
    } 
    
}
