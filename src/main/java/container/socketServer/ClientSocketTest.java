package container.socketServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/** 
 * @author  �  
 * @date ����ʱ�䣺2017��12��13�� ����10:23:44 
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
		}/*�ͻ���˯��30�������������˷�����Ϣ*/
        dos.writeUTF("Hello Server!");
	}

}
