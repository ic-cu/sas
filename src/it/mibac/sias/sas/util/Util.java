package it.mibac.sias.sas.util;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public final class Util
{
	public static XMLGregorianCalendar stringToXGC(String s)
			throws DatatypeConfigurationException, IllegalArgumentException, SiasSasException
	{
		int aa = 0;
		int mm = 0;
		int dd = 0;
		XMLGregorianCalendar xgc = null;
		if(s != null)
		{
			// Anno dal 1000
			if(s.length() == 8)
			{
				aa = Integer.parseInt(s.substring(0, 4));
				mm = Integer.parseInt(s.substring(4, 6));
				dd = Integer.parseInt(s.substring(6, 8));
			}
			// Anno prima del 1000
			else if(s != null && s.length() == 7)
			{
				aa = Integer.parseInt(s.substring(0, 3));
				mm = Integer.parseInt(s.substring(3, 5));
				dd = Integer.parseInt(s.substring(5, 7));
			}
			else
			{
				SiasSasException ee;
				ee = new SiasSasException("data non valida");
				throw ee;
// log.warn("date_estremo_remoto = " + s + ", il complesso sarà scartato");
			}
		}
		else
		{
			SiasSasException ee;
			ee = new SiasSasException("data nulla");
			throw ee;
// log.warn("date_estremo_remoto nullo, il complesso sarà scartato");
		}
		DatatypeFactory dtf = DatatypeFactory.newInstance();
		int tz = DatatypeConstants.FIELD_UNDEFINED;
		xgc = dtf.newXMLGregorianCalendarDate(aa, mm, dd, tz);
		return xgc;
	}


}
