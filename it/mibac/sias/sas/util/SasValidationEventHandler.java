package it.mibac.sias.sas.util;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.apache.log4j.Logger;

public class SasValidationEventHandler implements ValidationEventHandler
{
	private static Logger log;
	
	public SasValidationEventHandler()
	{
		log = Logger.getLogger("VALIDATE");
	}
	
	public boolean handleEvent(ValidationEvent event)
	{
		log.info(event.getLocator().getObject().getClass().getName() + ": " + event.getMessage());
		return true;
	}
}