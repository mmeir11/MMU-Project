package com.hit.client;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.EventListener;
import java.util.Scanner;

import com.hit.view.CacheUnitPanel;
import com.hit.view.CacheUnitView;

public class CacheUnitClientObserver implements PropertyChangeListener, EventListener{

	private CacheUnitClient cuc;
	private CacheUnitView cuv;
	
	//C'tor
	public CacheUnitClientObserver() {
		cuc = new CacheUnitClient();
	}
	
	
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		String response;
		response = cuc.send((String) e.getNewValue());	//recive Responde from the server
		cuv = (CacheUnitView) e.getSource();
		cuv.updateUIData(response);		//Send the Responde to CacheUnitView
	}
}
