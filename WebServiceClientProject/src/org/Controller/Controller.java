package org.Controller;

import java.rmi.RemoteException;

import org.WebServices.WebServiceSoapProxy;

public class Controller {
	String filename;
    String text;
    WebServiceSoapProxy client = new WebServiceSoapProxy();
    
    public void setFileText(String text, String filename) {
        this.text = text;
        this.filename = filename;
        try {
			client.changeTxtFile(text, filename);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }
    public String getTextFile(String filename) {
        this.filename = filename;
        String text = null;
		try {
			text = client.getTxtFile(filename);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
        return text;
    }
    public String[] getFiles() {
        String[] files = null;
		try {
			files = client.getAllFileNames();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
        return files;
    }
}
