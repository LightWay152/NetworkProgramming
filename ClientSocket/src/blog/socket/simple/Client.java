package blog.socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public void connect(){
		try {
			//Create server with server port
			Socket socket = new Socket("localhost",7272);
			
			// Sending to server
			PrintStream ps = new PrintStream(socket.getOutputStream());
			ps.println("Study And Share");
			
			// Receiving from server
			BufferedReader br = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			String response = br.readLine();
			if(response != null){
				System.out.println("Server answered: "+response);
			}
	
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.connect();
	}
	
}
