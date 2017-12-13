package container.socketServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/** 
 * @author  阮航  
 * @date 创建时间：2017年12月13日 上午10:23:44 
 * @version 1.0 
*/
public class ClientSocketTest {
	
	public static void main(String[] args) throws IOException, IOException {
		
		Socket socket = new Socket("127.0.0.1",6666);
		OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*客户端睡眠30秒后再向服务器端发送信息*/
        dos.writeUTF("Hello Server!");
	}

}
