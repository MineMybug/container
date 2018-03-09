package container.thread;

import java.awt.List;

/**
 * @author 阮航
 * @date 创建时间：2018年3月8日 下午4:14:25
 * @version 1.0
 */
public class ThreadA implements Runnable {

	private Object obj;

	public ThreadA(Object obj) {

		super();
		this.obj = obj;
	}

	@Override
	public void run() {
		try {
			
			synchronized (obj) {
				
				for (int i = 0; i < 15; i++) {
					MyList.add();
					System.out.println("添加了" + (i + 1) + "个元素");
					Thread.sleep(1000);
					if (MyList.size() == 5) {
						obj.notify();
						System.out.println("发出通知");
					}
				}
			}

		} catch (Exception e) {
		}
	}

}
