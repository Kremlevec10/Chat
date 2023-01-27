package server;

import java.net.ServerSocket;
import java.net.Socket;

import chatapplication.controllers.ServerController;

public class MyServer {
	
	private static final int PORT = 7700; 

	private Socket socket;
	
	public void startServer() {
		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			socket = serverSocket.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
