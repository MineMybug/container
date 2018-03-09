package container.thread;

/**
 * @author �
 * @date ����ʱ�䣺2018��3��8�� ����4:00:17
 * @version 1.0
 */
public class VolitileTest {

	private static volatile int number = 6;

	public static synchronized void getNumber() {
		number--;
		System.out.println(number);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {

					VolitileTest.getNumber();
				}
			}).start();
		}

	}
}
