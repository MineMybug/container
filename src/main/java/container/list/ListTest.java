package container.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 阮航
 * @date 创建时间：2018年1月12日 上午10:04:35
 * @version 1.0
 */
public class ListTest {

//	private static final List<String> list = new ArrayList<String>(); // Thread
																		// not
																		// safe

//	 private static final List<String> list = Collections.synchronizedList(new ArrayList<String>());

	 private static int count = 0;
	 private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
	public static void main(String[] args) {

		
//		for (int i = 0; i < 100; i++) {
//			
			new ThreadOne().start();
			new ThreadTwo().start();
//			printAll();
//		}
		
		System.out.println(count);
	}

	private static class ThreadOne extends Thread {

		public void run() {
			int i = 0;
			while (i < 6) {
				list.add(String.valueOf(i));
				printAll();
				i++;
			}
//			synchronized (list) {
//				
//				list.add(String.valueOf(i));
//			}
		}

	}

	private static class ThreadTwo extends Thread {

		public void run() {
			int i = 10;
			while (i < 16) {
				list.add(String.valueOf(i));
				printAll();
				i++;
			}
//			synchronized (list) {
//				
//				list.add(String.valueOf(i));
//			}
		}
	}

	public static void printAll() {

		System.out.println("");
		String value = null;
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			value = iterator.next();
			System.out.println(value + ",");
		}
		
//		count++;
//		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		
	}
}
