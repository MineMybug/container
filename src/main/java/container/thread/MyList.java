package container.thread;
/** 
 * @author  阮航  
 * @date 创建时间：2018年3月8日 下午4:11:37 
 * @version 1.0 
*/

import java.util.ArrayList;
import java.util.List;

public class MyList {
	
	private List list = new ArrayList();
	
	public void add(){
		list.add("a");
	}
	
	public int size(){
		return list.size();
	}

}
