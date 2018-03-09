package container.thread;

/**
 * @author 阮航
 * @date 创建时间：2018年3月8日 下午4:18:25
 * @version 1.0
 */
public class ThreadB implements Runnable {

	private MyList list;

	public ThreadB(MyList list) {

		super();
		this.list = list;
	}

	@Override
	public void run() {

		try {
			
			System.out.println("b开启了");
			while (true) {
				if (list.size() == 5) {
					System.out.println("线程B要退出了！");
					throw new InterruptedException();
				}
			}
		} catch (Exception e) {

		}
	}

}
