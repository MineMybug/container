package container.thread;
/** 
 * @author  阮航  
 * @date 创建时间：2017年12月13日 下午2:58:23 
 * @version 1.0 
*/

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//场景：当俩个线程共同访问共享数据时，这个类是线程安全的，但是不能保证共享数据的同步性。程序不是安全的！
public class NameList {

	private List<String> nameList = Collections.synchronizedList(new LinkedList<String>());

	public synchronized void add(String name) {
		nameList.add(name);
	}

	public synchronized String removeFirst() {
		if (nameList.size() > 0) {
			return (String) nameList.remove(0);
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		final NameList nameList = new NameList();
		nameList.add("ruanhang");
		class Drop extends Thread {
			public void run() {
				String name = nameList.removeFirst();
				System.out.println(name);
			}
		}
		
		Thread t1 = new Drop();
		Thread t2 = new Drop();
		t1.start();
		t2.start();
	}
}
