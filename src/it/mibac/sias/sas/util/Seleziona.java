package it.mibac.sias.sas.util;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;

import org.apache.log4j.Logger;

public class Seleziona
{

	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	private Panel checkPanel;
	private Panel okPanel;
	private Button showButton;
	private List list;
	private CheckboxGroup cbg;
	private Panel listPanel;
	private Logger log;

	public Seleziona(Iterator<String> items)
	{
		log = Logger.getLogger("LOG");
		list = new List(10, false);
		prepareGUI();
		while(items.hasNext())
		{
			String str = items.next();
			log.trace(str);
			list.add(str);
		}
	}

	public Seleziona(String[] items)
	{
		prepareGUI();
		list = new List(items.length, false);
		for(String str : items)
		{
			log.trace(str);
			list.add(str);
		}
	}

	private void prepareGUI()
	{
		mainFrame = new Frame("Esportazione SIAS-SAS");
		mainFrame.setSize(600, 600);
//		mainFrame.setLayout(new GridLayout(2, 1));
		mainFrame.setLayout(new BorderLayout());
		mainFrame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent windowEvent)
			{
				System.exit(0);
			}
		});
		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);
		statusLabel = new Label();
		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setSize(300, 100);

// pannello con una lista e le checkbox		
		
		controlPanel = new Panel();
		controlPanel.setLayout(new GridLayout(1, 2));
//		controlPanel.setSize(600, 400);
		mainFrame.add(controlPanel);

// sotto-pannello con la lista
		
		listPanel = new Panel();
		listPanel.setLayout(new GridLayout(1, 1));
//		listPanel.setSize(300, 400);
		listPanel.add(list);
		controlPanel.add(listPanel);

// sotto-pannello con le checkbox		
		
		checkPanel = new Panel();
		checkPanel.setLayout(new GridLayout(6, 1));
//		checkPanel.setSize(300, 400);
		cbg = new CheckboxGroup();
		checkPanel.add(new Checkbox("soggetti conservatori", cbg, true));
		checkPanel.add(new Checkbox("soggetti produttori", cbg, false));
		checkPanel.add(new Checkbox("complessi archivistici", cbg, false));
		checkPanel.add(new Checkbox("relazioni conservatori-complessi", cbg, false));
		checkPanel.add(new Checkbox("relazioni produttori-complessi", cbg, false));
		controlPanel.add(checkPanel);

// pannello per il bottone ok		
		
		okPanel = new Panel();
		okPanel.setLayout(new GridLayout(1, 1));
		okPanel.setSize(600, 600);
		showButton = new Button("OK");
		okPanel.add(showButton);
		checkPanel.add(showButton);
//		mainFrame.add(okPanel, BorderLayout.SOUTH);

//		mainFrame.add(headerLabel);
//		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
		
	}

	public void showListDemo()
	{

		headerLabel.setText("Seleziona un istituto");
		mainFrame.setVisible(true);
	}

	public void addListener(ActionListener al)
	{
		log.trace("Aggiunto l'actionListener " + al.getClass());
		showButton.addActionListener(al);
	}

	public int getSelectedIndex()
	{
		return list.getSelectedIndex();
	}

	public String getSelectedItem()
	{
		return list.getItem(list.getSelectedIndex());
	}

	public String getSelectedAction()
	{
		return cbg.getSelectedCheckbox().getLabel();
	}
	
	public void dispose()
	{
		mainFrame.dispose();
	}
}
