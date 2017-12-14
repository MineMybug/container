package container.thread;
/** 
 * @author  阮航  
 * @date 创建时间：2017年12月14日 下午2:29:06 
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
	 * 获取仓库实例
	 * @param currentNum
	 * @return
	 */
	private Godown getInstance(int currentNum){
		return new Godown(currentNum);
	}
	
	/*
	 * 仓库
	 */
	class Godown{
		private static final int MAX_SIZE = 50;//仓库总存储量
		public int currentNum;//当前库存量
		
		public Godown() {
			// TODO Auto-generated constructor stub
		}
		
		public Godown (int cunrrentNum){
			this.currentNum = cunrrentNum;
		}
		
		/**
		 * 生产指定的产品数量
		 */
		public synchronized void produce(int needNum){
			//判断是否提供生产
			while(currentNum + needNum > MAX_SIZE){
				System.out.println("要生产的产品数量： " + needNum + " 超过剩余库存量" + (MAX_SIZE - needNum) + ",暂时不能执行任务！");
				try {
					//当前生产的线程停止
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//满足要求的生产任务可以执行，简单更改库存量
			currentNum+=needNum;
			System.out.println("已经生产了"+ needNum + "个产品，"+ "现在库存量为：" + currentNum);
			//唤醒此对象监视器上所有等待的线程
			notifyAll();
		}
		
		/**
		 * 消费指定的产品数量
		 */
		public synchronized void comsumer(int needNum){
			//判断是否提供消费
			while(needNum > currentNum){
				System.out.println("剩余库存量为： " + currentNum + "需要消费的产品数量为：" + needNum + ",暂时不能实行任务！");
				try {
					//当前消费的线程停止
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//满足消费要的产品数量可以执行，简单更改剩余库存量
			currentNum-=needNum;
			System.out.println("已经消费了"+ needNum + "个产品！还剩余" + currentNum+ "个产品！");
			//唤醒此对象监视器上的所有阻塞状态的线程
			notifyAll();
		}
	}

	/*
	 * 生产者
	 */
	class Produce extends Thread{
		private int needNum;//生产产品数量
		private Godown godown;//仓库
		
		public Produce(int needNum, Godown godown) {
			this.needNum = needNum;
			this.godown = godown;
		}
		//生产指定产品数量
		public void run(){
			godown.produce(needNum);
		}
	}
	
	/*
	 * 消费者
	 */
	class Comsumer extends Thread{
		private int needNum;
		private Godown godown;
		public Comsumer(int needNum, Godown godown) {
			this.needNum = needNum;
			this.godown = godown; 			
		}
		//消费者指定消费的数量
		public void run(){
			godown.comsumer(needNum);
		}
	}
}
