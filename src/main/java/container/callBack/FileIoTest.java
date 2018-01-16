package container.callBack;
/** 
 * @author  阮航  
 * @date 创建时间：2018年1月16日 下午3:52:14 
 * @version 1.0 
*/
public class FileIoTest {

	public static void main(String[] args) {
		CallBackDemo callBackDemo = new CallBackDemo("D:\\link.txt", "asdb");
		callBackDemo.saveStr();
	}
}
