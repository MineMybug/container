package container.thread;
/** 
 * @author  �  
 * @date ����ʱ�䣺2017��12��13�� ����10:51:56 
 * @version 1.0 
*/
public class SleepThread implements Runnable{

	private String name;
	public SleepThread(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {

		for(int i = 0; i < 50; i++ ){
			if((i%10)==0){
				System.out.println(name + i);
			}
			try {
				Thread.sleep(i);
				System.out.println("     �߳�˯��" + i + "ms");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		SleepThread sleepThread = new SleepThread("thread");
		Thread thread = new Thread(sleepThread);
		thread.start();
	}

}
