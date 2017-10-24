package blog.socket.simple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public void serve(){
		try {
			// Create server with any port
			ServerSocket server = new ServerSocket(7272);
			System.out.println("Server is ready...");
			Socket socket = server.accept();			
			
			// Receiving request from client
			BufferedReader br = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			String request = br.readLine();
			if(request != null){
				System.out.println("Received from a client: "+request);
				// Process: Select database or calculate...
				// Response to client
				PrintStream ps = new PrintStream(socket.getOutputStream());
				ps.println(request.toUpperCase());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.serve();
	}

}
