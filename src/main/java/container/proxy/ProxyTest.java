package container.proxy;
/** 
 * @author  �  
 * @date ����ʱ�䣺2018��1��15�� ����7:51:40 
 * @version 1.0 
 * 
*/
public class ProxyTest {
	
	public static void main(String[] args) {
		
		OrderProxy orderProxy = new OrderProxy(new OrderServiceImpl());
		OrderService orderService = (OrderService)orderProxy.getProxy();
		orderService.test1();
//		orderService.test2();
	}

}
