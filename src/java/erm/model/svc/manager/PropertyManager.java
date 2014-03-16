package erm.model.svc.manager;

import erm.model.business.exception.PropertyFileNotFoundException;
import erm.model.business.manager.Manager;
import java.io.*;
import java.util.*;
import java.util.logging.Level;

/**
 * TODO: Loading the properties file he is not working and causing breaks upstream
 * -- As a result, I hard coded a switch the serves up the service impl in the Service Factory 
 * -- this is temporary until I can figure out what is happening here
 * Load properties a single time from a properties file
 * Allow properties to be accessed from business and service tier from this manager
 * @author Daniel.Jones
 */
public class PropertyManager {
	
	private static Properties _properties;
        private static final String propertyFilePath = "/Users/danieljones/NetBeansProjects/erm/src/conf/application.properties";

		
        public static void loadProperties() {
           
          try {
            //Properties sysProps = System.getProperties();
            //String propertyFilePath;            
            //propertyFilePath = sysProps.getProperty("property_file_location"); 
            loadProperties(propertyFilePath);
          } catch (PropertyFileNotFoundException pfnfe) {
              
              java.util.logging.Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, pfnfe);
              
          }
           
            
        }       
        
    public static void loadProperties(String propertyFileLocation) throws PropertyFileNotFoundException {
            
		// using try-with-resources statement : no final or explicit close of fis required
		try (FileInputStream fis = new FileInputStream(propertyFileLocation)){
			_properties = new Properties();
			_properties.load(fis);	
		}
	  catch (FileNotFoundException fnfe) 
		{
        
      System.out.println(fnfe.getMessage());
	  	throw new PropertyFileNotFoundException ("Property File was not found at the specified location", fnfe);
      
		}	  
	  catch (IOException ioe)
	  {
        
      System.out.println(ioe.getMessage());
	  	throw new PropertyFileNotFoundException ("IOException while loading Properties file", ioe);	    	
      
	  }
	  catch (Exception e) 
	  {
        
	  	System.out.println(e.getMessage());
	  	throw new PropertyFileNotFoundException ("Exception while loading Properties file", e);	
      
	  }
	}
	
	/**
	 * This methods returns the Value for the passed key.
	 * @param key - key whose value needs to be returned
	 * @return String - value for the passed key
	 */
    static public String getPropertyValue (String key)
    {
    	return _properties.getProperty(key);	
    }
	
}
