package container.socketServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/** 
 * @author  阮航  
 * @date 创建时间：2017年12月13日 上午10:16:36 
 * @version 1.0 
*/
public class ServerSocketTest {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(6666);
		while(true){
			Socket socket = serverSocket.accept();
			System.out.println("A Client Connected!");
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String string = dis.readUTF();
			System.out.println(string);
		}
		
	}
}
