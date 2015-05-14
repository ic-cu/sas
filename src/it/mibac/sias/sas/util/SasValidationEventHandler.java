package it.mibac.sias.sas.util;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.apache.log4j.Logger;

public class SasValidationEventHandler implements ValidationEventHandler
{
	private Logger log;
	
	public SasValidationEventHandler()
	{
		log = Logger.getLogger("LOG");
	}
	
	public boolean handleEvent(ValidationEvent event)
	{
		log.info(event.getLocator().getObject().getClass().getName() + ": " + event.getMessage());
/*
		log.info("\nEVENT"
      + "SEVERITY:  " + event.getSeverity()
      + "MESSAGE:  " + event.getMessage()
      + "LINKED EXCEPTION:  " + event.getLinkedException()
    	+ "LOCATOR"
    	+ "    LINE NUMBER:  " + event.getLocator().getLineNumber()
    	+ "    COLUMN NUMBER:  " + event.getLocator().getColumnNumber()
    	+ "    OFFSET:  " + event.getLocator().getOffset()
    	+ "    OBJECT:  " + event.getLocator().getObject()
    	+ "    NODE:  " + event.getLocator().getNode()
    	+ "    URL:  " + event.getLocator().getURL());
*/
		return true;
	}
}