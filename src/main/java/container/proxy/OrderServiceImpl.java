package container.proxy;
/** 
 * @author  �  
 * @date ����ʱ�䣺2018��1��15�� ����7:37:37 
 * @version 1.0 
*/
public class OrderServiceImpl implements OrderService{

	public void test1(){
		System.out.println("test1");
		test2();
	}
	
	public void test2(){
		System.out.println("test2");
	}
}
