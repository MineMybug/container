package container.thread;

import java.awt.List;

/**
 * @author �
 * @date ����ʱ�䣺2018��3��8�� ����4:14:25
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
				System.out.println("�����" + (i + 1) + "��Ԫ��");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
		}
	}

}
