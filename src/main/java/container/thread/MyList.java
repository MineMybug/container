package container.thread;
/** 
 * @author  �  
 * @date ����ʱ�䣺2018��3��8�� ����4:11:37 
 * @version 1.0 
*/

import java.util.ArrayList;
import java.util.List;

public class MyList {
	
	private static List list = new ArrayList();
	
	public static void add(){
		list.add("a");
	}
	
	public static int size(){
		return list.size();
	}

}
