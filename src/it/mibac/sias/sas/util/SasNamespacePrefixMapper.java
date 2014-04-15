package it.mibac.sias.sas.util;

import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class SasNamespacePrefixMapper extends NamespacePrefixMapper
{

	private Map<String, String> mapping;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sun.xml.bind.marshaller.NamespacePrefixMapper#getPreferredPrefix(java
	 * .lang. String, java.lang.String, boolean)
	 */
	@Override
	public String getPreferredPrefix(final String namespaceUri,
			final String suggestion, final boolean requirePrefix)
	{

		String prefix = null;
		if(namespaceUri == null || namespaceUri.equals(""))
		{
			prefix = "";
		}
		if(mapping != null) for(String uri : mapping.keySet())
		{
			//System.err.println(uri);
			if(namespaceUri.equalsIgnoreCase(uri))
			{
				prefix = mapping.get(uri);
				break;
			}
		}
		if(prefix == null)
		{
			prefix = suggestion;
		}
		return prefix;
	}

	public final void setMapping(Map<String, String> mapping)
	{
		this.mapping = mapping;
	}

	public final void setMapping(Properties prop)
	{
		if(prop != null)
		{
			this.mapping = new Hashtable<String, String>();
 			for(Object uri : prop.keySet())
			{
				// String val = prop.getProperty((String) uri);
				// System.err.println((String) uri + " " + val);
				// this.mapping.put((String) uri, val);
				this.mapping.put((String) uri, prop.getProperty((String) uri));
			}
		}
	}

}