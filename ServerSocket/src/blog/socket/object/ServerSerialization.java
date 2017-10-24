package blog.socket.object;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerSerialization {
	public void serve(){
		try {
			ServerSocket server = new ServerSocket(7272);
			System.out.println("Server is ready...");
			int count = 0;
			while(true){
				System.out.println("Client "+ ++count);
				Socket socket = server.accept();	
				new ServerThread(socket).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServerSerialization server = new ServerSerialization();
		server.serve();
	}
}
