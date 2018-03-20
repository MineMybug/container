package container.staticOfUsing;
/** 
 * @author  �  
 * @date ����ʱ�䣺2018��3��20�� ����2:44:35 
 * @version 1.0 
*/
//�ܽ᣺�������μ��ع��췽����֪��
//    1.����洢�ڶ��ڴ��У����õ�ַ�洢��ջ�ڴ��У��ֲ��������õ�ַ��ջ�ڴ��У������洢��������
//    2.static �ؼ��ֿ������γ�Ա�����Լ������ϡ�
//    3.���߿����Լ���һ���ڴ�ͼ����
public class Cat {
	
	/*
	 * ��̬����
	 */
	private static int sid = 0;
	private String name;
	private int id;
	
	public Cat(String name) {

		this.name = name;
		id = sid++;
	}
	
	public void getSid(){
		System.out.println("name��" + name + "sid��" + sid + "id:" + id);
	}
	
	public static void main(String[] args) {
		Cat.sid = 2;
		Cat mimi = new Cat("mimi");
		Cat dog = new Cat("dog");
		mimi.getSid();
		dog.getSid();
	}
}
