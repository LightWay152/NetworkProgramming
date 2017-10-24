package blog.rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.blog.Compute;
import rmi.blog.Strategy;

public class Calculator {
	public static void main(String[] args){
		System.out.println("Started client");
		String host = "localhost";
		int port = 6969;
		try {
			Registry registry = LocateRegistry.getRegistry(host, port);
			Compute math = (Compute) registry.lookup("math");
			System.out.println(math.add(3, 4));
			System.out.println(math.add(5, 6));
			
			System.out.println("Strategy: " + math.deploy(new Strategy("Ducky")));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Client is close.");
	}
}
