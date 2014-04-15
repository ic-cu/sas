package it.mibac.sias.sas.util;

/*
 * Un numero di telefono, o fax, che sia in grado di convertire numeri scritti
 * male in numeri aderenti al pattern richiesto da SAS.
 */
public class TelefonoSas
{
	private String numero;

	/*
	 * costruisce un numero valido secondo SAS partendo da una stringa qualunque;
	 * ovviamente fa quello che può nei casi plausibili
	 */
	public TelefonoSas(String s)
	{
		numero = null;
		if(s != null)
		{
			// si rimuovono eventuali spazi, interni ed esterni
			numero = s.replaceAll(" ", "");
			// si rimuove il "+39." iniziale, ma anche il solo "+39"
			numero = numero.replaceFirst("\\+39\\.", "");
			numero = numero.replaceFirst("\\+39", "");
			// si rimuovonon eventuali "Direttore", "Segreteria"...
			numero = numero.replaceAll("[A-Za-z]+", "");
			/*
			 * si divide la stringa su alcuni caratteri plausibili, ma non essendo
			 * ripetibile il telefono nei flussi SAS, si conserva solo la prima
			 * componente; ovviamente se i caratteri in questione non sono presenti,
			 * l'operazione è ignorata; inoltre se la prima componente è troppo corta,
			 * si prende anche la seconda (la cosa funziona grazie ai passi
			 * precedenti, e solo nei casi presenti in Sias ad oggi)
			 */
			String[] temp = numero.split("[-_,;.:/\\\\+]");
			if(temp.length != 0)
			{
				if(temp.length == 1)
				{
					numero = temp[0];
				}
				else if(temp[0].length() < 5)
				{
					numero = temp[0] + temp[1];
				}
				else
				{
					numero = temp[0];
				}
			}
			if(numero.length() < 5) numero = null;
		}
	}

	public String getNumero()
	{
		return numero;
	}
}
