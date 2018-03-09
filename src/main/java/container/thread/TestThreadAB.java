package container.thread;
/** 
 * @author  阮航  
 * @date 创建时间：2018年3月8日 下午4:21:45 
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
