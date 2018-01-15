package container.proxy;
/** 
 * @author  阮航  
 * @date 创建时间：2018年1月15日 下午7:51:40 
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
