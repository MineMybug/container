package container.callBack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/** 
 * @author  �  
 * @date ����ʱ�䣺2018��1��16�� ����3:41:37 
 * @version 1.0 
 * ���ַ���д��txt�ļ�
*/
public class FileIo {
	
	/**
	 * �ӿڻص�
	 * @param fileName
	 * @param context
	 * @param callBackFileIo
	 */
	public void saveStrToFile (String fileName,String context,CallBackFileIo callBackFileIo){
		
		new Thread(new Runnable() {
			public void run() {
				try {
					writeStrToFile(fileName, context);
					callBackFileIo.onResult(true);
				} catch (IOException e) {
					e.printStackTrace();
					callBackFileIo.onResult(false);
				}
			}
		}).start();		
	}

	private void writeStrToFile(String fileName, String context) throws IOException {

		File file = new File(fileName);
		PrintStream pStream = new PrintStream(new FileOutputStream(file));
		pStream.print(context);		
	}

}
