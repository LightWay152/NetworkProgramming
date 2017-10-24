package rmi.blog.utils;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmi.blog.Compute;
import rmi.blog.Strategy;

public class Math extends UnicastRemoteObject implements Compute{
	
	public Math() throws RemoteException{
		
	}

	@Override
	public int add(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a + b;
	}
	
	public static void main(String[] args){
		try {
			Math math = new Math();
			System.out.println("Server is ready...");
			LocateRegistry.createRegistry(6969);
			Registry registry = LocateRegistry.getRegistry(6969);
			registry.bind("math", math);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Server is close.");
	}

	@Override
	public String deploy(Strategy strategy) throws RemoteException {
		// TODO Auto-generated method stub
		return strategy.getName();
	}

}
