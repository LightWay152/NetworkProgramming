package blog.socket.object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import blog.socket.model.Message;

public class ClientSerialization {
	public void connect(){
		try {
			System.out.println("Client 2 is ready...");
			Socket socket = new Socket("localhost",7272);
			// Sending to server
			ObjectOutputStream oos = new ObjectOutputStream(
					socket.getOutputStream());
			Message msg1 = new Message("Study", "Give me some ebooks");
			oos.writeObject(msg1);
			System.out.println("Sent to the server: "
					+ msg1.getTitle() + " " + msg1.getBody());
			
			ObjectInputStream ois = new ObjectInputStream(
					socket.getInputStream());
			Message msg2 = (Message) ois.readObject();
			if(msg2 != null){
				System.out.println("Received from the server: "
						+ msg2.getTitle() + " " + msg2.getBody());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ClientSerialization client = new ClientSerialization();
		client.connect();
	}
	
}
