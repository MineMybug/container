package container.thread;

/**
 * @author �
 * @date ����ʱ�䣺2018��3��8�� ����4:18:25
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
			
			System.out.println("b������" );
//			while (true) {
//				
//				System.out.println("b������" + MyList.size());
//				if (MyList.size() == 5) {
//					System.out.println("�߳�BҪ�˳��ˣ�");
//					throw new InterruptedException();
//				}
//			}
			
			synchronized (obj) {
				if (MyList.size() != 5) {
					obj.wait();
					System.out.println("b�̵߳ȴ�" + System.currentTimeMillis());
				}
			}
			
		} catch (Exception e) {

		}
	}

}
