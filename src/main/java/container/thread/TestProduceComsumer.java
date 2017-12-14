package container.thread;
/** 
 * @author  �  
 * @date ����ʱ�䣺2017��12��14�� ����2:29:06 
 * @version 1.0 
*/
public class TestProduceComsumer {
	
	public static void main(String[] args) {
		TestProduceComsumer testProduceComsumer = new TestProduceComsumer();
		TestProduceComsumer.Godown godown = testProduceComsumer.getInstance(30);
		TestProduceComsumer.Produce produce1 = testProduceComsumer.new Produce(10, godown);
		TestProduceComsumer.Comsumer comsumer1 = testProduceComsumer.new Comsumer(15, godown);
		TestProduceComsumer.Produce produce2 = testProduceComsumer.new Produce(20, godown);
		TestProduceComsumer.Comsumer comsumer2 = testProduceComsumer.new Comsumer(15, godown);
		produce1.start();
		comsumer1.start();
		produce2.start();
		comsumer2.start();
	}
	
	/**
	 * ��ȡ�ֿ�ʵ��
	 * @param currentNum
	 * @return
	 */
	private Godown getInstance(int currentNum){
		return new Godown(currentNum);
	}
	
	/*
	 * �ֿ�
	 */
	class Godown{
		private static final int MAX_SIZE = 50;//�ֿ��ܴ洢��
		public int currentNum;//��ǰ�����
		
		public Godown() {
			// TODO Auto-generated constructor stub
		}
		
		public Godown (int cunrrentNum){
			this.currentNum = cunrrentNum;
		}
		
		/**
		 * ����ָ���Ĳ�Ʒ����
		 */
		public synchronized void produce(int needNum){
			//�ж��Ƿ��ṩ����
			while(currentNum + needNum > MAX_SIZE){
				System.out.println("Ҫ�����Ĳ�Ʒ������ " + needNum + " ����ʣ������" + (MAX_SIZE - needNum) + ",��ʱ����ִ������");
				try {
					//��ǰ�������߳�ֹͣ
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//����Ҫ��������������ִ�У��򵥸��Ŀ����
			currentNum+=needNum;
			System.out.println("�Ѿ�������"+ needNum + "����Ʒ��"+ "���ڿ����Ϊ��" + currentNum);
			//���Ѵ˶�������������еȴ����߳�
			notifyAll();
		}
		
		/**
		 * ����ָ���Ĳ�Ʒ����
		 */
		public synchronized void comsumer(int needNum){
			//�ж��Ƿ��ṩ����
			while(needNum > currentNum){
				System.out.println("ʣ������Ϊ�� " + currentNum + "��Ҫ���ѵĲ�Ʒ����Ϊ��" + needNum + ",��ʱ����ʵ������");
				try {
					//��ǰ���ѵ��߳�ֹͣ
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//��������Ҫ�Ĳ�Ʒ��������ִ�У��򵥸���ʣ������
			currentNum-=needNum;
			System.out.println("�Ѿ�������"+ needNum + "����Ʒ����ʣ��" + currentNum+ "����Ʒ��");
			//���Ѵ˶���������ϵ���������״̬���߳�
			notifyAll();
		}
	}

	/*
	 * ������
	 */
	class Produce extends Thread{
		private int needNum;//������Ʒ����
		private Godown godown;//�ֿ�
		
		public Produce(int needNum, Godown godown) {
			this.needNum = needNum;
			this.godown = godown;
		}
		//����ָ����Ʒ����
		public void run(){
			godown.produce(needNum);
		}
	}
	
	/*
	 * ������
	 */
	class Comsumer extends Thread{
		private int needNum;
		private Godown godown;
		public Comsumer(int needNum, Godown godown) {
			this.needNum = needNum;
			this.godown = godown; 			
		}
		//������ָ�����ѵ�����
		public void run(){
			godown.comsumer(needNum);
		}
	}
}
