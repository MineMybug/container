package container.thread;

/**
 * @author 阮航
 * @date 创建时间：2018年3月8日 下午4:18:25
 * @version 1.0
 */
public class ThreadB implements Runnable {

	private Object obj;

	public ThreadB(Object obj) {

		super();
		this.obj = obj;
	}

	@Override
	public void run() {

		try {
			
			System.out.println("b开启了" );
//			while (true) {
//				
//				System.out.println("b开启了" + MyList.size());
//				if (MyList.size() == 5) {
//					System.out.println("线程B要退出了！");
//					throw new InterruptedException();
//				}
//			}
			
			synchronized (obj) {
				if (MyList.size() != 5) {
					obj.wait();
					System.out.println("b线程等待" + System.currentTimeMillis());
				}
			}
			
		} catch (Exception e) {

		}
	}

}
