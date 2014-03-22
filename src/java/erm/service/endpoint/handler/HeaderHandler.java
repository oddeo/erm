package erm.service.endpoint.handler;

import java.util.Set;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * @version 1.0
 * @author danieljones
 */
public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {
    
    @Override
    public Set getHeaders() {
        return null;
    }
    
    @Override
    public boolean handleMessage(SOAPMessageContext ctx) {
        
        // determine if this is an outbound request
        Boolean isRequest = (Boolean)ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        
        if(isRequest) {
            
            try {
                
              SOAPMessage msg = ctx.getMessage();
              SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
              SOAPHeader header = env.getHeader();
              
              // since header is not required, we might need to add one if its null
              if(header == null) {
                  
                  header = env.addHeader();
                  
              }
              
              QName name = new QName("http://endpoint.service.erm/", "valid-user");
              SOAPHeaderElement el = header.addHeaderElement(name);
              el.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
              
              // fake valid user to demonstrate how this might work
              String validationMsg = validUser("mr_sprinkles");
              el.addTextNode(validationMsg);
              msg.saveChanges();          
              
            
            } catch (SOAPException ex) {
                
                Logger.getLogger(HeaderHandler.class.getName()).log(
                  Level.SEVERE, null, ex);
                
            }
            
            
        }
        
        return true; // continue the chain
    }
    
    @Override
    public boolean handleFault(SOAPMessageContext messageContext) {

        Logger.getLogger(HeaderHandler.class.getName()).log(
            Level.WARNING, "Fault!");
        
        return true;        
        
    }
    
    @Override
    public void close(MessageContext context) {
        
        Logger.getLogger(HeaderHandler.class.getName()).log(Level.INFO, "closed");        
        
    }
    
    
    private static String validUser(String userName) {
        
        String message = userName + " is not a valid user"; 
        
        if(userName.equals("mr_sprinkles")) {
            
            message = userName + " is a valid user";
            
        }
                
        return message;
        
    }
    
}
