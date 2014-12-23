package it.mibac.sias.sas.spring;

import it.beniculturali.sas.catalogo.sogp.DSogp;

import java.util.Iterator;

/*
 * Classe wrapper attorno ad un DSogc. Non aggiunge quasi niente a DSogc, ma reimplemente alcuni dei
 * metodi di DSogc in modo che accettino tipi primitivi. Viene così nascosta la complessità di certe
 * chiamate, così da rendere il codice invocante più pulito
 */
public interface DSogpDao
{
	public Iterator<DSogp> getAllDSogp(int idIstituto);
}