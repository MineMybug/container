package container.thread;
/** 
 * @author  �  
 * @date ����ʱ�䣺2018��3��8�� ����4:21:45 
 * @version 1.0 
*/
public class TestThreadAB {
	
	public static void main(String[] args) {
		MyList list = new MyList();		
		
		ThreadB b = new ThreadB(list);
		Thread bThread = new Thread(b);
		bThread.setName("b");
		bThread.start();
		
		ThreadA a = new ThreadA(list);
		Thread aThread = new Thread(a);
		aThread.setName("a");
		aThread.start();
				
	}

}
