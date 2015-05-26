/**
 * WebServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.WebServices;

public interface WebServiceSoap extends java.rmi.Remote {
    public java.lang.String getTxtFile(java.lang.String filename) throws java.rmi.RemoteException;
    public java.lang.String[] getAllFileNames() throws java.rmi.RemoteException;
    public void changeTxtFile(java.lang.String fileText, java.lang.String filename) throws java.rmi.RemoteException;
}
