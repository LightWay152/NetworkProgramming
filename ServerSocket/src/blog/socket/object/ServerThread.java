package blog.socket.object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import blog.socket.model.Message;

public class ServerThread extends Thread{
	
	private Socket socket;
	
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		// Receive
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(
					socket.getInputStream());
		Message msg1 = (Message)ois.readObject();
		if(msg1 != null){
			System.out.println("Receive a message from client: "
					+ msg1.getTitle() + " " + msg1.getBody());
			// Do something
			Message msg2 = new Message("Ebooks","Java programming language");
			ObjectOutputStream oos = new ObjectOutputStream(
					socket.getOutputStream());
			oos.writeObject(msg2);
			System.out.println("Sent a message to client: "
					+ msg2.getTitle() + " " + msg2.getBody());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
