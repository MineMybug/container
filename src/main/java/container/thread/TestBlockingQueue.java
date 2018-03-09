package container.thread;
/** 
 * @author  �  
 * @date ����ʱ�䣺2018��3��9�� ����2:05:17 
 * @version 1.0 
*/
//���˼·:1.��ʼ����С���У�5
//	     2.����Ҫ����ʱ���жϵ�ǰ���г����Ƿ���Լ��룬�����5����ȴ�����
//       3.����Ҫ����ʱ���жϵ�ǰ�����Ƿ�������ѣ����Ϊ0����ȵ�����

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class TestBlockingQueue {

	private final LinkedList<Object> queue = new LinkedList<>();

	private final AtomicInteger count = new AtomicInteger(0);

	private final int max = 5;

	private final int mix = 0;

	// ��ʼ��������

	private final Object lock = new Object();

	// put ����

	public void put(Object obj) {

		synchronized (lock) {
			while (queue.size() == max) {
				try {
					lock.wait();
					System.out.println("a �̵߳ȴ��У�" + obj);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			queue.add(obj);
			count.incrementAndGet();
			System.out.println("��ǰ��ӵ�Ԫ��Ϊ��" + obj);
			lock.notify();
		}
	}

	// get ����

	public void get() {

		Object temp;

		synchronized (lock) {
			while (queue.size() == mix) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			count.decrementAndGet();
			temp = queue.removeFirst();
			System.out.println("�����ѵ�Ԫ��Ϊ��" + temp);
			lock.notify();
		}
	}

	public static void main(String[] args) throws Exception {
		
		final TestBlockingQueue myQueue = new TestBlockingQueue();
		initMyQueue(myQueue);
		
		Thread t1 = new Thread(() ->{
			myQueue.put("h");
			myQueue.put("f");
		},("t1"));
		
		Thread t2 = new Thread(() ->{
			try {
				Thread.sleep(2000);
				myQueue.get();
				myQueue.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		},("t2"));
		
		t1.start();
		Thread.sleep(2000);
		t2.start();
		
	}

	private static void initMyQueue(TestBlockingQueue myQueue) {

		myQueue.put("a");
		myQueue.put("b");
		myQueue.put("c");
		myQueue.put("d");
		myQueue.put("e");
		System.out.println("��ǰ����������" + myQueue.size());
	}

	private int size() {
		return count.get();
	}

}
