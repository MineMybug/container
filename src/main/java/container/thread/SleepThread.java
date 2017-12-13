package container.thread;
/** 
 * @author  阮航  
 * @date 创建时间：2017年12月13日 上午10:51:56 
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
				System.out.println("     线程睡眠" + i + "ms");
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
