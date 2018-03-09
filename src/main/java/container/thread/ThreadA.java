package container.thread;

import java.awt.List;

/**
 * @author 阮航
 * @date 创建时间：2018年3月8日 下午4:14:25
 * @version 1.0
 */
public class ThreadA implements Runnable {

	private MyList list;

	public ThreadA(MyList list) {

		super();
		this.list = list;
	}

	@Override
	public void run() {
		try {

			for (int i = 0; i < 10; i++) {
				list.add();
				System.out.println("添加了" + (i + 1) + "个元素");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
		}
	}

}
