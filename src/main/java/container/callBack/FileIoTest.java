package container.callBack;
/** 
 * @author  �  
 * @date ����ʱ�䣺2018��1��16�� ����3:52:14 
 * @version 1.0 
*/
public class FileIoTest {

	public static void main(String[] args) {
		CallBackDemo callBackDemo = new CallBackDemo("D:\\link.txt", "asdb");
		callBackDemo.saveStr();
	}
}
