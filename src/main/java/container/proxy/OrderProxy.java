package container.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 
 * @author  �  
 * @date ����ʱ�䣺2018��1��15�� ����7:38:44 
 * @version 1.0 
 * ������
 * 
 * 1.�̳���Proxy�࣬ʵ���˴���Ľӿڣ�����java���ܶ�̳У������Ѿ��̳���Proxy���ˣ������ټ̳��������࣬����JDK�Ķ�̬����֧�ֶ�ʵ����Ĵ���ֻ֧�ֽӿڵĴ���
 * 2.�ṩ��һ��ʹ��InvocationHandler��Ϊ�����Ĺ��췽����
 * 3.���ɾ�̬���������ʼ���ӿ��з�����Method�����Լ�Object���equals��hashCode��toString������
 * 4.��д��Object���equals��hashCode��toString�����Ƕ�ֻ�Ǽ򵥵ĵ�����InvocationHandler��invoke������
 * �����Զ����������Ĳ�����Ҳ����˵JDK�Ķ�̬�������Դ�����������������
 * 5.������ʵ�ִ���ӿڵ�sayHello�����У�ֻ�Ǽ򵥵ĵ�����InvocationHandler��invoke���������ǿ�����invoke�����н���һЩ�������������������ʵ�ֵķ�����ֱ�ӷ���
 */
public class OrderProxy implements InvocationHandler{

	private static final String METHOD_PREFIX = "test";
	
	private Object target;
	
	public OrderProxy(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		//�Ƿ�ʹ�õĴ����໹��ʵ����
		if(method.getName().startsWith(METHOD_PREFIX)){
			System.out.println("======�ָ���======");
		}
		return method.invoke(target, args);
	}
	
	public Object getProxy(){
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), 
				target.getClass().getInterfaces(), this);
	}

}
