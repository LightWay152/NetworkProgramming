package rmi.blog;

import java.rmi.RemoteException;
import java.rmi.Remote;

public interface Compute extends Remote{
	public int add(int a, int b) throws RemoteException;
	
	public String deploy(Strategy strategy) throws RemoteException;
}
