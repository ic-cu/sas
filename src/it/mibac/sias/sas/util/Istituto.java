package it.mibac.sias.sas.util;

public class Istituto
{
	private String fonte;
	private int id;
	private String ISAD;

	public Istituto(int id, String fonte, String ISAD)
	{
		this.id = id;
		this.fonte = fonte;
		this.ISAD = ISAD;
	}
	
	public Istituto()
	{
	}

	public String getFonte()
	{
		return fonte;
	}
	
	public void setFonte(String fonte)
	{
		this.fonte = fonte;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getISAD()
	{
		return ISAD;
	}
	
	public void setISAD(String iSAD)
	{
		ISAD = iSAD;
	}
}
