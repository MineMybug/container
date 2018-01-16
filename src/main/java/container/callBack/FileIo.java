package container.callBack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/** 
 * @author  阮航  
 * @date 创建时间：2018年1月16日 下午3:41:37 
 * @version 1.0 
 * 将字符串写入txt文件
*/
public class FileIo {
	
	/**
	 * 接口回调
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
