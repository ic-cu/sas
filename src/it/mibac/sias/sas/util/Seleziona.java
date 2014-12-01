package it.mibac.sias.sas.util;

import java.awt.Button;
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

public class Seleziona
{

	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	private Button showButton;
	private List list;

	public Seleziona(Iterator<String> items)
	{
		list = new List(10, false);
		prepareGUI();
		while(items.hasNext())
		{
			String str = items.next();
			System.err.println(str);
			list.add(str);
		}
	}

	public Seleziona(String[] items)
	{
		prepareGUI();
		list = new List(items.length, false);
		for(String str : items)
		{
			System.err.println(str);
			list.add(str);
		}
	}

	private void prepareGUI()
	{
		mainFrame = new Frame("Esportazione SIAS-SAS");
		mainFrame.setSize(200, 600);
		mainFrame.setLayout(new GridLayout(3, 1));
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
		statusLabel.setSize(100, 100);

		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());
		controlPanel.setSize(100, 400);

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
		showButton = new Button("Show");
		controlPanel.add(list);
		controlPanel.add(showButton);
	}

	public void showListDemo()
	{

		headerLabel.setText("Seleziona un istituto");
		mainFrame.setVisible(true);
	}

	public void addListener(ActionListener al)
	{
		System.err.println("Ho aggiunto l'actionListener " + al.getClass());
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
}
