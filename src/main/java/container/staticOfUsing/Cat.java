package container.staticOfUsing;
/** 
 * @author  阮航  
 * @date 创建时间：2018年3月20日 下午2:44:35 
 * @version 1.0 
*/
//总结：分析俩次加载构造方法可知：
//    1.对象存储在堆内存中，引用地址存储在栈内存中，局部变量引用地址在栈内存中，常量存储在数据区
//    2.static 关键字可以修饰成员变量以及方法上。
//    3.读者可以自己画一幅内存图分析
public class Cat {
	
	/*
	 * 静态变量
	 */
	private static int sid = 0;
	private String name;
	private int id;
	
	public Cat(String name) {

		this.name = name;
		id = sid++;
	}
	
	public void getSid(){
		System.out.println("name：" + name + "sid：" + sid + "id:" + id);
	}
	
	public static void main(String[] args) {
		Cat.sid = 2;
		Cat mimi = new Cat("mimi");
		Cat dog = new Cat("dog");
		mimi.getSid();
		dog.getSid();
	}
}
