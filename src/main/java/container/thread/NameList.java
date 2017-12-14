package container.thread;
/** 
 * @author  �  
 * @date ����ʱ�䣺2017��12��13�� ����2:58:23 
 * @version 1.0 
*/

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//�������������̹߳�ͬ���ʹ�������ʱ����������̰߳�ȫ�ģ����ǲ��ܱ�֤�������ݵ�ͬ���ԡ������ǰ�ȫ�ģ�
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
