package it.mibac.sias.sas.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class TestDate
{

	public static void main(String[] args)
	{
		XMLGregorianCalendar xgc = null;
		try
		{
			GregorianCalendar gc = new GregorianCalendar();
			xgc = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH) + 1, gc.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
		}
		catch(DatatypeConfigurationException e)
		{
			e.printStackTrace();
		}
		xgc.normalize();
		System.out.println(xgc.toString());
	}
}
