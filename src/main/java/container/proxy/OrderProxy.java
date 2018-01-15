package container.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 
 * @author  阮航  
 * @date 创建时间：2018年1月15日 下午7:38:44 
 * @version 1.0 
 * 代理类
 * 
 * 1.继承了Proxy类，实现了代理的接口，由于java不能多继承，这里已经继承了Proxy类了，不能再继承其他的类，所以JDK的动态代理不支持对实现类的代理，只支持接口的代理。
 * 2.提供了一个使用InvocationHandler作为参数的构造方法。
 * 3.生成静态代码块来初始化接口中方法的Method对象，以及Object类的equals、hashCode、toString方法。
 * 4.重写了Object类的equals、hashCode、toString，它们都只是简单的调用了InvocationHandler的invoke方法，
 * 即可以对其进行特殊的操作，也就是说JDK的动态代理还可以代理上述三个方法。
 * 5.代理类实现代理接口的sayHello方法中，只是简单的调用了InvocationHandler的invoke方法，我们可以在invoke方法中进行一些特殊操作，甚至不调用实现的方法，直接返回
 */
public class OrderProxy implements InvocationHandler{

	private static final String METHOD_PREFIX = "test";
	
	private Object target;
	
	public OrderProxy(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		//是否使用的代理类还是实体类
		if(method.getName().startsWith(METHOD_PREFIX)){
			System.out.println("======分隔符======");
		}
		return method.invoke(target, args);
	}
	
	public Object getProxy(){
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), 
				target.getClass().getInterfaces(), this);
	}

}
