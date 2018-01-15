package container.proxy;
/** 
 * @author  阮航  
 * @date 创建时间：2018年1月15日 下午7:37:37 
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
