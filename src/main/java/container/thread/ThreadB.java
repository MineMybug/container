package container.thread;

/**
 * @author �
 * @date ����ʱ�䣺2018��3��8�� ����4:18:25
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
			
			System.out.println("b������");
			while (true) {
				if (list.size() == 5) {
					System.out.println("�߳�BҪ�˳��ˣ�");
					throw new InterruptedException();
				}
			}
		} catch (Exception e) {

		}
	}

}
