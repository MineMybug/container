package container.thread;

import java.awt.List;

/**
 * @author �
 * @date ����ʱ�䣺2018��3��8�� ����4:14:25
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
					System.out.println("�����" + (i + 1) + "��Ԫ��");
					Thread.sleep(1000);
					if (MyList.size() == 5) {
						obj.notify();
						System.out.println("����֪ͨ");
					}
				}
			}

		} catch (Exception e) {
		}
	}

}
