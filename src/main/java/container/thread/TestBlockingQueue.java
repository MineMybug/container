package container.thread;
/** 
 * @author  阮航  
 * @date 创建时间：2018年3月9日 下午2:05:17 
 * @version 1.0 
*/
//设计思路:1.初始化大小队列：5
//	     2.当需要加入时，判断当前队列长度是否可以加入，如果是5，则等待插入
//       3.当需要消费时，判断当前队列是否可以消费，如果为0，则等到插入

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class TestBlockingQueue {

	private final LinkedList<Object> queue = new LinkedList<>();

	private final AtomicInteger count = new AtomicInteger(0);

	private final int max = 5;

	private final int mix = 0;

	// 初始化锁对象

	private final Object lock = new Object();

	// put 方法

	public void put(Object obj) {

		synchronized (lock) {
			while (queue.size() == max) {
				try {
					lock.wait();
					System.out.println("a 线程等待中：" + obj);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			queue.add(obj);
			count.incrementAndGet();
			System.out.println("当前添加的元素为：" + obj);
			lock.notify();
		}
	}

	// get 方法

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
			System.out.println("被消费的元素为：" + temp);
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
		System.out.println("当前队列容量：" + myQueue.size());
	}

	private int size() {
		return count.get();
	}

}
